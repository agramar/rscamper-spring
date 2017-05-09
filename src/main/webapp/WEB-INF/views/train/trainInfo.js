		// TrainMap 부분
		// 화면에 맵나타나고
		var map;
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 37.53196, //37.5665350
					lng : 126.98895   //126.9779690
				},
				zoom : 6
			});
		}
		
	// 지도맵 조인 버튼
	var markers = [];
	var paths = [];
	function trainLinBtn(e) {
		var trainVal = e.dataset.val;
		$.ajax({
			url : myConfig.homeUrl + "/trainMap/trainMapLine",
			dataType : "json",
			type : "GET",
			success : function(result) {
				var latLngArr = [];
				var mapArr = [];
				var count = 0;
				clearMarkers();
				clearPaths();
				console.log(result);
				for (var i = 0; i < result.length; i++) {
					var data = result[i];
					if (data.train_type == trainVal) {
						var latLng = new google.maps.LatLng(
								data.mapLatitude, data.mapLongitude);
						latLngArr[latLngArr.length] = latLng; // latLng 배열에 담기.
						//		console.log(data.mapLatitude);
						//		console.log(data.mapLongitude);
						
						var mapObj = {
								lat: 0,
								lng: 0
						}
						mapObj.lat = data.mapLatitude;
						mapObj.lng = data.mapLongitude;
						mapArr.push(mapObj);
						
						// 아이콘 변경
						var myIcon = new google.maps.MarkerImage(
								"train3.png", null, null, null,
								new google.maps.Size(45, 45));
							
						// 마커 찍어주기	
						var marker = new google.maps.Marker({
							position : {
								lat : parseFloat(data.mapLatitude),
								lng : parseFloat(data.mapLongitude)
							},
							draggable : false,
							icon : myIcon,
							animation : google.maps.Animation.DROP,
//							map : map,
						});
						
						// 맵 줌인 첨과 끝
						
//						bounds = new google.maps.LatLngBounds();
//							for (var i=0; i < markers.length; i++) {
//								bounds.extend(mapArr[i]);
//						}
//								map.fitBounds(bounds);
//								console.log("eee", bounds);
						
						count++;
						
						// 선긋기
						var flightPath = new google.maps.Polyline({
							path : latLngArr,
							strokeColor : e.dataset.color,
							strokeOpacity : 1.0,
							strokeWeight : 6
						});
						flightPath.setMap(map);
						paths.push(flightPath);
					}
						var contentString = data.mapStationTitle;
						var infowindow = new google.maps.InfoWindow({
							content : contentString
					});

						function addMarkerWithTimeout(mapArr, timeout, map) {
						  window.setTimeout(function() {
						   var marker = new google.maps.Marker({
						      position: {
									lat : parseFloat(mapArr.lat),
									lng : parseFloat(mapArr.lng)
								},
								draggable : false,
								icon : myIcon,
								animation : google.maps.Animation.DROP,
								map : map,
								title : data.mapStationTitle
						    });
						   console.log("e",data.mapStationTitle);
						   markers.push(marker);
						   marker.setMap(map);
						   marker.addListener('click', function() {
							   infowindow.open(map ,marker);
						   });
						   
						  }, timeout);
						
						}
					}
						
						function drop(mapArr, map) {
							clearMarkers();
						  for (var i = 0; i < mapArr.length; i++) {
						    addMarkerWithTimeout(mapArr[i], i * 70, map);
						  }
						}
						drop(mapArr, map);
				},
				err : function() {
					alert("에러");
				}
			});

		}

		// 마커지우기	
		function clearMarkers() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}
		
		// 폴리라인지우기
		function clearPaths() {
			for (var i = 0; i < paths.length; i++) {
				paths[i].setMap(null);
			}
			paths = [];
		}
	
	// 시간표 부분	
	function joinBtn() {
		$("#timeList").modal('show');
		var trainGradeCode = $("input[name=trainRadio]:checked").val();
		var depPlaceId = $("input[name=start]").val();
		var arrPlaceId = $("input[name=arrive]").val();
		var depPlandTime = $("input[name=calender]").val();
		var numOfRows = $("input[name=numofRows]").val();
		var pageNo = $("input[name=pageNo]").val();
		var startPage = $("input[name=startPage]").val();
		var pageSize = $("input[name=pageSize]").val();
		var depPlandTime = depPlandTime.split('-');
		var depPlandTime = depPlandTime[0] + depPlandTime[1]
				+ depPlandTime[2];

		console.log(trainGradeCode);

		var obj = new Object();
		obj.trainGradeCode = trainGradeCode;
		obj.depPlaceId = depPlaceId;
		obj.arrPlaceId = arrPlaceId;
		obj.depPlandTime = depPlandTime;
		obj.numOfRows = 999;
		obj.pageNo = 1;
		obj.startPage = 1;
		obj.pageSize = 999;

		console.dir(obj);

		$.ajax({
			url : myConfig.homeUrl + "/trainTime/time",
			type : "GET",
			dataType : 'json',
			data : obj,
			err : function() {
				console.log(err);
			},
			success : function(data) {
				console.log("wwrj",data);
				var data = JSON.parse(data);
				timeList(data);

			}
		});
	}
	// 시간표 모달창 ajax
	function timeList(data) {

		var item = data.response.body.items.item;
		var fail = data.response.body.items;
		var timeList = $("#timeList");
		var html = "";
		
		html += "<table class='table table-responsive'>";
		html += "<thead>";
		html += "	<tr>";
		html += "		<td>출발역</td>";
		html += "		<td>출발시간</td>";
		html += "		<td>도착역</td>";
		html += "		<td>도착시간</td>";
		html += "		<td>열차종류</td>";
		html += "	</tr>";
		html += "</thead>"
		html += "<tbody>"
		
		for (var i = 0; i < item.length; i++) {
			var t = item[i];
//			console.log(t);
//			console.log(t.depplandtime);

			var dyear = t.depplandtime.toString().substring(0,4);
			var dmonth = t.depplandtime.toString().substring(4,6);
			var dday = t.depplandtime.toString().substring(6,8);
			var dhour = t.depplandtime.toString().substring(8,10);
			var dmin = t.depplandtime.toString().substring(10,12);
			var dsec = t.depplandtime.toString().substring(12,14);
			
			var ayear = t.arrplandtime.toString().substring(0,4);
			var amonth = t.arrplandtime.toString().substring(4,6);
			var aday = t.arrplandtime.toString().substring(6,8);
			var ahour = t.arrplandtime.toString().substring(8,10);
			var amin = t.arrplandtime.toString().substring(10,12);
			var asec = t.arrplandtime.toString().substring(12,14);

			html += "<tr>";
			html += "	<td>" + t.depplacename + "</td>";
			html += "	<td>" + dyear +"년"+dmonth +"월"+dday+"일"+dhour+"시"+dmin+"분"+dsec+"초"+ "</td>";
			html += "	<td>" + t.arrplacename + "</td>";
			html += "	<td>" + ayear +"년"+amonth +"월"+aday+"일"+ahour+"시"+amin+"분"+asec+"초"+ "</td>";
			html += "	<td>" + t.traingradename + "</td>";
			html += "</tr>";

		}
		html += "</tbody>";
		html += "</table>";
		console.log(t.depplandtime);
//		$("tbody").html($("tbody").html() + html);
		//		timeList.html(html);
		$("#bodyTime2").html(html);
//		$("#timeList").modal('show');
	}
	
	// 역별 조회
	function ajaxList() {
			$.ajax({
					url : myConfig.homeUrl + "/trainTime/trainTimeList",
					dataType : "json",
					type : "GET",
					success : function(result) {
						var trainSelect = "";
						var qwer = $("input[name=trainRadio]:checked").val();

						console.log(qwer);
						if (typeof qwer == "undefined") {
							alert("열차를 선택하여 주세요.");
							return false;
						}

						var trainVal = "";
						switch (qwer) { // 눌럿을때 value값을 넣기
						case "01":
							trainVal = "trainSaemaeul";
							break;
						case "02":
							trainVal = "trainMugunghwa";
							break;
						case "03":
							trainVal = "trainTonggeun";
							break;
						case "04":
							trainVal = "trainNuriro";
							break;
						case "09":
							trainVal = "trainItxchungchun";
							break;
						case "08":
							trainVal = "trainItxsaemaeul";
							break;
						}
						
						console.log("trainVal : ");	
						console.log(trainVal);	
						
						// 주요역
						var html = "";
//						html += "<table width='90%' border='1' align='center' cellpadding='5' cellspacing='5' style='box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; max-width: 100%; color: rgb(0, 0, 0); font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif; font-size: 16px; line-height: 32px; border: 1px solid grey;'>";
						html += "<table class='table table-bordered'>";
						console.log(result.length);
						for (var i = 0; i < result.length; i++) {
							var data = result[i];

							if (data.stationVital > 0) {
								if (i % 5 == 0) {
									html += "<tr>";
								}
								
							switch (trainVal) { // 눌럿을때 value값을 넣기
							// 새마을
							case "trainSaemaeul":
								console.log("case : trainSaemaeul");
								if (data.trainSaemaeul > 0) {
									html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// 무궁화	
							case "trainMugunghwa":
								console.log("case : trainMugunghwa");
								if (data.trainMugunghwa > 0) {
									html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// 통근	
							case "trainTonggeun":
								console.log("case : trainTonggeun");
								if (data.trainTonggeun > 0) {
									html += "<td align='center' style='background: #df598e; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a align='center'></td>";
								} else {
									html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// 누리로	
							case "trainNuriro":
								console.log("case : trainNuriro");
								if (data.trainNuriro > 0) {
									html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
								}
								break; 
							//	itx청춘
							case "trainItxchungchun":
								console.log("case : trainItxchungchun");
								if (data.trainItxchungchun > 0) {
									html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							// itx새마을	
							case "trainItxsaemaeul":
								console.log("case : trainItxsaemaeul");
								if (data.trainItxsaemaeul > 0) {
									html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</a></td>";
								} else {
									html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
											+ data.stationTitle
											+ "</p></td>";
								}
								break;
							}
							
								if (i % 5 == 4) {
									html += "</tr>";
								}
							}
						}
						html += "</table>";
						$("#bodyTime1").html(html);

						html = "<div id='sort'>";
						html = "<ul style='overflow: hidden; height:40px; padding:8px 0 0 5px; margin-bottom: 20px; border: 2px solid orange; list-style: none;'>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄱ\")'>가</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄴ\")'>나</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄷ\")'>다</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄹ\")'>라</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅁ\")'>마</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅂ\")'>바</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅅ\")'>사</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅇ\")'>아</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅈ\")'>자</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅊ\")'>차</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅋ\")'>카</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅌ\")'>타</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅍ\")'>파</div></li>";
						html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅎ\")'>하</div></li>";
						html += "</ul>";
						html += "</div>";

						// 철도역
//						html += "<table width='90%' border='1' align='center' cellpadding='5' cellspacing='5' style='box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; max-width: 100%; color: rgb(0, 0, 0); font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif; font-size: 16px; line-height: 32px; border: 1px solid grey;'>";
						html += "<table class='table table-bordered'>";
						console.log(result)

						var trainVal = "";
						switch (qwer) { // 눌럿을때 value값을 넣기
						case "01":
							trainVal = "trainSaemaeul";
							break;
						case "02":
							trainVal = "trainMugunghwa";
							break;
						case "03":
							trainVal = "trainTonggeun";
							break;
						case "04":
							trainVal = "trainNuriro";
							break;
						case "09":
							trainVal = "trainItxchungchun";
							break;
						case "08":
							trainVal = "trainItxsaemaeul";
							break;
						}
						
						for (var j = 0; j < result.length; j++) {
							var data = result[j];
							if (data.stationVital == 0) {
								console.log(data);
								//	console.log(data.stationTitle); 들어왓고

								if ((j-2) % 5 == 0) {
									html += "<tr>";
								}
								
								switch (trainVal) { // 눌럿을때 value값을 넣기
								// 새마을
								case "trainSaemaeul":
									console.log("case : trainSaemaeul");
									if (data.trainSaemaeul > 0) {
										html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</a></td>";
									} else {
										html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</p></td>";
									}
									break;
								// 무궁화	
								case "trainMugunghwa":
									console.log("case : trainMugunghwa");
									if (data.trainMugunghwa > 0) {
										html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</a></td>";
									} else {
										html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</p></td>";
									}
									break;
								// 통근	
								case "trainTonggeun":
									console.log("case : trainTonggeun");
									if (data.trainTonggeun > 0) {
										html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</a></td>";
									} else {
										html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</p></td>";
									}
									break;
								// 누리로	
								case "trainNuriro":
									console.log("case : trainNuriro");
									if (data.trainNuriro > 0) {
										html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</a></td>";
									} else {
										html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</p></td>";
									}
									break; 
								//	itx청춘
								case "trainItxchungchun":
									console.log("case : trainItxchungchun");
									if (data.trainItxchungchun > 0) {
										html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</a></td>";
									} else {
										html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</p></td>";
									}
									break;
								// itx새마을	
								case "trainItxsaemaeul":
									console.log("case : trainItxsaemaeul");
									if (data.trainItxsaemaeul > 0) {
										html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</a></td>";
									} else {
										html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
												+ data.stationTitle
												+ "</p></td>";
									}
									break;
								}

								if (j % 5 == 1) {
									html += "</tr>";
								}
							}
						}
						html += "</table>";
						$(".modal-footer").html(html);

						$('#trainModal').modal('show');
				},
				err : function() {
					alert("오류");
			}
		});

	}

		function ajaxSort(data) {
			console.log(data);
			
			var obj = new Object();
			obj.data = data;
			
			$.ajax({
				url : myConfig.homeUrl + "/trainTime/trainSearch",
				dataType : "json",
				type : "GET",
				data : obj,
				success : function(result) {
					var html = "";
							
					html = "<div id='sort'>";
					html = "<ul style='overflow: hidden; height:40px; padding:8px 0 0 5px; margin-bottom: 20px; border: 2px solid orange; list-style: none;'>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄱ\")'>가</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄴ\")'>나</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄷ\")'>다</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㄹ\")'>라</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅁ\")'>마</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅂ\")'>바</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅅ\")'>사</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅇ\")'>아</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅈ\")'>자</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅊ\")'>차</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅋ\")'>카</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅌ\")'>타</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅍ\")'>파</div></li>";
					html += "<li style='margin: 0; padding: 0; border : 0; float: left; width: 7%; cursor:pointer; font-weight: bold;'><div id='sorta' onclick = 'ajaxSort(\"ㅎ\")'>하</div></li>";
					html += "</ul>";
					html += "</div>";
					
					var qwer = $("input[name=trainRadio]:checked").val();
	//				html += "<table width='90%' border='1' align='center' cellpadding='5' cellspacing='5' style='box-sizing: border-box; border-collapse: collapse; border-spacing: 0px; max-width: 100%; color: rgb(0, 0, 0); font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif; font-size: 16px; line-height: 32px; border: 1px solid grey;'>";
					html += "<table class='table table-bordered'>";
					console.log("qwer 여기다 :");
					console.log(qwer);
	
					var trainVal = "";
					switch (qwer) { // 눌럿을때 value값을 넣기
					case "01":
						trainVal = "trainSaemaeul";
						break;
					case "02":
						trainVal = "trainMugunghwa";
						break;
					case "03":
						trainVal = "trainTonggeun";
						break;
					case "04":
						trainVal = "trainNuriro";
						break;
					case "09":
						trainVal = "trainItxchungchun";
						break;
					case "08":
						trainVal = "trainItxsaemaeul";
						break;
					}
					
					for (var j = 0; j < result.length; j++) {
					var data = result[j];
						console.log(data);
						if (j % 5 == 0) {
							html += "<tr>";
						}
					
						switch (trainVal) { // 눌럿을때 value값을 넣기
						// 새마을
						case "trainSaemaeul":
							console.log("case : trainSaemaeul");
							if (data.trainSaemaeul > 0) {
								html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// 무궁화	
						case "trainMugunghwa":
							console.log("case : trainMugunghwa");
							if (data.trainMugunghwa > 0) {
								html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// 통근	
						case "trainTonggeun":
							console.log("case : trainTonggeun");
							if (data.trainTonggeun > 0) {
								html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// 누리로	
						case "trainNuriro":
							console.log("case : trainNuriro");
							if (data.trainNuriro > 0) {
								html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
									+ data.stationTitle
									+ "</p></td>";
							}
							break; 
						//	itx청춘
						case "trainItxchungchun":
							console.log("case : trainItxchungchun");
							if (data.trainItxchungchun > 0) {
								html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						// itx새마을	
						case "trainItxsaemaeul":
							console.log("case : trainItxsaemaeul");
							if (data.trainItxsaemaeul > 0) {
								html += "<td align='center' style='background: #FF4500; width: 105px; font-weight: bold;'><a style='color: white' href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</a></td>";
							} else {
								html += "<td align='center' style='width: 105px;'><p href='javascript:void(0)' onClick='stationFn(this)'>"
										+ data.stationTitle
										+ "</p></td>";
							}
							break;
						}
	
						if (j % 5 == 4) {
							html += "</tr>";
						}
					}
				html += "</table>";
				$(".modal-footer").html(html);
					
			},
			err : function() {
				alert("오류");
			}
		});
	}

//		   ------ input창에 text넣기 -------

	var result = true;

	function startBtn() {
		ajaxList();
		// 		$('#trainModal').modal('show');
	};
	function arriveBtn() {
		$('#trainModal').modal('show');
		result = false;
	};

	function stationFn(e) {
		//			alert(e.text);
		if (result) {
			$('#startInput').val(e.text);
		} else {
			$('#arriveInput').val(e.text);
		}
		$("#trainModal").modal('hide');

	}
	
	// 메인 모달창

	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
		var trainGradeCode = getParameterByName("trainGradeCode");
		var depPlaceId = getParameterByName("depPlaceId");
		var arrPlaceId = getParameterByName("arrPlaceId");
		var depPlandTime = getParameterByName("depPlandTime");
		var numOfRows = getParameterByName("numOfRows");
		var pageNo = getParameterByName("pageNo");
		var startPage = getParameterByName("startPage");
		var pageSize = getParameterByName("pageSize");
	
		var obj = new Object();
		obj.trainGradeCode = trainGradeCode;
		obj.depPlaceId = depPlaceId;
		obj.arrPlaceId = arrPlaceId;
		obj.depPlandTime = depPlandTime;
		obj.numOfRows = numOfRows;
		obj.pageNo = pageNo;
		obj.startPage = startPage;
		obj.pageSize = pageSize;
	
		$.ajax({
			url : myConfig.homeUrl + "/trainTime/time",
			type : "GET",
			dataType : 'json',
			data : obj,
			err : function() {
				console.log(err);
			},
			success : function(data) {
				console.log(data);
				var jdata = JSON.parse(data);
				mainTraintime(jdata);
				
				// 
				var state = { 'page_id': 1, 'user_id': 5 };
				var title = '열차정보';
				var url = 'trainInfo.jsp';
				 
				history.pushState(state, title, url)
	
			}
		});
	
		function mainTraintime(data) {
			var item = data.response.body.items.item;
			var fail = data.response.body.items;
			var mainTraintime = $("#mainTraintime");
			var html = "";
			
			html += "<table class='table table-striped'>";
			html += "<thead>";
			html += "	<tr class='success'>";
			html += "		<td>출발역</td>";
			html += "		<td>출발시간</td>";
			html += "		<td>도착역</td>";
			html += "		<td>도착시간</td>";
			html += "		<td>열차종류</td>";
			html += "	</tr>";
			html += "</thead>"
			html += "<tbody>"
			
			for (var i = 0; i < item.length; i++) {
				var t = item[i];
//				console.log("여기롥도ㅑ도햦ㄷ고햠ㄷㄱㅎ :");
//				console.log(t);
	
				var dyear = t.depplandtime.toString().substring(0,4);
				var dmonth = t.depplandtime.toString().substring(4,6);
				var dday = t.depplandtime.toString().substring(6,8);
				var dhour = t.depplandtime.toString().substring(8,10);
				var dmin = t.depplandtime.toString().substring(10,12);
				var dsec = t.depplandtime.toString().substring(12,14);
				
				var ayear = t.arrplandtime.toString().substring(0,4);
				var amonth = t.arrplandtime.toString().substring(4,6);
				var aday = t.arrplandtime.toString().substring(6,8);
				var ahour = t.arrplandtime.toString().substring(8,10);
				var amin = t.arrplandtime.toString().substring(10,12);
				var asec = t.arrplandtime.toString().substring(12,14);
	
				html += "<tr>";
				html += "	<td>" + t.depplacename + "</td>";
				html += "	<td class='active'>" + dyear +"년"+dmonth +"월"+dday+"일"+dhour+"시"+dmin+"분"+dsec+"초"+ "</td>";
				html += "	<td>" + t.arrplacename + "</td>";
				html += "	<td class='active'>" + ayear +"년"+amonth +"월"+aday+"일"+ahour+"시"+amin+"분"+asec+"초"+ "</td>";
				html += "	<td>" + t.traingradename + "</td>";
				html += "</tr>";
	
			}
			html += "</tbody>";
			html += "</table>";
	
			$("#bodyTime3").html(html);
			$("#mainTraintime").modal('show');
		}

	