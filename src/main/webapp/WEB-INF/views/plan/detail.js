angular.module("TourPlanApp")
	.controller("DetailController", function ($rootScope, $scope, $http, $window, $timeout, RequestService) {
		/** ==================================================== */
		/** 여행일정 기본 데이터 불러오기 */
		/** ==================================================== */
		// recordNo로 파라미터 받은 값으로 일정 정보 불러옴
		$scope.getTourPlan = function () {
//			$.isLoading({
//				position: "overlay",
//				text: "Loading"
//			});
			
			$http({
				url: myConfig.serverURL + "/tourPlan/select/oneTourPlan?recordNo=" + RequestService.getParameter("recordNo"),
				method: "GET"
			}).success(function (response) {
//				console.log(response);
				
				// TODO 공개비공개 확인
				
				// 유저 확인
				if (response.userUid == $rootScope.user.userUid) {
					$scope.isWriter = true; 
				}
				
				$scope.tourPlan = response;
				$scope.tourPlan.departureDate = new Date(response.departureDate);
				$scope.tourPlan.arriveDate = new Date(response.arriveDate);
				$scope.tourPlan.period = $scope.convertDate($scope.tourPlan.departureDate, $scope.tourPlan.arriveDate);
				$scope.tourPlan.regDate = new Date(response.regDate);
				/** ==================================================== */
				/** 여행일정 작성자 데이터 불러오기 */
				/** ==================================================== */
				$http({
					url: myConfig.serverURL + "/user/select/oneUser?userUid=" + response.userUid,
					method: "GET"
				}).success(function (response) {
					console.log(response);
					$scope.writer = response;
				}).error(function (error) {
					
				})
				
				/** ==================================================== */
				/** 여행일정 좋아요 북마크 커스터마이징 데이터 불러오기 */
				/** ==================================================== */
				$scope.checkTourPlanSet();
				
				/** ==================================================== */
				/** 댓글 불러오기 */
				/** ==================================================== */
				$scope.getCommentList();
				
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
						// 일정표에 이벤트 렌더링
						calendarObj.fullCalendar("renderEvent", event, true);
					}
					
					// 일정표 바인딩
					$scope.getAllCalendarEvents();
					// 구글맵 이니시
					initMap();
					// 지도에 이벤트 렌더링
					renderingEventToMap();
					
//					$.isLoading("hide");
					
				}).error(function (error) {
					console.log(error);
				});
			}).error(function (error) {
				swal("에러", "잘못된 접근입니다.", "error");
				// 일정리스트 페이지로 리다이렉트
				$window.location.href = "list.jsp";
			});
		};
		
		
		/** ==================================================== */
		/** 여행일정 수정, 공개, 좋아요, 북마크, 복사 */
		/** ==================================================== */
		// 수정하기
		$scope.modTourPlan = function () {
			// 일정을 수정하시겠습니까?
			swal({
				  title: "일정을 수정하시겠습니까?",
				  text: "일정수정",
				  type: "warning",
				  showCancelButton: true,
				  closeOnConfirm: false,
				  showLoaderOnConfirm: true,
				},
				function(){
					$window.location.href = "makeplan.jsp?recordNo=" + RequestService.getParameter("recordNo");
				});
		};
		
		// 일정 공개 비공개
		$scope.togglePrivateTourPlan = function () {
			if ($scope.tourPlan.isOpen == 2) {
				swal({
					  title: "일정공개",
					  text: "일정을 공개하시겠습니까",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#DD6B55",
					  confirmButtonText: "네",
					  cancelButtonText: "아니오",
					  closeOnConfirm: false,
					  closeOnCancel: false
					},
					function(isConfirm){
						if (isConfirm) {
							$http({
								url: myConfig.serverURL + "/tourPlan//update/tourPlanOpen?recordNo=" + RequestService.getParameter("recordNo") + "&isOpen=1",
								method: "GET"
							}).success(function (response) {
								$scope.tourPlan.isOpen = 1;
								swal("공개됨!", "당신의 일정에 공개처리 되었습니다.", "success");
							})
						} else {
							swal("취소", "취소되었습니다.", "error");
						}
					});
			} else {
				swal({
					  title: "일정비공개",
					  text: "일정을 비공개하시겠습니까",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#DD6B55",
					  confirmButtonText: "네",
					  cancelButtonText: "아니오",
					  closeOnConfirm: false,
					  closeOnCancel: false
					},
					function(isConfirm){
						if (isConfirm) {
							$http({
								url: myConfig.serverURL + "/tourPlan/update/tourPlanOpen?recordNo=" + RequestService.getParameter("recordNo") + "&isOpen=2",
								method: "GET"
							}).success(function (response) {
								$scope.tourPlan.isOpen = 2;
								swal("비공개됨!", "당신의 일정에 비공개처리 되었습니다.", "success");
							})
						} else {
							swal("취소", "취소되었습니다.", "error");
						}
					});
			}
		};
		
		$scope.myselfAlert = function () {
			swal("취소", "자신의 일정에는 하실수 없습니다.", "error");
		};
		
		// 체크 좋아요 북마크 커스텀
		$scope.checkTourPlanSet = function () {
			$http({
				url: myConfig.serverURL + "/tourPlan/checkScheduleSet?recordNo="+ RequestService.getParameter("recordNo") + "&userUid=" + $rootScope.user.userUid + "&targetType=3",
				method: "GET"
			}).success(function (response) {
//				console.log(response);
				$scope.tourPlanCheckSet = response;
			})
		};
		
		// 토스트
		$scope.toast = function (text, heading, icon) {
			$.toast({
			    text: text, // Text that is to be shown in the toast
			    heading: heading, // Optional heading to be shown on the toast
			    icon: icon, // Type of toast icon
			    showHideTransition: 'fade', // fade, slide or plain
			    allowToastClose: false, // Boolean value true or false
			    hideAfter: 1000, // false to make it sticky or number representing the miliseconds as time after which toast needs to be hidden
			    stack: false, // false if there should be only one toast at a time or a number representing the maximum number of toasts to be shown at a time
			    position: 'mid-center', // bottom-left or bottom-right or bottom-center or top-left or top-right or top-center or mid-center or an object representing the left, right, top, bottom values
			    textAlign: 'left',  // Text alignment i.e. left, right or center
			    loader: false,
			});
		}
		
		// 좋아요
		$scope.likeTourPlan = function () {
				if($scope.tourPlanCheckSet.scheduleLike) {
					$http({
						url: myConfig.serverURL + "/tourPlan/addScheduleLike?recordNo="+ RequestService.getParameter("recordNo") + "&userUid=" + $rootScope.user.userUid,
						method: "GET"
					}).success(function (response) {
						$scope.tourPlan.likeCnt = response;
						$scope.checkTourPlanSet();
						$scope.toast("이 일정을 추천합니다.", "좋아요", "success");
					})
				} else {
					$http({
						url: myConfig.serverURL + "/tourPlan/cancelScheduleLike?recordNo="+ RequestService.getParameter("recordNo") + "&userUid=" + $rootScope.user.userUid,
						method: "GET"
					}).success(function (response) {
						$scope.tourPlan.likeCnt = response;
						$scope.checkTourPlanSet();
						$scope.toast("추천을 취소합니다.", "좋아요", "error")
					})
				}
		};
		
		// 북마크
		$scope.bookmarkTourPlan = function () {
			if($scope.tourPlanCheckSet.bookMark) {
				$http({
					url: myConfig.serverURL + "/tourPlan/addScheduleBookmark?targetNo="+ RequestService.getParameter("recordNo") + "&userUid=" + $rootScope.user.userUid + "&targetType=3",
					method: "GET"
				}).success(function (response) {
					$scope.tourPlan.bookmarkCnt = response;
					$scope.checkTourPlanSet();
					$scope.toast("이 일정을 북마크합니다.", "북마크", "success");
				})
			} else {
				$http({
					url: myConfig.serverURL + "/tourPlan/cancelScheduleBookMark?targetNo="+ RequestService.getParameter("recordNo") + "&userUid=" + $rootScope.user.userUid + "&targetType=3",
					method: "GET"
				}).success(function (response) {
					$scope.tourPlan.bookmarkCnt = response;
					$scope.checkTourPlanSet();
					$scope.toast("북마크를 취소합니다.", "북마크", "error");
				})
			}
		};
		
		// 일정복사
		$scope.customizingTourPlan = function () {
			console.log($scope.tourPlanCheckSet.customizing);
			if($scope.tourPlanCheckSet.customizing) {
				// 로딩버튼 달기
				$http({
					url: myConfig.serverURL + '/tourPlan/addCustomizing',
					method: 'POST',
					data: $.param({
						recordNo : $scope.tourPlan.recordNo,
						budGet : $scope.tourPlan.budGet,
						period : $scope.tourPlan.period,
						strapline : $scope.tourPlan.strapline,
						title : $scope.tourPlan.title,
						departureDate : $scope.tourPlan.departureDate,
						arriveDate : $scope.tourPlan.arriveDate,
						isOpen : 2,
						userUid : $rootScope.user.userUid
					}),
					headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
				}).success(function (response) {
					$scope.tourPlan.customCnt = response;
					$scope.checkTourPlanSet();
					
					$scope.toast("이 일정을 복사합니다.", "커스터마이징", "success");
				})
			} else {
				$http({
					url: myConfig.serverURL + "/tourPlan/cancelCustomizing?recordNo="+ RequestService.getParameter("recordNo") + "&userUid=" + $rootScope.user.userUid,
					method: "GET"
				}).success(function (response) {
					$scope.tourPlan.customCnt = response;
					$scope.checkTourPlanSet();
					
					$scope.toast("일정복사를 취소합니다.", "커스터마이징", "error");
				})
			}
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
		/** 스토리 */
		/** ==================================================== */
	    // 스토리 리스트 불러오기
	    $scope.getWriteTourSpotMemoList = function () {
	    	$scope.tourSpotMemoList = [];
	    	$http({
				url: myConfig.serverURL + "/tourPlan/select/tourSpotMemoList?recordNo=" + RequestService.getParameter("recordNo"),
				method: "GET",
			}).success(function (response) {
				console.log(response);
				$scope.tourSpotMemoList = response;
			}).error(function (error) {
				
			});
	    } 
	    
	    $scope.getWriteTourSpotMemoList();
	    
	    
		
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
				// TODO 동시간대 일정 : 허용
				eventOverlap: true,
				// 기본 일정 시작 일자
				defaultDate: $scope.calendarPage.currentDate,
				// 드래그앤드랍설정
				editable: false,
				droppable: false,
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
					    		"<div><img src='"+ event.imageUrl +"' style='margin-left:3px; width:70px; height:50px; float:left;'></div>" +
					    		"<div style='width: 170px; height: 55px; float:left; margin-left: 5px;'>" +
					    		"<p style='color:white;'>"+ event.overview +"</p>" +
					    		"</div>"
					    );
					}
				},
				// 이벤트 클릭
			    eventClick: function(calEvent, jsEvent, view) {
			    	var param = {
			    		contentid: calEvent.contentId,
			    		contenttypeid: calEvent.contentTypeId
			    	}
			    	
			    	$scope.openDetailTourSpot(param);
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
	    			imageUrl: $(this).children().first().find("b:eq(5)").text()
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
					// TODO 일정추가 물어보기
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
				
				// TODO 인포윈도우 꾸미기
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
		/** TODO 댓글 */
		/** ==================================================== */
		// 댓글 리스트 조회
		$scope.getCommentList = function () {
			$http({
				url: myConfig.serverURL + '/tourPlan/select/tourPlan/commentList?recordNo=' + RequestService.getParameter("recordNo"),
				method: 'GET'
			}).success(function (response) {
//				console.log(response);
	            $scope.tourPlanCommentList = response;
			}).error(function (){
				
			});
		}
//		$scope.tourPlanCommentForm.content = "";
		// 댓글 등록
		$scope.writeComment = function () {
			$http({
				url: myConfig.serverURL + '/tourPlan/insert/tourPlan/comment',
				method: 'POST',
				data: $.param({
					recordNo: RequestService.getParameter("recordNo"),
					userUid: $rootScope.user.userUid,
					content: $scope.tourPlanCommentForm.content,
					recivUserUid: $scope.writer.userUid,
					title: $scope.tourPlan.title,
					url: document.location.href
				}),
				headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
			}).success(function (response) {
				$scope.getCommentList();
				$scope.tourPlanCommentForm.content = "";
				
				var user = sessionStorageService.getObject("user");
				
				console.log("noti-count");
				console.log($(".noti-count").html());
				
				notis_socket.emit("commentInfo", {
					type : "comment",
					recvId : $scope.writer.userUid,
					count : $(".noti-count").html()
				});
				
			}).error(function (){
				
			});
		}
		
		
		// 댓글 삭제
		$scope.removeComment = function (commentNo) {
			swal({
				  title: "댓글삭제",
				  text: "댓글을 삭제하시겠습니까",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonColor: "#DD6B55",
				  confirmButtonText: "네",
				  cancelButtonText: "아니오",
				  closeOnConfirm: false,
				  closeOnCancel: false
				},
				function(isConfirm){
					if (isConfirm) {
						$http({
							url: myConfig.serverURL + '/tourPlan/delete/tourPlan/comment?commentNo=' + commentNo,
							method: 'GET'
						}).success(function (response) {
							$scope.getCommentList();
							swal("삭제", "삭제되었습니다.", "success");
						}).error(function (){
							
						});
					} else {
						swal("취소", "취소되었습니다.", "error");
					}
				});
		}
		
		// TODO 댓글 수정
		$scope.modifyComment = function () {
			swal("댓글수정");
		}
		
		// 댓글 200자제한
		$scope.commentLengthCheck = function () {
			if ($scope.tourPlanCommentForm.content.length >= 200) {
				$scope.tourPlanCommentForm.content = $scope.tourPlanCommentForm.content.substring(0, 200);
				swal("댓글수 제한(200자)");
			}
		}
		

  })
	