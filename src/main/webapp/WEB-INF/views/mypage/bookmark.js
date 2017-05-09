// 앵귤러 모듈
angular.module("MypageApp")
.controller("BookmarkController", function($rootScope, $scope, $http) {
	/** ==================================================== */
	/** 내 여행일정 */
	/** ==================================================== */
	// 내 여행일정 불러오기
	$scope.getBookmarkTourPlanList = function () {
		$http({
			url: myConfig.serverURL + "/tourPlan/select/bookmarkTourPlanList?userUid=" + $rootScope.user.userUid,
			method: "GET",
		}).success(function (result) {
			$scope.planList = result
		}).error(function (error) {
			console.log(error);
		});
	}
	
	$scope.getBookmarkTourPlanList();
	
	
	// 여행일정 북마크 취소
//	$scope.cancelBookmarkTourPlan = function () {};
	
	/** ==================================================== */
	/** 북마크 여행일정 */
	/** ==================================================== */
	// 북마크 여행일정 불러오기
	$scope.getBookmarkSpotList = function () {
		// 무한로딩 방지
//		console.log($scope.bookmarkSpotParams.pageNo);
//		console.log($scope.bookmarkTotalPages);
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
			console.log(response);
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
	
	// TODO 여행일정 북마크 취소
	$scope.cancelBookmarkTourPlan = function () {};
	
	
	/** ==================================================== */
	/** 북마크 포스트 */
	/** ==================================================== */
	// 북마크 포스트 불러오기
	$scope.getMyPostList = function (pageNo) {
		$http({
			url: myConfig.serverURL + "/community/select/board/bookmark?page="+pageNo+"&userUid=" + $rootScope.user.userUid,
			method: "GET",
		}).success(function (response) {
			console.log(response);
			$scope.postList = response.boardList;
		}).error(function (error) {
			console.log(error);
		});
	}
	
	$scope.getMyPostList(1);
	
	// TODO 포스트 북마크 취소
	$scope.cancelBookmarkPost = function () {};
	
	
	/** ==================================================== */
	/** 메뉴 카운트 조회 */
	/** ==================================================== */
	$scope.getMenuCount = function () {
		$http({
			url : myConfig.serverURL + "/mypage/select/menuCount?userUid=" + $rootScope.user.userUid,
			method : "GET"
		}).success(function(response) {
			$scope.menuCount = response;
		}).error(function(error) {
		
		})
	}
	$scope.getMenuCount();
	
	/** ==================================================== */
	/** 프로필 이미지 */
	/** ==================================================== */
	// 프로필 사진 업로드 이미지 미리보기 이벤트
	$('#profileImageFile').on('change', function(){
		if(img_validation(this)) {
			readURL(this, $('#profileImage'));
		} else {
			$(this).val("");
			$('#profileImage').attr('src', '/rscamper-web/resources/img/default/default-image.png');
		};
	});
	// 프로필 사진 변경 모달창 열기
	$scope.updateProfileImage = function () {
		$scope.uploadProfileUrl = myConfig.serverURL + "/user/upload/profileImage"
		$("#profileImage").val("");
		$("#profileImageFile").val("");
		$('#profileImageUploadFormModal').modal('show');
	};
	// 프로필 업로드 완료 콜백
	$scope.uploadProfileCallBack = function (result) {
        var data = JSON.parse(result);
        var userPhoto = {
          userUid: $scope.user.userUid,
          type: data.type,
          path: data.path,
          size: data.size
        }
        $scope.updateImage(userPhoto, "/user/update/profileImage")
	};
	
	// 배경 파일 업로드 이미지 미리보기 이벤트
	$('#BGImageFile').on('change', function(){
		if(img_validation(this)) {
			readURL(this, $('#BGImage'));
		} else {
			$(this).val("");
			$('#BGImage').attr('src', '/rscamper-web/resources/img/default/default-image.png');
		};
	});
	// 배경 사진 변경 모달창 열기
	$scope.updateBGImage = function () {
		$scope.uploadBGUrl = myConfig.serverURL + "/user/upload/bgImage"
		$("#BGImageFile").val("");
		$('#BGImage').attr('src', '/rscamper-web/resources/img/default/default-image.png');
		$('#BGImageUploadFormModal').modal('show');
	};
	// 배경사진 업로드 완료 콜백
	$scope.uploadBGCallBack = function (result) {
        var data = JSON.parse(result);
        var userPhoto = {
          userUid: $scope.user.userUid,
          type: data.type,
          path: data.path,
          size: data.size
        }
        $scope.updateImage(userPhoto, "/user/update/bgImage")
	};
	
	// 사진 데이터베이스 업데이트
    $scope.updateImage = function (userPhoto, url) {
        $http({
          url: myConfig.serverURL + url,
          method: "POST",
          data: $.param({
            userUid: userPhoto.userUid,
            type: userPhoto.type,
            path: userPhoto.path,
            size: userPhoto.size
          }),
          headers: {
            "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
          }
        })
        .success(function () {
         	 $http({
                 url: myConfig.serverURL + "/user/select/oneUser?userUid=" + $scope.user.userUid,
                 method: "GET"
             })
             .success(function (result) {
             	sessionStorageService.setObject("user", result);
             	$scope.user = sessionStorageService.getObject("user");
        		$("#BGImageFile").val("");
        		$('#BGImage').attr('src', '/rscamper-web/resources/img/default/default-image.png');
        		$('#BGImageUploadFormModal').modal('hide');
        		$("#profileImage").attr("src", "/rscamper-web/resources/img/default/default-image.png");
        		$("#profileImageFile").val("");
        		$('#profileImageUploadFormModal').modal('hide');
             });
        });
    };
    
    // 왼쪽 메뉴에 액티브 효과주기
    $(".list-group-item").removeClass("active");
    $("#bookmark_menu").addClass("active");
})


