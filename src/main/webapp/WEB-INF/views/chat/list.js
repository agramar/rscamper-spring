var user = sessionStorageService.getObject("user");

var chatRoomInfoNo = "";

if (user == null) {
	  var $form_modal = $('.cd-user-modal'), $form_login = $form_modal
			.find('#cd-login'), $form_signup = $form_modal.find('#cd-signup'), $form_forgot_password = $form_modal
			.find('#cd-reset-password'), $form_modal_tab = $('.cd-switcher'), $tab_login = $form_modal_tab
			.children('li').eq(0).children('a'), $tab_signup = $form_modal_tab
			.children('li').eq(1).children('a'), $forgot_password_link = $form_login
			.find('.cd-form-bottom-message a'), $back_to_login_link = $form_forgot_password
			.find('.cd-form-bottom-message a');

	$form_modal.addClass("is-visible");

	$form_login.removeClass('is-selected');
	$form_signup.addClass('is-selected');
	$form_forgot_password.removeClass('is-selected');
	$tab_login.removeClass('selected');
	$tab_signup.addClass('selected');
}


function chat_room_list() {
	$.ajax({
		url : myConfig.serverUrl + '/chat/room_list',
		method : 'GET',
		dataType : 'json',
		success : function(result) {
			listRoomCreate(result);
			console.dir(result);
		}
	});
}
// 채팅 방 리스트 만들기
chat_room_list();


function listRoomCreate(data) {
	var room_list = $("#room-list");
	var html = "";
	
	for (var i = 0; i < data.length; i++) {
		var item = data[i];
		
		html += "<tr>";
		html += "<td>" + item.areaName + "</td>";
		html += "<td>" + item.chatRoomName + "</td>";
		html += "<td>" + item.roomUserCnt + "</td>";
		html += "<td class='glyphicon glyphicon-share-alt' onclick='intoRoom(this)' data-room=";
		html += item.chatRoomInfoNo;
		html += " data-loc=";
		html += item.areacode;
		html += " data-tle=";
		html += item.chatRoomName;
		html += " style='cursor:pointer;'></td>";
		html += "</tr>";
	}
	$("tbody").html(html);
}


function listRoomCreateByArea(area) {
	console.log("in listRoomCreateByArea");
	var obj = new Object();
	obj.area = area;
	
	$.ajax({
		url : myConfig.serverUrl + '/chat/area_room_list',
		method : 'GET',
		data : obj,
		dataType : 'json',
		success : function(result) {
			listRoomCreate(result);
			console.dir(result);
		}
	});
}


// 채팅방 입장	
function intoRoom(e) {
	var room_name = $(e).parent().siblings(".room-name").text();
	var obj = new Object();
	
	obj.userUid = user.userUid;
	obj.chatRoomInfoNo = e.getAttribute("data-room");
	chatRoomInfoNo = obj.chatRoomInfoNo; 
	
	$.ajax({
		url : myConfig.serverUrl + '/chat/insert_user',
		method : 'POST',
		dataType : 'json',
		data : obj,
		success : function(result) {
			console.log("success");
			console.dir(result);
			window.location = myConfig.serverUrl + '/chat/detail?room=' + e.getAttribute("data-room") + "&location=" + e.getAttribute("data-loc") + "&title=" + e.getAttribute("data-tle");
		}
	});
}
		
		
// 채팅방 사용자 생성
function createRoom() {
	var obj = new Object();
	obj.areacode =  $("select[name=locationid]").val();
	obj.chatRoomName = $("#inputRoomTitle").val();
	obj.userUid = user.userUid;
	
	// 1. 방 생성 -> 디비 입력 -> 디비 방 정보 가져오기
	$.ajax({
		url : myConfig.serverUrl + '/chat/detail',
		method : 'POST',
		dataType : 'json',
		data : obj,
		success : function(result) {
			var userObj = new Object();
			
			var s1 = result.split("&");
			console.log(s1[3]);
			
			var s2 = s1[3].split("=");
			console.log(s2[1]);
			
			userObj.userUid = user.userUid;
			userObj.chatRoomInfoNo = s2[1];
			
			$.ajax({
				url : myConfig.serverUrl + '/chat/insert_user',
				method : 'POST',
				dataType : 'json',
				data : userObj,
				success : function() {
					window.location = myConfig.serverUrl + '/chat/detail?room=' + userObj.chatRoomInfoNo + "&location=" + obj.areacode + "&title=" + obj.chatRoomName;
				}
			});
		}
	})
}












// 이전 코드



//방 생성
//$("#createRoomBtn").click(function() {
//	var obj = new Object();
//	obj.areacode =  $("select[name=locationid]").val();
//	obj.chatRoomName = $("#inputRoomTitle").val();
//	obj.userUid = user.userUid;
//	
//	console.log(obj.areacode);
//	console.log(obj.chatRoomName);
//	console.log(obj.userUid);
//	
//	// 1. 방 생성 -> 디비 입력 -> 디비 방 정보 가져오기
//	$.ajax({
//		url : myConfig.imsiServerUrl + '/chat/detail',
//		method : 'POST',
//		dataType : 'json',
//		data : obj,
//		success : function(result) {
//			console.dir(result);
//			
//			var userObj = new Object();
//			
//			console.log(result);
//			
//			var s1 = result.split("&");
//			console.log(s1[3]);
//			
//			var s2 = s1[3].split("=");
//			console.log(s2[1]);
//			
//			
//			console.log(user.userUid);
//			userObj.userUid = user.userUid;
//			userObj.chatRoomInfoNo = s2[1];
//			$.ajax({
//				url : myConfig.imsiServerUrl + '/chat/insert_user',
//				method : 'POST',
//				dataType : 'json',
//				data : userObj,
//				success : function() {
//					window.location = myConfig.imsiServerUrl + '/chat/detail?room=' + userObj.chatRoomInfoNo + "&location=" + obj.areacode + "&title=" + obj.chatRoomName;
//				}
//			});
//		}
//	})
//});
	