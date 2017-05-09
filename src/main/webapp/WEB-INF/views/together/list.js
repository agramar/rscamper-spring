
var user = sessionStorageService.getObject("user");
console.log(user);

var page;

function togetherList(e) {
	console.log("in togetherList")
	console.log(e);
	console.dir(e);
	var obj = new Object();
	obj.page = e;
	
	$.ajax({
		type : "GET",
		url : myConfig.serverUrl + "/together/list",
		dataType : 'json',
		data : obj,
		error : function (err) {
			alert("에러");
		},
		success : function(result) {
			console.log("list ajax success");
			console.dir(result);
			listCreate(result);
		}
	})
}
				
 		
function listCreate(data) {
	console.dir(data);
	var p = data.page;
	var pageMaker = data.pageMaker;
	page = pageMaker.endPage;
	var list = $("tbody");
	var html = "";
	for (var i = 0; i < p.length; i++) {
		var v = p[i];
		var d = new Date(v.regDate);
		var mon = d.getMonth() + 1;
		html += "<tr>";
		html += "<td style='margin: auto; text-align: center;'>" + v.togetherlNo + "</td>";
		html += "<td>" + v.title1 + "</td>";
		html += "<td>";
		html += "<a href='"+ myConfig.serverUrl +"/together/" + v.togetherlNo + "'>";
		html += v.title2 + "</a>";
		html += "<td>" + d.getFullYear() + "-" + prependZero(mon, 2) + "-" + prependZero(d.getDate(), 2) + "</td>";
		html += "</tr>";
	}
	
	list.html(html);
	html = "";
	
	var pageination = $(".pagination");
	console.dir(pageMaker.prev);
	if (pageMaker.prev) {
		html += "<li class='page-item'>";
		html += "<a class='page-link' href='#' aria-label='Previous'>";
		html += "<span aria-hidden='true' onclick=previousNextFn('P') >&laquo;</span>";
		html += "<span class='sr-only'>Previous</span>";
		html += "</a>";
		html += "</li>";
	}

	for (var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
		html += "<li class='page-item'>";
		html += "<a href='#' onclick= togetherList(this.text)>" + i + "</a>";
		html += "</li>";
	}

	if (pageMaker.next && pageMaker.endPage > 0) {
		html += "<li class='page-item'>";
		html += "<a class='page-link' href='#' aria-label='Next'>";
		html += "<span aria-hidden='true' onclick=previousNextFn('N') >&raquo;</span>";
		html += "<span class='sr-only'>Next</span>";
		html += "</a>";
		html += "</li>";
	}
	pageination.html(html);
}
 		
 		
function prependZero(num, len) {
	while (num.toString().length < len) {
		num = "0" + num;
	}
	return num;
}


function previousNextFn(val) {
	console.log("in previousNextFn");
	console.log(val);
	console.log("page : " + page);

	if (val == 'N') {
		page = page + 1;
	} else {
		page = page - 19;
	}

//	togetherList(page);
}


togetherList();