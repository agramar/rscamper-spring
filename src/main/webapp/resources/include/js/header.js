$(document).ready(function(){
	var user = sessionStorageService.getObject("user");
	/* 알림 */
	$('[data-toggle="popover"]').popover({
		html: true, 
		content:  function() {
//	      return $('#popovnotier-content').html();
	      return $('.last-noti-list').html();
	    }
	});

	console.log("user");
	console.dir(user);

	if (user) {
		var obj = new Object();
		obj.userUid = user.userUid;
		
		$.ajax({
			type : "GET",
			url : myConfig.serverURL + "/notisfication/list",
			dataType : 'json',
			data : obj,
			error : function(err) {
				alert("에러");
			},
			success : function(result) {
				console.log("알림 success");
				console.dir(result);
				
				notisficationList(result);
			}
		});
	} else {
		alert("null");
	}

	function notisficationList(data) {
		
		var html = "";
		for (var i = 0; i < data.length; i++) {
			var item = data[i];
			
			html += "<li data-id='05dd80646296182b' data-url= " + item.url + " data-type='8' data-link-key='d3358b3b6597e8ca'";
			html += "onclick=pageMove(this)>";
			html += "<div></div>";
			html += "<div class='noti-img-wrap'><img src=" + item.photoUrl + "></div>";
			html += "<div class='noti-contents'>";
			html += "<h5><i class='fa comment'></i> <span><span style='color:#ff8000;'>" + item.displayName + "</span>";
			html += "님이 <span style='color:#ff8000;'>" + item.title +  "</span>" + item.codeName + "</span>";
			html += "<span class='noti-new'>N</span></h5>";
			html += "<p class='date'>" + item.date + "</p>";
			if (item.message) {
				html += "<p>" + item.message + "</p>";
			}
			html += "</div>";
			html += "</li>";
		}
		
		$("#my-notice-list").html(html);
	}
});




// 알림 닫기 
$('body').on('click', function (e) {
    //did not click a popover toggle or popover
    if ($(e.target).data('toggle') !== 'popover'
        && $(e.target).parents('.popover.in').length === 0) { 
        $('[data-toggle="popover"]').popover('hide');
    }
});

//알림 닫기 이벤트
var hideAllPopovers = function() {
    $('[data-toggle="popover"]').each(function() {
         $(this).popover('hide');
    });  
};

// 알림 클릭 -> 페이지 이동
function pageMove(e) {
//	alert("ee");
	console.dir(e);
	window.location.href = e.dataset.url;
}




