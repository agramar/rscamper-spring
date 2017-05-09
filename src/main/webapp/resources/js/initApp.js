// 환경설정
var myConfig = {
//	serverUrl: "http://localhost:8081" // 내 컴퓨터
	serverUrl : "http://14.32.66.104:8081", // 서버 컴퓨터
	serverURL : "http://14.32.66.104:8081", // 서버 컴퓨터
	webServerUrl : "http://14.32.66.104:8083", // 서버 웹 URL
//	serverUrl : "http://192.168.0.9:8081", // 서버 컴퓨터
//	serverUrl : "http://192.168.0.173:8081", // 호동 서버 컴퓨터
	nodeChatServerUrl : "http://14.32.66.104:8084", // 노드 채팅 서버 컴퓨터
	nodeNotisServerUrl : "http://14.32.66.104:8085", // 노드 알림 서버 컴퓨터
//	nodeChatServerUrl : "http://192.168.0.173:10001", // 호동 노드 채팅 서버
//	nodeNotisServerUrl : "http://192.168.0.173:10002", // 호동 노드 알림 서버
	homeUrl : "http://14.32.66.104:8081"
};

//이미지 유효성 체크
function img_validation(input) {
	var image = input.value;
    if (image != "" ) {
        var ext = image.slice(image.lastIndexOf(".") + 1).toLowerCase();
        if (!(ext == "gif" || ext == "jpg" || ext == "png")) {
            alert("이미지 파일 (JPG, GIF, PNG) 만 업로드 가능합니다.");
            input.focus();
            return false;
        }
    }
    return true;
};

//이미지 미리보기 혹은 이미지 파일 데이터
function readURL(input, img) {
    if (input.files && input.files[0]) {
	    var reader = new FileReader();
	    reader.readAsDataURL(input.files[0]);
	    reader.onload = function (e) {
	    	if (img) {
	    		img.attr('src', e.target.result);
	    	}
	    	return e.target.result;
	    }
    }
};

// 유효성 체크 서비스
var validCheckService = function(type, value) {
	switch (type) {
	case "null":
		if (!value) {
			alert("입력되지 않은 값이 있습니다.");
			return false;
		}
		return true;
	case "email": // 이메일 형식 체크(정규식)(not null)
		if (!value) {
			alert("이메일을 입력해 주세요.");
			return false;
		}
		if (!value.match(/[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/)) {
			alert("올바른 이메일 형식이 아닙니다.");
			return false;
		}
		return true;
	case "emailNull": // 이메일 형식 체크(정규식)(null 가능)
		if (value) {
			if (!value.match(/[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/)) {
				alert("올바른 이메일 형식이 아닙니다.");
				return false;
			}
		}
		return true;
	case "password": // 6~20자 문자숫자혼합(정규식)(not null)
		if (!value) {
			alert("비밀번호를 입력해 주세요");
			return false;
		}
		if (!value.match(/^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/)) {
			alert("올바른 비밀번호 형식(영문자/숫자조합 6~20자)이 아닙니다.");
			return false;
		}
		return true;
	case "displayName": // 20자 이하(not null)
		if (!value) {
			alert("사용자 이름을 입력해 주세요.");
			return false;
		}
		if (value.length > 20) {
			alert("입력된 사용자 이름이 너무 깁니다.(20자이하)");
			return false;
		}
		return true;
	case "phoneNumber": // 전화번호 형식(정규식)(널가능)
		if (value) {
			if (!value.match(/^\d{2,3}-\d{3,4}-\d{4}$/)) {
				alert("올바른 전화번호를 입력해 주세요.");
				return false;
			}
		}
		return true;
	case "websiteUrl":// 인터넷 주소(정규식)(널가능)
		if (value) {
			if (!value.match(/^(http?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w_\.-]*)*\/?$/)) {
				alert("올바른 인터넷 주소를 입력해 주세요.");
				return false;
			}
		}
		return true;
	case "introduce": // 1000자이하(널가능)
		if (value) {
			if (value.length > 1000) {
				alert("입력된 자기소개 내용이 너무 깁니다.(1000자이하)");
				return false;
			}
		}
		return true;
	case "birthday": // 현재보다 과거인지 체크(널가능)
		if (value) {
			if (new Date() < new Date(value)) {
				alert("현재보다 과거를 선택해야 합니다.");
				return false;
			}
		}
		return true;
	}
	return false;
}

// 세션 스토리지 서비스
var sessionStorageService = {
	set : function(key, value) {
		sessionStorage.setItem(key, value);
	},
	get : function(key, defaultValue) {
		return sessionStorage.getItem(key);
	},
	setObject : function(key, value) {
		sessionStorage.setItem(key, JSON.stringify(value));
	},
	getObject : function(key) {
		return JSON.parse(sessionStorage.getItem(key));
	},
	remove : function(key) {
		sessionStorage.removeItem(key);
	},
}

// 시작 메소드
jQuery(document).ready(function() {
	App.init();
	OwlCarousel.initOwlCarousel();
	ParallaxSlider.initParallaxSlider();
	menuCreate();
});
