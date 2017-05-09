<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<title>프로필</title>

<!-- Meta -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="rscamper">
<meta name="author" content="rscamper">

<!-- Favicon -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/headers/header-default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footers/footer-v3.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/parallax-slider/css/parallax-slider.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/login-signup-modal-window/css/style.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/scrollbar/css/jquery.mCustomScrollbar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css">

<!-- CSS Page Style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/profile.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-colors/default.css" id="style_color">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-skins/dark.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">

<!-- Sweet Alert -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.css">

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="profile.css">

</head>

<body class="header-fixed header-fixed-space-default">
	<div class="wrapper">

		<!-- 헤더 include -->
		<%@include file="/resources/include/header.jsp"%>

		<!--=== 사이트맵 ===-->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="pull-left breadcrumb">
					<li><a href="${pageContext.request.contextPath}/views/main.jsp"><i class="fa fa-home"></i></a></li>
					<li><a href="${pageContext.request.contextPath}/views/mypage/profile.jsp">MYPAGE</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/views/mypage/profile.jsp">PROFILE</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->

		<!--=== 바디 ===-->
		<div class="container content profile" style="padding-top: 20px;" ng-app="MypageApp" ng-controller="ProfileController">
		
		
			<!-- 배경 사진 업로드 모달 -->
			<%@include file="include/BGUploadFormModal.jsp"%>
			
			<!-- 프로필 사진 업로드 모달 -->
			<%@include file="include/profileUploadFormModal.jsp"%>
		
			<!-- 회원 정보 수정 모달 include -->
			<%@include file="include/updateProfileFormModal.jsp"%>
			
			<!-- 사용자 사진 및 배경사진 include -->
			<%@include file="include/userPhoto.jsp"%>
		
			<!-- 메뉴 및  프로필 내용 -->
			<div class="row" style="margin-top: 30px;">
				
				<!--Left Sidebar-->
				<%@include file="include/left_sidebar.jsp"%>
				
				<!-- Profile Content -->
				<div class="col-md-9">
					<div class="profile-body margin-bottom-20">
						<div class="tab-v1">
							<ul class="nav nav-justified nav-tabs">
								<li class="active"><a data-toggle="tab" href="#profile">프로필</a></li>
								<li ng-if="user.providerName == 'password'"><a data-toggle="tab" href="#passwordTab">비밀번호 변경</a></li>
								<li><a data-toggle="tab" href="#settings">설정</a></li>
							</ul>
							<div class="tab-content">
								
								<div id="profile" class="profile-edit tab-pane fade in active">
									<h2 class="heading-md"><a>{{user.displayName}}</a>님의 프로필</h2>
									<br>
									<dl class="dl-horizontal">
										<dt><strong>UID</strong></dt>
										<dd ng-bind="user.userUid"></dd>
										<hr>
										<dt><strong>계정 유형</strong></dt>
										<dd ng-bind="user.providerName | provider"></dd>
										<hr>
										<dt><strong>사용자명</strong></dt>
										<dd ng-bind="user.displayName"></dd>
										<hr>
										<dt><strong>이메일</strong></dt>
										<dd ng-bind="user.email"></dd>
										<hr>
										<dt><strong>거주지역</strong></dt>
										<dd ng-bind="user.locationName"></dd>
										<hr>
										<dt><strong>전화번호</strong></dt>
										<dd ng-bind="user.phoneNumber"></dd>
										<hr>
										<dt><strong>홈페이지</strong></dt>
										<dd ng-bind="user.websiteUrl"></dd>
										<hr>
										<dt><strong>생년월일</strong></dt>
										<dd ng-bind="user.birthday | date : 'yyyy년 MM월 dd일 HH:mm:ss'"></dd>
										<hr>
										<dt><strong>성별</strong></dt>
										<dd ng-bind="user.gender | gender"></dd>
										<hr>
										<dt><strong>자기소개</strong></dt>
										<dd><pre ng-bind="user.introduce"></pre></dd>
										<hr>
										<dt><strong>회원가입일자</strong></dt>
										<dd ng-bind="user.regDate | date : 'yyyy년 MM월 dd일 HH:mm:ss'"></dd>
										<hr>
									</dl>
									<button type="button" class="btn-u" ng-click="openProfileUpdateFormModal();">프로필 수정</button>
								</div>
		
								<div id="passwordTab" class="profile-edit tab-pane fade">
									<h2 class="heading-md">비밀번호 변경</h2>
									<br>
									<form class="sky-form" id="sky-form4" action="#">
										<dl class="dl-horizontal">
											<dt>이메일 주소</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-envelope"></i>
														<input type="email" placeholder="Email address" name="email">
														<b class="tooltip tooltip-bottom-right">회원가입시 입력한 이메일 주소를 입력해 주세요</b>
													</label>
												</section>
											</dd>
											<dt>비밀번호</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-lock"></i>
														<input type="password" id="password" name="password" placeholder="Password">
														<b class="tooltip tooltip-bottom-right">변경할 비밀번호 입력</b>
													</label>
												</section>
											</dd>
											<dt>비밀번호 확인</dt>
											<dd>
												<section>
													<label class="input">
														<i class="icon-append fa fa-lock"></i>
														<input type="password" name="passwordConfirm" placeholder="Confirm password">
														<b class="tooltip tooltip-bottom-right">비밀번호 재확인</b>
													</label>
												</section>
											</dd>
										</dl>
										<button class="btn-u" type="submit">비밀번호 변경하기</button>
										<button type="button" class="btn-u btn-u-default">취소</button>
									</form>
								</div>
		
								<div id="settings" class="profile-edit tab-pane fade">
									<h2 class="heading-md">계정 설정</h2>
									<br>
									<form class="sky-form" id="sky-form3" action="#">
										<label class="toggle"><input type="checkbox" checked="" name="checkbox-toggle-1"><i class="no-rounded"></i>이메일 알림</label>
										<hr>
										<label class="toggle"><input type="checkbox" checked="" name="checkbox-toggle-1"><i class="no-rounded"></i>나에게 댓글 달았을시 알림</label>
										<hr>
										<label class="toggle"><input type="checkbox" checked="" name="checkbox-toggle-1"><i class="no-rounded"></i>사이트 개편이 알림</label>
										<hr>
										<label class="toggle"><input type="checkbox" checked="" name="checkbox-toggle-1"><i class="no-rounded"></i>나에게 쪽지가 왔을때 알림</label>
										<hr>
										<label class="toggle"><input type="checkbox" checked="" name="checkbox-toggle-1"><i class="no-rounded"></i>뉴스레터 받기</label>
										<hr>
										<button class="btn-u" type="submit">변경사항 저장</button>
										<button type="button" class="btn-u btn-u-default">되돌리기</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div><!-- End Profile Content -->
			</div><!--end row-->
		</div><!--=== 내용 끝 ===-->
		
		<!-- 푸터 include -->
		<%@include file="/resources/include/footer.jsp"%>

	</div>
	
	<!-- 로그인 모달 include -->
	<%@include file="/resources/include/userModal.jsp"%>

	<!-- JS Global Compulsory -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- Angular JS -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>

	<!-- JS Implementing Plugins -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/back-to-top.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/smoothScroll.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/jquery.maskedinput.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/modernizr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/login-signup-modal-window/js/main.js"></script>

	<!-- JS Page Level -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/parallax-slider.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/masking.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/datepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/validation.js"></script>

	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/assets/plugins/respond.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/placeholder-IE-fixes.js"></script>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/sky-forms-ie8.js"></script>
	<![endif]-->

	<!-- 파이어베이스 -->
	<script type="text/javascript" src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/firebaseInit.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/firebaseAuth.js"></script>
	
	<!-- Sweet Alert -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
	
	<!-- 메뉴 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/menu.js"></script>
	
	<!-- INIT APP -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/initApp.js"></script>
	
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="js/ng-simple-upload.js"></script>
	<script type="text/javascript" src="js/mypageApp.js"></script>
	<script type="text/javascript" src="js/mypageDirectives.js"></script>
	<script type="text/javascript" src="js/mypageFilters.js"></script>
	<script type="text/javascript" src="js/mypageServices.js"></script>
	<script type="text/javascript" src="profile.js"></script>
	
</body>
</html>
