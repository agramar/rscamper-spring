<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicon -->
<link rel="shortcut icon" href="../../favicon.ico">

<!-- Web Fonts -->
<!--     <link rel='stylesheet' type='text/css' href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600&amp;subset=cyrillic,latin'> -->

<!-- CSS Global Compulsory -->
<link rel="stylesheet"
	href="../../assets/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../../assets/css/style.css">

<!-- CSS Header and Footer -->
<link rel="stylesheet"
	href="../../assets/css/headers/header-default.css">
<link rel="stylesheet" href="../../assets/css/footers/footer-v3.css">

<!-- CSS Implementing Plugins -->
<link rel="stylesheet" href="../../assets/plugins/animate.css">
<link rel="stylesheet"
	href="../../assets/plugins/line-icons/line-icons.css">
<link rel="stylesheet"
	href="../../assets/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="../../assets/plugins/parallax-slider/css/parallax-slider.css">
<link rel="stylesheet"
	href="../../assets/plugins/owl-carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet"
	href="../../assets/plugins/login-signup-modal-window/css/style.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="../../assets/css/theme-colors/default.css"
	id="style_color">
<link rel="stylesheet" href="../../assets/css/theme-skins/dark.css">

<!-- CSS Customization -->
<link rel="stylesheet" href="../../assets/css/custom.css">
<!-- modal 버튼 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script type="text/javascript" src="../../assets/js/jquery-3.1.1.min.js"></script>
<style type="text/css">
#timeList{
	border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
    margin: 20px 10px;
}
#timeList tr{
	width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #eee;
}
#timeList td{
	width: 155px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #ce4869;
}
</style>

</head>

<body class="header-fixed header-fixed-space-default">

	<div class="wrapper">

		<!--=== Header ===-->
		<div class="header header-sticky">
			<div class="container">
				<!-- Logo -->
				<a class="logo" href="index.html"> <img
					src="../../assets/img/logo1.png" style="width:50px; height: 50px;" alt="Logo">
				</a>
				<!-- End Logo -->

				<!-- Topbar -->
				<div class="topbar">
					<ul class="loginbar pull-right">
						<li><a href="#"><i class="fa fa-info"></i> HELP</a></li>
						<li class="topbar-devider"></li>
						<li id="loginBtn" class="cd-log_reg"><a class="cd-signin"
							href="javascript:void(0);"><i class="fa fa-lock"></i> Login</a></li>
						<li id="logoutBtn" style="display: none;">
						<a href="javascript:void(0);" onclick="signout();">
						<i class="fa fa-unlock-alt"></i> Logout</a></li>
					</ul>
				</div>
				<!-- End Topbar -->

				<!-- Toggle get grouped for better mobile display -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-responsive-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="fa fa-bars"></span>
				</button>
				<!-- End Toggle -->
			</div>
			<!--/end container-->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div
				class="collapse navbar-collapse mega-menu navbar-responsive-collapse">
				<div class="container">
					<ul class="nav navbar-nav" id="start">
						<!-- Search Block -->
						<li><i class="search fa fa-search search-btn"></i>
							<div class="search-open">
								<div class="input-group animated fadeInDown">
									<input type="text" class="form-control" placeholder="Search">
									<span class="input-group-btn">
										<button class="btn-u" type="button">Go</button>
									</span>
								</div>
							</div></li>
						<!-- End Search Block -->

					</ul>
				</div>
				<!--/end container-->
			</div>
			<!--/navbar-collapse-->
		</div>
		<!--=== End Header ===-->

		<!-- ================================================================ -->

		<!--=== Breadcrumbs 사이트맵 ===-->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="breadcrumb pull-left">
					<li><a href="http://localhost:8081"><i class="fa fa-home"></i></a></li>
					<li><a href="javascript:history.back()">TrainTime</a></li>
				</ul>
			</div>
			<!--/container-->
		</div>
		<!--/breadcrumbs-->
		<!--=== End Breadcrumbs ===-->


		<!--=== Content ===-->
		<div class="container content-md">
			<!--  기차정보 여기부터 -->
			<div id="selectTrain"
				style="overflow: hidden; float: left; width: 900px; height: 300px; padding: 17px 20px 0; border: 4px solid #0095cd; background: #ecf1f4">
				<input type="radio" name="trainRadio" value="01" id="a1">새마을 
				<input type="radio" name="trainRadio" value="02" id="a2">무궁화
				<input type="radio" name="trainRadio" value="03" id="a3">통근열차 
				<input type="radio" name="trainRadio"value="04" id="a4">누리로 
				<input type="radio" name="trainRadio" value="09" id="a5">ITX-청춘
				<input type="radio" name="trainRadio" value="08" id="a6">ITX-새마을 <br> 
				출발역:<input type="text" id="startInput" name="start"><button class="btn btn-default" id="startButton" onclick="startBtn();">조회</button><br>
				도착역:<input type="text" id="arriveInput" name="arrive"><button class="btn btn-default" id="arriveButton"onclick="arriveBtn();">조회</button><br> 
				<input type="date" name="calender"> 
				<input type="hidden" name="numOfRows"> 
				<input type="hidden" name="pageNo"> 
				<input type="hidden" name="pageSize">
				<input type="hidden" name="startPage"> 
				<input type="button" value="조회하기" onclick="joinBtn();" />

			</div>
		</div>

		<table class="table" id="timeList">
			<thead>
				<tr>
					<td>출발역</td>
					<td>출발시간</td>
					<td>도착역</td>
					<td>도착시간</td>
					<td>열차종류</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>

		<!-- Train Modal(여기모달부분) -->

		<div class="modal fade" id="trainModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">역선택</h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>
		
		
		<!--=== End Content ===-->
		<!-- ================================================================ -->

		<!--=== Footer v3 ===-->
		<div id="footer-v3" class="footer-v3">
			<div class="footer">
				<div class="container">
					<div class="row">
						<!-- About -->
						<div class="col-sm-3 md-margin-bottom-40">
							<a href="index.html"><img id="logo-footer"
								class="footer-logo" src="assets/img/logo2-default.png" alt=""></a>
							<p>About Unify dolor sit amet, consectetur adipiscing elit.
								Maecenas eget nisl id libero tincidunt sodales.</p>
						</div>
						<!--/col-md-3-->
						<!-- End About -->

						<!-- Simple List -->
						<div class="col-sm-3 md-margin-bottom-40">
							<div class="thumb-headline">
								<h2>About Unify</h2>
							</div>
							<ul class="list-unstyled simple-list margin-bottom-20">
								<li><a href="#">About Us</a></li>
								<li><a href="#">Forum</a></li>
								<li><a href="#">Careers</a></li>
								<li><a href="#">Community</a></li>
								<li><a href="#">Stories</a></li>
								<li><a href="#">Contact Us</a></li>
							</ul>
						</div>
						<!--/col-md-3-->

						<div class="col-sm-3">
							<div class="thumb-headline">
								<h2>Topics</h2>
							</div>
							<ul class="list-unstyled simple-list margin-bottom-20">
								<li><a href="#">Bootstrap</a></li>
								<li><a href="#">Font Awesome</a></li>
								<li><a href="#">WordPress</a></li>
								<li><a href="#">Favicon</a></li>
								<li><a href="#">Javascript</a></li>
								<li><a href="#">iOS</a></li>
							</ul>
						</div>
						<!--/col-md-3-->

						<div class="col-sm-3">
							<div class="thumb-headline">
								<h2>Developers</h2>
							</div>
							<ul class="list-unstyled simple-list margin-bottom-20">
								<li><a href="#">Web Development</a></li>
								<li><a href="#">Web Design</a></li>
								<li><a href="#">Android Development</a></li>
								<li><a href="#">PHP Development</a></li>
								<li><a href="#">Programmer</a></li>
								<li><a href="#">Start-up</a></li>
							</ul>
						</div>
						<!--/col-md-3-->
						<!-- End Simple List -->
					</div>
				</div>
			</div>
			<!--/footer-->

			<div class="copyright">
				<div class="container">
					<div class="row">
						<!-- Terms Info-->
						<div class="col-md-6">
							<p>
								2015 &copy; All Rights Reserved. Unify Theme by <a
									target="_blank" href="https://twitter.com/htmlstream">Htmlstream</a>
								| <a href="#">Privacy Policy</a> | <a href="#">Terms of
									Service</a>
							</p>
						</div>
						<!-- End Terms Info-->

						<!-- Social Links -->
						<div class="col-md-6">
							<ul class="social-icons pull-right">
								<li><a href="#" data-original-title="Facebook"
									class="rounded-x social_facebook"></a></li>
								<li><a href="#" data-original-title="Twitter"
									class="rounded-x social_twitter"></a></li>
								<li><a href="#" data-original-title="Goole Plus"
									class="rounded-x social_googleplus"></a></li>
								<li><a href="#" data-original-title="Linkedin"
									class="rounded-x social_linkedin"></a></li>
								<li><a href="#" data-original-title="Pinterest"
									class="rounded-x social_pintrest"></a></li>
							</ul>
						</div>
						<!-- End Social Links -->
					</div>
				</div>
			</div>
			<!--/copyright-->
		</div>
		<!--=== End Footer v3 ===-->

	</div>
	<!--/wrapper-->

	<div class="cd-user-modal">
		<!-- this is the entire modal form, including the background -->
		<div class="cd-user-modal-container">
			<!-- this is the container wrapper -->
			<ul class="cd-switcher">
				<li><a href="javascript:void(0);">로그인</a></li>
				<li><a href="javascript:void(0);">회원가입</a></li>
			</ul>

			<div id="cd-login">
				<!-- log in form -->
				<form id="signin-email-form" class="cd-form">
					<p class="social-login">
						<span class="social-login-facebook"><a href="#"
							onclick="signinProvider('facebook');"><i
								class="fa fa-facebook"></i> Facebook</a></span> <span
							class="social-login-google"><a href="#"
							onclick="signinProvider('google');"><i class="fa fa-google"></i>
								Google</a></span> <span class="social-login-twitter"><a href="#"
							onclick="signinProvider('twitter');"><i class="fa fa-twitter"></i>
								Twitter</a></span>
					</p>

					<div class="lined-text">
						<span>이메일 계정으로 로그인</span>
						<hr>
					</div>

					<p class="fieldset">
						<label class="image-replace cd-email" for="signin-email">E-mail</label>
						<input class="full-width has-padding has-border" id="signin-email"
							type="email" placeholder="E-mail" required> <span
							class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">Password</label>
						<input class="full-width has-padding has-border"
							id="signin-password" type="password" placeholder="Password"
							required> <a href="javascript:void(0);"
							class="hide-password">Show</a> <span id="signin-email-error"
							class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input type="checkbox" id="remember-me"> <label
							for="remember-me">로그인 유지하기</label>
					</p>

					<p class="fieldset">
						<input id="signin-email-btn" class="full-width" type="button"
							value="로그인">
					</p>
				</form>

				<p class="cd-form-bottom-message">
					<a href="javascript:void(0);" onclick="">비밀번호를 잊으셨나요?</a>
				</p>
				<a href="javascript:void(0);" class="cd-close-form">Close</a>
			</div>
			<!-- cd-login -->

			<div id="cd-signup">
				<!-- sign up form -->
				<form id="signup-email-form" class="cd-form">
					<p class="social-login">
						<span class="social-login-facebook"><a href="#"
							onclick="signinProvider('facebook');"><i
								class="fa fa-facebook"></i> Facebook</a></span> <span
							class="social-login-google"><a href="#"
							onclick="signinProvider('google');"><i class="fa fa-google"></i>
								Google</a></span> <span class="social-login-twitter"><a href="#"
							onclick="signinProvider('twitter');"><i class="fa fa-twitter"></i>
								Twitter</a></span>
					</p>

					<div class="lined-text">
						<span>새로운 이메일 계정 등록하기</span>
						<hr>
					</div>

					<p class="fieldset">
						<label class="image-replace cd-username" for="signup-username">Username</label>
						<input class="full-width has-padding has-border"
							id="signup-username" type="text" placeholder="Username" required>
						<span class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-email" for="signup-email">E-mail</label>
						<input class="full-width has-padding has-border" id="signup-email"
							type="email" placeholder="E-mail" required> <span
							class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signup-password">Password</label>
						<input class="full-width has-padding has-border"
							id="signup-password" type="password" placeholder="Password"
							required> <a href="javascript:void(0);"
							class="hide-password">Show</a> <span id="signup-email-error"
							class="cd-error-message">Error message here!</span>
					</p>

					<p class="fieldset">
						<input type="checkbox" id="accept-terms"> 
						<label for="accept-terms"> 본 사이트의 약관에 동의합니다. 
						<a href="page_terms.html">약관보기</a></label>
					</p>

					<p class="fieldset">
						<input id="signup-email-btn" class="full-width has-padding"
							type="button" value="회원 가입하기">
					</p>
				</form>

				<!-- <a href="javascript:void(0);" class="cd-close-form">Close</a> -->
			</div>
			<!-- cd-signup -->

			<div id="cd-reset-password">
				<!-- reset password form -->
				<p class="cd-form-message">이메일 주소를 입력해 주세요. 당신의 이메일로 비밀번호 초기화
					메일이 발송될것 입니다.</p>

				<form id="reset-email-form" class="cd-form">
					<p class="fieldset">
						<label class="image-replace cd-email" for="reset-email">E-mail</label>
						<input class="full-width has-padding has-border" id="reset-email"
							type="email" placeholder="E-mail"> <span
							id="reset-email-error" class="cd-error-message">오류발생!</span>
					</p>

					<p class="fieldset">
						<input id="reset-password-btn" class="full-width has-padding"
							type="button" value="비밀번호 초기화">
					</p>
				</form>

				<p class="cd-form-bottom-message">
					<a href="javascript:void(0);">로그인창으로</a>
				</p>
			</div>
			<!-- cd-reset-password -->
			<a href="javascript:void(0);" class="cd-close-form">Close</a>
		</div>
		<!-- cd-user-modal-container -->
	</div>
	<!-- cd-user-modal -->


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
	<script src="../../assets/plugins/login-signup-modal-window/js/main.js"></script>
	<!-- 모달 컨트롤 -->

	<!-- JS Customization -->
	<script type="text/javascript" src="../../assets/js/custom.js"></script>
	<!-- JS Page Level -->
	<script type="text/javascript" src="../../assets/js/app.js"></script>
	<script type="text/javascript"
		src="../../assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript"
		src="../../assets/js/plugins/style-switcher.js"></script>
	<script type="text/javascript"
		src="../../assets/js/plugins/parallax-slider.js"></script>
	<!-- xdomainajax 추가 -->
	<script type="text/javascript"
		src="../../assets/js/jquery.xdomainajax.js"></script>
	<script type="text/javascript"
		src="../../assets/js/sendRequest-ajax.js"></script>
		<script type="text/javascript" src="../../assets/js/xml2json.js"></script>
	<script type="text/javascript"
		src="../../assets/js/jquery-3.1.1.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
		jQuery(document).ready(function() {
			App.init();
			OwlCarousel.initOwlCarousel();
			StyleSwitcher.initStyleSwitcher();
			ParallaxSlider.initParallaxSlider();
			menuCreate();
		});
		
		$.ajax({
			type : "GET",
			url : "http://localhost:8081/menu/list",
			dataType : 'json',
			error : function(err) {
				alert("에러");
			},
			success : function(result) {
				// 				alert("성공");

				$("#start").empty();
				var html = "";
				for (var i = 0; i < result.length; i++) {
					var data = result[i];
					if (data.parentMenuNo == 0) {
						html += "<li class='dropdown' id="+ data.menuNo +">";
						html += "<a href='javascript:void(0);' class='dropdown-toggle' data-toggle='dropdown'>";
						html += data.title;
						html += "	</a>";
					}
				}

				// 삽입 부분
				html += "<li class='dropdown' id='mypage' style='display: none;'>";
				html += "		<a href='javascript:void(0);' class='dropdown-toggle' data-toggle='dropdown' id='mypageTitle'>";
				html += "			마이페이지";
				html += "		</a>";
				html += "<ul class='dropdown-menu'>";
				html += "		<li><a href='javascript:void(0);'><i class='fa fa-bell'></i> 알림</a></li>";
				html += "		<li><a href='javascript:void(0);'><i class='fa fa-envelope-square'></i> 쪽지</a></li>";
				html += "		<li><a href='javascript:void(0);'><i class='fa fa-calendar'></i> 여행일정</a></li>";
				html += "		<li><a href='http://localhost:8081/post/home;'><i class='fa fa-pencil'></i> 포스트</a></li>";
				html += "<li class='dropdown-submenu'>";
				html += "	<a href='javascript:void(0);''><i class='fa fa-cog'></i> 회원정보변경</a>";
				html += "	<ul class='dropdown-menu'>";
				html += "		<li><a href='http://localhost/rscamper-web/views/user/userModify.jsp'><i class='fa fa-user'></i> 프로필수정</a></li>";
				html += "		<li><a href='#'><i class='fa fa-lock'></i> 비밀번호변경</a></li>";
				html += "		<li><a href='#'><i class='fa fa-bell'></i> 알림설정</a></li>";
				html += "		<li><a href='#'><i class='fa fa-unlock'></i> 회원탈퇴</a></li>";
				html += "	</ul>";
				html += "</li>";
				html += "<li onclick='signout();'><a href='javascript:void(0);'><i class='fa fa-unlock'></i> 로그아웃</a></li>";
				html += "</ul>";
				html += "</li>";

				$("#start").html($("#start").html() + html);

				for (var i = 0; i < result.length; i++) {
					var data = result[i];
					console.log(data.url);
					if (data.parentMenuNo != 0) {
						if ($("#" + data.parentMenuNo).find("ul").length > 0) {
							$("#ul-" + data.parentMenuNo)
									.html(
											$(
													"#ul-"
															+ data.parentMenuNo)
													.html()
													+ "<li><a href='"+ data.URL +"'>"
													+ data.title
													+ "</a></li>");
						} else {
							$("#" + data.parentMenuNo)
									.html(
											$("#" + data.parentMenuNo)
													.html()
													+ "<ul class='dropdown-menu' id=ul-" + data.parentMenuNo + "><li><a href="+ data.URL +">"
													+ data.title
													+ "</a></li></ul>");
						}
					}
				}
			}
		});
// ex

function joinBtn() {
	var trainGradeCode = $("input[name=trainRadio]:checked").val();
	var depPlaceId = $("input[name=start]").val();
	var arrPlaceId = $("input[name=arrive]").val();
	var depPlandTime = $("input[name=calender]").val();
	var numOfRows = $("input[name=numofRows]").val();
	var pageNo = $("input[name=pageNo]").val();
	var startPage = $("input[name=startPage]").val();
	var pageSize = $("input[name=pageSize]").val();
	var depPlandTime = depPlandTime.split('-');
	var depPlandTime = depPlandTime[0] + depPlandTime[1]
			+ depPlandTime[2];

	console.log(trainGradeCode);

	var obj = new Object();
	obj.trainGradeCode = trainGradeCode;
	obj.depPlaceId = depPlaceId;
	obj.arrPlaceId = arrPlaceId;
	obj.depPlandTime = depPlandTime;
	obj.numOfRows = 999;
	obj.pageNo = 1;
	obj.startPage = 1;
	obj.pageSize = 999;

	console.dir(obj);

	$.ajax({
		url : "http://localhost:8081/trainTime/time",
		type : "GET",
		dataType : 'json',
		data : obj,
		err : function() {
			console.log(err);
		},
		success : function(data) {
			var data = JSON.parse(data);
			timeList(data);

// 	function joinBtn() {
// 		var trainGradeCodeIsTrue = false;
// 		var trainGradeCode = document.getElementsByName('trainRadio');
// 		var trainGradeCodeVal = "00";
// 		for (var i = 0; i < trainGradeCode.length; i++) {
// 			var t = trainGradeCode[i];

// 			if (t.checked == true) {
// 				console.log("ttttt");
// 				console.dir(t);
// 				trainGradeCodeIsTrue = true;
// 				trainGradeCodeVal = t.defaultValue; 
// 			}
// 		}
		}
	});
}


function timeList(data) {

	var item = data.response.body.items.item;
	var fail = data.response.body.items;
	var timeList = $("#timeList");
	var html = "";
	for (var i = 0; i < item.length; i++) {
		var t = item[i];
		
		html += "<tr>";
		html += "	<td>" + t.depplacename + "</td>";
		html += "	<td>" + t.depplandtime + "</td>";
		html += "	<td>" + t.arrplacename + "</td>";
		html += "	<td>" + t.arrplandtime + "</td>";
		html += "	<td>" + t.traingradename + "</td>";
		html += "</tr>";
	}
	$("tbody").html($("tbody").html() + html);
	//		timeList.html(html);
}

// 역별 조회
function ajaxList() {
		$.ajax({
				url : "http://localhost:8081/trainTime/trainTimeList",
				dataType : "json",
				type : "GET",
				success : function(result) {
					var trainSelect = "";
					var qwer = $("input[name=trainRadio]:checked").val();

					console.log(qwer);
					if (typeof qwer == "undefined") {
						alert("열차를 선택하여 주세요.");
						return false;
					}

					var trainVal = "";
					switch (qwer) { // 눌럿을때 value값을 넣기
					case "01":
						trainVal = "trainSaemaeul";
						break;
					case "02":
						trainVal = "trainMugunghwa";
						break;
					case "03":
						trainVal = "trainTonggeun";
						break;
					case "04":
						trainVal = "trainNuriro";
						break;
					case "09":
						trainVal = "trainItxchungchun";
						break;
					case "08":
						trainVal = "trainItxsaemaeul";
						break;
					}
					
					console.log("trainVal : ");	
					console.log(trainVal);	
					
					// 주요역
					var html = "";
					html += "<table width='90%' border='1' align='center' cellpadding='5' cellspacing='5' style='box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; max-width: 100%; color: rgb(0, 0, 0); font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif; font-size: 16px; line-height: 32px; border: 1px solid grey;'>";
					console.log(result.length);
					for (var i = 0; i < result.length; i++) {
						var data = result[i];

						if (data.stationVital > 0) {
							if (i % 5 == 0) {
								html += "<tr>";
							}
							
						switch (trainVal) { // 눌럿을때 value값을 넣기
						// 새마을
						case "trainSaemaeul":
							console.log("case : trainSaemaeul");
							if (data.trainSaemaeul > 0) {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// 무궁화	
						case "trainMugunghwa":
							console.log("case : trainMugunghwa");
							if (data.trainMugunghwa > 0) {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// 통근	
						case "trainTonggeun":
							console.log("case : trainTonggeun");
							if (data.trainTonggeun > 0) {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a align='center'></td>";
							} else {
								html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// 누리로	
						case "trainNuriro":
							console.log("case : trainNuriro");
							if (data.trainNuriro > 0) {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break; 
						//	itx청춘
						case "trainItxchungchun":
							console.log("case : trainItxchungchun");
							if (data.trainItxchungchun > 0) {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// itx새마을	
						case "trainItxsaemaeul":
							console.log("case : trainItxsaemaeul");
							if (data.trainItxsaemaeul > 0) {
								html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						}
							//							html += "<td>" + data.stationTitle + "</td>";
							if (i % 5 == 4) {
								html += "</tr>";
							}
						}
					}
					html += "</table>";
					$(".modal-body").html(html);

					html = "<div id='sort'>";
					html = "<ul style='overflow: hidden; height:25px; padding:8px 0 0 5px; margin-bottom: 20px; border: 1px solid skyblue; list-style: none;'>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄱ\")'>가</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄴ\")'>나</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄷ\")'>다</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄹ\")'>라</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅁ\")'>마</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅂ\")'>바</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅅ\")'>사</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅇ\")'>아</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅈ\")'>자</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅊ\")'>차</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅋ\")'>카</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅌ\")'>타</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅍ\")'>파</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅎ\")'>하</div></li>";
					html += "</ul>";
					html += "</div>";

					// 철도역
					html += "<table width='90%' border='1' align='center' cellpadding='5' cellspacing='5' style='box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; max-width: 100%; color: rgb(0, 0, 0); font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif; font-size: 16px; line-height: 32px; border: 1px solid grey;'>";
					console.log(result)

					var trainVal = "";
					switch (qwer) { // 눌럿을때 value값을 넣기
					case "01":
						trainVal = "trainSaemaeul";
						break;
					case "02":
						trainVal = "trainMugunghwa";
						break;
					case "03":
						trainVal = "trainTonggeun";
						break;
					case "04":
						trainVal = "trainNuriro";
						break;
					case "09":
						trainVal = "trainItxchungchun";
						break;
					case "08":
						trainVal = "trainItxsaemaeul";
						break;
					}
					
					for (var j = 0; j < result.length; j++) {
						var data = result[j];
						if (data.stationVital == 0) {
							//	console.log(data.stationTitle); 들어왓고

							if ((j - 1) % 5 == 0) {
								html += "<tr>";
							}
							
							switch (trainVal) { // 눌럿을때 value값을 넣기
							// 새마을
							case "trainSaemaeul":
								console.log("case : trainSaemaeul");
								if (data.trainSaemaeul > 0) {
									html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#1' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center'><p href='#1' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// 무궁화	
							case "trainMugunghwa":
								console.log("case : trainMugunghwa");
								if (data.trainMugunghwa > 0) {
									html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// 통근	
							case "trainTonggeun":
								console.log("case : trainTonggeun");
								if (data.trainTonggeun > 0) {
									html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// 누리로	
							case "trainNuriro":
								console.log("case : trainNuriro");
								if (data.trainNuriro > 0) {
									html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break; 
							//	itx청춘
							case "trainItxchungchun":
								console.log("case : trainItxchungchun");
								if (data.trainItxchungchun > 0) {
									html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// itx새마을	
							case "trainItxsaemaeul":
								console.log("case : trainItxsaemaeul");
								if (data.trainItxsaemaeul > 0) {
									html += "<td align='center' style='background: #df598e;'><a style='color: white' href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center'><p href='#' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							}

							if (j % 5 == 0) {
								html += "</tr>";
							}
						}
					}
					html += "</table>";
					$(".modal-footer").html(html);

					$('#trainModal').modal('show');
			},
			err : function() {
				alert("오류");
		}
	});

}

function ajaxSort(data) {
	console.log(data);
	
	var obj = new Object();
	obj.data = data;
//		obj.trainSaemaeul = trainSaemaeul;
//		obj.trainMugunghwa = trainMugunghwa;
//		obj.trainTonggeun = trainTonggeun;
//		obj.trainNuriro = trainNuriro;
//		obj.trainItxchungchun = trainItxchungchun;
//		obj.trainItxsaemaeul = trainItxsaemaeul;
	$.ajax({
		url : "http://localhost:8081/trainTime/trainSearch",
		dataType : "json",
		type : "GET",
		data : obj,
		success : function(result) {
//				console.log(result);
//				var qwer = $("input[name=trainRadio]:checked").val();
//				var html = "";
//				html += "<table>";
//				console.log(result)

//				var trainVal = "";
//				switch (qwer) { // 눌럿을때 value값을 넣기
//				case "01":
//					trainVal = "trainSaemaeul";
//					break;
//				case "02":
//					trainVal = "trainMugunghwa";
//					break;
//				case "03":
//					trainVal = "trainTonggeun";
//					break;
//				case "04":
//					trainVal = "trainNuriro";
//					break;
//				case "09":
//					trainVal = "trainItxchungchun";
//					break;
//				case "08":
//					trainVal = "trainItxsaemaeul";
//					break;
//				}
			
//				html = "<div id='sort'>";
//				html = "<ul style='overflow: hidden; height:25px; padding:8px 0 0 5px; margin-bottom: 20px; border: 1px solid tomato; list-style: none;'>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄱ\")'>가</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄴ\")'>나</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄷ\")'>다</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄹ\")'>라</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅁ\")'>마</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅂ\")'>바</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅅ\")'>사</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅇ\")'>아</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅈ\")'>자</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅊ\")'>차</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅋ\")'>카</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅌ\")'>타</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅍ\")'>파</div></li>";
//				html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅎ\")'>하</div></li>";
//				html += "</ul>";
//				html += "</div>";
			
//				for (var j = 0; j < result.length; j++) {
//					var data = result[j];
					
//						if (j % 5 == 0) {
//							html += "<tr>";
//						}
					
//						switch (trainVal) { // 눌럿을때 value값을 넣기
//						// 새마을
//						case "trainSaemaeul":
//								console.log("case : trainSaemaeul");
//								html += "<td><a href='#1' onClick='stationFn(this)'>"
//										+ data.stationTitle
//										+ "</a></td>";
//							break;
						
//						// 무궁화	
//						case "trainMugunghwa":
//								console.log("case : trainMugunghwa");
//								html += "<td><a href='#' onClick='stationFn(this)'>"
//										+ data.stationTitle
//										+ "</a></td>";
//							break;
						
//						// 통근	
//						case "trainTonggeun":
//								console.log("case : trainTonggeun");
//								html += "<td><a href='#' onClick='stationFn(this)'>"
//										+ data.stationTitle
//										+ "</a></td>";
//							break;
						
//						// 누리로	
//						case "trainNuriro":
//								console.log("case : trainNuriro");
//								html += "<td><a href='#' onClick='stationFn(this)'>"
//										+ data.stationTitle
//										+ "</a></td>";
//							break; 
						
//						//	itx청춘
//						case "trainItxchungchun":
//								console.log("case : trainItxchungchun");
//								html += "<td><a href='#' onClick='stationFn(this)'>"
//										+ data.stationTitle
//										+ "</a></td>";
						
//							break;
						
//						// itx새마을	
//						case "trainItxsaemaeul":
//								console.log("case : trainItxsaemaeul");
//								html += "<td><a href='#' onClick='stationFn(this)'>"
//										+ data.stationTitle
//										+ "</a></td>";
//							break;
//						}

//						if (j % 5 == 0) {
//							html += "</tr>";
//						}
//					}
//				html += "</table>";
//				$(".modal-footer").html(html);

					
			var html = "";
					
			html = "<div id='sort'>";
			html = "<ul style='overflow: hidden; height:25px; padding:8px 0 0 5px; margin-bottom: 20px; border: 1px solid tomato; list-style: none;'>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄱ\")'>가</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄴ\")'>나</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄷ\")'>다</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㄹ\")'>라</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅁ\")'>마</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅂ\")'>바</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅅ\")'>사</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅇ\")'>아</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅈ\")'>자</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅊ\")'>차</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅋ\")'>카</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅌ\")'>타</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅍ\")'>파</div></li>";
			html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><div id='sorta' onclick = 'ajaxSort(\"ㅎ\")'>하</div></li>";
			html += "</ul>";
			html += "</div>";
					
					
					html += "<table>";
					console.log(result)
					var trainSelect = "";

					for (var j = 0; j < result.length; j++) {
						var data = result[j];

							if (j % 5 == 0) {
								html += "<tr>";
							}
							
							html += "<td><a href='#1' onclick='stationFn(this)'>"
									+ data.stationTitle + "</a></td>";

							if (j % 5 == 0) {
								html += "</tr>";
							}
						}
					
					html += "</table>";
					$(".modal-footer").html(html);
				
			
	},
	err : function() {
		alert("오류");
}
});
}



// 역별 조회(예전꺼)	
// 	$.ajax({
// 				url : "http://localhost:8081/trainTime/trainTimeList",
// 				dataType : "json",
// 				type : "GET",
// 				success : function(result) {
// 					var html = "";

// 					// 주요역
// 					html += "<table>";
// 					for (var i = 0; i < result.length; i++) {
// 						var data = result[i];
// 					//	console.log(data.trainSaemaeul);

// 						if (data.stationVital > 0) {
// 							if (i % 5 == 0) {
// 								html += "<tr>";
// 								//							console.log(data.stationTitle);
// 							}
// 							if(data.trainSaemaeul > 0){

// 							html += "<td><a href='#' onClick='stationFn(this)'>"
// 									+ data.stationTitle + "</a></td>";
// 							} else {
// 							html += "<td><p href='#' onClick='stationFn(this)'>"
// 									+ data.stationTitle + "</p></td>";
// 							}

// 							//							html += "<td>" + data.stationTitle + "</td>";
// 							if (i % 5 == 4) {
// 								html += "</tr>";
// 							}
// 						}
// 					}
// 					html += "</table>";
// 					$(".modal-body").html(html);

// 					html = "<div id='sort'>";
// 					html = "<ul style='overflow: hidden; height:25px; padding:8px 0 0 5px; margin-bottom: 20px; border: 1px solid tomato; list-style: none;'>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>가</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>나</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>다</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>라</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>마</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>바</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>사</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>아</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>자</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>차</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>카</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>타</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>파</a></li>";
// 					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%;'><a href='#'>하</a></li>";
// 					html += "</ul>";
// 					html += "</div>";

// 					// 철도역
// 					html += "<table>";
// 					console.log(result)
// 					var trainSelect = "";

// 					for (var j = 0; j < result.length; j++) {
// 						var data = result[j];
// 						if (data.stationVital == 0) {
// 						//	console.log(data.stationTitle); 들어왓고

// 							if ((j - 1) % 5 == 0) {
// 								html += "<tr>";
// 							}
// 							
// 							html += "<td><a href='#1' class=\"abcde\" data-a=\"1\" data-b=\"2\" onClick='stationFn(this)'>"
// 									+ data.stationTitle + "</a></td>";

// 							if (j % 5 == 0) {
// 								html += "</tr>";
// 							}
// 						}
// 					}
// 					html += "</table>";
// 					$(".modal-footer").html(html);
// 				},
// 				err : function() {
// 					alert("오류");
// 				}
// 			});

//	   ------ input창에 text넣기 -------

var result = true;

function startBtn() {
	ajaxList();
	// 		$('#trainModal').modal('show');
};
function arriveBtn() {
	$('#trainModal').modal('show');
	result = false;
};

function stationFn(e) {
	//			alert(e.text);
	if (result) {
		$('#startInput').val(e.text);
	} else {
		$('#arriveInput').val(e.text);
	}
	$("#trainModal").modal('hide');

}


	</script>

	<!--[if lt IE 9]>
    <script src="assets/plugins/respond.js"></script>
    <script src="assets/plugins/html5shiv.js"></script>
    <script src="assets/plugins/placeholder-IE-fixes.js"></script>
    <![endif]-->

	<!-- firebase 로그인 -->
	<script src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script src="../../resources/js/firebaseInit.js"></script>
	<script src="../../resources/js/firebaseAuth.js"></script>
	<script src="../../resources/js/menu.js"></script>
	<script src="../../resources/js/tour.js"></script>
</body>
</html>
