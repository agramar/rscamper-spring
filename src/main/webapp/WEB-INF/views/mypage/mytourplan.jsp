<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<title>내 여행일정</title>

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
<link rel="stylesheet" href="mytourplan.css">

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
					<li class="active"><a href="${pageContext.request.contextPath}/views/mypage/mytourplan.jsp">MY TOUR PLAN</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->
		
		<!--=== 내용 ===-->
		<div class="container content profile" style="padding-top: 20px;" ng-app="MypageApp" ng-controller="MyTourPlanController">
		
			<!-- 배경 사진 업로드 모달 -->
			<%@include file="include/BGUploadFormModal.jsp"%>
			
			<!-- 프로필 사진 업로드 모달 -->
			<%@include file="include/profileUploadFormModal.jsp"%>
			
			<!-- 사용자 사진 및 배경사진 include -->
			<%@include file="include/userPhoto.jsp"%>
		
			<div class="row" style="margin-top: 30px;">
			
				<!--Left Sidebar-->
				<%@include file="include/left_sidebar.jsp"%>
				
				<div class="col-md-9">
				
					<!-- 여행일정 리스트 DIV -->
					<div class="row">

						<!-- 여행일정 한개 -->
						<div class="col-sm-6 news-v3" style="padding:10px; padding-top: 0px; padding-bottom: 30px;" ng-repeat="plan in planList">
							<img style="width: 100%; height: 170px;" ng-show="plan.filePath" ng-src="{{plan.filePath}}" >
							<img style="width: 100%; height: 170px;" ng-hide="plan.filePath" ng-src="http://lorempixel.com/400/200/city/{{$index}}">
							<div style="position: absolute; top:10px; left: 20px;" >
								<img class="rounded-x" ng-src="{{plan.photoUrl}}" style="width: 30px; hegiht: 30px;">
								<span style="color: white; text-shadow:-1px 0 gray, 0 1px gray, 1px 0 gray, 0 -1px gray;" ng-bind="plan.displayName"></span>
							</div>
							<div style="position: absolute; top:5px; right: 20px;" ng-if="plan.userUid == user.userUid">
								<a href="javascript:void(0);" ng-click="removeTourPlan(plan.recordNo);">
									<i class="icon-custom icon-xs rounded icon-bg-u fa fa-trash-o"></i>
								</a>
							</div>
							<div style="position: absolute; top: 50px; text-shadow:-1px 0 gray, 0 1px gray, 1px 0 gray, 0 -1px gray; font-size: 25px; width: 100%; overflow: hidden; text-align: center; padding-right: 20px;">
							<a style="color: white; white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;"  ng-bind="plan.title" href="${pageContext.request.contextPath}/views/plan/detail.jsp?recordNo={{plan.recordNo}}"></a>
							</div>
							<div class="news-v3-in-sm" style="border: 1px solid #e2e2e2;">
								<ul class="list-inline posted-info">
									<li ng-bind="plan.period"></li>
									<li ng-bind="plan.regDate | timesince : 'kr'"></li>
								</ul>
								<h2 ng-if="plan.strapline.length > 0"><a href="${pageContext.request.contextPath}/views/plan/detail.jsp?recordNo={{plan.recordNo}}" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;" ng-bind="plan.strapline"></a></h2>
								<h2 ng-if="plan.strapline.length == 0"><a href="${pageContext.request.contextPath}/views/plan/detail.jsp?recordNo={{plan.recordNo}}" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;">소제목이 없습니다</a></h2>
								<div style="height:100px; overflow:hidden;" ng-bind="plan.introduce"></div>
								<ul class="post-shares">
									<li><a href="javascript:void(0);"><i class="rounded-2x fa fa-thumbs-o-up"></i><span ng-bind="plan.likeCnt"></span></a></li>좋아요
									<li><a href="javascript:void(0);"><i class="rounded-2x fa fa-bookmark-o"></i><span ng-bind="plan.bookmarkCnt"></span></a></li>북마크
									<li><a href="javascript:void(0);"><i class="rounded-2x fa fa fa-clone"></i><span ng-bind="plan.customCnt"></span></a></li>커스텀
									<li><a href="javascript:void(0);"><i class="rounded-2x fa fa-comments-o"></i><span ng-bind="plan.commentCnt"></span></a></li>댓글
								</ul>
							</div>
						</div><!-- 여행일정 한개 끝 -->

					</div><!-- 여행일정 리스트 DIV -->
					
				</div>
				
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
	<script type="text/javascript" src="mytourplan.js"></script>
	
</body>
</html>
