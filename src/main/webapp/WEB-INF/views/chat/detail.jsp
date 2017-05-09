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

<!-- 사용자 정의 CSS -->
<link rel="stylesheet" href="chat.css">
<link rel="stylesheet" href="chat-message.css">

</head>

<body class="header-fixed header-fixed-space-default" onkeydown='on_key_down()'>
	<!-- 프로필 사진 업로드 모달 -->
	<%@include file="../mypage/include/profileUploadFormModal.jsp"%>
	
	<div class="wrapper">
		<!-- 헤더 include -->
		<%@include file="/resources/include/header.jsp"%>

		<!--=== 사이트맵 ===-->
		<div class="breadcrumbs">
			<div class="container">
				<ul class="breadcrumb pull-left">
					<li><a href="http://localhost:8081"><i class="fa fa-home"></i></a></li>
					<li><a href="javascript:history.back()">chat</a></li>
					<li>new</li>
				</ul>
			</div>
		</div>

		<!--=== 내용 ===-->
		<!--=== Content ===-->
		
		<!-- 모달  -->
<!-- 		<button class="btn btn-default" data-target="#layerpop" -->
<!-- 			data-toggle="modal">모달출력버튼</button> -->
<!-- 		<br /> -->
		<!-- 모달 > 대화명 변경 -->
		<div class="modal fade" id="layerpop">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- header -->
					<div class="modal-header">
						<!-- 닫기(x) 버튼 -->
						<button type="button" class="close" data-dismiss="modal">×</button>
						<!-- header title -->
						<h4 class="modal-title">대화명 변경</h4>
					</div>
					<!-- body -->
					<div class="modal-body">
					대화명 : <input type="text" id="nickname">
					
					</div>
					<!-- Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick="nickNameMod()">확인</button>
					</div>
				</div>
			</div>
		</div>
		<!-- end 모달 > 대화명 변경-->
		<!-- end 모달 -->

		<div class="container content-md">
			<div style="width: 100%;">
				<table class="table" style="margin: 0 auto; width: 80%; background: #EEEEEE;">
					<thead>
						<tr style="">
							<th id="locationName" class="locationName"></th>
							<th id="roomTitle" class="roomTitle"></th>
						</tr>
						<tr>
							<th colspan="2">
							<button id="clean-screen" class='btn btn-u btn-u-blue'>화면비우기</button>
							<button id="nickname-modfy" class='btn btn-u btn-u-purple' style='margin-left: 5px;'>방제목변경</button>
							<button id="room-background" class='btn btn-u btn-u-yellow' style='margin-left: 5px;'>방테마변경</button>
							<button id="room-save" class='btn btn-u btn-u-sea' style='margin-left: 5px;'>저장하기</button>
							<button id="out-room" class='btn btn-u btn-u-red' style='margin-left: 5px;'>퇴장</button>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="3" rowspan="2" class="massagePrint" style="width: 85%; height: 500px;">
								<div id="msg-content" style="height: 500px; background: #FFFFFF; overflow: auto;">
								</div>
							</td>
							<td id="chat-user-cnt" class="glyphicon glyphicon-user" data-cnt="" style="height: 30px;">접속자</td>
						</tr>
						<tr>
							<td id="chat-user-info" style="height: 400px;"></td>
						</tr>
						<tr style="height: 50px; ">
							<td></td>
						</tr>
						<tr style="height: 30px; ">
							<td colspan="4" style="weight: 90%; ">
								<span id="spanStrWidth" style="visibility:hidden; position:absolute; top:-10000; font-size:9pt;"></span>
								<input type="text" id="msg" style="width: 90%; height: 35px;">
								<button id="msg-btn" type="button" class="btn-u">입력</button>
								<input type="file" id="imgSend" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<!--=== End Content ===-->
		<!-- ================================================================ -->

		<!-- 푸터 include -->
		<%@include file="/resources/include/footer.jsp"%>

	</div>
	
	<!-- 로그인 모달 include -->
	<%@include file="/resources/include/userModal.jsp"%>

	<!-- JS Global Compulsory -->
	<script type="text/javascript" src="../../assets/plugins/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="../../assets/plugins/jquery/jquery-migrate.min.js"></script>
	<script type="text/javascript" src="../../assets/plugins/bootstrap/js/bootstrap.min.js"></script>

	<!-- JS Implementing Plugins -->
	<script type="text/javascript" src="../../assets/plugins/back-to-top.js"></script>
	<script type="text/javascript" src="../../assets/plugins/smoothScroll.js"></script>
	<script type="text/javascript" src="../../assets/plugins/parallax-slider/js/modernizr.js"></script>
	<script type="text/javascript" src="../../assets/plugins/parallax-slider/js/jquery.cslider.js"></script>
	<script type="text/javascript" src="../../assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"></script>
	<script type="text/javascript" src="../../assets/plugins/modernizr.js"></script>
	<script type="text/javascript" src="../../assets/plugins/login-signup-modal-window/js/main.js"></script>

	<!-- JS Page Level -->
	<script type="text/javascript" src="../../assets/js/app.js"></script>
	<script type="text/javascript" src="../../assets/js/plugins/owl-carousel.js"></script>
	<script type="text/javascript" src="../../assets/js/plugins/parallax-slider.js"></script>

	<!--[if lt IE 9]>
	<script src="../../assets/plugins/respond.js"></script>
	<script src="../../assets/plugins/html5shiv.js"></script>
	<script src="../../assets/plugins/placeholder-IE-fixes.js"></script>
	<![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-toast-plugin/dist/jquery.toast.min.js"></script>

	<!-- 파이어베이스 -->
	<script type="text/javascript" src="https://www.gstatic.com/firebasejs/3.5.1/firebase.js"></script>
	<script type="text/javascript" src="../../resources/js/firebaseInit.js"></script>
	<script type="text/javascript" src="../../resources/js/firebaseAuth.js"></script>
	
	<!-- 메뉴 -->
	<script type="text/javascript" src="../../resources/js/menu.js"></script>
	
	<!-- INIT APP -->
	<script type="text/javascript" src="../../resources/js/initApp.js"></script>
	
	
	
	<!---------------------여기서부터수정------------------------------------------------------------------------------------>
	
	<!-- 사용자 정의 Java Script 작성이 완료되면 외부파일로 뺄것 -->
	<script type="text/javascript" src="https://cdn.socket.io/socket.io-1.4.5.js"></script>	
	<script type="text/javascript" src="detail.js"></script>
	<script type="text/javascript" src="js/moment.js"></script>
	<script type="text/javascript">
		var obj = new Object();
		obj.loc = "${param.location}";
		obj.title = "${param.title}";
		obj.room = "${param.room}";
		obj.roomNo = "${param.roomNo}";
		obj.sendRegDate = new Date();
		
		console.log("detail.jsp");
		console.dir(obj);
		
		roomHeadHandler(obj);
		
		var userName = user.displayName;
		
		// nodejs 소켓 통신
		function chat_socketIo() {
			console.log("in socketIo");
			// 소켓서버에 접속
// 			var socket = io("http://192.168.0.190:10001");
			var chat_socket = io(myConfig.nodeChatServerUrl);
			
			chat_socket.on('connection', function(data) {
				 // socket 연결 완료
	             if (data.type == 'connected') {
	             	 console.log("connected");
	             	chat_socket.emit('joinRoom', {
	                     uid : user.userUid,
	                     name : user.displayName,
	                     room : obj.roomNo,
	                     photoUrl : user.photoUrl
	                 });
	             }
	         });
			 
			 
			 // 방 유저 리스트
			 chat_socket.on('getUserInfo', function(data) {
				 console.log("in getUserInfo");
				 console.dir(data);
				 listUser(data);
	         });
			 
			 
			 chat_socket.on('system', function(data) {
				 console.log("system");
 				 console.log("서버에서 전송된 메세지 : " + data.message);
 				 console.log("서버에서 전송된 방번호 : " + data.roomNo);
 				 
				 var html = "";
				 html += "<div style='text-align:center; height:20px;'>";
				 html += "<span>";
				 html += data.message;
				 html += "</span>";
				 html += "</div>";
				 $("#msg-content").append(html);
				 $("#msg-content").scrollTop($("#msg-content")[0].scrollHeight);
				 listUser(data);
	         });
			 
			 chat_socket.on('message', function(data) {
				 if (data.type == "text") {
				 	var msgLength = data.message.length;				
				 	 console.log(msgLength);
					 if (msgLength <= 5) {
						msgLength = data.message.length + 3;
					 }
					 
					 var msgMgn = "" + (msgLength * 18) + "px"; 
				 }
				 
				
				 console.log("in message")
				 console.dir(data);
				 
				 
				 var html = "";
				 switch (data.type) {
			    	case 'text' :
			    		 html += "<div class='direct-chat-messages'>";
					      html += "<div class='direct-chat-msg'>";
					      html += "<div class='direct-chat-info clearfix'>";
					      html += "<span class='direct-chat-name pull-left'>";
					      html += data.name + "</span>";
					      html += "</div>";
					      html += "<img class='direct-chat-img' src=" + data.photoUrl + " alt='Message User Image'>";;
					      html += "<div class='direct-chat-text' style='width: " + msgMgn + "'>";
					      html += data.message;
					      html += "</div>";
					      html += "<span class='direct-chat-timestamp pull-left' style='margin-left: 20px;'>" + moment().format('MMMM Do YYYY, h:mm:ss a') + "</span>";
					      html += "</div></div>";
			    		break;
			    	case 'image' :
			    		  console.log("type : image ");
			    		  html += "<div style='height: 100%'>";
					      html += "<div class='direct-chat-msg'>";
					      html += "<div class='direct-chat-info clearfix'>";
					      html += "<span class='direct-chat-name pull-left'>";
					      html += data.name + "</span>";
					      html += "</div>";
					      html += "<img class='direct-chat-img' src=" + data.photoUrl + " alt='Message User Image'>";;
					      html += "<div>";
					      html += "<img src=" + data.imgUrl + ">";
					      html += "</div></div>";
			    		break;
			    	}
				 
				 $("#msg-content").append(html);
				 $("#msg-content").scrollTop($("#msg-content")[0].scrollHeight);
	         });
			 
			 
			
		$("#msg-btn").click(function() {
			// id가 msg 인 텍스트 창에 입력된 데이터를 소켓서버에 전송
			console.log("서버로 전송함");
			var s = $("#msg").val();
			var msgLength = s.length;
			
			if (s.length <= 4) {
				msgLength = s.length + 3;
			}
			var msgMgn = "" + (18 * msgLength) + "px"; 
			
			var html = "";
			html += "<div class='direct-chat-messages'>";
			html += "<div class='direct-chat-msg right'>";
			html += "<div class='direct-chat-info clearfix'>";
			html += "<span class='direct-chat-name pull-right'>";
			html += userName + "</span>";
			html += "</div>";
			html += "<img class='direct-chat-img' src='" + user.photoUrl + "' alt='Message User Image'>";
			html += "<div class='direct-chat-text' style='margin-left: auto; width: " + msgMgn + "'>";
			html += $("#msg").val();
			html += "</div>";
			html += "<span class='direct-chat-timestamp pull-left' style='margin-left: 480px;'>" + moment().format('MMMM Do YYYY, h:mm:ss a') + "</span>";
			html += "</div>";
			html += "</div>";

			$("#msg-content").append(html);
			chat_socket.emit("user", {
				type : "text",
				name : user.displayName,
				message : $("#msg").val(),
				photoUrl : user.photoUrl,
				uid : user.userUid,
				sendRegDate : new Date()
			});
			
			
			$("#msg").val("");
			$("#msg").focus();
			$("#msg-content").scrollTop($("#msg-content")[0].scrollHeight);
		});

		
		$("#out-room").click(function() {
			console.log("in out");
			
			chat_socket.emit("outRoom", {
				uid : user.userUid,
				name : user.displayName,
				room : obj.roomNo
			});
			
			// 방 삭제 - 방 인원 0
			chat_socket.on("roomList", function(data) {
				console.log("in roomList");
				// 채팅 방 목록
				console.dir(data);
				
				chat_socket.emit("exit", {
					uid : user.userUid
				});
			});
			
			// 방 인원이 남아있는 경우
			chat_socket.on("outRoomUser", function(data) {
				console.log("in roomList");
				// 채팅 방 목록
				console.dir(data);
				
				chat_socket.emit("exit", {
					uid : user.userUid
				});
			});
			
			window.location = myConfig.serverURL + '/chat/home';
		});
		

		chat_socket.on('outMsg', function(data) {
			console.log("on out");
			console.log("서버에서 전송된 데이터 > name : " + data.name);
			console.log("서버에서 전송된 데이터 > message : " + data.message);
			console.log("roomNo : " + data.roomNo);

			var html = "";
			html += "<div style='text-align:center;'>";
			html += "<span>";
			html += data.message;
			html += "</span>";
			html += "</div>";
			$("#msg-content").append(html);

			listUser(data);
		});
		
			
		function readImage(input) {
	        if (input.files && input.files[0]) {
	          var FR= new FileReader();
	          FR.onload = function(e) {
	            var data = {
	              "type" : "image",
	              "name" : user.displayName,
	              "imgUrl" : e.target.result,
	              "uid" : user.userUid
	            }
	            chat_socket.emit('user', data);
	            var imgUrl = e.target.result;
	            
        		var html = "";
				html += "<div style='height: 100%'>";
				html += "<div class='direct-chat-msg right'>";
				html += "<div class='direct-chat-info clearfix'>";
				html += "<span class='direct-chat-name pull-right'>";
				html += userName + "</span>";
				html += "<span class='direct-chat-timestamp pull-left'>23 Jan 2:05 pm</span>";
				html += "</div>";
				html += "<img class='direct-chat-img' src='" + user.photoUrl + "' alt='Message User Image'>";
				html += "<div>";
				html += "<img src=" + imgUrl + " style='margin: auto;'>";
				html += $("#msg").val();
				html += "</div>";
				html += "</div>";
				html += "</div>";
	            
	            $("#msg-content").append(html);
	            $("#msg-content").scrollTop($("#msg-content")[0].scrollHeight);
	          };
	          FR.readAsDataURL( input.files[0] );
	        }
	      }
		
		$("#imgSend").change(function () {
			readImage(this);
		});
	}

	chat_socketIo();
	</script>
</body>
</html>
