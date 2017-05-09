console.log(myConfig.imsiServerUrl);
var user = sessionStorageService.getObject("user");
    
    
function listUser(obj) {
	console.log("in listUser");
	var user_cnt = $("#chat-user-cnt");
	var user_info = $("#chat-user-info");

	console.log("방 번호 : " + obj.roomNo);
	var obj2 = new Object();
	obj2.roomNo = obj.roomNo;
	
	$.ajax({
		url : myConfig.serverUrl + "/chat/list_user",
		method : 'GET',
		dataType : 'json',
		data : obj2,
		success : function(result) {
			user_info.html("");
			user_cnt.html(" " + result.length + "명");
			user_cnt.attr("data-cnt", result.length);
			
			var html = "";
			
			for (var i = 0; i < result.length; i++) {
				var item = result[i];
				html += "<div class='dropdown'>";
				html += "<span id=" + item.userUid + ">" + item.displayName + "</span>";
				html += "<div class='dropdown-content'>";
				html += "<a href='#'>프로필</a>";
				html += "<a href='#' data-target='#layerpop' data-toggle='modal'>대화명 변경</a>";
				html += "<a href='#' onclick='updateProfileImage();'>사진 변경</a>";
				html += "</div>";
				html += "</div>";
				html += "<br>";
			}
			
			user_info.html(html);
		}
	});
}


function roomHeadHandler(obj) {
	console.log("in roomHeadHandler");
	
	$(".locationName").html(obj.room);
	$(".roomTitle").html("방제목 : " + obj.title);
	listUser(obj);
}
	
	
function nickNameMod() {
	var nick = $("#nickname");
	$("#" + user.userUid).text(nick.val());
	userName = nick.val();
}
	
	
function on_key_down() {
	console.log(event.keyCode);
	
	if (event.keyCode == 13) {
		$("#msg-btn").trigger("click");
	}
}
	
