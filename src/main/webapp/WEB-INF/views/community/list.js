// 앵귤러 모듈
angular.module("CommunityApp")
.controller("ListController", function($rootScope, $scope, $http, RequestService) {

	// TODO 토스트 왜안되지?
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
	
    // 게시판 리스트 불러오기
    $scope.getBoardList = function () {
    	if ($scope.boardParam.page >= $scope.total) {
    		return false;
    	}
    	$scope.boardParam.page++;
      
		// 카테고리가 있는지 없는지 판단
		if ($scope.boardParam.categoryNo == 0) {
			var url = myConfig.serverURL + "/community/select/board?page=" + $scope.boardParam.page + "&count=" + $scope.boardParam.count;
		} else {
			var url = myConfig.serverURL + "/community/select/boardByCategory?page=" + $scope.boardParam.page + "&count=" + $scope.boardParam.count + "&categoryNo=" + $scope.boardParam.categoryNo;
		}
		$http({
			url: url,
			method: "GET"
		})
		.success(function (response) {
			console.log(response)
			angular.forEach(response.boardList, function (board) {
			$scope.boardList.push(board);
		})
			$scope.total = response.totalPages;
		})
		.error(function (error) {
			swal("에러", error, "error");
		})
    };
	
    $scope.initBoard = function (categoryNo) {
    	$scope.boardParam = {
    		page: 0,
    		count: 10,
    		categoryNo: categoryNo
    	};
    		
    	$scope.total = 1;
    		
    	// 게시판 리스트 초기화
    	$scope.boardList = [];

    	// 게시판 리스트 처음 한번 불러오기
    	$scope.getBoardList();
    }
    
	// 카테고리 파라미터 있을경우 이벤트
	$scope.isCategoryParam = function () {
		if(RequestService.getParameter("categoryNo")) {
			$(".list-group-item").removeClass("active");
			switch(RequestService.getParameter("categoryNo")) {
			case "0": 
				$("#all_board").addClass("active");
				break;
			case "2" :
				$("#tour_board").addClass("active");
				break;
			case "1":
				$("#free_board").addClass("active");
				break;
			case "5":
				$("#qna_board").addClass("active");
				break;
			case "3":
				$("#information_board").addClass("active");
				break;
			case "4":
				$("#review_board").addClass("active");
				break;
			}
			$scope.initBoard(RequestService.getParameter("categoryNo"));
		} else {
			$scope.initBoard(0);
		}
	};
	
	$scope.isCategoryParam();	
	
	
	// 게시글 삭제
    $scope.deleteBoard = function(boardNo) {
		swal({
			title : "게시글 삭제",
			text : "해당 게시글을삭제하시겠습니까?",
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
	                url: myConfig.serverURL + "/community/delete/oneBoard?boardNo=" + boardNo,
	                method: "DELETE",
	            }).success(function(response) {
	            	swal("삭제완료!", "삭제완료 하였습니다.", "success");
	        		$scope.boardList = [];
	        	    $scope.getBoardList();
	            }).error(function(error) {
	                console.log(error);
	            })
			} else {
				swal("취소됨!", "삭제가 취소되었습니다.", "error");
			}
		});
    }
	
    // 스마트에디터 선언
    $scope.writeFormModal = $("#writeFormModal");
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
    
    // 글쓰기 폼 열기
	$scope.openWriteFormModal = function () {
		$scope.writeBoard = {
		  categoryNo: $scope.boardParam.categoryNo
		}
		// 카테고리 리스트 가져오기
		$http({
			url : myConfig.serverURL + "/community/select/category",
			method : "GET"
		})
		.success(function(response) {
			$scope.categories = response;
			// 모달 오픈
		    $scope.writeFormModal.modal("show");
		    
		}).error(function(err) {
			console.log(err);
		})
	};
	
	// 글쓰기폼 모달 닫기
    $scope.closeWriteFormModal = function () {
    	$scope.writeFormModal.modal("hide");
    };
    
    // 글쓰기폼 모달 리셋
    $scope.resetWriteForm = function () {
    	$scope.writeData = {
    		categoryNo: 0,
    		title: ""
    	}
    }
    
    $scope.resetWriteForm();
    
    // 모달 가려질떄 이벤트
    $scope.writeFormModal.on('hidden.bs.modal', function (e) {
    	$scope.resetWriteForm();
    	editor_object.getById["smarteditor"].exec("SET_CONTENTS", [""]);
    })
    
    // 글쓰기
    $scope.write = function () {
    	var content = editor_object.getById["smarteditor"].getIR();
    	console.log(editor_object.getById["smarteditor"]);
    	
    	if ($scope.writeBoard.categoryNo == 0 || null) {
    		swal("놉!")
    		return;
    	};
    	
    	if (!$scope.writeBoard.title) {
    		swal("놉!")
    		return;
    	}
    	
    	if (!content) {
    		swal("놉!")
    		return;
    	}
    	
    	$http({
    		url: myConfig.serverURL + "/community/insert/board",
    		method: "POST",
			data: $.param({
				categoryNo: $scope.writeBoard.categoryNo,
				title: $scope.writeBoard.title,
				userUid: $rootScope.user.userUid,
				content: content
			}),
			headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
		})
		.success(function (response) {
			$scope.closeWriteFormModal();
			swal("성공", "글이 등록되었습니다.");
			$scope.initBoard($scope.boardParam.categoryNo);
		})
		.error(function (error) {
			swal("에러", "서버접속불가");
		})
	};
	
	// 카테고리 변경 이벤트
	$scope.addActiveCategoryMenu = function (e) {
		var eventTarget = $(e.currentTarget)
		$(".list-group-item").removeClass("active");
		eventTarget.addClass("active");
		
		$scope.boardParam = {
			page: 0,
			count: 10,
			categoryNo: 0
		};
		
		$scope.total = 1;
		
		switch(eventTarget.attr("id")) {
			case "all_board":
				$scope.boardParam.categoryNo = 0;
				break;
			case "tour_board":
				$scope.boardParam.categoryNo = 2;
				break;
			case "free_board":
				$scope.boardParam.categoryNo = 1;
				break;
			case "qna_board":
				$scope.boardParam.categoryNo = 5;
				break;
			case "information_board":
				$scope.boardParam.categoryNo = 3;
				break;
			case "review_board":
				$scope.boardParam.categoryNo = 4;
				break;
		}
		$scope.initBoard($scope.boardParam.categoryNo);
	}


	// 무한 스크롤 이벤트
    angular.element(document).scroll( function() {
    	maxHeight = $(document).height();
    	currentScroll = $(window).scrollTop() + $(window).height();
    	if (maxHeight <= currentScroll) {
    		$scope.getBoardList();
    	};
    	
    	var leftBottom = $("#leftNav").height() + $(window).scrollTop() + 120
    	var rightBottom = $("#rightContent").position().top + $("#rightContent").height();
    	
    	// 따라다니는 메뉴
    	if (rightBottom < leftBottom) {
//    		$("#leftNav").animate({"top": rightBottom - $("#leftNav").height()}, {duration:"fast", easing:"linear", queue:false});
    	} else {
    		$("#leftNav").animate({"top": $(window).scrollTop()}, {duration:"fast", easing:"linear", queue:false});
    	}
	});
    
    // 좋아요
    $scope.likeBoard = function (boardNo, index) {
      $http({
        url: myConfig.serverURL + "/community/like",
        method: "POST",
        data: $.param({
          targetNo: boardNo,
          targetType: 1,
          userUid: $rootScope.user.userUid
        }),
        headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
      }).success(function (response) {
        if (response == true) {
          $scope.boardList[index].likeCnt--;
          $scope.toast("추천을 취소합니다.", "좋아요", "error");
        } else {
          $scope.boardList[index].likeCnt++;
          $scope.toast("이 게시글을 추천합니다.", "좋아요", "success");
        }
      }).error(function (error) {
        swal("에러", error, "error");
      })
    };
    
    // 북마크 추가 삭제
    $scope.bookmarkBoard = function (boardNo, index) {
      $http({
        url: myConfig.serverURL + "/community/bookMark",
        method: "POST",
        data: $.param({
           targetNo: boardNo,
           targetType: 1,
           userUid: $rootScope.user.userUid
        }),
        headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
      }).success(function (response) {
        $scope.bookMark = response;
        if (response == true) {
        	$scope.boardList[index].bookmarkCnt--;
        	$scope.toast("북마크 취소합니다.", "좋아요", "error");
        } else {
        	$scope.boardList[index].bookmarkCnt++;
        	$scope.toast("이 게시글을 북마크합니다.", "좋아요", "success");
        }
      }).error(function (error) {
    	  swal("에러", error, "error");
      })
    };
    
    // 검색 및 검색 디폴트 값
	$scope.searchParams = {
		order: "-regDate"
	};
    
	// 검색 옵션 데이터
	$scope.optionDatas = {
		orderList: [
			{orderValue: "-regDate", orderName: "등록일순"},
			{orderValue: "-likeCnt", orderName: "추천순"},
			{orderValue: "-bookmarkCnt", orderName: "북마크순"},
			{orderValue: "-commentCnt", orderName: "댓글순"}
		],
	};

})


