// 서비스
angular.module("CommunityApp")
	// 설정 정보 관련 서비스
  .factory("MyConfig", function () {
    return {
      backEndURL: "http://14.32.66.104:8081", // 학원 서버 컴퓨터 외부
//       backEndURL: "http://192.168.0.9:8081", // 학원 서버 컴퓨터 내부
      // backEndURL: "http://192.168.0.228:8081", // 학원 내컴퓨터
      // backEndURL: "http://192.168.1.13:8081", // 집
    };
  })
  // 리퀘스트 서비스
  .factory("RequestService", function () {
	  return {
		getParameter : function(paramName) {
			var _tempUrl = window.location.search.substring(1); //url에서 처음부터 '?'까지 삭제
//			console.log(_tempUrl)
			if (_tempUrl) {
				var _tempArray = _tempUrl.split('&'); // '&'을 기준으로 분리하기

				for (var i = 0; _tempArray.length; i++) {
					var _keyValuePair = _tempArray[i].split('='); // '=' 을 기준으로 분리하기

					if (_keyValuePair[0] == paramName) { // _keyValuePair[0] : 파라미터 명
						// _keyValuePair[1] : 파라미터 값
						return _keyValuePair[1];
					}
				}
			} else {
				return false;
			}

		}
	};
  })
    // 유효성 체크 서비스
  .factory("ValChkService", function () {
    return {
      validationCheck: function (type, value) {
        switch (type) {
          case "null":
            if (!value) {
              swal("알림", "입력되지 않은 값이 있습니다.");
              return false;
            }
            return true;
          case "email": // 이메일 형식 체크(정규식)(not null)
            if (!value) {
              swal("알림", "이메일을 입력해 주세요.");
              return false;
            }
            if (!value.match(/[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/)) {
              swal("알림", "올바른 이메일 형식이 아닙니다.");
              return false;
            }
            return true;
          case "password": // 6~20자 문자숫자혼합(정규식)(not null)
            if (!value) {
              swal("알림", "비밀번호를 입력해 주세요");
              return false;
            }
            if (!value.match(/^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/)) {
              swal("알림", "올바른 비밀번호 형식(영문자/숫자조합 6~20자)이 아닙니다.");
              return false;
            }
            return true;
          case "displayName": // 20자 이하(not null)
            if (!value) {
              swal("알림", "사용자 이름을 입력해 주세요.");
              return false;
            }
            if (value.length > 20) {
              swal("알림", "입력된 사용자 이름이 너무 깁니다.(20자이하)");
              return false;
            }
            return true;
          case "phoneNumber": // 전화번호 형식(정규식)(널가능)
            if (value) {
              if (!value.match(/^\d{2,3}-\d{3,4}-\d{4}$/)) {
                swal("알림", "올바른 전화번호를 입력해 주세요.");
                return false;
              }
            }
            return true;
          case "websiteUrl":// 인터넷 주소(정규식)(널가능)
            if (value) {
              if (!value.match(/^(http?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w_\.-]*)*\/?$/)) {
                swal("알림", "올바른 인터넷 주소를 입력해 주세요.");
                return false;
              }
            }
            return true;
          case "introduce": // 1000자이하(널가능)
            if (value) {
              if (value.length > 1000) {
                swal("알림", "입력된 자기소개 내용이 너무 깁니다.(1000자이하)");
                return false;
              }
            }
            return true;
          case "birthday": // 현재보다 과거인지 체크(널가능)
            if (value) {
              if (new Date() < new Date(value)) {
                swal("알림", "현재보다 과거를 선택해야 합니다.");
                return false;
              }
            }
            return true;
        }
        return false;
      }
    }
  })

  