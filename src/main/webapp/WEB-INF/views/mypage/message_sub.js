var user = sessionStorageService.getObject("user");
    
//쪽지 날짜
function timeSince(date, lang) {
	var langs = {
		en : {
			years : " years ago",
			months : " months ago",
			days : " days ago",
			hours : " hours ago",
			minutes : " minutes ago",
			seconds : " seconds ago",
			now : "now"
		},
		it : {
			years : " anni fa",
			months : " mesi da",
			days : " giorni fa",
			hours : " ore fa",
			minutes : " minuti fa",
			seconds : " secondi fa",
			now : "adesso"
		},
		kr : {
			years : "년전",
			months : "달전",
			days : "일전",
			hours : "시간전",
			minutes : "분전",
			seconds : "초전",
			now : "지금"
		}
	};

	var selectedLang = langs.en;

	if (lang != null && langs[lang] != null) {
		selectedLang = langs[lang];
	}

	if (date == null)
	return "";

	date = new Date(date);

	var seconds = Math.floor((new Date() - date) / 1000);
	var interval = Math.floor(seconds / 31536000);
	if (interval >= 1) {
		return interval + selectedLang.years;
	}
	interval = Math.floor(seconds / 2592000);
	if (interval >= 1) {
		return interval + selectedLang.months;
	}
	interval = Math.floor(seconds / 86400);
	if (interval >= 1) {
		return interval + selectedLang.days;
	}
	interval = Math.floor(seconds / 3600);
	if (interval >= 1) {
		return interval + selectedLang.hours;
	}
	interval = Math.floor(seconds / 60);
	if (interval >= 1) {
		return interval + selectedLang.minutes;
	}

	if (Math.floor(seconds) == 0) {
		return selectedLang.now;
	} else
	return Math.floor(seconds) + selectedLang.seconds;
}

// 페이지 번호
var page;

// 페이지 현재 id 셀렉터
var pageId = ""; 

// 쪽지 리스트
function note_list(pageNo) {
	console.log("in note_list");
	console.dir(pageNo);
	
	if(jQuery.type(pageNo) === 'undefined' ) {
		pageId = "page_1";
	} else {
		pageId = "page_" + pageNo;
	}
	
	console.dir($("#" + pageId));	
	
	var obj = new Object();
	obj.uid = user.userUid;
	obj.page = pageNo;
	
	$.ajax({
		url : myConfig.serverURL + '/note/list',
		method : 'GET',
		dataType : 'json',
		data : obj,
		success : function(result) {
			console.log("note_list success");
			console.dir(result);
			listCreate(result);
			
			$.ajax({
				url : myConfig.serverUrl + '/note/sent-list',
				method : 'GET',
				dataType : 'json',
				data : obj,
				success : function(result) {
					sentListCreate(result);
				}
			})
		}
	})
}


// 받은 쪽지함 리스트 만들기
function listCreate(data) {
	console.log("in listCreate");
	var p = data.page;
	var pageMaker = data.pageMaker;
	page = pageMaker.endPage;
	var html = "";
	
	for (var i = 0; i < p.length; i++) {
		var item = p[i];
		html += "<tr id=note-list-" + item.notesNo + " style='border-top:1px solid gray;'>";
		html += "<td style='padding: 10px;'>";
		html += "<input type='checkbox'>";
		
		if (item.recvRead == 'N') {
			html += "<span class='glyphicon glyphicon-envelope' aria-hidden='true' style='margin-left: 30px;'></span>";
		} else {
			html += "<span class='glyphicon glyphicon-ok' aria-hidden='true' style='margin-left: 30px;'></span>";
		}
		
		html += "<img src='" + item.photoUrl + "'";
		html += "alt='...' class='img-thumbnail' style='width: 70px; height: 70px; margin-left: 10px;'>";
		html += "</td>";
		html += "<td style='padding: 10px;'>";
		html += "<a title='displayName' href='#''>";
		html += "<span class='spr l8'>";
		html += "<span class='blind'>" + item.displayName + "</span>";
		html += "</span>";
		html += "</a>";
		html += "<br>";
		html += "<span>" + timeSince(item.dateSent, "kr") + "</span>";
		html += "</td>";
		html += "<td style='padding: 10px;'>";
		html += "<span><strong>" + item.title + "</strong></span>";
		html += "<br>";
		html += "<div style='display: inline-block; width: 350px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;'>" + item.content + "</div>";
		html += "</td>";
		html += "</tr>";
	}
		$("#recv-tbody").html(html);
		
		html = "";
		var pageination = $(".pagination");
//		console.dir(pageMaker.prev);
	if (pageMaker.prev) {
		html += "<li class='page-item'>";
		html += "<a class='page-link' href='javascript:void(0);' aria-label='Previous' onclick=previousNextFn('P')>";
		html += "<span aria-hidden='true'  >&laquo;</span>";
		html += "<span class='sr-only'>Previous</span>";
		html += "</a>";
		html += "</li>";
	}

	for (var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
		html += "<li class='page-item'>";
		html += "<a href='javascript:void(0);' onclick= note_list(this.text) id=page_" + i + ">" + i + "</a>";
		html += "</li>";
	}

	if (pageMaker.next && pageMaker.endPage > 0) {
		html += "<li class='page-item'>";
		html += "<a class='page-link' href='javascript:void(0);' aria-label='Next' onclick=previousNextFn('N')>";
		html += "<span aria-hidden='true' >&raquo;</span>";
		html += "<span class='sr-only'>Next</span>";
		html += "</a>";
		html += "</li>";
	}
	pageination.html(html);
	
	$("#" + pageId).css('color', '#fff');
	$("#" + pageId).css('background', '#5fb611');
	$("#" + pageId).css('border-color', '#5fb611');
}


// 보낸쪽지함 리스트 만들기
function sentListCreate(data) {
	console.log("in sentListCreate");
//	console.dir(data);
	
	var p = data.page;
	var pageMaker = data.pageMaker;
	sent_page = pageMaker.endPage;
	var html = "";
	
	for (var i = 0; i < p.length; i++) {
		var item = p[i];
	
		html += "<tr id=note-list-" + item.notesNo + " style='border-top:1px solid gray;'>";
		html += "<td style='padding: 10px;'>";
		html += "<input type='checkbox'>";
		
		if (item.recvRead == 'N') {
			html += "<span class='glyphicon glyphicon-envelope' aria-hidden='true' style='margin-left: 30px;'></span>";
		} else {
			html += "<span class='glyphicon glyphicon-ok' aria-hidden='true' style='margin-left: 30px;'></span>";
		}
		
		html += "<img src='" + item.photoUrl + "'";
		html += "alt='...' class='img-thumbnail' style='width: 70px; height: 70px; margin-left: 10px;'>";
		html += "</td>";
		html += "<td style='padding: 10px;'>";
		html += "<a title='displayName' href='#''>";
		html += "<span class='spr l8'>";
		html += "<span class='blind'>" + item.displayName + "</span>";
		html += "</span>";
		html += "</a>";
		html += "<br>";
		html += "<span>" + timeSince(item.dateSent, "kr") + "</span>";
		html += "</td>";
		html += "<td style='padding: 10px;'>";
		html += "<span><strong>" + item.title + "</strong></span>";
		html += "<br>";
		html += "<div style='display: inline-block; width: 350px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;'>" + item.content + "</div>";
		html += "</td>";
		html += "</tr>";
	}	
	$("#sent-tbody").html(html);
}


function prependZero(num, len) {
	while (num.toString().length < len) {
		num = "0" + num;
	}
	return num;
}


// 페이지 10개 단위 이동
function previousNextFn(val) {
	console.log("in previousNextFn");
	console.log(val);
	console.log("end-page : " + page);
	
	page = Math.ceil(page * 0.1) * 10;
	
	if (val == 'N') {
		page = page + 1;
	} else {
		page = page - 19;
	}
	console.log("page : " + page);

	note_list(page);
}

note_list();


// 모달 쪽지 보내기 띄우기
$('#new_note').on('click', function(){
	$('#note_send').modal('show');
});


// 쪽지 전송
$('#uploadNote').on('click', function(){
	var recUid = $("#project-id").val();
	var title = $("#inputNoteSendTitle").val();
	var content = $("#inputNoteSendContent").val();
	var sendUid = user.userUid;
	
	var obj = new Object();
	obj.recvUserUid = recUid;
	obj.title = title;
	obj.content = content;
	obj.sentUserUid = sendUid;
	
	$.ajax({
		url : myConfig.serverURL + '/note/send',
		method : 'POST',
		data : obj,
		success : function(result) {
			$('#note_send').modal('hide');
			
			note_list();
			
			console.log("쪽지 보내기 성공");
			
			var nObj = new Object();
			
			nObj.recivUserUid = recUid;
			nObj.targetUserUid = sendUid;
			nObj.title = title;
			nObj.type = '4';
			nObj.contentId = '1';
			nObj.message = content;
			nObj.url = document.location.href;
			
			console.dir(nObj);
			
			$.ajax({
				type : "POST",
				url : myConfig.serverURL + "/notisfication/insert",
				dataType : 'json',
				data : nObj,
				error : function(err) {
					alert("에러");
				},
				success : function(result) {
					console.log("알림 insert success");
					
					notis_socket.emit("commentInfo", {
						type : "message",
						recvId : recUid,
						count : $(".noti-count").html()
					});
				}
			});
		}
	})
});


/* 쪽지 보내기 모달 autocomplete */
////////////////////////////////////////////////////////////////
var projects = new Array();
$.ajax({
	url : myConfig.serverURL + '/note/user-list',
	method : 'GET',
	success : function(result) {
//		console.log("user-list success");
//		console.dir(result);
//		console.log(result.length);
		var obj = jQuery.parseJSON(result);
		
		for (var i = 0; i < obj.length; i++) {
			var item = obj[i];
			var project = new Object();
			project.value = item.userUid;
			project.label = item.email;
			project.desc = item.displayName;
			project.icon = item.photoUrl;
			projects.push(project);
		}
//		console.log("projects : ");
//		console.dir(projects);
	}
});


$(function() {
	$("#project").autocomplete({
		minLength : 0,
		source : projects,
		focus : function(event, ui) {
			$("#project").val(ui.item.label);
			return false;
		},
		select : function(event, ui) {
			$("#project").val(ui.item.label);
			$("#project-id").val(ui.item.value);
			$("#project-description").html(ui.item.desc);
			$("#project-icon").attr("src", ui.item.icon);
			return false;
		}
	}).autocomplete("instance")._renderItem = function(ul, item) {
		return $("<li>").append(
				"<div>" + item.label + "<br>" + item.desc + "</div>").appendTo(
				ul);
	};
});    
////////////////////////////////////////////////////////////////



