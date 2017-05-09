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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/js/jquery/css/ui-lightness/jquery.ui.all.css">


<style>
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

		<!-- 헤더 include -->
		<%@include file="/resources/include/header.jsp"%>

		<!--=== 사이트맵 ===-->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="breadcrumb pull-left">
					<li><a href="http://localhost:8081"><i class="fa fa-home"></i></a></li>
					<li><a href="javascript:history.back()">기차시간표</a></li>
					<li class="active">New</li>
				</ul>
			</div>
		</div>

		<!--=== 내용 ===-->
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
				출발역:<input type="text" class="form-control" id="startInput" name="start" placeholder="출발역선택"><button type="submit" class="btn btn-default" id="startButton" onclick="startBtn();">조회</button><br>
				도착역:<input type="text" class="form-control" id="arriveInput" name="arrive" placeholder="도착역선택"><button type="submit" class="btn btn-default" id="arriveButton"onclick="arriveBtn();">조회</button><br> 
				<input type="date" name="calender"> 
				<input type="hidden" name="numOfRows"> 
				<input type="hidden" name="pageNo"> 
				<input type="hidden" name="pageSize">
				<input type="hidden" name="startPage"> <input type="button" value="조회하기" onclick="joinBtn();" />
				
				<input type="text" id="test33" name="test33">
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
			<a>※ 본 정보는 한국철도공사의 사정에 따라 변경 될 수 있습니다. 최신정보 확인은 한국철도공사 홈페이지( http://letskorail.com ) 에서 확인하시기 바랍니다.</a>

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
	<script type="text/javascript">
	
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

			}
		});
	}


	function timeList(data) {

		var item = data.response.body.items.item;
		var fail = data.response.body.items;
		var timeList = $("#timeList");
		var html = "";
		
	//	var depplandtime = depplandtime("yyyy"+년+"MM"+월+"dd"+일+"hh"+시+"mm"+분+"ss"+초);
		for (var i = 0; i < item.length; i++) {
			var t = item[i];
			console.log(t);
			console.log(t.depplandtime);
//			2016120119 4 5 0 0
//			012345678910111213
			var dyear = t.depplandtime.toString().substring(0,4);
			var dmonth = t.depplandtime.toString().substring(4,6);
			var dday = t.depplandtime.toString().substring(6,8);
			var dhour = t.depplandtime.toString().substring(8,10);
			var dmin = t.depplandtime.toString().substring(10,12);
			var dsec = t.depplandtime.toString().substring(12,14);
			
			var ayear = t.arrplandtime.toString().substring(0,4);
			var amonth = t.arrplandtime.toString().substring(4,6);
			var aday = t.arrplandtime.toString().substring(6,8);
			var ahour = t.arrplandtime.toString().substring(8,10);
			var amin = t.arrplandtime.toString().substring(10,12);
			var asec = t.arrplandtime.toString().substring(12,14);
			
			html += "<tr>";
			html += "	<td>" + t.depplacename + "</td>";
			html += "	<td>" + dyear +"년"+dmonth +"월"+dday+"일"+dhour+"시"+dmin+"분"+dsec+"초"+ "</td>";
			html += "	<td>" + t.arrplacename + "</td>";
			html += "	<td>" + ayear +"년"+amonth +"월"+aday+"일"+ahour+"시"+amin+"분"+asec+"초"+ "</td>";
			html += "	<td>" + t.traingradename + "</td>";
			html += "</tr>";
		}
		console.log(t.depplandtime);
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
		
		$.ajax({
			url : "http://localhost:8081/trainTime/trainSearch",
			dataType : "json",
			type : "GET",
			data : obj,
			success : function(result) {
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
				
				var qwer = $("input[name=trainRadio]:checked").val();
				html += "<table width='90%' border='1' align='center' cellpadding='5' cellspacing='5' style='box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; max-width: 100%; color: rgb(0, 0, 0); font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif; font-size: 16px; line-height: 32px; border: 1px solid grey;'>";
				console.log("qwer 여기다 :");
				console.log(qwer);

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
					console.log(data);
					if ((j+1) % 4 == 0) {
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

					if ((j+1) % 4 == 0) {
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


//		   ------ input창에 text넣기 -------

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
	
	$(function() {
	    $("#test33").datepicker({dateFormat:"yy-mm-dd"});
	    console.log("달력");
	});
	
	</script>
	<!-- 필요한 js파일 -->
	<script src="assets/js/jquery/js/jquery-1.7.2.js"></script>
	<script src="assets/js/jquery/js/jquery.ui.core.js"></script>
	<script src="../jquery/js/jquery.ui.widget.js"></script>
	<script src="../jquery/js/jquery.ui.datepicker.js"></script>
<!-- 	<script type="text/javascript" -->
<!-- 		src="../../assets/js/jquery.xdomainajax.js"></script> -->
<!-- 	<script type="text/javascript" -->
<!-- 		src="../../assets/js/sendRequest-ajax.js"></script> -->
<!-- 	<script type="text/javascript" src="../../assets/js/xml2json.js"></script> -->
<!-- 	<script type="text/javascript" -->
<!-- 		src="../../assets/js/jquery-3.1.1.min.js"></script> -->
<!-- 	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script> -->
<!-- 	<script -->
<!-- 		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
</body>
</html>
