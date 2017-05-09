// 앵귤러 모듈
angular.module("CommunityApp")
.controller("DetailController", function($rootScope, $scope, $http, $window, RequestService) {
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

	
	// TODO 게시글수정
	$scope.modifyBoard = function (boardNo) {
		swal({
			title : "게시글 수정",
			text : "해당 게시글을 수정하시겠습니까?",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "네",
			cancelButtonText : "아니오",
			closeOnConfirm : true,
			closeOnCancel : false
		}, function(isConfirm) {
			if (isConfirm) {
				// TODO
			} else {
				swal("취소됨!", "취소되었습니다.", "error");
			}
		});
	}
	
	// 게시글삭제
	$scope.removeBoard = function (boardNo) {
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
	            	$window.location.href = "list.jsp?categoryNo=0";
	            }).error(function(error) {
	                console.log(error);
	            })
			} else {
				swal("취소됨!", "삭제가 취소되었습니다.", "error");
			}
		});
	};
	
	// 댓글창 토글
	$scope.commentToggleStatus = true;
	$scope.toggleComment = function () {
		$scope.commentToggleStatus = !$scope.commentToggleStatus;
	};
	
    // 게시글 불러오기
	$scope.getBoard = function () {
		$http({
			url: myConfig.serverURL + "/community/select/oneBoard?boardNo=" + RequestService.getParameter("boardNo"),
			method: "GET",
		})
		.success(function (response) {
			$scope.board = response;
		})
		.error(function (error) {
			swal("에러", "서버접속불가");
		})
	};
	
    
	// 댓글 리스트 불러오기
	$scope.getCommentList = function () {
		$scope.page++;
		$http({
			url: myConfig.serverURL + "/community/select/comment?page=" + $scope.page + "&boardNo=" + RequestService.getParameter("boardNo"),
			method: "GET"
		}).success(function (response) {
			angular.forEach(response.commentList, function (comment) {
				$scope.commentList.push(comment);
				$scope.total = response.totalPages;
			})
		}).error(function (error) {
			swal("에러", "서버접속불가", "error");
		})
	};
	
	
	// 무한 스크롤 이벤트
    angular.element(document).scroll( function() {
    	maxHeight = $(document).height();
    	currentScroll = $(window).scrollTop() + $(window).height();
    	if (maxHeight <= currentScroll) {
    		$scope.getCommentList();
    	};
	});
    
	// 댓글 파라미터 초기화
	$scope.load = function () {
		$scope.page = 0;
	    $scope.total = 1;
	    $scope.commentList = [];
	    $scope.targetCommentNo = null;
	    $scope.getBoard();
	    $scope.getCommentList();
	};
	
	$scope.load();
	
    // 대댓글 작성
    $scope.writeSubComment = function(targetCommentNo,displayName) {
		$scope.targetCommentNo = targetCommentNo;
		$scope.commentForm = {
			content : displayName + "에게 : "
		};
	};
    
    // 댓글 작성
    $scope.writeComment = function() {
        // 댓글 유효성 체크
        if (!$scope.commentForm.content) {
            swal("놉!");
            return false;
        }
        $http({
            url: myConfig.serverURL + "/community/insert/comment",
            method: "POST",
            data: $.param({
                targetCommentNo: $scope.targetCommentNo,
                boardNo: RequestService.getParameter("boardNo"),
                userUid: $rootScope.user.userUid,
                content: $scope.commentForm.content
            }),
            headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
        }).success(function(response) {
        	$scope.load();
        	$scope.commentForm.content="";
        }).error(function(error) {
            swal("에러", "서버접속불가", "error");
        })
    };
    
    // 댓글 삭제
    $scope.deleteComment = function (commentNo) {
    	console.log(commentNo);
		swal({
			title : "댓글 삭제",
			text : "해당 댓글을삭제하시겠습니까?",
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
					url : myConfig.serverURL + "/community/delete/oneComment?commentNo=" + commentNo,
					method : "DELETE"
				})
				.success(function(response) {
					swal("알림", "댓글이 삭제되었습니다.", "success")
		        	$scope.load();
				})
				.error(function(error) {
					swal("오류", "오류발생", "success")
				})
			} else {
				swal("취소됨!", "삭제가 취소되었습니다.", "error");
			}
		});
    };
	
    // 좋아요
    $scope.likeBoard = function (boardNo) {
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
          $scope.board.likeCnt--;
      	$scope.toast("추천을 취소합니다.", "좋아요", "error");
        } else {
          $scope.board.likeCnt++;
          $scope.toast("이 게시글을 추천합니다.", "좋아요", "success");
        }
      }).error(function (error) {
        swal("에러", error, "error");
      })
    };
    
    // 북마크 추가 삭제
    $scope.bookmarkBoard = function (boardNo) {
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
        	$scope.board.bookmarkCnt--;
        	$scope.toast("북마크 취소합니다.", "좋아요", "error");
        } else {
        	$scope.board.bookmarkCnt++;
        	$scope.toast("이 게시글을 북마크합니다.", "좋아요", "success");
        }
      }).error(function (error) {
    	  swal("에러", error, "error");
      })
    };
		
})


