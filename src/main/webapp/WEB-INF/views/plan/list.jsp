<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<title>여행일정</title>

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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/fancybox/source/jquery.fancybox.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.1/jquery-ui.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/brand-buttons/brand-buttons.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/brand-buttons/brand-buttons-inversed.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css">
	
	<!-- CSS Theme -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-colors/default.css" id="style_color">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-skins/dark.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">
	
	<!-- Sweet Alert -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.css">

	<!-- 사용자 정의 CSS -->
	<link rel="stylesheet" href="list.css">

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
					<li class="active"><a href="list.jsp">여행일정</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->

		<!--=== 내용 ===-->
		<div class="container content-md" style="padding-top: 20px;" ng-app="TourPlanApp" ng-controller="ListController">

			<!-- 여행일정 만들기 폼 모달 -->
			<%@include file="include/createTourPlanFormModal.jsp"%>

			<!-- 일정 및 사이드바 -->
			<div class="row">

				<!-- 여행일정 전체 -->
				<div class="col-md-9" ng-if="planList.length > 0">

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
					
					<!-- 페이징 -->
					<div class="text-center">
						<ul class="pagination">
							<li><a href="javascript:void(0);" ng-click="pnPage(false)">«</a></li>
								<li ng-repeat="pageNumber in pageArr" ng-class="{true: 'active'}[pageNumber == searchParams.pageNo]"><a href="javascript:void(0);" ng-click="noPage(pageNumber)" ng-bind="pageNumber"></a></li>
							<li><a href="javascript:void(0);" ng-click="pnPage(true)">»</a></li>
						</ul>
					</div><!-- 페이징 끝 -->

				</div><!-- 여행일정 전체 끝 -->
				
				<!-- 표시해줄 일정이 없을때 -->
				<div class="col-md-9" style="text-align: center;" ng-if="planList.length == 0">
					<img style="height: 200px;" src="${pageContext.request.contextPath}/resources/img/404/yaoming.png">
					<span>일정이 없습니다.</span>
				</div>

				<!-- 사이드 바 -->
				<div class="col-md-3">

					<!-- 일정 만들기 -->
					<div class="bg-light">
						<h4><i class="fa fa-map-signs"></i>여행일정 만들기</h4>
						<button class="btn rounded btn-block btn-bitcoin-inversed" ng-click="createTourPlan();">
							<i class="fa fa-map-signs"></i> 내 여행일정 만들기
						</button>
					</div>

					<!-- 정렬 -->
					<div class="bg-light">
						<h4><i class="fa fa-sort"></i>정렬방식</h4>
						<select class="form-control margin-bottom-10" ng-options="standard.standardValue as standard.standardName for standard in optionDatas.standardList" ng-model="searchParams.standard"></select>
						<select class="form-control" ng-options="order.orderValue as order.orderName for order in optionDatas.orderList" ng-model="searchParams.order"></select>
					</div>

					<!-- 검색 -->
					<div class="bg-light">
						<h4><i class="fa fa-keyboard-o"></i>검색어</h4>
						<input type="text" class="form-control margin-bottom-20" placeholder="검색어를 입력하세요" ng-model="searchParams.word">

						<h4><i class="fa fa-th-large"></i>표시개수</h4>
						<select class="form-control margin-bottom-20" ng-options="amount.amountValue as amount.amountName for amount in optionDatas.amountList" ng-model="searchParams.amount"></select>

						<h4><i class="fa fa-sliders"></i>검색범위</h4>
						<select class="form-control margin-bottom-20" ng-options="datePeriod.datePeriodValue as datePeriod.datePeriodName for datePeriod in optionDatas.datePeriodList" ng-model="searchParams.datePeriod"></select>

						<h4><i class="fa fa-calendar"></i>여행기간</h4>
						<input type="text" id="day-range-value" readonly style="border: 0; color: #f6931f; font-weight: bold;">
						<div id="day-range" class="margin-bottom-30"></div>

						<button class="btn rounded btn-block btn-bitcoin-inversed" ng-click="filtering();">
							<i class="fa fa-list-ul"></i> 검색 및 정렬 적용
						</button>

					</div>

				</div><!-- 사이드바 끝 -->

			</div><!-- 일정 및 사이드바 끝 -->

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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/angular-1.5.8/angular.min.js"></script>

	<!-- JS Implementing Plugins -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/back-to-top.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/smoothScroll.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/modernizr.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/login-signup-modal-window/js/main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/fancybox/source/jquery.fancybox.pack.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.1/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/jquery.maskedinput.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/js/jquery.validate.min.js"></script>


	<!-- JS Page Level -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/fancy-box.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/parallax-slider.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/masking.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/datepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/plugins/validation.js"></script>

	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/assets/plugins/respond.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/placeholder-IE-fixes.js"></script>
	<![endif]-->

	<!-- 파이어베이스 -->
	<script type="text/javascript" src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/firebaseInit.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/firebaseAuth.js"></script>
	
	<!-- Sweet Alert -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.min.js"></script>
	<!-- isLoading -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/isLoading/jquery.isloading.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
	<!-- 메뉴 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/menu.js"></script>

	<!-- INIT APP -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/initApp.js"></script>

	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="js/ng-simple-upload.js"></script>
	<script type="text/javascript" src="js/tourPlanApp.js"></script><!-- 앵귤러 모듈 및 라우터 선언 -->
	<script type="text/javascript" src="js/tourPlanFilters.js"></script><!-- 앵귤러 사용자정의 필터 선언 -->
	<script type="text/javascript" src="js/tourPlanServices.js"></script><!-- 앵귤러 모듈 및 라우터 선언 -->
	<script type="text/javascript" src="js/tourPlanDirectives.js"></script><!-- 앵귤러 사용자정의 지시자 선언 -->
	<script type="text/javascript" src="list.js"></script>

</body>
</html>
