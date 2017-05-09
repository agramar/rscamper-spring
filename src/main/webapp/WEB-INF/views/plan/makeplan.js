angular.module("TourPlanApp")
	.controller("MakePlanController", function ($rootScope, $scope, $http, $window, $timeout, RequestService) {
		/** ==================================================== */
		/** 여행일정 기본 데이터 불러오기 */
		/** ==================================================== */
		// recordNo로 파라미터 받은 값으로 일정 정보 불러옴
		$scope.getTourPlan = function () {
			
			$http({
				url: myConfig.serverURL + "/tourPlan/select/oneTourPlan?recordNo=" + RequestService.getParameter("recordNo"),
				method: "GET"
			}).success(function (response) {
//				console.log(response);
				if (response.userUid != $rootScope.user.userUid) {
					swal("에러", "해당 일정에 대한 수정권한이 없습니다.", "error");
					// 일정리스트 페이지로 리다이렉트
					$window.location.href = "list.jsp";
				};
				$scope.tourPlan = response;
				$scope.tourPlan.departureDate = new Date(response.departureDate);
				$scope.tourPlan.arriveDate = new Date(response.arriveDate);
				$scope.tourPlan.period = $scope.convertDate($scope.tourPlan.departureDate, $scope.tourPlan.arriveDate);
				$scope.tourPlan.regDate = new Date(response.regDate);
				
				/** ==================================================== */
				/** 여행일정 스케쥴 데이터 불러오기 */
				/** ==================================================== */
				// 일정표 날짜 정보 셋팅
				$scope.setCalendarDate();
				// 일정표 init
				$scope.initCalendar();
				// 포함된 일정 불러오기
				$http({
					url: myConfig.serverURL + "/tourPlan/select/tourPlanScheduleByRecordNo?recordNo=" + RequestService.getParameter("recordNo"),
					method: "GET"
				}).success(function (response) {
//					console.log(response);
					
					// 일정표에 불러온 이벤트 추가
					for (var i = 0; i < response.length ; i++) {
						switch (response[i].contentTypeId) {
							case 12: var color = "#f29e37"; break;
							case 14: var color = "#f29e37"; break;
							case 15: var color = "#f29e37"; break;
							case 25: var color = "#f29e37"; break;
							case 28: var color = "#f29e37"; break;
							case 38: var color = "#f29e37"; break;
							case 39: var color = "#46c0fb"; break;
							case 32: var color = "#6bb130"; break;
						}
						var event = {
				    		title: response[i].title, // 태그안 택스트를 title 변수로 준다
				    		stick: true, // 날짜이동해도 일정을 유지시켜줌
				    		constraint: "availableDate", // availableDate필드에만 일정 추가 가능
				    		color: color,
				    			
				    		// 필터를 위한
				    		category: "tourSpot",
				    			
				    		// DB에 들어가야할 일정 데이터 
							locationNo: response[i].locationNo,
				    		recordNo: RequestService.getParameter("recordNo"),
				    		contentId: response[i].contentCode,
				    		contentTypeId: response[i].contentTypeId,
				    		spotTitle: response[i].title,
				    		mapX: response[i].mapX,
				    		mapY: response[i].mapY,
				    		imageUrl: response[i].imageUrl,
				    		start: moment(response[i].detailDepartureDate),
				    		overview: response[i].overview,
				    		homepage: response[i].homepage,
				    		addr1: response[i].addr1,
				    		tel: response[i].tel,
				    		
						}
						if (response[i].detailArriveDate) {
							event.end = moment(response[i].detailArriveDate);
						}
						calendarObj.fullCalendar("renderEvent", event, true);
					}
					
					// 일정표 바인딩
					$scope.getAllCalendarEvents();
					// 구글맵 이니시
					initMap();
					// 지도에 이벤트 렌더링
					renderingEventToMap();
					
				}).error(function (error) {
					console.log(error);
				});
			}).error(function (error) {
				swal("에러", "잘못된 접근입니다.", "error");
				// 일정리스트 페이지로 리다이렉트
				$window.location.href = "list.jsp";
			});
		};
		
		// 기간 표시 메소드
		$scope.convertDate = function(dDate, aDate) {
			var response = "";
			var nTime = aDate.getTime() - dDate.getTime();
			var year = Math.floor(nTime/1000/60/60/24/365);
			var day = nTime/1000/60/60/24;
			if (day >= 1) {
				var duty = day + 1;
				response = day + "박" + duty + "일";
			} else if (day == 0){
				response = "당일치기";
			} else if (day < 0) {
				response = "시간여행";
			}
			return response;
		};
		
		// TODO 일정 시간 변경시 유효성 체크
		
		// 출발시간 변경시 이벤트
		angular.element("#departureDate").change( function() {
            $scope.$apply(function() {
            	$scope.tourPlan.period = $scope.convertDate($scope.tourPlan.departureDate, $scope.tourPlan.arriveDate);
            });
            $scope.setCalendarDate();
		});
		
		// 도착시간 변경시 이벤트
		angular.element("#arriveDate").change( function() {
            $scope.$apply(function() {
            	$scope.tourPlan.period = $scope.convertDate($scope.tourPlan.departureDate, $scope.tourPlan.arriveDate);
            });
            $scope.setCalendarDate();
		});
		
		// 여행일정 가져오기
		$scope.getTourPlan();

		/** ==================================================== */
		/** 여행일정 저장/취소  								         */
		/** ==================================================== */
		/*	저장요소
		 *  전체정보 : record_tb
		 *  일정정보 : record_location_tb
		 */
		// 일정 전체 저장 메소드
		$scope.saveTourPlan = function () {
//			console.log($scope.tourPlan);
//			console.log($scope.getAllCalendarEvents());
			var tourPlanScheduleList = $scope.getAllCalendarEvents()
			// 전체정보 입력
			$http({
				url: myConfig.serverURL + "/tourPlan/update/tourPlan",
				method: "POST",
				data: $.param($scope.tourPlan),
				headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
			}).success(function (response) {
				// 스케줄 정보 삭제
				$http({
					url: myConfig.serverURL + "/tourPlan/delete/tourPlanScheduleByRecordNo?recordNo=" + RequestService.getParameter("recordNo"),
					method: "GET",
				}).success(function (response) {
					$.isLoading();
					// 스케쥴 정보 입력
					for (var i = 0, len = tourPlanScheduleList.length; i < len; i++) {
						var tps = tourPlanScheduleList[i]
						var tourPlanSchedule = {
								contentCode: tps.contentId,
								recordNo: tps.recordNo,
								title: tps.spotTitle,
								imageUrl: tps.imageUrl,
								contentTypeId: tps.contentTypeId,
								mapX: tps.mapX,
								mapY: tps.mapY,
								detailDepartureDate: tps.start.format("YYYY-MM-DD HH:mm:ss"),
								departureDate: tps.start.format("YYYY. MM. DD. ddd")
						}
						if (tps.end) { tourPlanSchedule.detailArriveDate = tps.end.format("YYYY-MM-DD HH:mm:ss") }
						if (tps.locationNo) { tourPlanSchedule.locationNo = tps.locationNo }
//						console.log(tourPlanSchedule);
						$http({
							url: myConfig.serverURL + "/tourPlan/insert/tourPlanSchedule",
							method: "POST",
							data: $.param(tourPlanSchedule),
							headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
						}).success(function (response) {

						}).error(function (error) {
							console.log(error);
						})
					}
			        setTimeout( function(){
			        	$.isLoading( "hide" );
						swal("일정 저장이 완료되었습니다.");
						$window.location.reload();
			        }, 1000 );
				}).error(function (error) {
					console.log(error);
				})
			}).error(function (error) {
				console.log(error);
			})
		}
		
		// 취소버튼 이벤트
		$scope.cancelTourPlan = function () {
			swal("redirecting...");
			$window.location.href = "detail.jsp?recordNo=" + RequestService.getParameter("recordNo");
		}
		
		/** ==================================================== */
		/** 제목 바꾸기 */
		/** ==================================================== */
		// 제목바꾸기 시작 이벤트
		$scope.changeTitle = function () {
			$scope.modTitle = true;
		}
		
		// 제목바꾸기 완료 이벤트
		$scope.updateTitle = function () {
			$http({
				url: myConfig.serverURL + "/tourPlan/update/tourPlanTitle",
				method: "POST",
				data: $.param({
					recordNo: RequestService.getParameter("recordNo"),
					title: $scope.tourPlan.title
				}),
				headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
			}).success(function (response) {
				$scope.modTitle = false;
			}).error(function (error) {
				console.log(error);
			})
		}
		
		/** ==================================================== */
		/** 배경사진 바꾸기 */
		/** ==================================================== */
		// 배경 파일 업로드 이미지 미리보기 이벤트
		$("#BGImageFile").on("change", function(){
			if(img_validation(this)) {
				readURL(this, $("#BGImage"));
			} else {
				$(this).val("");
				$("#BGImage").attr("src", "/rscamper-web/resources/img/default/default-image.png");
			};
		});
		
		// 배경 사진 변경 모달창 열기
		$scope.changeTourPlanBGImage = function () {
			$scope.uploadBGUrl = myConfig.serverURL + "/tourPlan/upload/coverImage"
			$("#BGImageFile").val("");
			$("#BGImage").attr("src", "/rscamper-web/resources/img/default/default-image.png");
			$("#BGImageUploadFormModal").modal("show");
		};
		
		// 배경사진 업로드 완료 콜백
		$scope.uploadBGCallBack = function (response) {
	        var data = JSON.parse(response);
	        var TourPlanCover = {
	        		recordNo: RequestService.getParameter("recordNo"),
	        		realPath: data.realPath, // 서버 경로
	        		filePath: data.filePath, // 웹 경로
	        		oriName: data.oriName, // 업로드시 파일이름
	        		fileName: data.fileName, // 서버저장 파일이름
	        		fileSize: data.fileSize // 파일 크기
	        }
	        $scope.updateImage(TourPlanCover, "/tourPlan/update/coverImage")
		};
		
		// 사진 데이터베이스 업데이트
	    $scope.updateImage = function (TourPlanCover, url) {
	        $http({
	          url: myConfig.serverURL + url,
	          method: "POST",
	          data: $.param({
	        		recordNo: RequestService.getParameter("recordNo"),
	        		realPath: TourPlanCover.realPath, // 서버 경로
	        		filePath: TourPlanCover.filePath, // 웹 경로
	        		oriName: TourPlanCover.oriName, // 업로드시 파일이름
	        		fileName: TourPlanCover.fileName, // 서버저장 파일이름
	        		fileSize: TourPlanCover.fileSize // 파일 크기
	          }),
	          headers: {
	            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
	          }
	        })
	        .success(function () {
				$http({
					url: myConfig.serverURL + "/tourPlan/select/oneTourPlan?recordNo=" + RequestService.getParameter("recordNo"),
					method: "GET",
				}).success(function (response) {
					// 불러온 일정정보 uid값이 $rootScope.user와 같은지 확인 : 같으면 진행, 아니면 오류 메세지 띄우고 일정 리스트 페이지로 이동
//					console.log(response);
					if (response.userUid != $rootScope.user.userUid) {
						swal("에러", "해당 일정에 대한 수정권한이 없습니다.", "error");
						// 일정리스트 페이지로 리다이렉트
						$window.location.href = "list.jsp";
					};
					$scope.tourPlan = response;
					$scope.tourPlan.arriveDate = new Date(response.arriveDate);
					$scope.tourPlan.departureDate = new Date(response.departureDate);
					$scope.tourPlan.regDate = new Date(response.regDate);
					
	        		$("#BGImageFile").val("");
	        		$("#BGImage").attr("src", "/rscamper-web/resources/img/default/default-image.png");
	        		$("#BGImageUploadFormModal").modal("hide");
					
				}).error(function (error) {
					swal("에러", "잘못된 접근입니다.", "error");
					// 일정리스트 페이지로 리다이렉트
					$window.location.href = "list.jsp";
				});
		
	        });
	    };
	    
		/** ==================================================== */
		/** 스토리 */
		/** ==================================================== */
	    // 스마트에디터 선언
	    $scope.writeTourSpotMemoFormModal = $("#writeTourSpotMemoFormModal");
	    var editor_object = [];
	    nhn.husky.EZCreator.createInIFrame({
	        oAppRef: editor_object,
	        elPlaceHolder: "smarteditor",
	        sSkinURI: "../../resources/plugins/smartEditor/SmartEditor2Skin.html", 
	        htParams : {
	            // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseToolbar : true,             
	            // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseVerticalResizer : true,     
	            // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
	            bUseModeChanger : true, 
	        }
	    });
	    
	    // 글쓰기폼 모달 리셋
	    $scope.resetWriteTourSpotMemoForm = function () {
	    	$scope.writeTourSpotMemoData = {
	    		title: "",
	    		memoType: 1,
	    		locationNo: 0,
	    		contentId: 0
	    	} 
	    };
	    
	    $scope.resetWriteTourSpotMemoForm();
	    
	    // 스토리 리스트 불러오기
	    $scope.getWriteTourSpotMemoList = function () {
	    	$scope.tourSpotMemoList = [];
	    	$http({
				url: myConfig.serverURL + "/tourPlan/select/tourSpotMemoList?recordNo=" + RequestService.getParameter("recordNo"),
				method: "GET",
			}).success(function (response) {
//				console.log(response);
				$scope.tourSpotMemoList = response;
			}).error(function (error) {
				
			});
	    } 
	    
	    $scope.getWriteTourSpotMemoList();
	    
	    // 스토리 작성(모달창 열기)
	    $scope.openWriteTourSpotMemoFormModal = function (locationNo, contentId) {
	    	$scope.writeTourSpotMemoData.locationNo = locationNo;
	    	$scope.writeTourSpotMemoData.contentId = contentId;
	    	$scope.memoTypes = [{
	    		memoNo: 1,
	    		memoName: "메모"
	    	},
	    	{
	    		memoNo: 2,
	    		memoName: "여행기"
	    	}]
	    	$scope.writeTourSpotMemoFormModal.modal("show");
	    }
	    
	    // 모달창 닫기
	    $scope.closeWriteTourSpotMemoFormModal = function () {
	    	$scope.writeTourSpotMemoFormModal.modal("hide");
	    }
	    
	    // 모달 가려질떄 이벤트
	    $scope.writeTourSpotMemoFormModal.on('hidden.bs.modal', function (e) {
	    	$scope.resetWriteTourSpotMemoForm();
	    	editor_object.getById["smarteditor"].exec("SET_CONTENTS", [""]);
	    });
	    
	    // 스토리 작성
	    $scope.writeTourSpotMemo = function () {
	    	var content = editor_object.getById["smarteditor"].getIR();
	    	console.log(editor_object.getById["smarteditor"]);
	    	
	    	if ($scope.writeTourSpotMemoData.memoType == 0 || null) {
	    		swal("놉!")
	    		return;
	    	};
	    	
	    	if (!$scope.writeTourSpotMemoData.title) {
	    		swal("놉!")
	    		return;
	    	}
	    	
	    	if (!content) {
	    		swal("놉!")
	    		return;
	    	}
	    	
	    	if ($scope.writeTourSpotMemoData.locationNo == 0 || null) {
	    		swal("놉!")
	    		return;
	    	}
	    	
	    	$http({
	    		url: myConfig.serverURL + "/tourPlan/insert/tourSpotMemo",
	    		method: "POST",
				data: $.param({
					memoType: $scope.writeTourSpotMemoData.memoType,
					title: $scope.writeTourSpotMemoData.title,
					userUid: $rootScope.user.userUid,
	    			locationNo: $scope.writeTourSpotMemoData.locationNo,
	    			recordNo: RequestService.getParameter("recordNo"),
					content: content,
					contentId: $scope.writeTourSpotMemoData.contentId
				}),
				headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
			})
			.success(function (response) {
				$scope.closeWriteTourSpotMemoFormModal();
				swal("성공", "글이 등록되었습니다.");
				$scope.getWriteTourSpotMemoList();
			})
			.error(function (error) {
				swal("에러", "서버접속불가");
			})
	    }
	    
	    // 스토리 삭제
	    $scope.deleteTourSpotMemo = function (scheduleMemoNo) {
			swal({
				title : "여행기 삭제",
				text : "해당 여행기를 삭제하시겠습니까?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "네",
				cancelButtonText : "아니오",
				closeOnConfirm : false,
				closeOnCancel : false
			}, function(isConfirm) {
				if (isConfirm) {
		            $http({
		                url: myConfig.serverURL + "/tourPlan/delete/tourSpotMemo?scheduleMemoNo=" + scheduleMemoNo,
		                method: "DELETE",
		            }).success(function(response) {
		            	swal("삭제완료!", "삭제완료 하였습니다.", "success");
		            	$scope.getWriteTourSpotMemoList();
		            }).error(function(error) {
		                console.log(error);
		            })
				} else {
					swal("취소됨!", "삭제가 취소되었습니다.", "error");
				}
			});
	    	
	    }
	    
	    // TODO 스토리 수정(모달창 열기)
	    $scope.updateTourSpotMemoForm = function () {
	    	
	    }
	    
	    // TODO 스토리 수정
	    $scope.updateTourSpotMemo = function (locationNo) {
	    	
	    }
	    
		
		/** ==================================================== */
		/** 예산 */
		/** ==================================================== */
		// 파라미터 기본값
	    $scope.chartParam = {
	    	type: "1",
	    	chart: "1"
	    }
	    
	    // 예산 모달 열기
	    $scope.openTourPlanBudget = function () {
	    	$("#tourPlanBudgetModal").modal("show");
	    	$scope.selectChart($scope.chartParam.type, $scope.chartParam.chart);
	    };
	    
	    // 차트 선택
	    $scope.selectChart = function () {
	    	$("#chart").html("");
	    	var data;
	    	
	    	switch ($scope.chartParam.type) {
	    	case 1:
		    	data = $scope.makeDataForDate();
	    		break;
	    	case 2:
	    		data = $scope.makeDataForType();
	    		break;
	    	case 3:
	    		data = $scope.makeDataForTourSpot();
	    		break;
	    	case "1":
	    		data = $scope.makeDataForDate();
	    		break;
	    	case "2":
	    		data = $scope.makeDataForType();
	    		break;
	    	case "3":
	    		data = $scope.makeDataForTourSpot();
	    		break;
	    	}
	    	
	    	switch ($scope.chartParam.chart) {
	    	case 1:
	    		$scope.pieChart(data);
	    		break;
	    	case 2:
	    		$scope.discreteBarChart(data);
	    		break;
	    	case "1":
	    		$scope.pieChart(data);
	    		break;
	    	case "2":
	    		$scope.discreteBarChart(data);
	    		break;
	    	}
	    }
	    
	    // 여행 장소별로
	    $scope.makeDataForTourSpot = function () {
	    	var data = [];
	    	for (var i = 0; i < $scope.budgetDataForChart.length ; i++) {
	    		var really = false;
	    		for (var j = 0; j < data.length; j++) {
	    			if (data[j].label == $scope.budgetDataForChart[i].title) {
	    				data[j].value += $scope.budgetDataForChart[i].travelPrice;
	    				really = true;
	    			}
	    		}
	    		if (really == false) {
	    			data.push({label: $scope.budgetDataForChart[i].title, value: $scope.budgetDataForChart[i].travelPrice})
	    		}
	    	}
	    	return data;
	    }
	    
	    // 여행 일차별로
	    $scope.makeDataForDate = function () {
	    	var DateString = function (dateNo) {
	    		return dateNo + "일차";
	    	}
	    	var data = [];
	    	for (var i = 0; i < $scope.budgetDataForChart.length ; i++) {
	    		var really = false;
	    		for (var j = 0; j < data.length; j++) {
	    			if (data[j].label == DateString($scope.budgetDataForChart[i].dateArray)) {
	    				data[j].value += $scope.budgetDataForChart[i].travelPrice;
	    				really = true;
	    			}
	    		}
	    		if (really == false) {
	    			data.push({label: DateString($scope.budgetDataForChart[i].dateArray), value: $scope.budgetDataForChart[i].travelPrice})
	    		}
	    	}
	    	return data;
	    };
	    
	    // 지출 종류별로
	    $scope.makeDataForType = function () {
			var budgetType = function (priceType) {
				switch (priceType) {
				case 1:
					return "교통"
				case 2:
					return "음식"
				case 3:
					return "엑티비티"
				case 4:
					return "쇼핑"
				case 5:
					return "숙박"
				case 6:
					return "기타"
				}
			}
			
	    	var data = [];
	    	
	    	for (var i = 0; i < $scope.budgetDataForChart.length ; i++) {
	    		var really = false;
	    		for (var j = 0; j < data.length; j++) {
	    			if (data[j].label == budgetType($scope.budgetDataForChart[i].priceType)) {
	    				data[j].value += $scope.budgetDataForChart[i].travelPrice;
	    				really = true;
	    			}
	    		}
	    		if (really == false) {
	    			data.push({label: budgetType($scope.budgetDataForChart[i].priceType), value: $scope.budgetDataForChart[i].travelPrice})
	    		}
	    	}
	    	return data;
	    }
	    
	    // 원형 그래프 그리기
	    $scope.pieChart = function (data) {
	        var width = 868;
	        var chart;
			nv.addGraph(function() {
			    var chart = nv.models.pieChart()
			        .x(function(d) { return d.label })
			        .y(function(d) { return d.value })
			        .donut(true)
			        .width(width)
			        .padAngle(.08)
			        .cornerRadius(5)
			        .duration(700)
			        .labelSunbeamLayout(true)
			        .showTooltipPercent(true)
			        .labelType("value")
				chart.title("TOTAL : " + $scope.totalBudget + "원");
				chart.pie.labelsOutside(false).donut(true);
				chart.valueFormat(function (d) { return d3.format(",.0")(d)+"원" });
				d3.select("#chart")
					.datum(data)
					.transition().duration(700)
					.call(chart);
				return chart;
			});
	    }
	    
	    // 막대 그래프 그리기
	    $scope.discreteBarChart = function (data) {
	    	thisData = [{ key: "Budget", values: data}]
	    	var width = 868;
	    	var chart;
			nv.addGraph(function() {
			    var chart = nv.models.discreteBarChart()
			        .x(function(d) { return d.label })
			        .y(function(d) { return d.value })
			        .staggerLabels(false)
			        .width(width)
			        .showValues(true)
			        .valueFormat(function(d) { return d3.format(",.0")(d)+"원" })
			        .duration(700);
	            chart.yAxis
	            	.tickFormat(function(d) { return d3.format(",.0")(d)+"원" });
			d3.select("#chart")
			        .datum(thisData)
			        .call(chart);
			    nv.utils.windowResize(chart.update);
			    return chart;
			});
	    }
	                
		// 필요 칼럼 : 예산명(content), 예산(travelPrice), 예산종류(priceType), 일차(dateArray), 예산사용일정(tourPlanTitle)
		$scope.budgetDataForChart = [];
		
		// D3용 예산 데이터 가져오기
	    $scope.getBudgetListForChart = function () {
	    	$http({
				url: myConfig.serverURL + "/tourPlan/select/budgetListForChartByRecordNo?recordNo=" + RequestService.getParameter("recordNo"),
				method: "GET",
			}).success(function (response) {
				$scope.budgetDataForChart = response;
//				console.log(response);
			}).error(function (error) {
				swal("에러", erorr, "error");
			});
	    };
	    
	    $scope.getBudgetListForChart();
	    
	    
	    // 예산 리스트 가져오기
	    $scope.getTourPlanBudgetList = function () {
	    	$http({
				url: myConfig.serverURL + "/tourPlan/select/budgetListByRecordNo?recordNo=" + RequestService.getParameter("recordNo"),
				method: "GET",
			}).success(function (response) {
				$scope.tourPlanBudgetList = response;
//				console.log($scope.tourPlanBudgetList);
				
				// 예산합
				$scope.getTotalBudget();
			}).error(function (error) {
				swal("에러", erorr, "error");
			});
	    };
	    
	    $scope.getTourPlanBudgetList();
	    
	    // 예산 작성하기
	    $scope.writeTourPlanBudget = function (scheduleMemoNo, tourPlanBudgetData, contentId, locationNo) {
	    	if (!tourPlanBudgetData) { swal("놉!"); return; };
	    	if (!tourPlanBudgetData.content) { swal("놉!"); return; };
	    	if (!tourPlanBudgetData.travelPrice) { swal("놉!"); return; };
	    	if (!tourPlanBudgetData.priceType) { swal("놉!"); return; };
	    	
	    	$http({
	    		url: myConfig.serverURL + "/tourPlan/insert/budget",
	    		method: "POST",
				data: $.param({
					scheduleMemoNo: scheduleMemoNo,
					recordNo: RequestService.getParameter("recordNo"),
					userUid: $rootScope.user.userUid,
					content: tourPlanBudgetData.content,
					travelPrice: tourPlanBudgetData.travelPrice,
					priceType: tourPlanBudgetData.priceType,
					contentId: contentId,
					locationNo: locationNo 
				}),
				headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
			})
			.success(function (response) {
			    $scope.getTourPlanBudgetList();
			    tourPlanBudgetData.content = "";
			    tourPlanBudgetData.travelPrice = 0;
			    tourPlanBudgetData.priceType = "";
			})
			.error(function (error) {
				swal("에러", "서버접속불가");
			})
	    }
	    
	    // 예산 지우기
	    $scope.delTourPlanBudget = function (travelPriceNo) {
	    	swal({
				title : "예산 삭제",
				text : "해당 예산을 삭제하시겠습니까?",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "네",
				cancelButtonText : "아니오",
				closeOnConfirm : false,
				closeOnCancel : false
			}, function(isConfirm) {
				if (isConfirm) {
		            $http({
		                url: myConfig.serverURL + "/tourPlan/delete/budgetByTravelPriceNo?travelPriceNo=" + travelPriceNo,
		                method: "DELETE",
		            }).success(function(response) {
		            	swal("삭제완료!", "삭제완료 하였습니다.", "success");
		            	$scope.getTourPlanBudgetList();
		            }).error(function(error) {
		                console.log(error);
		            })
				} else {
					swal("취소됨!", "삭제가 취소되었습니다.", "error");
				}
			});
	    }
	   
	    $scope.totalBudget;
	    
	    // 예산합계 구하는 메소드
	    $scope.getTotalBudget = function () {
	    	 // 예산 총합
	    	$scope.totalBudget = 0;
	    	for (var i = 0; i< $scope.tourPlanBudgetList.length; i++) {
	    		$scope.totalBudget += $scope.tourPlanBudgetList[i].travelPrice;
	    	}
	    }
	    
		
		/** ==================================================== */
		/** 관광지정보 리스트 */
		/** ==================================================== */
		/** contentTypeId
		 *  관광지 : 12, 14, 15, 25, 28
		 *  음식점 : 39
		 *  숙박업소 : 32
		 */
		// 장소 클릭 -> 디테일 정보(디테일 모달 CSS)
		$scope.openDetailTourSpot = function (tourSpot, contenttypeid) {
			if (contenttypeid) {
				var src = "include/tourSpotDetail.jsp?contentid=" + tourSpot + "&contenttypeid=" + contenttypeid;
				$("#tourSpotDetailIframe").attr("src", src);
				$("#detailTourSpotModal").modal("show");
			} else {
				// 주소
				var src = "include/tourSpotDetail.jsp?contentid=" + tourSpot.contentid + "&contenttypeid=" + tourSpot.contenttypeid;
				$("#tourSpotDetailIframe").attr("src", src);
				$("#detailTourSpotModal").modal("show");
			}
		}
		
		// 여행 장소 리스트 불러오기 
		$scope.getSpotList = function () {
			// 무한로딩 방지
//			console.log($scope.spotParams.pageNo);
//			console.log($scope.totalPages);
			if ($scope.spotParams.pageNo >= $scope.totalPages) {
				console.log("리스트 끝");
				return;
			}
			$scope.spotParams.pageNo++;
			$http({
				url: myConfig.serverURL + "/tourPlan/select/spotList",
				method: "GET",
				params: $scope.spotParams
			}).success(function (response) {
//				console.log(response);
				angular.forEach(response.tourSpotList, function (spot) {
					$scope.tourSpotList.push(spot);
				})					
				$scope.totalPages = response.totalPages;
				
			}).error(function (error) {
				console.log(error);
			});
			
		};
		
		// 장소리스트 ng-repeat 완료 함수 : 드래그 이벤트 걸어주기
		$scope.$on("ngRepeatFinished", function(ngRepeatFinishedEvent) {
			$scope.addDragEvent();
		});
		
		// 무한 스크롤 이벤트
		angular.element("#searchContent").scroll( function() {
			var elem = angular.element("#searchContent");
//			console.log("1 : " +typeof(elem[0].scrollHeight))
//			console.log("2 : " +typeof(elem.scrollTop()))
//			console.log("3 : " +elem.outerHeight())
//			console.log(elem[0].scrollHeight - elem.scrollTop())
			if (Math.floor(elem[0].scrollHeight - elem.scrollTop()) < elem.outerHeight()) {
				$scope.getSpotList();
			}
		});
		
		// 검색창 ENTER 이벤트
		angular.element("#searchText").on("keypress", function (e) {
	         if(e.which === 13){
	             if ($scope.spotParams.category) {
	            	 $scope.initSpotList($scope.spotParams.category);
	             } else {
	            	 $scope.initSpotList("all");
	             }
	          }
		})
		
		// 장소 리스트 가져오기 시작
		$scope.initSpotList = function (category) {
			// 장소 리스트 선언
			$scope.tourSpotList = [];
			// 검색 및 검색 디폴트 값
			$scope.spotParams = {
				standard: "PUBLIC_DATA_LIST_NO",
				order: "ASC",
				word: $scope.searchWord,
				category: category,
				amount: 20,
				pageNo: 0
			};
			$scope.totalPages = 1;
			// 첫 리스트 불러오기
			$scope.getSpotList();
		}
		
		// 디폴트 리스트 호출 : 전체
		$scope.initSpotList("all");
		

		/** ==================================================== */
		/** 북마크 */
		/** ==================================================== */
		// 여행 장소 리스트 불러오기 
		$scope.getBookmarkSpotList = function () {
			// 무한로딩 방지
//			console.log($scope.bookmarkSpotParams.pageNo);
//			console.log($scope.bookmarkTotalPages);
			if ($scope.bookmarkSpotParams.pageNo >= $scope.bookmarkTotalPages) {
				console.log("리스트 끝");
				return;
			}
			$scope.bookmarkSpotParams.pageNo++;
			$http({
				url: myConfig.serverURL + "/tourPlan/select/spotList/bookmark",
				method: "GET",
				params: $scope.bookmarkSpotParams
			}).success(function (response) {
//				console.log(response);
				angular.forEach(response.tourSpotList, function (spot) {
					$scope.tourBookmarkSpotList.push(spot);
				})					
				$scope.bookmarkTotalPages = response.totalPages;
				
			}).error(function (error) {
				console.log(error);
			});
			
		};
		
		// 장소리스트 ng-repeat 완료 함수 : 드래그 이벤트 걸어주기
		$scope.$on("ngRepeatFinished", function(ngRepeatFinishedEvent) {
			$scope.addBookmarkDragEvent();
		});
		
		// 무한 스크롤 이벤트
		angular.element("#bookmarkContent").scroll( function() {
			var elem = angular.element("#bookmarkContent");
//			console.log("1 : " +typeof(elem[0].scrollHeight))
//			console.log("2 : " +typeof(elem.scrollTop()))
//			console.log("3 : " +elem.outerHeight())
//			console.log(elem[0].scrollHeight - elem.scrollTop())
			if (Math.floor(elem[0].scrollHeight - elem.scrollTop()) < elem.outerHeight()) {
				$scope.getBookmarkSpotList();
			}
		});
		
		// 검색창 ENTER 이벤트
		angular.element("#bookmarkSearchText").on("keypress", function (e) {
			if(e.which === 13){
				if ($scope.bookmarkSpotParams.category) {
					$scope.initBookmarkSpotList($scope.bookmarkSpotParams.category);
				} else {
					$scope.initBookmarkSpotList("all");
				}
			}
		});
		
		// 장소 리스트 가져오기 시작
		$scope.initBookmarkSpotList = function (category) {
			// 장소 리스트 선언
			$scope.tourBookmarkSpotList = [];
			// 검색 및 검색 디폴트 값
			$scope.bookmarkSpotParams = {
					standard: "PUBLIC_DATA_LIST_NO",
					order: "ASC",
					word: $scope.bookmarkSearchWord,
					category: category,
					amount: 20,
					pageNo: 0,
					userUid: $rootScope.user.userUid
			};
			$scope.bookmarkTotalPages = 1;
			// 첫 리스트 불러오기
			$scope.getBookmarkSpotList();
		}
		
		// 디폴트 리스트 호출 : 전체
		$scope.initBookmarkSpotList("all");
		
		/** ==================================================== */
		/** 일정표												 */
		/** ==================================================== */
		// 일정표 객체 선언
		var calendarObj = $("#calendar");
		
		// 일정표 이벤트 리스트 가져오기 (전체 / 리스트)
		$scope.getAllCalendarEvents = function () {
			$scope.allTourSpotEvent = [];
			// 일정표에서 모든 이벤트 가져오기
			$scope.allEvents = calendarObj.fullCalendar("clientEvents");
			// 모든 이벤트중 tourSpot만 필터링해서 집어넣기
			for (var i = 0; i < $scope.allEvents.length; i++) {
				if ($scope.allEvents[i].category == "tourSpot") {
					$scope.allEvents[i].tourDate = $scope.allEvents[i].start.diff(moment($scope.tourPlan.departureDate), "days") + 1
					$scope.allTourSpotEvent.push($scope.allEvents[i]);
				};
			}
			
			// 이벤트 배열 정렬(시간순으로)
			$scope.allTourSpotEvent.sort(function (a, b) {
				return a.start.isBefore(b.start) ? -1 : a.start.isAfter(b.start) ? 1 : 0;
			});
			
			return $scope.allTourSpotEvent;
		};
		
		
		// 일정표 이벤트 객체 확인 (선택날짜)
		$scope.getCurrentDateCalendarEvents = function () {
			$scope.currentDateTourSpotEvents = [];
			// 일정표에서 선택날짜만 가져오는 이벤트 필터 적용해서 이벤트 가져오기
			$scope.currentDateEvents = calendarObj.fullCalendar("clientEvents", function (event) {
				if ($scope.calendarPage.currentDate.isSame(event.start, "day")) {
					return event;
				}
			});
			
			// 이벤트중 tourSpot만 필터링해서 집어넣기
			for (var i = 0; i < $scope.currentDateEvents.length; i++) {
				if ($scope.currentDateEvents[i].category == "tourSpot") {
					$scope.currentDateEvents[i].tourDate = $scope.currentDateEvents[i].start.diff(moment($scope.tourPlan.departureDate), "days") + 1
					$scope.currentDateTourSpotEvents.push($scope.currentDateEvents[i]);
				};
			}
			
			// 이벤트 배열 정렬(시간순으로)
			$scope.currentDateTourSpotEvents.sort(function (a, b) {
				return a.start.isBefore(b.start) ? -1 : a.start.isAfter(b.start) ? 1 : 0;
			});
			
			return $scope.currentDateTourSpotEvents;
		};
		
		
		// 일정표 날짜 변수 업데이트 메소드
		$scope.setCalendarDate = function () {
			$scope.calendarPage = {
				currentDate: moment($scope.tourPlan.departureDate),
				startLimitDate: moment($scope.tourPlan.departureDate),
				endLimitDate: moment($scope.tourPlan.arriveDate).endOf("day"),
				currentDateStart: moment($scope.tourPlan.departureDate).startOf("day"),
				currentDateEnd: moment($scope.tourPlan.departureDate).endOf("day")
			}
			// 선택가능날짜 업데이트
			$scope.setAvailableBackgroundEvent();
			// 선택날짜 업데이트
			$scope.setCurrentBackgroundEvent();
			// 현재날짜 처음으로
			calendarObj.fullCalendar("gotoDate", $scope.calendarPage.currentDate);
		};
		
		// 선택 가능날짜 배경 이벤트 업데이트 메소드
		$scope.setAvailableBackgroundEvent = function () {
			var availableBackgroundEvent = calendarObj.fullCalendar("clientEvents", "availableDate");
			availableBackgroundEvent[0].start = $scope.calendarPage.startLimitDate;
			availableBackgroundEvent[0].end = $scope.calendarPage.endLimitDate;
			calendarObj.fullCalendar("updateEvent", availableBackgroundEvent[0]);
		}
		// 현재 선택날짜 배경 이벤트  업데이트 메소드
		$scope.setCurrentBackgroundEvent = function () {
			var currentBackgroundEvent = calendarObj.fullCalendar("clientEvents", "currentDate");
			currentBackgroundEvent[0].start = $scope.calendarPage.currentDateStart;
			currentBackgroundEvent[0].end = $scope.calendarPage.currentDateEnd;
			calendarObj.fullCalendar("updateEvent", currentBackgroundEvent[0]);
		}
		
		// 일정표 initialize
		$scope.initCalendar = function () {
			// Full Calendar 옵션
			calendarObj.fullCalendar({
				// 타임존
				timezone: "local",
				// 높이
				height: "auto",
				// 달 표시 옵션
				monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
				monthNamesShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
				// 요일 표시 옵션
				dayNames: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
				dayNamesShort: ["일", "월", "화", "수", "목", "금", "토"],
				// 제목 표시 형식
				titleFormat: "YYYY년 MM월 DD일",
				// 칼럼 표시 형식
				columnFormat: "MM월 DD일 ddd요일",
				// 사용자 정의 버튼
			    customButtons: {
			    	firstDayBtn: {
			            text: "첫날",
			            icon: "left-double-arrow",
			            click: $scope.toDayMethods.toFirstDay
			    	},
			    	LastDayBtn: {
						text: "마지막날",
						icon: "right-double-arrow",
						click: $scope.toDayMethods.toLastDay
			    	},
			        prevDayBtn: {
			            text: "이전",
			            icon: "left-single-arrow",
			            click: $scope.toDayMethods.toPrevDay
			        },
					nextDayBtn: {
						text: "다음",
						icon: "right-single-arrow",
						click: $scope.toDayMethods.toNextDay
					}
			    },
			    // 헤더 메뉴 구성
			    header: {
			    	left: "firstDayBtn, LastDayBtn",
			    	center: "prevDayBtn, title, nextDayBtn",
			    	right: "agendaWeekDay, agendaThreeDay"
			    },
			    // 뷰
			    views: {
			        agendaThreeDay: {
			            type: "agenda",
			            duration: {days:3},
			            buttonText: "3일",
			        },
			        agendaWeekDay: {
			        	type: "agenda",
			            duration: {days:7},
			        	buttonText: "일주일"
			        }
			    },
			    // 기본 뷰
				defaultView: "agendaThreeDay",
				// 공통일정 : 허용하지 않음
				allDaySlot: false,
				// 매일 시작시간 : 아침 06시
				minTime: "06:00:00",
				// 일정 겹치기 : 허용하지 않음
				slotEventOverlap: false,
				// 동시간대 일정 : 허용
				eventOverlap: true,
				// 기본 일정 시작 일자
				defaultDate: $scope.calendarPage.currentDate,
				// 드래그앤드랍설정
				editable: true,
				droppable: true,
				// 드래그시 투명도
				dragOpacity: 0.8,
				// 이벤트 디폴트 시간
				defaultTimedEventDuration: "02:00:00",
				// 디폴트 이벤트(백그라운드)
				events: [
					// 선택된 날짜
					{
						id: "currentDate",
						start: $scope.calendarPage.currentDateStart,
						end: $scope.calendarPage.currentDateEnd,
						overlap: true,
						rendering: "background"
					},
					// 입력 가능 날짜
					{
						id: "availableDate",
						start: $scope.calendarPage.startLimitDate,
						end: $scope.calendarPage.endLimitDate,
						overlap: true,
						rendering: "inverse-background",
						color: "#ff9f89"
					}
				],
				// 이벤트 렌더시 삭제 버튼 주기
				eventRender: function(event, element) { 
					if (event.id != "currentDate" && event.id != "availableDate") {
						element.find(".fc-bg").css("pointer-events","none");
					    element.append(
					    		"<div class='btnDiv' style='position:absolute;top:1px;right:1px;z-index:1000;display:none;'>" +
					    		"<button type='button' id='btnDeleteEvent' class='btn-u btn-u-xs btn-u-red rounded'><i class='fa fa-times' aria-hidden='true'></i></button>" +
					    		"</div>" + 
					    		"<div><img src='"+ event.imageUrl +"' style='margin-left:3px; width:70px; height:50px; float:left;'></div>" +
					    		"<div style='width: 170px; height: 55px; float:left; margin-left: 5px;'>" +
					    		"<p style='color:white;'>"+ event.overview +"</p>" +
					    		"</div>"
					    );
					    element.find("#btnDeleteEvent").click(function(){
					    	$('#calendar').fullCalendar('removeEvents',event._id);
					    	$scope.$apply(function() {
					    		$scope.getAllCalendarEvents();
					    	});
					    	renderingEventToMap();
					    });
					}
				},
				// 이벤트 추가시 콜백
			    eventReceive: function(event) {
		            $scope.$apply(function() {
		            	$scope.getAllCalendarEvents();
		            });
		            renderingEventToMap();
			    },
			    // 이벤트 드래그앤 드롭시
			    eventDrop: function(event) {
		            $scope.$apply(function() {
		            	$scope.getAllCalendarEvents();
		            });
		            renderingEventToMap();
			    },
			    // 이벤트 리사이즈시
			    eventResize: function(event, delta, revertFunc) {
		            $scope.$apply(function() {
		            	$scope.getAllCalendarEvents();
		            });
		            renderingEventToMap();
			    },
				// 이벤트 클릭
			    eventClick: function(calEvent, jsEvent, view) {
			    	var param = {
			    		contentid: calEvent.contentId,
			    		contenttypeid: calEvent.contentTypeId
			    	}
			    	
			    	$scope.openDetailTourSpot(param);
			    },
			    // 이벤트 마우스 오버
			    eventMouseover: function( event, jsEvent, view ) {
			        $(this).css('border-width', '2px');
			        $(this).find(".btnDiv").css("display", "block");
			    },
			    // 이벤트 마우스 아웃
			    eventMouseout : function( event, jsEvent, view ) { 
			    	$(this).css('border-width', '1px');
			    	$(this).find(".btnDiv").css("display", "none");
			    }
			});
		};
		
		// 여행장소리스트 드래그 이벤트 추가 함수
		$scope.addDragEvent = function () {
	        angular.element($("#searchContent .tourSpot")).each(function() {
	    		// 각 이벤트에 들어가야할 데이터
	    		$(this).data("event", {
	    			title: $(this).children().first().find("b:eq(2)").text(), // 태그안 택스트를 title 변수로 준다
	    			stick: true, // 날짜이동해도 일정을 유지시켜줌
	    			constraint: "availableDate", // availableDate필드에만 일정 추가 가능
	    			color: $(this).children().first().find("b:eq(6)").text(),
	    			
	    			// 필터를 위한
	    			category: "tourSpot",
	    			
	    			// DB에 들어가야할 일정 데이터 
	    			recordNo: RequestService.getParameter("recordNo"),
	    			contentId: $(this).children().first().find("b:eq(0)").text(),
	    			contentTypeId: $(this).children().first().find("b:eq(1)").text(),
	    			spotTitle: $(this).children().first().find("b:eq(2)").text(),
	    			mapX: $(this).children().first().find("b:eq(3)").text(),
	    			mapY: $(this).children().first().find("b:eq(4)").text(),
	    			imageUrl: $(this).children().first().find("b:eq(5)").text(),
	    			categoryColor: $(this).children().first().find("b:eq(6)").text(),
	    			categoryName: $(this).children().first().find("b:eq(7)").text(),
	    			overview: $(this).children().first().find("b:eq(8)").text()
	    		});
	    		
	    		// JQuery-UI 드래그 이벤트 추가 함수
	    		$(this).draggable({
	    			revert: true,
	    			revertDuration: 0,
	    			zIndex: 99,
	    			appendTo: "body",
	    			containment: "window",
	    			scroll: false,
	    			helper: "clone"
	    		});
	    	});
		};
		
		// 여행장소 북마크 리스트 드래그 이벤트 추가 함수
		$scope.addBookmarkDragEvent = function () {
	        angular.element($("#bookmarkContent .tourSpot")).each(function() {
	    		// 각 이벤트에 들어가야할 데이터
	    		$(this).data("event", {
	    			title: $(this).children().first().find("b:eq(2)").text(), // 태그안 택스트를 title 변수로 준다
	    			stick: true, // 날짜이동해도 일정을 유지시켜줌
	    			constraint: "availableDate", // availableDate필드에만 일정 추가 가능
	    			color: $(this).children().first().find("b:eq(6)").text(),
	    			
	    			// 필터를 위한
	    			category: "tourSpot",
	    			
	    			// DB에 들어가야할 일정 데이터 
	    			recordNo: RequestService.getParameter("recordNo"),
	    			contentId: $(this).children().first().find("b:eq(0)").text(),
	    			contentTypeId: $(this).children().first().find("b:eq(1)").text(),
	    			spotTitle: $(this).children().first().find("b:eq(2)").text(),
	    			mapX: $(this).children().first().find("b:eq(3)").text(),
	    			mapY: $(this).children().first().find("b:eq(4)").text(),
	    			imageUrl: $(this).children().first().find("b:eq(5)").text(),
	    			categoryColor: $(this).children().first().find("b:eq(6)").text(),
	    			categoryName: $(this).children().first().find("b:eq(7)").text(),
	    			overview: $(this).children().first().find("b:eq(8)").text()
	    		});
	    		
	    		// JQuery-UI 드래그 이벤트 추가 함수
	    		$(this).draggable({
	    			revert: true,
	    			revertDuration: 0,
	    			zIndex: 99,
	    			appendTo: "body",
	    			containment: "window",
	    			scroll: false,
	    			helper: "clone"
	    		});
	    	});
		};

		// 일정 이동 메소드들
		$scope.toDayMethods = {
			toFirstDay: function () {
				$scope.calendarPage = {
						currentDate: moment($scope.tourPlan.departureDate),
						startLimitDate: moment($scope.tourPlan.departureDate),
						endLimitDate: moment($scope.tourPlan.arriveDate).endOf("day"),
						currentDateStart: moment($scope.tourPlan.departureDate).startOf("day"),
						currentDateEnd: moment($scope.tourPlan.departureDate).endOf("day")
				}
				calendarObj.fullCalendar("gotoDate", $scope.calendarPage.currentDate);
				
				$scope.setCurrentBackgroundEvent();
				
				renderingEventToMap();
			},
			toLastDay: function () {
				$scope.calendarPage = {
						currentDate: moment($scope.tourPlan.arriveDate),
						startLimitDate: moment($scope.tourPlan.departureDate),
						endLimitDate: moment($scope.tourPlan.arriveDate).endOf("day"),
						currentDateStart: moment($scope.tourPlan.arriveDate).startOf("day"),
						currentDateEnd: moment($scope.tourPlan.arriveDate).endOf("day")
				}
				calendarObj.fullCalendar("gotoDate", $scope.calendarPage.currentDate);
				
				$scope.setCurrentBackgroundEvent();
				
				renderingEventToMap();
			},
			toPrevDay: function () {
				if ($scope.calendarPage.currentDate.isSameOrBefore($scope.calendarPage.startLimitDate)) {
					swal("첫날입니다.");
				} else {
					$scope.calendarPage.currentDate.subtract(1, "days");
					$scope.calendarPage.currentDateStart.subtract(1, "days");
					$scope.calendarPage.currentDateEnd.subtract(1, "days");
					calendarObj.fullCalendar("gotoDate", $scope.calendarPage.currentDate);
					
					$scope.setCurrentBackgroundEvent();
					
					renderingEventToMap();
				}
			},
			toNextDay: function () {
				if ($scope.calendarPage.currentDate.isSameOrAfter($scope.calendarPage.endLimitDate.startOf("day"))) {
					swal("마지막날 입니다.");
					// 일정추가 물어보기
				} else {
					$scope.calendarPage.currentDate.add(1, "days");
					$scope.calendarPage.currentDateStart.add(1, "days");
					$scope.calendarPage.currentDateEnd.add(1, "days");
					calendarObj.fullCalendar("gotoDate", $scope.calendarPage.currentDate);
					
					$scope.setCurrentBackgroundEvent();
					
					renderingEventToMap();
				}
			}
		};
		
		
		/** ==================================================== */
		/** 구글맵 */
		/** ==================================================== */
		// 맵 설정 변수
		var infowindow;
		var markers = [];
		var map;
		var labels = '123456789';
		var labelIndex = 0;
		var flightPath = null;
		
		// 맵 이닛 함수
		function initMap() {
			var myLatlng = new google.maps.LatLng(37.4963799255, 127.0265547405);
			var mapOptions = {
				center : myLatlng,
				zoom : 8
			};
			map = new google.maps.Map(document.getElementById("map"), mapOptions);
		}
		
		// 선긋기
		function addLocationInfo(eventList) {
			var locationInfos = [];
			for (var i = 0; i < eventList.length; i++) {
				var locationInfo = {
					lat : Number(eventList[i].mapY),
					lng : Number(eventList[i].mapX)
				}
				locationInfos.push(locationInfo);
			}

			flightPath = new google.maps.Polyline({
				path : locationInfos,
				geodesic : true,
				strokeColor : '#46c0fb',
				strokeOpacity : 0.8,
				strokeWeight : 3
			});
			flightPath.setMap(map);
			
			// 위치정보에 따라 맵 범위 설정
			var bounds = new google.maps.LatLngBounds();
			if (eventList.length == 0) {
				bounds.extend(new google.maps.LatLng(37.5, 127.1000000000));
				bounds.extend(new google.maps.LatLng(35, 127.0265547405));
			}
			for (var i = 0; i < eventList.length; i++) {
				var locationInfo = {
					lat : Number(eventList[i].mapY),
					lng : Number(eventList[i].mapX)
				}
				bounds.extend(locationInfo);
			}
			map.fitBounds(bounds);

		}
		
		// 선지우기
		function removePath() {
			flightPath.setMap(null);
		}
		
		// 마커 이벤트
		function drop(eventList) {
			clearMarkers();
			labelIndex = 0;
			for (var i = 0; i < eventList.length; i++) {
				addMarkerWithTimeout(eventList[i], i * 50);
			}
		}
		
		// 마커 1초후에 찍어주기
		function addMarkerWithTimeout(event, timeout) {
			var locationPosition = {
				lat : Number(event.mapY),
				lng : Number(event.mapX)
			}
			window.setTimeout(function() {
				// 마커
				var marker = new google.maps.Marker({
					position : locationPosition,
					map : map,
					animation : google.maps.Animation.DROP,
					label : labels[labelIndex++ % labels.length],
					title : event.title
				});

				markers.push(marker);
				
				// 인포윈도우 꾸미기
				var content = '<a style="text-decoration: none; font-weight: bold" href="#1">'
						+ event.title
						+ '</a>';
				infowindow = new google.maps.InfoWindow();
				marker.addListener('mouseover', function() {
					infowindow.close();
					infowindow.setContent(content);
					infowindow.open(map, marker);
				})
//				console.log(event)
			}, timeout);
		}

		// 마커 클리어
		function clearMarkers() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}
		
		// 일정표 지도에 렌더링
		function renderingEventToMap() {
			var currentEventList = $scope.getCurrentDateCalendarEvents();
			if (flightPath) {
				removePath();
			}
			addLocationInfo(currentEventList);
			drop(currentEventList);
		}
		
		/** ==================================================== */
		/** 기타 */
		/** ==================================================== */
		// 여행지 메뉴 스크롤 컨트롤
		var scrollVarObj = {
			attbHeight: $("#attractionTab").height(),
			searchHeight: $("#searchContent").height(),
			bookMarkHeight: $("#bookmarkContent").height()
		}
		
	    angular.element(document).scroll( function() {
	    	if ($(window).scrollTop() > 709) {
    			$("#attractionTab").animate({"top": $(window).scrollTop() - 709 + 125.46875}, {duration:"fast", easing:"linear", queue:false});
    			$("#attractionTab").animate({"height": scrollVarObj.attbHeight - ($(window).scrollTop() - 709)}, {duration:"fast", easing:"linear", queue:false});
    			$("#searchContent").animate({"height": scrollVarObj.searchHeight - ($(window).scrollTop() - 709)}, {duration:"fast", easing:"linear", queue:false});
    			$("#bookmarkContent").animate({"height": scrollVarObj.bookMarkHeight - ($(window).scrollTop() - 709)}, {duration:"fast", easing:"linear", queue:false});
    			$("#searchContent").css("overflow", "scroll");
    			$("#bookmarkContent").css("overflow", "scroll");
	    	} else {
				$("#attractionTab").animate({"top": 125.46875}, {duration:"fast", easing:"linear", queue:false});
	    		$("#attractionTab").animate({"height": scrollVarObj.attbHeight}, {duration:"fast", easing:"linear", queue:false});
	    		$("#searchContent").animate({"height": scrollVarObj.searchHeight}, {duration:"fast", easing:"linear", queue:false});
	    		$("#bookmarkContent").animate({"height": scrollVarObj.bookMarkHeight}, {duration:"fast", easing:"linear", queue:false});
	    		$("#searchContent").css("overflow", "scroll");
	    		$("#bookmarkContent").css("overflow", "scroll");
	    	}
		});
		
		// 검색창 활성 비활성
		$scope.isPlanAndMap = true;
		
		$scope.showTourSpotList = function () {
			$scope.isPlanAndMap = true;
		}
		
		$scope.hideTourSpotList = function () {
			$scope.isPlanAndMap = false;
		}

  })
  
	