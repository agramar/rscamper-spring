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
<style>
#mapBtn {
   border: 1px solid #0a3c59;
   background: #3e779d;
   background: -webkit-gradient(linear, left top, left bottom, from(#95bfdb), to(#3e779d));
   background: -webkit-linear-gradient(top, #95bfdb, #3e779d);
   background: -moz-linear-gradient(top, #95bfdb, #3e779d);
   background: -ms-linear-gradient(top, #95bfdb, #3e779d);
   background: -o-linear-gradient(top, #95bfdb, #3e779d);
   background-image: -ms-linear-gradient(top, #95bfdb 0%, #3e779d 100%);
   padding: 6.5px 13px;
   -webkit-border-radius: 6px;
   -moz-border-radius: 6px;
   border-radius: 6px;
   -webkit-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 0px 0;
   -moz-box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 0px 0;
   box-shadow: rgba(255,255,255,0.4) 0 0px 0, inset rgba(255,255,255,0.4) 0 0px 0;
   text-shadow: #7ea4bd 0 1px 0;
   color: #06426c;
   font-size: 16px;
   font-family: helvetica, serif;
   text-decoration: none;
   vertical-align: middle;
   }
#mapBtn:hover {
   border: 1px solid #0a3c59;
   text-shadow: #1e4158 0 1px 0;
   background: #3e779d;
   background: -webkit-gradient(linear, left top, left bottom, from(#9fc0d6), to(#3e779d));
   background: -webkit-linear-gradient(top, #9fc0d6, #3e779d);
   background: -moz-linear-gradient(top, #9fc0d6, #3e779d);
   background: -ms-linear-gradient(top, #9fc0d6, #3e779d);
   background: -o-linear-gradient(top, #9fc0d6, #3e779d);
   background-image: -ms-linear-gradient(top, #9fc0d6 0%, #3e779d 100%);
   color: #fff;
   }
#mapBtn:active {
   text-shadow: #1e4158 0 1px 0;
   border: 1px solid #0a3c59;
   background: #65a9d7;
   background: -webkit-gradient(linear, left top, left bottom, from(#3e779d), to(#3e779d));
   background: -webkit-linear-gradient(top, #3e779d, #65a9d7);
   background: -moz-linear-gradient(top, #3e779d, #65a9d7);
   background: -ms-linear-gradient(top, #3e779d, #65a9d7);
   background: -o-linear-gradient(top, #3e779d, #65a9d7);
   background-image: -ms-linear-gradient(top, #3e779d 0%, #65a9d7 100%);
   color: #fff;
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
					<li><a href="javascript:history.back()">노선도</a></li>
					<li class="active">New</li>
				</ul>
			</div>
		</div>

		<!--=== 내용 ===-->
		<!--=== Content ===-->
		<div class="container content-md">
			<div style="width: 100px; height: 800px; float: right;">
					<input type="button" id="mapBtn" value="경부선" data-val="1" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="경북선" data-val="2" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="경원선" data-val="3" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="경전선" data-val="4" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="경춘선" data-val="5" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="광주선" data-val="6" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="동해남부선" data-val="7" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="영동선" data-val="8" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="장항선" data-val="9" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="전라선" data-val="10" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="중앙선" data-val="11" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="충북선" data-val="12" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="태백선" data-val="13" onclick="trainLinBtn(this);"><br><br>
					<input type="button" id="mapBtn" value="호남선" data-val="14" onclick="trainLinBtn(this);"><br><br>
		
			</div>
			
			<div id="map" style="width: 1000px; height: 800px;"></div>
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
		// 화면에 맵나타나고
			var map;
			function initMap() {
					map = new google.maps.Map(document.getElementById('map'), {
						center : {lat: 37.6, lng: 127.9},
						zoom: 8
//						mapTypeId: google.maps.MapTypeId.TERRANIN
				});
			}
			var markers = [];
			var paths = [];
			// 
		function trainLinBtn(e) {
			var trainVal = e.dataset.val;
			$.ajax({
				url: "http://localhost:8081/trainMap/trainMapLine",
				dataType : "json",
				type: "GET",
				success: function(result) {
					
					var latLngArr = [];
					var count = 0;
					clearMarkers();
					clearPaths();
					for(var i =0; i < result.length; i++) {
						var data = result[i];
						if(data.train_type == trainVal) {
							var latLng = new google.maps.LatLng(data.mapLatitude, data.mapLongitude);
	 						latLngArr[latLngArr.length] = latLng; // latLng 배열에 담기.
	 				//		console.log(data.mapLatitude);
	 				//		console.log(data.mapLongitude);
	 						var contentString = data.mapStationTitle;
	 						let infowindow = new google.maps.InfoWindow({
	 							content : contentString
	 						});
	 						
// 	 						function addMarkerWithTimeout(position, timeout){
// 	 							window.setTimeout(function() {
// 	 								markers.push(marker = new google.mpas.Marker({
// 	 									position : {lat: parseFloat(data.mapLatitude), lng: parseFloat(data.mapLongitude)},
// 	 									map: map,
// 	 									anmation: google.maps.Animation.DROP
// 	 								}));
// 	 							}, timeout);
// 	 						}
// 	 						function clearMarkers() {
// 	 							for(var i = 0; i < markers.length; i++) {
// 	 								markers[i].setMap(null);
// 	 							}
// 	 							markers = [];
// 	 						}
	 						var myIcon = new google.maps.MarkerImage("train2.png", null, null, null, new google.maps.Size(30,30));
	 						
	 						let marker = new google.maps.Marker({
	 							position: {lat: parseFloat(data.mapLatitude), lng: parseFloat(data.mapLongitude)},
	 							draggable: false,
	 							icon: myIcon,
	 							animation: google.maps.Animation.DROP,
	 				//			animation:google.maps.Animation.BOUNCE,
	 							map: map,
	 							title: data.mapStationTitle
	 						});
// 	 						marker.setMap(map);
 	 						markers.push(marker);
	 						count++;
 	 						 marker.addListener('click', function() {
 	 						    infowindow.open(map, marker);
 	 						});
				
	 					}
	 			//			console.log(latLngArr.length);
 						var flightPath = new google.maps.Polyline({
 							  path: latLngArr,
 							  strokeColor: "#FF0000",
 							  strokeOpacity: 1.0,
 							  strokeWeight: 2
	 					});
	 					flightPath.setMap(map);
 						paths.push(flightPath);
					}
				},
				err: function(){
					alert("에러");
				}
			});
			
		}
			
		// 마커지우기	
		function clearMarkers() {
			for(var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}
		// 폴리라인지우기
		function clearPaths() {
			for(var i = 0; i < paths.length; i++) {
				paths[i].setMap(null);
			}
			paths = [];
		}
		
			
		// 디비에잇는 위도경도 불러서 마커 찍고	
// 			$.ajax({
// 				url : "http://localhost:8081/trainMap/mapTrain",
// 				dataType : "json",
// 				type : "GET",
// 				success : function(result) {
// 		//				console.log(result); // db에잇는정보 object로 나왓고
// 					var markers = []; // 마커를 배열에 담고
// 					var latLngArr = [];
// 					for(var i = 0; i < result.length; i++) {
// 						var data = result[i];
// 						var latLng = new google.maps.LatLng(data.mapLatitude, data.mapLongitude);
// 						latLngArr[latLngArr.length] = latLng; // latLng 배열에 담기.
// 				//		console.log(data.mapLatitude);
// 				//		console.log(data.mapLongitude);
// 						var marker = new google.maps.Marker({
// 							position: latLng,
// 							draggable: true,
// 				//			animation:google.maps.Animation.BOUNCE,
// 							map: map
// 						});
// 						console.log("들어옴?");
// 						markers.push[marker];
			
// 					}
// 						console.log(latLngArr.length);
// 						var flightPath = new google.maps.Polyline({
// 							  path: latLngArr,
// 							  strokeColor: "#FF0000",
// 							  strokeOpacity: 1.0,
// 							  strokeWeight: 2
// 						});
// 					    flightPath.setMap(map);
					
// 				},
// 				err : function() {
// 					console.log("에러");
// 				}
// 			});
		
	</script>
	<!-- 구글맵KEY -->
	<script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDP280f_8sA7GmSMVAXTl9DdUsDGRXTUgM&callback=initMap">
    </script>
    <!-- 구글맵지오코딩KEY -->
    
</body>
</html>
