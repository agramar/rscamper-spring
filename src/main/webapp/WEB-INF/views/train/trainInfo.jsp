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
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/favicon.ico">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css'
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/headers/header-default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/footers/footer-v3.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/parallax-slider/css/parallax-slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/plugins/login-signup-modal-window/css/style.css">

<!-- CSS Theme -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/theme-colors/default.css"
	id="style_color">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/theme-skins/dark.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/custom.css">

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="trainInfo.css">

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
					<li><a href="javascript:history.back()">기차정보</a></li>
					<li class="active">New</li>
				</ul>
			</div>
		</div>

		<!--=== 내용 ===-->
		<!--=== Content ===-->
	<div class="container content-md">
		<!-- 노선도 부분 -->
			<div class="box boxpurple clearfix">
				<h3>지역별 노선도</h3>
				<input class="btn-u" type="button" id="mapBtn" value="경부선" data-val="1" onclick="trainLinBtn(this);" data-color="#72c02c"> 
				<input class="btn-u btn-u-blue" type="button" id="mapBtn" value="경북선" data-val="2" onclick="trainLinBtn(this);" data-color="blue">
				<input class="btn-u btn-u-red" type="button" id="mapBtn" value="경원선" data-val="3" onclick="trainLinBtn(this);" data-color="red"> 
				<input class="btn-u btn-u-orange" type="button" id="mapBtn" value="경전선" data-val="4" onclick="trainLinBtn(this);" data-color="orange">
				<input class="btn-u btn-u-sea" type="button" id="mapBtn" value="경춘선" data-val="5" onclick="trainLinBtn(this);" data-color="#16a085"> 
				<input class="btn-u btn-u-green" type="button" id="mapBtn" value="광주선" data-val="6" onclick="trainLinBtn(this);" data-color="green">
				<input class="btn-u btn-u-yellow" type="button" id="mapBtn" value="동해남부선" data-val="7" onclick="trainLinBtn(this);" data-color="yellow"> 
				<input class="btn-u btn-u-default" type="button" id="mapBtn" value="영동선" data-val="8" onclick="trainLinBtn(this);" data-color="#95a5a6">
				<input class="btn-u btn-u-dark" type="button" id="mapBtn" value="장항선" data-val="9" onclick="trainLinBtn(this);" data-color="#333"> 
				<input class="btn-u btn-u-purple" type="button" id="mapBtn" value="전라선" data-val="10" onclick="trainLinBtn(this);" data-color="purple">
				<input class="btn-u btn-u-aqua" type="button" id="mapBtn" value="중앙선" data-val="11" onclick="trainLinBtn(this);" data-color="#27d7e7"> 
				<input class="btn-u btn-u-brown" type="button" id="mapBtn" value="충북선" data-val="12" onclick="trainLinBtn(this);" data-color="#9c8061">
				<input class="btn-u btn-u-dark-blue" type="button" id="mapBtn" value="태백선" data-val="13" onclick="trainLinBtn(this);" data-color="#324c80"> 
				<input class="btn-u btn-u-light-green" type="button" id="mapBtn" value="호남선" data-val="14" onclick="trainLinBtn(this);" data-color="#59b795">

				<div id="map" style="width: 1032px; height: 700px;"></div>
			</div>
			<br>
		<!-- 시간표 부분 -->
		<div id="selectTrain">
			<div class="wrap">
  				<input name="trainRadio" type="radio" id="radio0" class="radio" value="01">
  					<label for="radio0" class="radio-label">
    					<i class="fa fa-check"></i>
    						<span>새마을</span>
  					</label>
  				<input name="trainRadio" type="radio" id="radio1" class="radio" value="02">
  					<label for="radio1" class="radio-label">
   						 <i class="fa fa-check"></i>
    						<span>무궁화</span>
  					</label>
  				<input name="trainRadio" type="radio" id="radio2" class="radio" value="03">
  					<label for="radio2" class="radio-label">
   						 <i class="fa fa-check"></i>
    						<span>통근열차</span>
  					</label>
  				<input name="trainRadio" type="radio" id="radio3" class="radio" value="04">
  					<label for="radio3" class="radio-label">
   						 <i class="fa fa-check"></i>
    						<span>누리로</span>
  					</label>
  				<input name="trainRadio" type="radio" id="radio4" class="radio" value="09">
  					<label for="radio4" class="radio-label">
   						 <i class="fa fa-check"></i>
    						<span>ITX-청춘</span>
  					</label>
  				<input name="trainRadio" type="radio" id="radio5" class="radio" value="08">
  					<label for="radio5" class="radio-label">
   						 <i class="fa fa-check"></i>
    						<span>ITX-새마을</span>
  					</label>
  			<div class="row" style="margin-top: 10px;">
  				<div class="col-sm-6 col-lg-3">
  					<div class="input-group">
						<input type="text" class="form-control" id="startInput" name="start" placeholder="출발역선택">
							<span class="input-group-btn">
						<button type="submit" class="btn btn-default" id="startButton" onclick="startBtn();">조회</button>
							</span>
  					</div>
  				</div>
  				
  				<div class="col-sm-6 col-lg-3">
  					<div class="input-group">
						<input type="text" class="form-control" id="arriveInput" name="arrive" placeholder="도착역선택">
							<span class="input-group-btn">
						<button type="submit" class="btn btn-default" id="arriveButton"onclick="arriveBtn();">조회</button> 
							</span>
  					</div>
  				</div>
  				
  				<div class="col-sm-6 col-lg-3" style="width: 155px;">
  					<div class="input-group">
						<input type="date" name="calender" style="height: 34px;" width="140px;"> 
  					</div>
  				</div>
					<input type="hidden" name="numOfRows"> 
					<input type="hidden" name="pageNo"> 
					<input type="hidden" name="pageSize">
					<input type="hidden" name="startPage">
					<div class="col-sm-6 col-lg-3" style="width: 160px;">
  						<div class="input-group">
							<button type="button" class="btn-u rounded btn-u-yellow" onclick="joinBtn();" style="width: 80px;"><i class="fa fa-search"></i></button>
						</div>
					</div>
  			  </div>		
			</div>
		</div>
		<br>
			<p>※ 본 정보는 한국철도공사의 사정에 따라 변경 될 수 있습니다. 최신정보 확인은 한국철도공사 홈페이지<a href="http://letskorail.com">  www.letskorail.com  </a>에서 확인하시기 바랍니다.</p>
		
	<!-- Train Modal(여기모달부분) 조회 모달 -->
		
		<div class="modal fade" id="trainModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="width: 650px; height: 800px; overflow: scroll;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">역선택</h4>
					</div>
					<div class="modal-body" id="bodyTime1"></div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
		
		<!-- 시간표 조회 모달  -->
		<div class="modal fade" id="timeList" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="width: 650px; height: 800px; overflow: scroll;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">열차시간표</h4>
					</div>
					<div class="modal-body" id="bodyTime2"></div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 메인에서 조회시 모달창 -->
		<div class="modal fade" id="mainTraintime" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content" style="width: 650px; height: 480px; overflow: scroll;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">열차시간표</h4>
					</div>
					<div class="modal-body" id="bodyTime3"></div>
				</div>
			</div>
		</div>
	</div>

		<!--=== End Content ===-->


		<!-- 푸터 include -->
		<%@include file="/resources/include/footer.jsp"%>



	<!-- 로그인 모달 include -->
	<%@include file="/resources/include/userModal.jsp"%>

	<!-- JS Global Compulsory -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

	<!-- JS Implementing Plugins -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/back-to-top.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/smoothScroll.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/modernizr.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/plugins/login-signup-modal-window/js/main.js"></script>

	<!-- JS Page Level -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/plugins/parallax-slider.js"></script>

	<!--[if lt IE 9]>
	<script src="${pageContext.request.contextPath}/assets/plugins/respond.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/html5shiv.js"></script>
	<script src="${pageContext.request.contextPath}/assets/plugins/placeholder-IE-fixes.js"></script>
	<![endif]-->

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>

	<!-- 파이어베이스 -->
	<script type="text/javascript"
		src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/firebaseInit.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/firebaseAuth.js"></script>

	<!-- 메뉴 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/menu.js"></script>

	<!-- INIT APP -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/initApp.js"></script>



	<!---------------------여기서부터수정------------------------------------------------------------------------------------>
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="trainInfo.js"></script>

	<!-- 구글맵KEY -->
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDP280f_8sA7GmSMVAXTl9DdUsDGRXTUgM&callback=initMap">
		
	</script>
	<!-- 구글맵지오코딩KEY -->

</body>
</html>
