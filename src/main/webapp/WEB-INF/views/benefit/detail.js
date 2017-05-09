	function contentCreate(obj) {
		
		$.ajax({
			type : "GET",
			url : myConfig.serverUrl + "/benefit/detail",
			dataType : 'json',
			data : obj,
			error : function(err) {
				alert("에러");
			},
			success : function(result) {
				var content = $(".content");
				content.html(result.content);
			}
		});
	}
		
		