var user = sessionStorageService.getObject("user");

function commentList() {
	$.ajax({
		url : myConfig.serverUrl + '/main/all',
		method : 'GET',
		dataType : 'json',
		success : function(result) {
			commentFn(result);
		}
	});
}

$("#commentBtn").click(function() {
	var uid = firebase.auth().currentUser.uid;
	var comment = $("#inputComment").val();

	$.ajax({
		url : myConfig.serverUrl + '/main/' + uid + '/' + comment,
		method : 'PUT',
		dataType : 'json',
		success : function(result) {
			$("#inputComment").val("");
			commentFn(result);
		}
	});
});

function commentFn(data) {
	var cList = $("#comment-list");
	console.dir(data);

	cList.html("");
	
	for (var i = 0; i < data.length; i++) {
		var m = data[i];
		var html = "";
		html += "<div style='margin: 10px;'>";
		if (m.providerPhotoUrl) {
			html += "<img src='" + m.providerPhotoUrl + "' style='width:40px; height:40px'>";
		} else {
		html += "<img src='../assets/img/user.jpg' style='width:40px; height:40px'>";
		}
		html += "<span style='margin-left: 20px;'>";
		html += m.mainContent;
		html += "</span>";
		html += "</div>"
		cList.append(html);
	}
}

commentList();


		
		// 추천콘텐츠 ajax
		var benefitList = $("#benefitList");
		var html4 = "";
		$.ajax({
			url : myConfig.serverUrl + "/main/benefitList",
			dataType : "json",
			type : "GET",
			success: function(result) {
				console.log(result); // 다들어왓고
				for(var i = 0; i < 15; i++) {
					var data = result[i];
					console.log(data);
					html4 += "<div class='col-md-4' style='height: 300px; margin-top: 10px; padding: 0 5px;'>";
					html4 += "<div class='thumbnails thumbnail-style thumbnail-kenburn' style='border: 1px solid #F0F0F0;'>";
					html4 += "	<div class='thumbnail-img'>";
					html4 += "		<div class='overflow-hidden'>";
					html4 += "			<img class='img-responsive' src='" + data.imageUrl + "'>";
					html4 += "		</div>";
					html4 += "			<a class='btn-more hover-effect' href='http://localhost/rscamper-web/views/benefit/detail.jsp?benefitno="+ data.benefitNo +"'>자세히</a>";
					html4 += "	</div>";
					html4 += "	<div class='caption'>";
					html4 += "		<div class='caption-title'>";
					html4 += "			<h3 style='margin: 0; line-height: 1.2; font-weight: bold;>";
					html4 += "			<a class='hover-effect' href='#'>"+ data.info +"</a>";
					html4 += "			</h3>";
					html4 += "		</div>";
					html4 += "		<p style='color: #999'>"+ data.title +"</p>";
					html4 += "</div>";
					html4 += "</div>";
					html4 += "</div>";
					benefitList.html(html4);
				}
				
			},
			err: function() {
				alert("에러");
			}	
		});
	
		// 광관지, 맛집, 숙소 ajax
		var touristList = $("#touristList");
		var foodList = $("#foodList");
		var lodegeList = $("#lodegeList");
		var html1 = "";
		var html2 = "";
		var html3 = "";
		$.ajax({
			url : myConfig.serverUrl + "/main/touristList",
			dataType : "json",
			type : "GET",
			success : function(result) {
			//	console.log("result :"); 확인완료
			//	console.log(result);    확인완료
			//	html += "<h2 class='title-v4'>관광지</h2>";
				for(var i = 0; i < result.length; i++) {
					var data = result[i];
					console.log("관광지");
					console.log(data);
					if(data.contenttypeid == 12){
					//	console.log(data.contenttypeid);
						if(data.status == 'on'){
						//	console.log(data);
							html1 += "<div class='blog-thumb margin-bottom-20'>";
							html1 += "	<div class='blog-thumb-hover'>";
							html1 += "		<img src="+ data.firstimage +" style='width: 160px; height: 150px;'>";
							html1 += "		<a class='hover-grad' href='#'>";
							html1 += "			<i class='fa fa-photo'></i>";
							html1 += "		</a>";
							html1 += "	</div>";
							html1 += "	<div class='blog-thumb-desc'>";
							html1 += "		<h3 style='font-family: 'Open Sans', Arial, sans-serif; color: #555;'>";
							html1 += "			<a id='a1' href='http://localhost:80/rscamper-web/views/tour-all/detail.jsp?contentid="+ data.contentid +"&contenttypeid="+ data.contenttypeid +"'>"+ data.addr1 +"</a>";
							html1 += "		</h3>";
							html1 += "		<p style='font-size: 14px; color: #bbb; margin-bottom: 3px;'>"+ data.title +"</p>";
							html1 += "		<div style='font-size: 18px; color: #999'>";
		//					html1 += "				<i data-original-title='Instagram' class='rounded-x social_instagram'></i> "+ Math.floor(Math.random() * 100) + 1 +"개의 포스트";
							html1 += "				<i class='fa fa-commenting'></i> <span style='font-size: 13px; color: #999'>"+ Math.floor(Math.random() * 100) + 1 +"개의  포스트</span>";
							html1 += "		</div>";
							html1 += "	</div>";
							html1 += "</div>";
						}
					}
					touristList.html(html1);
					
					if(data.contenttypeid == 39){
						//	console.log(data.contenttypeid);
							if(data.status == 'on'){
						//		console.log(data);
								html2 += "<div class='blog-thumb margin-bottom-20'>";
								html2 += "	<div class='blog-thumb-hover'>";
								html2 += "		<img src="+ data.firstimage +" style='width: 160px; height: 150px;'>";
								html2 += "		<a class='hover-grad' href='#'>";
								html2 += "			<i class='fa fa-photo'></i>";
								html2 += "		</a>";
								html2 += "	</div>";
								html2 += "	<div class='blog-thumb-desc'>";
								html2 += "		<h3>";
								html2 += "			<a id='a2' href='http://localhost:80/rscamper-web/views/tour-all/detail.jsp?contentid="+ data.contentid +"&contenttypeid="+ data.contenttypeid +"'>"+ data.addr1 +"</a>";
								html2 += "		</h3>";
								html2 += "		<p style='font-size: 14px; color: #bbb; margin-bottom: 3px;'>"+ data.title +"</p>";
								html2 += "		<div style='font-size: 18px; color: #999'>";
		//						html2 += "				<i data-original-title='Instagram' class='rounded-x social_instagram'></i> "+ Math.floor(Math.random() * 100) + 1 +"개의 포스트";
								html2 += "				<i class='fa fa-commenting'></i> <span style='font-size: 13px; color: #999'>"+ Math.floor(Math.random() * 100) + 1 +"개의  포스트</span>";
								html2 += "		</div>";
								html2 += "	</div>";
								html2 += "</div>";
							}
						}
						foodList.html(html2);
						
					if(data.contenttypeid == 32){
					//	console.log(data.contenttypeid);
							if(data.status == 'on'){
					//			console.log(data);
							html3 += "<div class='blog-thumb margin-bottom-20'>";
							html3 += "	<div class='blog-thumb-hover'>";
							html3 += "		<img src="+ data.firstimage +" style='width: 160px; height: 150px;'>";
							html3 += "		<a class='hover-grad' href='#'>";
							html3 += "			<i class='fa fa-photo'></i>";
							html3 += "		</a>";
							html3 += "	</div>";
							html3 += "	<div class='blog-thumb-desc'>";
							html3 += "		<h3 style='font-family: 'Open Sans', Arial, sans-serif; color: #555;'>";
							html3 += "			<a id='a3' href='http://localhost:80/rscamper-web/views/tour-all/detail.jsp?contentid="+ data.contentid +"&contenttypeid="+ data.contenttypeid +"'>"+ data.addr1 +"</a>";
							html3 += "		</h3>";
							html3 += "		<p style='font-size: 14px; color: #bbb; margin-bottom: 3px;'>"+ data.title +"</p>";
							html3 += "		<div style='font-size: 18px; color: #999'>";
		//					html3 += "				<i data-original-title='Instagram' class='rounded-x social_instagram'></i> "+ Math.floor(Math.random() * 100) + 1 +"개의 포스트";
							html3 += "				<i class='fa fa-commenting'></i> <span style='font-size: 13px; color: #999'>"+ Math.floor(Math.random() * 100) + 1 +"개의  포스트</span>";
							html3 += "		</div>";
							html3 += "	</div>";
							html3 += "</div>";
						}
					}
					lodegeList.html(html3);
				}	
			},
			err : function() {
				alert("에러");
			}
		});

		var tourPlanList = $("#tourPlanList");
		var html5 = "";
		$.ajax({
			url : myConfig.serverUrl + "/tourPlan/select/tourPlanList/likeCnt",
			dataType : "json",
			type : "GET",
			success : function(result) {
				console.log("here~~~~");
				console.dir(result);
				var count=0;
				for(var i = 0; i < result.length; i++) {
					var data = result[i];
					html5 += "<div class='col-md-4' style='height: 300px; margin-top: 10px; padding: 0 5px;'>";
		//			html5 += "<div class='thumbnails thumbnail-style thumbnail-kenburn' style='border: 1px solid #e0e0e0; background-color: rgba(0, 0, 0, 0.05)'>";
					html5 += "<div class='thumbnails thumbnail-style thumbnail-kenburn' style='border: 1px solid #F0F0F0;'>";
					html5 += "	<div class='thumbnail-img'>";
					html5 += "		<div class='overflow-hidden'>"; 
					
					if (data.filePath) {
						html5 += "			<img class='img-responsive' src="+ data.filePath +" style='width: 218px; height: 180px;'>";
					} else {
						html5 += "			<img class='img-responsive' src='http://lorempixel.com/218/180/city/"+ (count++) +"' style='width: 218px; height: 180px;'>";
					}
					html5 += "		</div>";
					html5 += "			<a class='btn-more hover-effect' href='#'>자세히</a>";
					html5 += "	</div>";
					html5 += "	<div class='caption'>";
					html5 += "		<div class='caption-title'>";
					html5 += "			<h3 style='margin: 0; line-height: 1.2; font-weight: bold;'>";
					html5 += "				<a class='hover-effect' href='plan/detail.jsp?recordNo="+ data.recordNo +"'>"+ data.title +"</a>";
					html5 += "			</h3>";
					html5 += "		</div>";
		//			html5 += "		<p style='margin-top: 13px; color: #999;'>"+ data.displayName +"<span class='glyphicon glyphicon-flag' style='color: #999'>"    + data.period +"</span></p>";
					html5 += "		<p style='margin-top: 13px; color: #999;'>"+ data.displayName +"   |   "+ data.period +"</p>";
					html5 += "</div>";
					html5 += "</div>";
					html5 += "</div>";
					
					tourPlanList.html(html5);
				}
			},
			err : function() {
				alert("에러");
			}
		});

	// 출발역, 도착역 ajax 처리
	var projects = new Array();
	
		$.ajax({
			url : myConfig.serverUrl + "/main/mainTrainList",
			dataType : "json",
			type : "GET",
			success: function(result) {
	//			console.log("기차 :")
	//			console.log(result);
				
				autocompleteFn(result);
			},
			err: function() {
				alert("에러");
			}
		});
		// obj 객체 넣기
		function autocompleteFn(obj) {
			for (var i = 0; i < obj.length; i++) {
				var item = obj[i];
				var project = new Object();
				project.value = item.trainId;
				project.label = item.stationTitle;
				projects.push(project);
			}
			
	//		console.log("projects : ");
	//		console.dir(projects);
		} 
	
		// 출발역 autocomplete
		$(function() {
			$("#startStation").autocomplete({
				minLength : 0,
				source : projects,
				focus : function(event, ui) {
				//	console.log("focus");
					$("#startStation").val(ui.item.label);
					return false;
				},
				select : function(event, ui) {
				//	console.log("select");
					$("#startStation").val(ui.item.label);
					$("#startStation-id").val(ui.item.value);
					return false;
				}
			}).autocomplete("instance")._renderItem = function(ul, item) {
				//console.log("instance");
				return $("<li>").append(
						"<div>" + item.label + "</div>").appendTo(ul);
			};
	
		});
		// 도착역 autocomplete
		$(function() {
			$("#arriveStation").autocomplete({
				minLength : 0,
				source : projects,
				focus : function(event, ui) {
					//console.log("focus");
					$("#arriveStation").val(ui.item.label);
					return false;
				},
				select : function(event, ui) {
				//console.log("select");
					$("#arriveStation").val(ui.item.label);
					$("#arriveStation-id").val(ui.item.value);
					return false;
				}
			}).autocomplete("instance")._renderItem = function(ul, item) {
				//console.log("instance");
				return $("<li>").append(
						"<div>" + item.label + "</div>").appendTo(ul);
			};
	
		});

// 조회버튼  
	function mainTimeSearch(dd) {
		var trainGradeCode = $("input[name=trainGradeCode]:checked").val();
		var depPlaceId = $("input[name=depPlaceId]").val();
		var arrPlaceId = $("input[name=arrPlaceId]").val();
		var depPlandTime = $("input[name=depPlandTime]").val();
		var numOfRows = $("input[name=numofRows]").val();
		var pageNo = $("input[name=pageNo]").val();
		var startPage = $("input[name=startPage]").val();
		var pageSize = $("input[name=pageSize]").val();
		var depPlandTime = depPlandTime.split('-');
		var depPlandTime = depPlandTime[0] + depPlandTime[1]
				+ depPlandTime[2];
		
		var obj = new Object();
		obj.trainGradeCode = trainGradeCode;
		obj.depPlaceId = depPlaceId;
		obj.arrPlaceId = arrPlaceId;
		obj.depPlandTime = depPlandTime;
		obj.numOfRows = 999;
		obj.pageNo = 1;
		obj.startPage = 1;
		obj.pageSize = 999;
		
		location.href = myConfig.webServerUrl + "/rscamper-web/views/train/trainInfo.jsp?trainGradeCode="+ obj.trainGradeCode +"&depPlaceId="+ obj.depPlaceId +"&arrPlaceId="+ obj.arrPlaceId +"&depPlandTime="+ obj.depPlandTime +"&numOfRows="+ obj.numOfRows +"&pageNo="+ obj.pageNo +"&startPage="+ obj.startPage +"&pageSize="+ obj.pageSize +"";
	}


