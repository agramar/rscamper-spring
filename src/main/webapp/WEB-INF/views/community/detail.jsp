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
<link rel="stylesheet" href="detail.css">

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
					<li class="active"><a href="#">Detail</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->

		<!--=== 내용 ===-->
		<div class="container" style="padding-top: 20px;" ng-app="CommunityApp" ng-controller="DetailController">
			<!-- 작성자 시간 기타등등 -->
			<div class="row">
				<img class="rounded-2x" src="{{board.photoUrl}}" style="width: 40px; height: 40px;">
				<span ng-bind="board.displayName" style="font-size: 14px; font-weight: bold;"></span>
				<span ng-bind="board.regDate | timesince : 'kr'" style="color:gray; float:right; font-size: 14px;"></span>
			</div>
			
			<!-- 카테고리 제목 -->
			<div class="row">
				<span id="board-category" ng-bind="board.categoryName"></span>
				<a id="board-title" href="javascript:void(0);" ng-bind="board.title"></a>
			</div>
			
			<!-- 내용 -->
			<div id="board-content" class="row" style="position: relative; padding-top: 40px;">
				<div id="board-content-btn" ng-if="board.userUid == user.userUid" style="position: absolute; top:10px; right: 10px;">
					<a href="javascript:void(0);" ng-click="modifyBoard(board.boardNo);"><i style="color:gray; font-size:24px; margin-right: 10px;" class="fa  fa-pencil-square-o"></i></a>
					<a href="javascript:void(0);" ng-click="removeBoard(board.boardNo);"><i style="color:gray; font-size:24px;" class="fa  fa-trash-o"></i></a>
				</div>
				<div ng-bind-html="board.content"></div>
			</div>
			
			<!-- 댓글 & 좋아요 -->
			<div class="author-info" style="padding-top: 15px;">
				<div class="spot-like-count" style="display: inline-block;">
					<a id="icon-plan-like" class="off" style="cursor: pointer;" ng-click="likeBoard(board.boardNo);" >
						<img src="https://www.wishbeen.co.kr/images/icon-plan-like-off.png" >
					</a>
						좋아요
						<span id="like-count" ng-bind="board.likeCnt"></span>
				</div>
				
				<div class="spot-like-count" style="display: inline-block;">
					<a id="icon-plan-bookmark" class="off" style="cursor: pointer;" ng-click="bookmarkBoard(board.boardNo);">
						<img src="https://www.wishbeen.co.kr/images/bg-btn-bookmark.png">
					</a>
					북마크
					<span id="bookmark-count" ng-bind="board.bookmarkCnt"></span>
				</div>
				
				<div class="spot-commont-count" style="display: inline-block;" ng-click="toggleComment();">
					<a class="show-comments-of-note" style="cursor: pointer;">
						<img src="https://www.wishbeen.co.kr/images/icon-comment-gry.png">
					</a>
					댓글
					<span id="comment-count" ng-bind="board.commentCnt"></span>
				</div>
			</div>
			
			<div class="plan-comment" ng-show="commentToggleStatus">
				<div class="spot-comment-content">
					<div class="comment-write">
						<div class="my-p" style="float: left;">
							<div class="my-p-img" >
								<div>
									<img src="{{user.photoUrl}}" style="width: 40px; height: 40px;">
								</div>
							</div>
						</div>
						
						<textarea ng-model="commentForm.content" class="form-control new-comment-textarea"	placeholder="댓글을 남겨주세요." style="width: 88%; height: 40px; float: left; margin-right: 3px; margin-left: 3px; resize:none;"></textarea>
						<div class="comment-edit-btns" style="right: 0;">
							<button class="btn btn-primary save-new-comment" ng-click="writeComment();" style="height: 40px; color: #ff8000; border: 1px solid #ff8000; background: #fff!important;">등록</button>
						</div>
					</div>
				</div>
				
				<div class="spot-comment-list">
					<ul class="comment-list">
					
						<li class="commentRoot" ng-repeat="comment in commentList | orderBy: 'regDate'">
							<div>
								<div class="profile-img">
									<a href="javascript:void(0);" class="user">
										<img class="" src="{{comment.photoUrl}}" style="width: 40px; height: 40px;">
									</a>
								</div>
								<div class="comment-contents">
									<div class="comment-info">
										<div class="name-date">
											<a href="javascript:void(0);" class="user">
												<span class="username" ng-bind="comment.displayName"></span>
											</a>
											<span class="update-date" ng-bind="comment.regDate | timesince : 'kr'"></span>
										</div>
									</div>
									
									<div class="comment-txt">
										<p class="comment-content-for-find" ng-bind="comment.content"></p>
									</div>
									
									<div class="comment-deleteBtn">
										<a ng-if="comment.userUid == user.userUid" href="javascript:void(0);" ng-click="deleteComment(comment.commentNo)" ><i style="color:red; font-size:20px;" class="fa fa-times" aria-hidden="true"></i></a>
									</div>
									
								</div>
							</div>
						</li>
						
					</ul>
				</div>
				
			</div>


			
			
						
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
	<script type="text/javascript" src="detail.js"></script>
	
</body>
</html>
