<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.css">

<!--=== Header ===-->
<div class="header header-sticky">
	<div class="container">

		<!-- 알림 팝오버 -->
		<div class="last-noti-list mynotice dropdown-menu" role="menu"
			aria-labelledby="dLabel">
			<div class="noti-tri"></div>
			<h5 class="noti-title">알림</h5>
			<a id="nav-my-notice-confirm-all" class="noti-check-on">읽은 상태로 표시</a>
			<ul id="my-notice-list">
			</ul>
			<div class="see-all-notice">더 보기</div>
		</div>
		<!-- End 알림 팝오버 -->


		<!-- Logo -->
		<a class="logo"	href="${pageContext.request.contextPath}/views/main.jsp"> 
		<img src="${pageContext.request.contextPath}/resources/img/logo/catbuslogo.png" style="width: 70px; height: 40px;" alt="Logo">
		<img src="${pageContext.request.contextPath}/resources/img/logo/z.png" style="width: 70px; height: 40px;" alt="Logo">
		</a>
		<!-- End Logo -->

		<!-- Topbar -->
		<div class="topbar">
			<ul class="loginbar pull-right">
				<!-- 				<li style="margin-right: 20px; cursor: pointer;"><img src="/rscamper-web/resources/img/default/icon-new-bell.png"><span class="noti-count" style="color: #ff8000; line-height: 19px;">0</span></li> -->
				<li data-placement="bottom" data-toggle="popover"
					data-container="body" data-placement="left" data-html="true"
					style="margin-right: 20px; cursor: pointer;">
					<i class="fa fa-bell" style='color: #72c02c;'></i> 
					<span class="noti-count" style="color: #ff8000; line-height: 19px;">0</span></li>
				<li><a href="#"><i class="fa fa-info"></i> HELP</a></li>
				<li class="topbar-devider"></li>
				<li id="loginBtn" class="cd-log_reg"><a class="cd-signin"
					href="javascript:void(0);"> <i class="fa fa-lock"></i> Login
				</a></li>
				<li id="logoutBtn" style="display: none;"><a
					href="javascript:void(0);" onclick="logout();"> <i
						class="fa fa-unlock-alt"></i> Logout
				</a></li>
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
			</ul>
		</div>
		<!--/end container-->
	</div>
	<!--/navbar-collapse-->
</div>
<!--=== End Header ===-->

<%-- <script	src="${pageContext.request.contextPath}/resources/include/js/header.js"></script> --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/include/css/header.css">
<script type="text/javascript" src="https://cdn.socket.io/socket.io-1.4.5.js"></script>

