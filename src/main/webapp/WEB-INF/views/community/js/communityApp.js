//앵귤러 모듈 선언(라우터 설정할거면 여기서 설정)
angular.module("CommunityApp", ["ngSimpleUpload", "ngSanitize"])
  .run(function ($rootScope) {
	// 세션에서 유저정보 가져오기
    $rootScope.user = sessionStorageService.getObject("user");
  })
