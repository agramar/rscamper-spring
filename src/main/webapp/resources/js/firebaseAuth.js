// 메인페이지로 이동
function redirectToMain() {
	location.href = "/rscamper-web/views/main.jsp";
}

// 로그아웃 - 물음
function logout() {
	if(confirm("로그아웃 하시겠습니까?")) {
		signout();
	}
}

// 로그아웃 - 실행
function signout() {
    firebase.auth().signOut();
    // 세션에 유저정보 삭제
    sessionStorageService.remove('user');
    // 로그아웃하면 메인페이지로 이동;
    redirectToMain();
};

// 이메일 로그인
function signinEmail() {
    if (firebase.auth().currentUser) {
    	alert("이미 로그인이 되어있어 로그아웃 합니다.");
        signout();
    } else {
    	
        var email = document.getElementById('signin-email').value;
        var password = document.getElementById('signin-password').value;
        // TODO: 유효성 체크
        if(!validCheckService("null", email)) {return;}
        if(!validCheckService("null", password)) {return;}
        if(!validCheckService("email", email)) {return;}
        if(!validCheckService("password", password)) {return;}
        
        // 파이어베이스 이메일 로그인 메소드
        firebase.auth().signInWithEmailAndPassword(email, password)
	        .then(function (result) {
	        	// 이메일 인증 확인
	            if (!result.emailVerified) {
	            	if(confirm("이메일 인증이 필요합니다. 인증메일을 다시 받으시겠습니까?") == true) {
	            		firebase.auth().currentUser.sendEmailVerification().then(function () {
	                        alert("인증메일 재발송 완료 : 계정 활성화를 위해 이메일 인증을 해주시기 바랍니다.");
	                        signout();
	                    });
	            	} else {
	            		signout();
	            	}
	            	return;
	            }
	            alert("로그인 되었습니다.");
	            // 로그인하면 메인 페이지로 이동
	            redirectToMain();
	            
	        })
	        .catch(function(error) {
	            if (error.code === 'auth/wrong-password') {
	                alert('로그인 실패 : 비밀번호가 잘못되었습니다.');
	            } else {
	                alert('로그인 실패 : ' + error.message);
	            }
	            console.log(error);
	        });
    }
};

// 소셜 로그인
function signinProvider(providerName) {
    if (!firebase.auth().currentUser) {
        switch(providerName) {
            case "google":
                var provider = new firebase.auth.GoogleAuthProvider();
                provider.addScope('https://www.googleapis.com/auth/plus.login');
                break;
            case "facebook":
                var provider = new firebase.auth.FacebookAuthProvider();
                provider.addScope('user_birthday');
                break;
            case "twitter":
                var provider = new firebase.auth.TwitterAuthProvider();
                break;
        };

        firebase.auth().signInWithPopup(provider)
	        .then(function(result) {
	            var token = result.credential.accessToken;
	            var user = result.user;
	            var secret;  // 트위터용
	            if (result.credential.secret) {
	                secret = result.credential.secret;
	            }
	            // 외부로그인 정보 DB에 넣기
	            $.ajax({
	            	type: "POST",
	            	url: myConfig.serverUrl + "/user/insert",
	            	dataType : 'json',
	                data: {
	                   userUid: user.uid,
	                   displayName: user.displayName,
	                   email: user.email,
	                   photoUrl: user.photoURL,
	                   providerName: user.providerData[0].providerId,
	                   providerUid: user.providerData[0].uid,
	                   providerDisplayName: user.providerData[0].displayName,
	                   providerPhotoUrl: user.providerData[0].photoUrl,
	                   providerEmail: user.providerData[0].email
	                },
	                error : function(err) {
						alert(err);
					},
					success : function(result) {
						redirectToMain();
					}
	            });
	        })
	        .catch(function(error) {
	            // Handle Errors here.
	            var errorCode = error.code;
	            var errorMessage = error.message;
	            var email = error.email;
	            var credential = error.credential;
	            if (errorCode === 'auth/account-exists-with-different-credential') {
	                alert('You have already signed up with a different auth provider for that email.');
	            } else {
	                console.error(error);
	            }
	        });
    } else {
    	alert("이미 로그인이 되어있어 로그아웃 합니다.");
        signout();
    }
};

// 이메일 회원가입
function signupEmail() {
    var displayName = document.getElementById('signup-username').value;
    var email = document.getElementById('signup-email').value;
    var password = document.getElementById('signup-password').value;
    
    // 유효성 체크
    if(!validCheckService("null", email)) {return;}
    if(!validCheckService("null", password)) {return;}
    if(!validCheckService("null", displayName)) {return;}
    
    if(!validCheckService("email", email)) {return;}
    if(!validCheckService("password", password)) {return;}
    
    firebase.auth().createUserWithEmailAndPassword(email, password)
        .then(function (result) {
        	var user = result;
        	
        	// 1. DB에 유저정보 저장하기 
            $.ajax({
            	type: "POST",
            	url: myConfig.serverUrl + "/user/insert",
            	dataType : 'json',
                data: {
                   userUid: user.uid,
                   displayName: displayName,
                   email: user.email,
                   photoUrl: user.photoURL,
                   providerName: user.providerData[0].providerId,
                   providerUid: user.providerData[0].uid,
                   providerDisplayName: user.providerData[0].displayName,
                   providerPhotoUrl: user.providerData[0].photoUrl,
                   providerEmail: user.providerData[0].email
                },
                error : function(err) {
					alert(err);
				},
				success : function(result) {
					
				}
            });

            // 2. 모달창 닫기
            $('.cd-user-modal').removeClass('is-visible');

            // 3. 인증메일 보내기
            sendEmailVerification();
            alert('메일 인증후 이용하실수 있습니다.');
            signout();
        })
        .catch(function (error) {
            // 회원가입 에러 처리
            var errorCode = error.code;
            var errorMessage = error.message;
            if (errorCode == 'auth/weak-password') {
                alert('회원가입 실패 : 패스워드가 단순함');
            } else {
                alert('회원가입 실패 : ' + errorMessage);
            }
            console.log(error);
            return;
    });
};

// 인증 이메일 보내는 함수
function sendEmailVerification() {
    firebase.auth().currentUser.sendEmailVerification().then(function() {
        alert('인증메일이 발송되었습니다.!');
    });
};

// 비번 재생성 메일 보내는 함수
function sendPasswordReset() {
    var email = document.getElementById('reset-email').value;
    
    // 유효성 체크
    if(!validCheckService("null", email)) {return;}
    if(!validCheckService("email", email)) {return;}
    
    firebase.auth().sendPasswordResetEmail(email).then(function() {
        alert('비밀번호 초기화 메일이 발송 되었습니다. 이메일을 확인해 주세요!');
        $('.cd-user-modal').removeClass('is-visible');
    }).catch(function(error) {
        var errorCode = error.code;
        var errorMessage = error.message;
        if (errorCode == 'auth/invalid-email') {
            alert("잘못된 이메일 주소입니다.");
        } else if (errorCode == 'auth/user-not-found') {
            alert("요청한 이메일이 존재하지 않습니다.");
        }
        console.log(error);
    });
};

//회원탈퇴
function resignAccount() {
	var user = firebase.auth().currentUser
	if (user) {
		if(prompt("회원을 탈퇴하시려면 [회원탈퇴] 라고 입력해주세요") == "회원탈퇴") {
			user.delete().then(function() {
				// DB회원정보 삭제
				$.ajax({
					type: "DELETE",
					url: myConfig.serverURL + "/user/delete/oneUser?userUid=" + user.uid,
					dataType : 'json',
		            error : function(err) {
		            	alert("에러발생");
					},
					success : function(result) {
						alert("회원탈퇴 성공");
					}
				})
			})
			signout();
		} else {
			alert("회원탈퇴 취소");
		}
	}
};

// 로케이션 리스트 가져오는 메소드
function getLocationList (successCB) {
  $.ajax({
	  type: "GET",
	  url: myConfig.serverURL + "/user/select/locations",
	  dataType: "json",
	  error : function (err) {
		  
	  },
	  success : function (result) {
		  successCB(result);
	  }
  })
};

//로그인과 로그아웃 상태 감지
function initApp() {
    firebase.auth().onAuthStateChanged(function(user) {
        if (user) {
        	$.ajax({
        		type: "GET",
        		url: myConfig.serverURL + "/user/select/oneUser?userUid=" + user.uid,
        		dataType : 'json',
        	    error : function(err) {
        		},
        		success : function(result) {
        			// 세션에 유저정보 등록
        			sessionStorageService.setObject('user', result);
        			if (result.displayName) {
        				$('#mypageTitle').html(result.displayName);
        			}
        			// 로그인 모달창 닫기
                    $('.cd-user-modal').removeClass('is-visible');

                    // UI 로그인상태로 변경
                    $('#loginBtn').css('display', 'none');
                    $('#logoutBtn').css('display', 'inline');
                    $('#mypage').css('display', 'block');
        		}
        	});
        } else {
            // UI 로그아웃상태로 변경
            $('#loginBtn').css('display', 'inline');
            $('#logoutBtn').css('display', 'none');
            $('#mypage').css('display', 'none');
            $('#mypageTitle').html('마이페이지');
        }
    });

    // 로그인 관련 이벤트 등록
    $('#signin-email-btn').on('click', signinEmail);
    $('#signup-email-btn').on('click', signupEmail);
    $('#reset-password-btn').on('click', sendPasswordReset);
};

// 시작
jQuery(document).ready(function() {
	initApp();
});
