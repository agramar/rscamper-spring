
function contentCreate(no) {
	var obj = new Object();
	obj.no = no;

	$.ajax({
		type : "POST",
		url : myConfig.serverUrl + "/together/detail",
		dataType : 'json',
		data : obj,
		error : function(err) {
			alert("에러");
		},
		success : function(result) {
			console.log(result);
			if (!result) {
				alert("비밀글입니다.");
				javascript: history.back(-1);
			}

			var d = new Date(result.regDate);
			var mon = d.getMonth() + 1;

			$("#together-title").html("<h2>" + result.title2 + "</h2>");
			$("#together-regdate").html("작성일 : " + d.getFullYear() + "-" + prependZero(mon, 2) + "-" + prependZero(d.getDate(), 2));
			$("#together-content").html(result.content);
		}
	});
}

function prependZero(num, len) {
	while (num.toString().length < len) {
		num = "0" + num;
	}
	return num;
}

