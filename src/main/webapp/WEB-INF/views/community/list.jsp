<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<title>커뮤니티</title>

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

<!-- Jquery Toast Plugin -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.css">

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
					<li class="active"><a href="${pageContext.request.contextPath}/views/community/list.jsp">Community</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->

		<!--=== 내용 ===-->
		<div class="container content profile" style="padding-top: 20px;" ng-app="CommunityApp" ng-controller="ListController">
		
			<!--============ 글쓰기 모달 ============-->
			<div class="modal fade bs-example-modal-lg" id="writeFormModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="top: 50px;">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<select ng-model="writeBoard.categoryNo" style="height: 30px;" ng-options="category.categoryNo as category.categoryName for category in categories">
            					<option value=""></option>
          					</select>
							<input type="text" ng-model="writeBoard.title" style="width: 800px; height: 30px;" />
						</div>

						<div class="modal-body">
							<textarea id="smarteditor" rows="10" cols="100" style="width: 850px; height: 412px;"></textarea>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" ng-click="write();">글쓰기</button>
						</div> 
					</div>
				</div>
			</div>


			<div class="row" style="margin-top: 30px;">
				<!-- 리스트 컨트롤러 -->
				<div id="leftNav" class="col-md-3 md-margin-bottom-40">
					<!-- 새글 쓰기 -->
					<div class="bg-light">
						<h4><i class="fa fa-pencil-square-o"></i>새글 포스트</h4>
						<button class="btn rounded btn-block btn-warning" ng-click="openWriteFormModal();">
							<i class="fa fa-pencil-square-o"></i> 새글 포스트 하기
						</button>
					</div>
					<!-- 검색 및 정렬 -->
					<div class="bg-light">
						<h4><i class="fa fa-keyboard-o"></i>검색어</h4>
						<input type="text" class="form-control margin-bottom-20" placeholder="검색어를 입력하세요" ng-model="searchParams.word">
						<h4><i class="fa fa-th-large"></i>정렬방식</h4>
						<select class="form-control margin-bottom-20" ng-options="order.orderValue as order.orderName for order in optionDatas.orderList" ng-model="searchParams.order"></select>
					</div>
					<!-- 메뉴 -->
					<ul class="list-group sidebar-nav-v1 margin-bottom-40" id="sidebar-nav-1">
						<li id="all_board" class="list-group-item" ng-click="addActiveCategoryMenu($event);">
							<a href="javascript:void(0);"><i class="fa fa-user"></i> 전체</a>
						</li>
						<li id="tour_board" class="list-group-item" ng-click="addActiveCategoryMenu($event);">
							<span class="badge badge-u rounded" ng-bind=""></span>
							<a href="javascript:void(0);"><i class="fa fa-bell"></i> 여행기</a>
						</li>
						<li id="free_board" class="list-group-item" ng-click="addActiveCategoryMenu($event);">
							<span class="badge badge-u rounded" ng-bind=""></span>
							<a href="javascript:void(0);"><i class="fa fa-envelope"></i> 자유게시판</a>
						</li>
						<li id="qna_board" class="list-group-item" ng-click="addActiveCategoryMenu($event);">
							<span class="badge badge-u rounded" ng-bind=""></span>
							<a href="javascript:void(0);"><i class="fa fa-calendar"></i> 질문과답변</a>
						</li>
						<li id="information_board" class="list-group-item" ng-click="addActiveCategoryMenu($event);">
							<span class="badge badge-u rounded" ng-bind=""></span>
							<a href="javascript:void(0);"><i class="fa fa-pencil"></i> 정보</a>
						</li>
						<li id="review_board" class="list-group-item" ng-click="addActiveCategoryMenu($event);">
							<span class="badge badge-u rounded" ng-bind=""></span>
							<a href="javascript:void(0);"><i class="fa fa-bookmark-o"></i> 리뷰</a>
						</li>
					</ul>
				</div>
				
				<!-- Content -->
				<div id="rightContent" class="col-md-9">
					<div class="row" ng-if="boardList.length > 0">
						<div class="board-wrapper col-md-12" ng-repeat="board in boardList | filter : searchParams.word | orderBy: searchParams.order">
							<div class="board-image-wrapper">
								<img class="board-image" src="http://lorempixel.com/218/180/city/{{$index}}" alt="">
							</div>
							
							<div class="board-info">
								
								<div class="board-header">
									<span class="board-category" ng-bind="board.categoryName"></span>
									<a href="${pageContext.request.contextPath}/views/community/detail.jsp?boardNo={{board.boardNo}}" class="board-title" ng-bind="board.title"></a>
								</div>
								
								<div class="board-deleteBtn">
									<a ng-if="board.userUid == user.userUid" href="javascript:void(0);" ng-click="deleteBoard(board.boardNo)" ><i style="color:red; font-size:20px;" class="fa fa-times" aria-hidden="true"></i></a>
								</div>
								
								<div class="board-content" ng-bind-html="board.content"></div>
								
								<div class="board-date" ng-bind="board.regDate | timesince : 'kr'"></div>
								
								<div class="board-writer"><strong ng-bind="board.displayName"></strong>님이 남긴 포스트입니다.</div>
								
								<div class="board-btn">
									<a href="javascript:void(0);" ng-click="likeBoard(board.boardNo, $index)"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> <b ng-bind="board.likeCnt"></b></a>
									<a href="javascript:void(0);" ng-click="bookmarkBoard(board.boardNo, $index)"><i class="fa fa-bookmark-o" aria-hidden="true"></i> <b ng-bind="board.bookmarkCnt"></b></a>
									<a href="${pageContext.request.contextPath}/views/community/detail.jsp?boardNo={{board.boardNo}}" ><i class="fa fa-commenting-o" aria-hidden="true"></i> <b ng-bind="board.commentCnt"></b></a>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row" ng-if="boardList.length == 0">
						<div class="board-wrapper col-md-12">
							<div style="margin: 0 auto;">
								<img style="height: 200px;" src="${pageContext.request.contextPath}/resources/img/404/yaoming.png">
								<span>게시물이 없습니다.</span>
							</div>
						</div>
					</div>
					
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
	<!-- JQuery Toast Plugin -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
	<!-- 스마트에디터 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	
	<!-- 메뉴 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/menu.js"></script>
	
	<!-- INIT APP -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/initApp.js"></script>
	
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="js/ng-simple-upload.js"></script>
	<script type="text/javascript" src="js/communityApp.js"></script>
	<script type="text/javascript" src="js/communityDirectives.js"></script>
	<script type="text/javascript" src="js/communityFilters.js"></script>
	<script type="text/javascript" src="js/communityServices.js"></script>
	<script type="text/javascript" src="list.js"></script>
	
</body>
</html>
