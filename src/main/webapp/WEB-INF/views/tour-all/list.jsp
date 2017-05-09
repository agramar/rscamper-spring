<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" 	href="../../assets/plugins/cube-portfolio/cubeportfolio/css/cubeportfolio.min.css">
<link rel="stylesheet"	href="../../assets/plugins/cube-portfolio/cubeportfolio/custom/custom-cubeportfolio.css">
<link rel="stylesheet"	href="list.css">


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
					<li><a href="javascript:history.back()">tour-all</a></li>
				</ul>
			</div>
		</div>

		<!--=== 내용 ===-->
		<!--=== Content ===-->
		<div class="container content-md" style="padding: 0px; margin-top: 10px;">
			<div class="row">
				<section class="col-lg-12">
					<button class="btn-u rounded" type="button" value="12" onclick="typeChange(this)"><i class="fa fa-bookmark-o"></i> 관광지</button>
					<button class="btn-u btn-u-purple rounded" type="button" value="14" onclick="typeChange(this)"><i class="fa fa-coffee"></i> 문화시설</button>
					<button class="btn-u btn-u-red rounded" type="button" value="15" onclick="typeChange(this)"><i class="fa fa-child"></i> 축제공연행사</button>
					<button class="btn-u btn-u-orange rounded" type="button" value="25" onclick="typeChange(this)"><i class="fa fa-plane"></i> 여행코스</button>
					<button class="btn-u btn-u-blue rounded" type="button" value="28" onclick="typeChange(this)"><i class="fa fa-soccer-ball-o"></i> 레포츠</button>
					<button class="btn-u btn-u-brown rounded" type="button" value="32" onclick="typeChange(this)"><i class="fa fa-home"></i> 숙박</button>
					<button class="btn-u btn-u-green rounded" type="button" value="38" onclick="typeChange(this)"><i class="fa fa-shopping-cart"></i> 쇼핑</button>
					<button class="btn-u btn-u-default rounded" type="button" value="39" onclick="typeChange(this)"><i class="fa fa-cutlery"></i> 음식점</button>
				</section>
			</div>
			<div id="category-div">
				<div class="col-lg-11">
					<div class="row" id="cat2-list">
						<section class="col-lg-4">
							<select class="form-control rounded" title="대분류" name="cat1" onchange="getCat2List(this);">
								<option value="">대분류</option>
								<option value="A01">자연</option>
								<option value="A02">인문(문화/예술/역사)</option>
								<option value="A03">레포츠</option>
								<option value="A04">쇼핑</option>
								<option value="A05">음식</option>
								<option value="B02">숙박</option>
								<option value="C01">추천코스</option>
							</select>
						</section>
						<section class="col-lg-4">
							<select class="form-control rounded" name="cat2" onchange="getCat3List(this);" title="중분류">
								<option value="">중분류</option>
							</select>
						</section>
						<section class="col-lg-4">
							<select class="form-control rounded" name="cat3" title="소분류">
								<option value="">소분류</option>
							</select>
						</section>
					</div>
					<div class="row" id="sigungu-list">
						<section class="col-lg-6">
							<select class="form-control rounded" title="지역선택" name="areacode" onchange="getSigunguList(this.value);">
								<option value="" selected="selected">지역선택</option>
								<option value="1">서울</option>
								<option value="2">인천</option>
								<option value="3">대전</option>
								<option value="4">대구</option>
								<option value="5">광주</option>
								<option value="6">부산</option>
								<option value="7">울산</option>
								<option value="8">세종특별자치시</option>
								<option value="31">경기도</option>
								<option value="32">강원도</option>
								<option value="33">충청북도</option>
								<option value="34">충청남도</option>
								<option value="35">경상북도</option>
								<option value="36">경상남도</option>
								<option value="37">전라북도</option>
								<option value="38">전라남도</option>
								<option value="39">제주도</option>
							</select> 
						</section>
						<section class="col-lg-6">
							<select class="form-control rounded" name="sigungucode" title="시군구선택">
								<option value="" selected="selected">시군구 선택</option>
							</select>
						</section>
					</div>
				</div>
				<div class="col-lg-1">
					<button class="btn-u rounded btn-u-yellow" type="button" onclick="tourList()"><i class="fa fa-search"></i></button>
				</div>
			</div>
			</div>
			
			<div class="cube-portfolio container margin-bottom-60" id="list">
				<div id="js-grid-masonry-projects" class="cbp cbp-l-grid-masonry-projects">
				</div>
			</div>

			<div class="text-center">
				<ul class="pagination pagination-lg"></ul>
			</div>

		</div>
		<!--=== End Content ===-->


	<!-- 푸터 include -->
	<%@include file="/resources/include/footer.jsp"%>

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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
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
	<script type="text/javascript" src="../../assets/plugins/cube-portfolio/cubeportfolio/js/jquery.cubeportfolio.min.js"></script>
	<script type="text/javascript" src="../../assets/js/plugins/cube-portfolio/cube-portfolio-4.js"></script>
	<script type="text/javascript" src="list.js"></script>
</body>
</html>
