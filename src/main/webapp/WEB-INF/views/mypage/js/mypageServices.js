// 서비스
angular.module("MypageApp")
	// 설정 정보 관련 서비스
  .factory("MyConfig", function () {
    return {
//      backEndURL: "http://14.32.66.104:8081", // 학원 서버 컴퓨터 외부
       backEndURL: "http://192.168.0.9:8081", // 학원 서버 컴퓨터 내부
      // backEndURL: "http://192.168.0.228:8081", // 학원 내컴퓨터
      // backEndURL: "http://192.168.1.13:8081", // 집
    };
  })
  // 리퀘스트 서비스
  .factory("RequestService", function () {
	  return {
		getParameter : function(paramName) {
			var _tempUrl = window.location.search.substring(1); //url에서 처음부터 '?'까지 삭제
			var _tempArray = _tempUrl.split('&'); // '&'을 기준으로 분리하기

			for (var i = 0; _tempArray.length; i++) {
				var _keyValuePair = _tempArray[i].split('='); // '=' 을 기준으로 분리하기

				if (_keyValuePair[0] == paramName) { // _keyValuePair[0] : 파라미터 명
					// _keyValuePair[1] : 파라미터 값
					return _keyValuePair[1];
				}
			}
		}
	};
  })

  