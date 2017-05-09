<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<head>
<title>일정만들기</title>

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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/brand-buttons/brand-buttons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/brand-buttons/brand-buttons-inversed.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/sky-forms-pro/skyforms/custom/custom-sky-forms.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/pages/shortcode_timeline2.css">

<!-- CSS Theme -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-colors/default.css" id="style_color">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/theme-skins/dark.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">

<!-- NV D3 -->
<link rel='stylesheet' href="${pageContext.request.contextPath}/resources/plugins/novus-nvd3-v1.8.5/build/nv.d3.min.css" />

<!-- Full Calendar -->
<link rel='stylesheet' href="${pageContext.request.contextPath}/resources/plugins/fullcalendar-3.0.1/fullcalendar.css" />

<!-- Sweet Alert -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.css">    

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="makeplan.css">

</head>

<body class="header-fixed header-fixed-space-default" ng-app="TourPlanApp" ng-controller="MakePlanController">
	<div class="wrapper">

		<!-- 헤더 include -->
		<%@include file="/resources/include/header.jsp"%>

		<!--=== 사이트맵 ===-->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="pull-left breadcrumb">
					<li><a href="${pageContext.request.contextPath}/views/main.jsp"><i class="fa fa-home"></i></a></li>
					<li class="active"><a href="makeplan.jsp">일정만들기</a></li>
				</ul>
			</div>
		</div>
		<!--=== 사이트맵 끝 ===-->
		
		<!-- 일정 만들기 헤더 include -->
		<%@include file="include/planHeader.jsp"%>

		<!--=== 내용 ===-->
		<div id="writeTourPlan">
			
			<!-- 배경사진 업로드 모달 -->
			<%@include file="include/BGUploadFormModal.jsp"%>
			
			<!-- 여행장소 디테일 모달 -->
			<%@include file="include/detailTourSpotModal.jsp"%>
			
			<!-- 스토리 여행기 글쓰기 모달 -->
			<div class="modal fade bs-example-modal-lg" id="writeTourSpotMemoFormModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="top: 50px;">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<select ng-model="writeTourSpotMemoData.memoType" style="height: 30px;" ng-options="memoType.memoNo as memoType.memoName for memoType in memoTypes">
            					<option value=""></option>
          					</select>
							<input type="text" ng-model="writeTourSpotMemoData.title" style="width: 800px; height: 30px;" />
						</div>

						<div class="modal-body">
							<textarea id="smarteditor" rows="10" cols="100" style="width: 850px; height: 412px;"></textarea>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
							<button type="button" class="btn btn-primary" ng-click="writeTourSpotMemo();">글쓰기</button>
						</div> 
					</div>
				</div>
			</div>
			
			<!-- 예산창 보기 모달 -->
			<div class="modal fade bs-example-modal-lg" id="tourPlanBudgetModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="top: 50px;">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h5 class="modal-title">여행 예산</h5>
						</div>

						<div class="modal-body">
							<div class="select-style" style="float:left; margin: 10px;">
								<select ng-model="chartParam.type" ng-change="selectChart();">
									<option value="1" selected>일차별</option>
									<option value="2">지출종류별</option>
									<option value="3">지출장소별</option>
								</select>
							</div>
							<div class="select-style" style="float:left; margin: 10px;">
								<select ng-model="chartParam.chart" ng-change="selectChart();">
									<option value="1" selected>원형차트</option>
									<option value="2">막대차트</option>
								</select>
							</div>
							<svg id="chart" style="height: 400px;"></svg>
						</div>
					</div>
				</div>
			</div>
			
			
			<div id="leftMenu">
			
				<!-- 저장 / 취소 -->
				<div id="controllers">
					<div class="bg-light">
						<button id="saveBtn" class="btn rounded btn-evernote-inversed" style="width: 49%;" ng-click="saveTourPlan();">
							<i class="fa fa-floppy-o"></i> 저장하기
						</button>
						<button class="btn rounded btn-evernote" style="width: 49%;" ng-click="cancelTourPlan();">
							<i class="fa fa-times"></i> 취소
						</button>
					</div>
				</div>
				
				<!-- 일정 정보 -->
				<div id="status" style="font-size: 14px;">
					<ul class="list-group sidebar-nav-v1" >
						<li id="notification_menu" class="list-group-item">
							<span class="badge" style="background: white; color: gray; font-size: 12px;">곳</span>
							<span class="badge badge-u rounded" style="font-size: 12px;" ng-bind="allTourSpotEvent.length"></span>
							<a href="javascript:void(0);"><i class="fa fa-map-marker"></i> 관광지</a>
						</li>
						<li id="notification_menu" class="list-group-item">
							<span class="badge" style="background: white; color: gray; font-size: 12px;">개</span>
							<span class="badge badge-u rounded" style="font-size: 12px;" ng-bind="tourSpotMemoList.length"></span>
							<a href="javascript:void(0);"><i class="fa fa-book"></i> 여행기</a>
						</li>
						<li id="notification_menu" class="list-group-item">
							<span class="badge" style="background: white; color: gray; font-size: 12px;">원</span>
							<span class="badge badge-u rounded" style="font-size: 12px;" ng-bind="totalBudget | currency : '' : 0"></span>
							<a href="javascript:void(0);" ng-click="openTourPlanBudget();"><i class="fa fa-money"></i> 여행 예산</a>
						</li>
					</ul>
				</div>
				
				<!-- 일정 클릭시 나오는 장소 탭  -->
				<div id="attractionTab" ng-show="isPlanAndMap">
					
					<div class="tab-v2">
					
						<!-- 탭 버튼 -->
						<ul class="nav nav-tabs">
							<li class="active" style="width:50%; text-align: center;">
								<a href="#searchTab" data-toggle="tab"><span class="fa fa-search"></span> 검색</a>
							</li>
							<li style="width:50%; text-align: center;">
								<a href="#bookmarkTab" data-toggle="tab"><span class="fa fa-bookmark-o"></span> 북마크</a>
							</li>
						</ul>
						
						<!-- 탭 내용 -->
						<div class="tab-content">
						
							<!-- 검색 -->						
							<div class="tab-pane fade in active" id="searchTab">
								
								<!-- 검색창 제어 -->
								<div id="searchHeader">
									<!-- 검색 -->
									<div class="bg-light" style="text-align: center;">
										<!-- 검색 텍스트 -->
										<input type="text" id="searchText" class="form-control margin-bottom-10" placeholder="검색할 장소명, 주소" ng-model="searchWord">
										<!-- 검색 카테고리 -->
										<div class="btn-group" data-toggle="buttons" style="width:100%;">
										  <label class="btn rounded btn-tumblr" style="width:22%; margin: 3px;" ng-click="initSpotList('all')">
										    <input type="radio">
										    <i class="fa fa-bars"></i>
										  </label>
										  <label class="btn rounded btn-amazon" style="width:22%; margin: 3px;" ng-click="initSpotList('tour')">
										    <input type="radio">
										    <i class="fa fa-binoculars"></i>
										  </label>
										  <label class="btn rounded btn-twitter" style="width:22%; margin: 3px;" ng-click="initSpotList('rest')">
										    <input type="radio">
										    <i class="fa fa-cutlery"></i>
										  </label>
										  <label class="btn rounded btn-evernote" style="width:22%; margin: 3px;" ng-click="initSpotList('bed')">
										    <input type="radio">
										    <i class="fa fa-bed"></i>
										  </label>
										</div>
									</div>
								</div>
								
								<div id="searchResult">
									<p>검색 결과</p>
								</div>
								
								<!-- 검색창 결과물 -->
								<div id="searchContent">
									<!-- 결과 카드 반복 -->
									<div class="tourSpot" ng-repeat="tourSpot in tourSpotList" ng-click="openDetailTourSpot(tourSpot);" on-finish-render="ngRepeatFinished"  ng-if="tourSpot.firstimage2.length > 0">
										<!-- 전송용 데이터 -->
										<div id="tourSpotData" ng-hide="true">
											<b ng-bind="tourSpot.contentid"></b>
											<b ng-bind="tourSpot.contenttypeid"></b>
											<b ng-bind="tourSpot.title"></b>
											<b ng-bind="tourSpot.mapx"></b>
											<b ng-bind="tourSpot.mapy"></b>
											<b ng-bind="tourSpot.firstimage"></b>
											<b ng-bind="tourSpot.contenttypeid | tourSpotColor"></b>
											<b ng-bind="tourSpot.contenttypeid | tourSpotCategory"></b>
											<b ng-bind="tourSpot.overview"></b>
										</div>
										<div class="tourSpotImageDiv">
											<img class="tourSpotImage" draggable="false" src="{{tourSpot.firstimage2}}">
										</div>
										<div class="tourSpotContent" >
											<b ng-bind="tourSpot.contenttypeid | tourSpotCategory"></b>
											<b ng-bind="tourSpot.areaname" style="float:right; color: #3b3b3b;"></b>
											<b ng-bind="tourSpot.title" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;"></b>
											<b ng-bind="tourSpot.overview" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;"></b>
											<button class="btn rounded btn-evernote" style="width: 40%; float:right; margin-top: 1px; padding: 0px; height:20px;"> <i class="fa fa-file-text-o" style="font-size:10px;"></i></button>
										</div>
									</div>
								</div>
								
							</div><!-- 검색 끝 -->
							
							
							<!-- 북마크 -->
							<div class="tab-pane fade in" id="bookmarkTab">
								<!-- 검색창 제어 -->
								<div id="searchHeader">
									<!-- 검색 -->
									<div class="bg-light" style="text-align: center;">
										<!-- 검색 텍스트 -->
										<input type="text" id="bookmarkSearchText" class="form-control margin-bottom-10" placeholder="검색할 장소명, 주소" ng-model="bookmarkSearchWord">
										<!-- 검색 카테고리 -->
										<div class="btn-group" data-toggle="buttons" style="width:100%;">
										  <label class="btn rounded btn-tumblr" style="width:22%; margin: 3px;" ng-click="initBookmarkSpotList('all')">
										    <input type="radio">
										    <i class="fa fa-bars"></i>
										  </label>
										  <label class="btn rounded btn-amazon" style="width:22%; margin: 3px;" ng-click="initBookmarkSpotList('tour')">
										    <input type="radio">
										    <i class="fa fa-binoculars"></i>
										  </label>
										  <label class="btn rounded btn-twitter" style="width:22%; margin: 3px;" ng-click="initBookmarkSpotList('rest')">
										    <input type="radio">
										    <i class="fa fa-cutlery"></i>
										  </label>
										  <label class="btn rounded btn-evernote" style="width:22%; margin: 3px;" ng-click="initBookmarkSpotList('bed')">
										    <input type="radio">
										    <i class="fa fa-bed"></i>
										  </label>
										</div>
									</div>
								</div>
								
								<div id="searchResult">
									<p>검색 결과</p>
								</div>
								
								<!-- 검색창 결과물 -->
								<div id="bookmarkContent">
									<!-- 결과 카드 반복 -->
									<div class="tourSpot" ng-repeat="bookmarkTourSpot in tourBookmarkSpotList" ng-click="openDetailTourSpot(bookmarkTourSpot);" on-finish-render="ngRepeatFinished">
										<!-- 전송용 데이터 -->
										<div id="tourSpotData" ng-hide="true">
											<b ng-bind="bookmarkTourSpot.contentid"></b>
											<b ng-bind="bookmarkTourSpot.contenttypeid"></b>
											<b ng-bind="bookmarkTourSpot.title"></b>
											<b ng-bind="bookmarkTourSpot.mapx"></b>
											<b ng-bind="bookmarkTourSpot.mapy"></b>
											<b ng-bind="bookmarkTourSpot.firstimage"></b>
											<b ng-bind="bookmarkTourSpot.contenttypeid | tourSpotColor"></b>
											<b ng-bind="bookmarkTourSpot.contenttypeid | tourSpotCategory"></b>
											<b ng-bind="bookmarkTourSpot.overview"></b>
										</div>
										<div class="tourSpotImageDiv">
											<img class="tourSpotImage" draggable="false" src="{{bookmarkTourSpot.firstimage2}}">
										</div>
										<div class="tourSpotContent" >
											<b ng-bind="bookmarkTourSpot.contenttypeid | tourSpotCategory"></b>
											<b ng-bind="bookmarkTourSpot.areaname" style="float:right; color: #3b3b3b;"></b>
											<b ng-bind="bookmarkTourSpot.title" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;"></b>
											<b ng-bind="bookmarkTourSpot.overview" style="white-space: nowrap; text-overflow: ellipsis; overflow: hidden; display: block;"></b>
											<button class="btn rounded btn-evernote" style="width: 40%; float:right; margin-top: 5px; padding: 0px;"> <i class="fa fa-file-text-o"></i></button>
										</div>
									</div>
								</div>
							
							</div><!-- 북마크 끝 -->
							
						</div><!-- 탭 내용 끝 -->
						
					</div><!-- 탭버전2 끝 -->
				
				</div><!-- 탭 전체 끝 -->
				
			</div><!-- left Menu 끝  -->
			
			
			<div id="rightContents">
			
				<!-- 콘텐츠 헤더 -->
				<div id="contentHeader">
					<form class="sky-form">
						<fieldset>
							<section>
								<label class="input"> 
									<i class="icon-prepend fa fa-pencil-square-o"></i>
									<input type="text" placeholder="소제목을 입력해 주세요" ng-model="tourPlan.strapline">
								</label>
							</section>
							<section>
								<label class="textarea">
									<textarea rows="5" placeholder="일정에 대한 간략한 소개글을 입력해 주세요" ng-model="tourPlan.introduce"></textarea>
								</label>
							</section>
							<section>
								<div class="row">
									<section class="col col-5">
										<label class="label" style="margin-bottom: 0px;"><strong>여행시작일</strong></label>
										<label class="input" style="margin-bottom: 0px;">
											<i class="icon-prepend fa fa-calendar"></i>
											<input id="departureDate" type="date" ng-model="tourPlan.departureDate">
										</label>
									</section>
									<section class="col col-5">
										<label class="label" style="margin-bottom: 0px;"><strong>여행종료일</strong></label>
										<label class="input" style="margin-bottom: 0px;">
											<i class="icon-prepend fa fa-calendar"></i>
											<input id="arriveDate" type="date" ng-model="tourPlan.arriveDate">
										</label>
									</section>
									<section class="col col-2">
										<label class="label" style="margin-bottom: 0px;"><strong>여행기간</strong></label>
										<label class="input" style="margin-bottom: 0px;">
											<input type="text" ng-model="tourPlan.period" readonly>
										</label>
									</section>
								</div>
							</section>
						</fieldset>
					</form>
				</div>
				
				<!-- 콘텐츠 탭 -->
				<div id="contentTab">
					<div class="tab-v2">
					
						<!-- 탭 버튼 -->
						<ul class="nav nav-tabs">
							<li class="active" style="width:50%; text-align: center; font-size: 16px;">
								<a href="#tourPlanTab" data-toggle="tab"  ng-click="showTourSpotList();"><span class="fa fa-map-o"></span> 일정/맵</a>
							</li>
							<li style="width:50%; text-align: center; font-size: 16px;">
								<a href="#tourStoryTab" data-toggle="tab"  ng-click="hideTourSpotList();"><span class="fa fa-book"></span> 스토리</a>
							</li>
						</ul>
						
						<!-- 탭 내용 -->
						<div class="tab-content">
						
							<!-- 일정/맵 -->						
							<div class="tab-pane fade in active" id="tourPlanTab">
								
								<!-- 구글맵 -->
								<div id="map" style="height: 400px;"></div>
								
								<!-- Full Calendar -->
								<div id="calendar">
								</div>
								
							</div><!-- 일정/맵 끝 -->
							
							
							<!-- 스토리 -->
							<div class="tab-pane fade in" id="tourStoryTab">
							
								<ul class="timeline-v2">
									
									<li class="equal-height-columns" ng-repeat="tourSpotEvent in allTourSpotEvent" ng-init="tourSpotEventIndex = $index">
										<div class="cbp_tmtime equal-height-column">
											<span>{{tourSpotEvent.start | convertISO : 'YYYY-MM-DD HH:mm'}}</span>
											<span>DAY {{tourSpotEvent.tourDate}}</span>
										</div>
										
										<i class="cbp_tmicon rounded-x hidden-xs"></i>
										
										<div class="cbp_tmlabel equal-height-column" style="margin-bottom: 10px; padding: 5px;">
										
											<div class="panel-group acc-v1" id="accordion-{{$index}}">
											
												<div class="panel panel-default">
												
													<div class="panel-heading" style="position: relative;">
														<h4 class="panel-title">
															<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-{{$index}}" href="#collapse-{{$index}}" aria-expanded="false">
																<b ng-click="openDetailTourSpot(tourSpotEvent.contentId, tourSpotEvent.contentTypeId);">{{tourSpotEvent.title}}</b>
															</a>
														</h4>
														<div style="position: absolute; right: 20px; top: 7px;">
															<i class="fa fa-expand" style="right: 10px;"></i>
														</div>
													</div>
													
													<div id="collapse-{{$index}}" class="panel-collapse collapse" aria-expanded="false">
														<div class="panel-body">
															<div class="row">
																<div class="col-md-4">
																	<img class="img-responsive" src="{{tourSpotEvent.imageUrl}}" alt="{{tourSpotEvent.title}}" ng-show="tourSpotEvent.imageUrl">
																	<img class="img-responsive" src="${pageContext.request.contextPath}/resources/img/404/yaoming.png" alt="{{tourSpotEvent.title}}" ng-hide="tourSpotEvent.imageUrl">
																</div>
																<div class="col-md-8">
																	<p>카테고리 : {{tourSpotEvent.contentTypeId | tourSpotCategory }}</p>
																	<p>전화번호 : {{tourSpotEvent.tel}}</p>
																	<p>주소 : {{tourSpotEvent.addr1}}</p>
																	<pre style="display: flex; white-space: normal; word-break: break-word;" ng-bind-html="tourSpotEvent.overview"></pre>
																</div>
															</div>
														</div>
													</div>
													
												</div>
											</div>
										</div>
										
										<!-- 여행기 / 메모 -->
										<div style="margin-bottom: 10px;" class="cbp_tmlabel equal-height-column" ng-repeat="tourSpotMemo in tourSpotMemoList" ng-if="tourSpotMemo.locationNo == tourSpotEvent.locationNo">
											<div style="position:absolute; right: 50px; top: 20px; color: gray; font-weight: bold;">{{tourSpotMemo.regDate | timesince : 'kr'}} 작성</div>
											<div class="memo-deleteBtn" style="position: absolute; right: 20px; top:15px;">
												<a href="javascript:void(0);" ng-click="deleteTourSpotMemo(tourSpotMemo.scheduleMemoNo)"><i style="color:green; font-size:20px;" class="fa fa-times" aria-hidden="true"></i></a>
											</div>
											<h2 ng-if="tourSpotMemo.memoType == 1"><b style="color: green; font-size: 16px;">{{tourSpotMemo.memoType | memoTypeName}}</b> {{tourSpotMemo.title}}</h2>
											<h2 ng-if="tourSpotMemo.memoType == 2"><b style="color: #ff8000; font-size: 16px;">{{tourSpotMemo.memoType | memoTypeName}}</b> {{tourSpotMemo.title}}</h2>
											<pre id="memo-content" ng-bind-html="tourSpotMemo.content" style="border: none; white-space: pre-wrap">여행기 내용</pre>


											<!-- 예산 리스트 반복돌자 -->
											<div style="border-top: 1px solid #ddd; border-bottom: 1px solid #ddd; padding: 5px;" ng-repeat="tourPlanBudget in tourPlanBudgetList" ng-if="tourPlanBudget.scheduleMemoNo == tourSpotMemo.scheduleMemoNo">
												<p style="margin-bottom: 0px; font-size:16px; color:gray; font-weight:bold;">
													<i style="margin:0px; width:20px; height:20px; font-size:12px; line-height:20px;" class="icon-custom icon-sm rounded-x icon-color-orange fa fa-krw"></i>
													<span style="margin-left: 10px;" ng-bind="tourPlanBudget.priceType | budgetType"></span>
													<span style="margin-left: 10px;">|</span> 
													<span style="margin-left: 10px;" ng-bind="tourPlanBudget.content"></span>
													<span style="margin-left: 10px;">|</span> 
													<span style="margin-left: 10px;" ng-bind="tourPlanBudget.travelPrice | currency : '' : 0"></span><span>원</span>
													<a style="margin-left: 10px;" href="javascript:void(0);" ng-click="delTourPlanBudget(tourPlanBudget.travelPriceNo);"><i style="color:orange; font-size:20px;" class="fa fa-minus" aria-hidden="true"></i></a>
												</p>
											</div>

											
											<!-- 예산 입력 폼 -->
											<form id="sky-form4" class="sky-form" novalidate="novalidate">
												<div class="row" style="margin-right: 3px; margin-left: 3px;">
													<!-- 카테고리 -->
													<section class="col col-2" style="margin:0px; padding: 3px;">												
														<label class="select">
															<select ng-model="tourPlanBudgetData.priceType">
																<option value="1" selected>교통</option>
																<option value="2">음식</option>
																<option value="3">엑티비티</option>
																<option value="4">쇼핑</option>
																<option value="5">숙박</option>
																<option value="6">기타</option>
															</select>
															<i></i>
														</label>
													</section>
													<!-- 타이틀 -->
													<section class="col col-5" style="margin:0px; padding: 3px;">
														<label class="input">
															<i class="icon-prepend fa fa-suitcase"></i>
															<input type="text" placeholder="예)점심값" ng-model="tourPlanBudgetData.content">
														</label>
													</section>
													<!-- 금액 -->
													<section class="col col-4" style="margin:0px; padding: 3px;">
														<label class="input">
															<i class="icon-prepend fa fa-krw"></i>
															<input type="number" min="0" step="100" placeholder="금액" ng-model="tourPlanBudgetData.travelPrice">
														</label>
													</section>
													<!-- 입력버튼 -->
													<section class="col col-1" style="margin:0px; padding: 3px;">
														<button class="btn btn-block btn-android-inversed rounded" ng-click="writeTourPlanBudget(tourSpotMemo.scheduleMemoNo, tourPlanBudgetData, tourSpotEvent.contentId, tourSpotEvent.locationNo);">
															<i class="fa fa-check"></i>
														</button>
													</section>
												</div>
											</form>
										</div>
										
										<!-- 여행기 / 메모 작성버튼 -->
										<div class="row" ng-if="tourSpotEvent.locationNo">
											<button class="btn rounded btn-evernote-inversed" ng-click="openWriteTourSpotMemoFormModal(tourSpotEvent.locationNo, tourSpotEvent.contentId)" type="button" style="margin-left: 228px; margin-bottom: 20px;"><i class="fa fa-pencil-square-o"></i> {{tourSpotEvent.title}} 여행기 작성</button>
										</div>
										
									</li>
									
								</ul>
								
							</div><!-- 스토리 끝 -->
					
						</div>
						
					</div>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/fullcalendar-3.0.1/lib/jquery-ui.min.js"></script>
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
	
	<!-- D3 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.2/d3.min.js" charset="utf-8"></script>
	<!-- NVD3 -->
	<script src="${pageContext.request.contextPath}/resources/plugins/novus-nvd3-v1.8.5/build/nv.d3.min.js"></script>
	
	<!-- Full Calendar -->
	<script src="${pageContext.request.contextPath}/resources/plugins/fullcalendar-3.0.1/lib/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/plugins/fullcalendar-3.0.1/fullcalendar.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
	<!-- Sweet Alert -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/sweetalert/dist/sweetalert.min.js"></script>
	<!-- isLoading -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/isLoading/jquery.isloading.min.js"></script>
	<!-- 스마트에디터 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
	
	<!-- Googla Map API -->
 	<script src="//maps.googleapis.com/maps/api/js?key=AIzaSyDIb6fCe7x5lHU_GJozbyb2WjS293g6eY4"></script>
	
	<!-- 메뉴 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/menu.js"></script>
	
	<!-- INIT APP -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/initApp.js"></script>
	
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-sanitize.min.js"></script>
	<script type="text/javascript" src="js/ng-simple-upload.js"></script>
	<script type="text/javascript" src="js/tourPlanApp.js"></script><!-- 앵귤러 모듈 및 라우터 선언 -->
	<script type="text/javascript" src="js/tourPlanFilters.js"></script><!-- 앵귤러 사용자정의 필터 선언 -->
	<script type="text/javascript" src="js/tourPlanServices.js"></script><!-- 앵귤러 사용자정의 서비스 선언 -->
	<script type="text/javascript" src="js/tourPlanDirectives.js"></script><!-- 앵귤러 사용자정의 지시자 선언 -->
	<script type="text/javascript" src="makeplan.js"></script>
	
</body>
</html>
