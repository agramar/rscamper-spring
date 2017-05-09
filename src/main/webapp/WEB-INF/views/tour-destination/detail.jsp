<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<title>메인</title>

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

<!-- CSS Theme -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-colors/default.css" id="style_color">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-skins/dark.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="detail.css">

</head>

<body class="header-fixed header-fixed-space-default">
	<div class="wrapper">

		<!-- 헤더 include -->
		<%@include file="/resources/include/header.jsp"%>

		<!--=== 사이트맵 ===-->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="breadcrumb pull-left">
					<li><a href="http://localhost:8081"><i class="fa fa-home"></i></a></li>
					<li><a href="javascript:history.back()">tour</a></li>
					<li class="active">New</li>
				</ul>
			</div>
		</div>

		<!--=== 내용 ===-->
		<!--=== Content ===-->
		<div class="container content-md content">
			<h4></h4>
			<div class="row">
					<div class="col-md-6 md-margin-bottom-50">
						<div class="ms-showcase2-template" style="position: relative;">
						<!-- Master Slider -->
						<div class="master-slider ms-skin-default ms-wk" id="masterslider" style="visibility: visible; opacity: 1; margin: 0px;">
							<div class="ms-container">
								<div class="ms-inner-controls-cont" style="max-width: 550px;">
									<div class="ms-view ms-fade-view ms-grab-cursor" style="width: 550px; height: 550px;">
										<div class="ms-slide-container">
											<div class="ms-slide ms-sl-selected" style="width: 550px; height: 550px; opacity: 1;">
												<div class="ms-slide-bgcont" style="height: 100%; opacity: 1;">
													<img class="ms-brd" src="" alt="이미지가 없습니다." style="width: 550px; height: 367px; margin-left: 0px;">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="image_container" style="margin-top: 20px;  width: 550px; height: 130px;">
								<div style="margin: 0 auto; width: 545px; height: 130px;">
									<button type="button" class="bottom_Move" onclick="bottomMove(1)" style="margin: 30px 10px; float: left; width: 25px; height: 25px; display: inline-block; ">◀</button>
									<div class="bottom_slider_canvas" style="float: left; width: 445px; height: 100px; margin: 0 auto; display: inline-block; overflow: hidden;">
										<div class="bottom_slider_panel" style="float:left; margin: 0 auto; position: relative;"></div>
									</div>
									<button type="button" class="bottom_Move" onclick="bottomMove(2)" style="margin: 30px 10px; float: left; width: 25px; height: 25px; display: inline-block; ">▶</button>
								</div>
							</div>

							<div class="bx-controls bx-has-pager bx-has-controls-direction">
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-6 content1">
					<div class="tag-box tag-box-v1">
						<ul id="ul-info">
							<li id="li-title"><i
								class="icon-custom icon-sm rounded-x icon-bg-orange glyphicon glyphicon-flag"></i>
								<h2 id="text-title"></h2></li>
							<li><i
								class="icon-custom icon-sm rounded-x icon-bg-yellow glyphicon glyphicon-map-marker"></i><strong
								class="strong-custom"> 주소</strong> <span id="text-address"></span>
							</li>
							<li><i class="icon-custom icon-sm rounded-x icon-bg-yellow glyphicon glyphicon-home"></i>
								<strong	class="strong-custom"> 홈페이지</strong>
								<p class='p-custom' id="text-homepage"></p></li>
						</ul>
					</div>
					
					<div class="panel-group acc-v1" id="accordion-1">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h5 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion-1" href="#collapse-One"> <i
										class="glyphicon glyphicon-pencil"></i>개요
									</a>
								</h5>
							</div>
							<div id="collapse-One" class="panel-collapse collapse in">
								<div class="panel-body" id="text-content"></div>
							</div>
						</div>

						<div class="panel panel-default">
							<div class="panel-heading">
								<h5 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion-1" href="#collapse-Two"> <!-- <i class="icon-custom rounded-x icon-bg-yellow fa fa-info-circle"></i>이용안내 -->
										<i class="fa fa-info-circle"></i>이용안내
									</a>
								</h5>
							</div>
							<div id="collapse-Two" class="panel-collapse collapse">
								<div class="panel-body" id="text-info"></div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h5 class="panel-title">
									<a class="accordion-toggle" data-toggle="collapse"
										data-parent="#accordion-1" href="#collapse-Three"> <i
										class="glyphicon glyphicon-plus-sign"></i>부가정보
									</a>
								</h5>
							</div>
							<div id="collapse-Three" class="panel-collapse collapse">
								<div class="panel-body" id="text-plusInfo"></div>
							</div>
						</div>
					</div>
				</div>
			</div>




		</div>
		<!--=== End Content ===-->

		<!-- 푸터 include -->
		<%@include file="/resources/include/footer.jsp"%>

	</div>
	
	<!-- 로그인 모달 include -->
	<%@include file="/resources/include/userModal.jsp"%>

	<!-- JS Global Compulsory -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

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
	<![endif]-->

	<!-- 파이어베이스 -->
	<script type="text/javascript" src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/firebaseInit.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/firebaseAuth.js"></script>
	
	<!-- 메뉴 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/menu.js"></script>
	
	<!-- INIT APP -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/initApp.js"></script>
	
	
	
	<!---------------------여기서부터수정------------------------------------------------------------------------------------>
	
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="detail.js"></script>
	<script type="text/javascript">
		var obj = new Object();
		obj.contentid = ${param.contentid};
		obj.contenttypeid = ${param.contenttypeid};
		apiAjax(obj);
	</script>
</body>
</html>
