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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/shortcode_timeline2.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/profile.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-colors/default.css" id="style_color">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-skins/dark.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">

<!-- Sweet Alert -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.css">

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="notification.css">

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
					<li class="active"><a href="${pageContext.request.contextPath}/views/mypage/notification.jsp">NOTIFICATION</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->

		<!--=== 내용 ===-->
		<div class="container content profile" style="padding-top: 20px;" ng-app="MypageApp" ng-controller="NotificationController">
		
			<!-- 배경 사진 업로드 모달 -->
			<%@include file="include/BGUploadFormModal.jsp"%>
			
			<!-- 프로필 사진 업로드 모달 -->
			<%@include file="include/profileUploadFormModal.jsp"%>
		
			<!-- 사용자 사진 및 배경사진 include -->
			<%@include file="include/userPhoto.jsp"%>
		
			<div class="row" style="margin-top: 30px;">
			
				<!--Left Sidebar-->
				<%@include file="include/left_sidebar.jsp"%>
				
				<!-- 알림 시작 -->
				<div class="col-md-9">
					<ul class="timeline-v2">
					
						<li class="equal-height-columns">
							<div class="cbp_tmtime equal-height-column"><span>2016년 11월 16일</span> <span>수요일</span></div>
							<i class="cbp_tmicon rounded-x hidden-xs"></i>
							<div class="cbp_tmlabel equal-height-column">
								<h2>ㅋㅋㅋ</h2>
								<div class="row">
									<div class="col-md-4">
										<div class="md-margin-bottom-20"></div>
									</div>
									<div class="col-md-8">
										<p>ㅋㅋㅋㅋ</p>
										<p>ㅋㅋㅋㅋ</p>
									</div>
								</div>
							</div>
						</li>
						
						<li class="equal-height-columns">
							<div class="cbp_tmtime equal-height-column"><span>2016년 11월 14일</span> <span>월요일</span></div>
							<i class="cbp_tmicon rounded-x hidden-xs"></i>
							<div class="cbp_tmlabel equal-height-column">
								<h2>알림</h2>
								<p>Caulie dandelion maize lentil collard greens radish arugula sweet pepper water spinach kombu courgette lettuce. Celery coriander bitterleaf epazote radicchio shallot winter purslane collard greens spring onion squash lentil. Artichoke salad bamboo shoot black-eyed pea brussels sprout garlic kohlrabi.</p>
								<div class="row">
									<div class="col-sm-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check color-green"></i> Donec id elit non mi porta gravida</li>
											<li><i class="fa fa-check color-green"></i> Corporate and Creative</li>
											<li><i class="fa fa-check color-green"></i> Responsive Bootstrap Template</li>
											<li><i class="fa fa-check color-green"></i> Corporate and Creative</li>
										</ul>
									</div>
									<div class="col-sm-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check color-green"></i> Donec id elit non mi porta gravida</li>
											<li><i class="fa fa-check color-green"></i> Corporate and Creative</li>
											<li><i class="fa fa-check color-green"></i> Responsive Bootstrap Template</li>
											<li><i class="fa fa-check color-green"></i> Corporate and Creative</li>
										</ul>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<!-- 알림 끝 -->
				
				
			</div><!--/end row-->
		</div>
		<!--=== 내용 끝 ===-->
				
				
				
				

		<!-- 푸터 include -->
		<%@include file="/resources/include/footer.jsp"%>

	</div>
	
	<!-- 로그인 모달 include -->
	<%@include file="/resources/include/userModal.jsp"%>

	<!-- JS Global Compulsory -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>

	<!-- JS Implementing Plugins -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/back-to-top.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/smoothScroll.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/modernizr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/login-signup-modal-window/js/main.js"></script>

	<!-- JS Page Level -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/parallax-slider.js"></script>

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
	<script type="text/javascript" src="notification.js"></script>
	
	
</body>
</html>
