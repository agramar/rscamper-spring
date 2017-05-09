<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>채팅</title>
<meta charset="utf-8">
<meta name="description" content="D3.js로 만든 우리나라 지도">
<meta name="author" content="링크잇, http://linkit.kr">
<!-- Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">	
	

<!-- Favicon -->
<link rel="shortcut icon" href="../../favicon.ico">

<!-- Web Fonts -->
<link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'>

<!-- CSS Global Compulsory -->
<link rel="stylesheet" href="../../assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet" href="../../assets/css/headers/header-default.css">
<link rel="stylesheet" href="../../assets/css/footers/footer-v3.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="../../assets/plugins/animate.css">
<link rel="stylesheet" href="../../assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet" href="../../assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="../../assets/plugins/parallax-slider/css/parallax-slider.css">
<link rel="stylesheet" href="../../assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="../../assets/plugins/login-signup-modal-window/css/style.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="../../assets/css/theme-colors/default.css" id="style_color">
<link rel="stylesheet" href="../../assets/css/theme-skins/dark.css">
<link rel="stylesheet" href="../../assets/css/custom.css">

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="css/style.css">
	
	<!--[if lt IE 9]>
  <script src="http://linkit.kr/demos/browser_update.js"></script>
  <![endif]-->
  
  <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
<!-- 	<script src="http://d3js.org/d3.v3.min.js"></script> -->
	<script charset="utf-8" src="js/d3.js"></script>
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
					<li><a href="javascript:history.back()">chat</a></li>
				</ul>
			</div>
		</div>
		
		<!--=== 내용 ===-->
		<!--=== Content ===-->
		<!-- 채팅방 팝업 -->
		<div class="modal fade shipping-form modal-dialog modal-center" id="layerpop" style="width: 500px;">
			<h3 style="color: #72c02c;">Create Room</h3>
			<div class="form-group g-mb-20">
				<input type="text" id="inputRoomTitle" class="form-control rounded g-mb-20" placeholder="방제목">
				<select class="form-control rounded" name="locationid">
					<option>지역</option>
					<option value="15">서울특별시</option>
					<option value="14">부산광역시</option>
					<option value="13">대구광역시</option>
					<option value="12">인천광역시</option>
					<option value="11">광주광역시</option>
					<option value="10">대전광역시</option>
					<option value="9">울산광역시</option>
					<option value="8">경기도</option>
					<option value="7">강원도</option>
					<option value="6">충청북도</option>
					<option value="5">충청남도</option>
					<option value="4">전라북도</option>
					<option value="3">전라남도</option>
					<option value="2">경상북도</option>
					<option value="1">경상남도</option>
					<option value="0">제주도</option>
				</select>
				<select class="form-control rounded" name="locationid">
					<option>최대인원</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="1">5</option>
					<option value="1">6</option>
					<option value="1">7</option>
					<option value="1">8</option>
					<option value="1">9</option>
					<option value="1">10+</option>
				</select>
			</div>

			<div class="form-group g-mb-20">
				<div class="row">
					<div class="col-sm-6 g-xs-mb-20">
						<input type="text" name="captain" class="form-control rounded" placeholder="Captain">
					</div>

					<div class="col-sm-6 g-xs-mb-20">
						<input type="password" name="password" class="form-control rounded" placeholder="Password">
					</div>
				</div>
			</div>
			<button type="button" class="btn-u btn-u-lg btn-u-default btn-u-upper rounded" data-dismiss="modal" 
			onclick="createRoom()" style="width: 100%; background: #72c02c;">생성</button>
			<button type="button" class="btn-u btn-u-lg btn-u-default btn-u-upper rounded" data-dismiss="modal" 
			style="width: 100%; background: #95a5a6;">취소</button>
		</div>
		
		
		<div class="container content-md" style="">
			<div class="row" style="padding: 0px;">
				<!-- map -->
				<div class="col-md-6" style="margin-top: 100px;">
					<div id="container" class="container" >
						<div id="control" class="ui-widget-header ui-corner-all"
							style="top: 140px;">
							<button id="zoomin">확대</button>
							<button id="zoomout">축소</button>
						</div>
					</div>
				</div>

				<!-- 채팅방 -->
				<div class="col-md-6">
					<div class="call-action-v1-in inner-btn page-scroll" >
						<button type="button" data-target="#layerpop" data-toggle="modal" class="btn-u btn-u-sea-shop btn-u-lg"
						style="margin-right: 0;">Add to Room</button>
						
						<div class="wrap" style="height: 700px; overflow: hidden;">
							<div style="height: 700px; overflow: auto;">
								<table class="table table-hover table-striped invoice-table">
									<thead style="height: 30px; background-color: #DEDEDE;">
										<tr>
											<th>Area</th>
											<th>Name</th>
											<th class="glyphicon glyphicon-user"></th>
											<th></th>
										</tr>
									</thead>
									<tbody style="height: 500px;"></tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="contex-bg" style="margin-top: 50px;"></div>
				</div>
			</div>
		</div>
	</div>
	<!--=== End Content ===-->
	<!-- ================================================================ -->
	
	<!-- 푸터 include -->
	<%@include file="/resources/include/footer.jsp"%>
	
	
	<!-- 로그인 모달 include -->
	<%@include file="/resources/include/userModal.jsp"%>

	<!-- JS Global Compulsory -->
	<script type="text/javascript"
		src="../../assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/bootstrap/js/bootstrap.min.js"></script>

	<!-- JS Implementing Plugins -->
	<script type="text/javascript"
		src="../../assets/plugins/back-to-top.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/smoothScroll.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script type="text/javascript" src="../../assets/plugins/modernizr.js"></script>
	<script type="text/javascript"
		src="../../assets/plugins/login-signup-modal-window/js/main.js"></script>

	<!-- JS Page Level -->
	<script type="text/javascript" src="../../assets/js/app.js"></script>
	<script type="text/javascript"
		src="../../assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript"
		src="../../assets/js/plugins/parallax-slider.js"></script>
	
	
	
	<!--[if lt IE 9]>
	<script src="../../assets/plugins/respond.js"></script>
	<script src="../../assets/plugins/html5shiv.js"></script>
	<script src="../../assets/plugins/placeholder-IE-fixes.js"></script>
	<![endif]-->
	
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>

	<!-- 파이어베이스 -->
	<script type="text/javascript"
		src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script type="text/javascript" src="../../resources/js/firebaseInit.js"></script>
	<script type="text/javascript" src="../../resources/js/firebaseAuth.js"></script>



	<!-- 메뉴 -->
	<script type="text/javascript" src="../../resources/js/menu.js"></script>

	<!-- INIT APP -->
	<script type="text/javascript" src="../../resources/js/initApp.js"></script>
	
	<!---------------------여기서부터수정------------------------------------------------------------------------------------>
	
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="list.js"></script>	
	<script src="js/script.js"></script>
</body>
</html>