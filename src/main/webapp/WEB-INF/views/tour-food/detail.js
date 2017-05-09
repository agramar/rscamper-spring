	var user = sessionStorageService.getObject("user");	

	function apiAjax(obj) {
		$.ajax({
			type : "GET",
			url : myConfig.serverUrl + "/tour/api/detail",
			dataType : 'json',
			data : obj,
			error : function(err) {
				alert("에러");
			},
			success : function(result) {
				var data = JSON.parse(result);
				console.dir(data);
				contentCreate(data);
			}
		});
	}
	
	
	function contentCreate(data) {
		console.log("contentCreate");
		var data1 = JSON.parse(data[0]);
		var data2 = JSON.parse(data[1]);
		var data3 = JSON.parse(data[2]);
		var data4 = JSON.parse(data[3]);
		
		var item1 = data1.response.body.items.item;
		var item2 = data2.response.body.items.item;
		var item3 = data3.response.body.items.item;
		var item4 = data4.response.body.items.item;
		
		// 제목
		$("#text-title").html($("#text-title").html() + item1.title);
		
		// 주소
		$("#text-address").html(item1.addr1 + " " + item1.addr2);
		
		// 홈페이지
		if (!item1.homepage) {
			item1.homepage = "정보가 없습니다";
		}
		$("#text-homepage").html(item1.homepage);
		
		// 개요
		console.log(item1);
		$("#text-content").html(item1.overview);
		
		// 이용안내
		tag = "";
		var item3tag = "";
		var tags = [];
		var phone;
		switch (item2.contenttypeid) {
		case 12:
			phone = item2.infocenter;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 신용카드 가능 여부</strong><p class='info-custom'>" + item2.chkcreditcard + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 체험안내</strong><p class='info-custom'> " + item2.expguide + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 쉬는날</strong><p class='info-custom'>" + item2.restdate + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 이용시기</strong><p class='info-custom'>" + item2.useseason + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 이용시간</strong><p class='info-custom'>" + item2.usetime + "</p>");
			break;                                               
		case 14:
			phone = item2.infocenterculture;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 신용카드 가능 여부 </strong><p class='info-custom'>" + item2.chkcreditcardculture + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 할인정보</strong><p class='info-custom'>" + item2.discountinfo + "</p>");               
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 쉬는날</strong><p class='info-custom'>" + item2.restdateculture + "</p>");             
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 이용요금</strong><p class='info-custom'>" + item2.usefee + "</p>");                     
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 이용시간</strong><p class='info-custom'>" + item2.usetimeculture + "</p>");             
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 관람 소요시간</strong><p class='info-custom'>" + item2.spendtime + "</p>");               
			break;
		case 15:
			phone = item2.sponsor1 + " " + item2.sponsor1tel;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 예매처</strong><p class='info-custom'>" + item2.bookingplace + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 할인정보</strong><p class='info-custom'>" + item2.discountinfofestival + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 행사 시작일</strong><p class='info-custom'>" + item2.eventstartdate + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 행사 종료일</strong><p class='info-custom'>" + item2.eventenddate + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 축제 등급</strong><p class='info-custom'>" + item2.festivalgrade + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 행사 장소</strong><p class='info-custom'>" + item2.eventplace + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 행사장 위치 안내</strong><p class='info-custom'>" + item2.placeinfo + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 공연시간</strong><p class='info-custom'>" + item2.placetime + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 행사 프로그램</strong><p class='info-custom'>" + item2.program + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 관람 소요 시간</strong><p class='info-custom'>" + item2.spendtimefestival + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 이용요금</strong><p class='info-custom'>" + item2.usetimefestival + "</p>");
			break;                                               
		case 25:
			phone = item2.infocentertourcourse;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 코스 총 거리</strong><p class='info-custom'>" + item2.distance + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 코스 일정</strong><p class='info-custom'>" + item2.schedule + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 코스 총 소요시간</strong><p class='info-custom'>" + item2.taketime + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 코스 테마</strong><p class='info-custom'>" + item2.theme + "</p>");
			break;
		case 28:
			phone = item2.infocenterleports;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 신용카드 가능 여부</strong><p class='info-custom'>" + item2.chkcreditcardleports + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 개장기간</strong><p class='info-custom'>" + item2.openperiod + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 예약안내</strong><p class='info-custom'>" + item2.reservation + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 쉬는날</strong><p class='info-custom'>" + item2.restdateleports + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 입장료</strong><p class='info-custom'>" + item2.usefeeleports + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 이용시간</strong><p class='info-custom'>" + item2.usetimeleports + "</p>");
			break;
		case 32:
			phone = item2.infocenterlodging;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 입실 시간</strong><p class='info-custom'>" + item2.checkintime + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 퇴실 시간</strong><p class='info-custom'>" + item2.checkouttime + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 굿스테이 여부</strong><p class='info-custom'>" + (item2.goodstay == 1 ? "<i class='fa fa-circle-o'></i>" : "<i class='fa fa-times'></i>") + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 픽업 서비스</strong><p class='info-custom'>" + item2.pickup + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 예약안내</strong><p class='info-custom'>" + item2.reservationlodging + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 예약안내 홈페이지</strong><p class='info-custom'>" + item2.reservationurl + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 자전거 대여 여부</strong><p class='info-custom'>" + (item2.bicycle == 1 ? "<i class='fa fa-circle-o'></i>" : "<i class='fa fa-times'></i>") + "</p>");
			break;
		case 38:
			phone = item2.infocentershopping;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 신용카드 사용 여부</strong><p class='info-custom'>" + item2.chkcreditcardshopping + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 장서는 날</strong><p class='info-custom'>" + item2.fairday + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 개장일</strong><p class='info-custom'>" + item2.opendateshopping + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 영업시간</strong><p class='info-custom'>" + item2.opentime + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 쉬는날</strong><p class='info-custom'>" + item2.restdateshopping + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 화장실 설명</strong><p class='info-custom'>" + item2.restroom + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 판매 품목</strong><p class='info-custom'>" + item2.saleitem + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 판매 품목별 가격</strong><p class='info-custom'>" + item2.saleitemcost + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 매장안내</strong><p class='info-custom'>" + item2.shopguide + "</p>");
			break;
		case 39:
			phone = item2.infocenterfood;
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 신용카드 사용 여부</strong><p class='info-custom'>" + item2.chkcreditcardfood + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 할인정보</strong><p class='info-custom'>" + item2.discountinfofood + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 대표 메뉴</strong><p class='info-custom'>" + item2.firstmenu + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 영업시간</strong><p class='info-custom'>" + item2.opentimefood + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 포장 가능 여부</strong><p class='info-custom'>" + item2.packing + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 예약안내</strong><p class='info-custom'>" + item2.reservationfood + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 쉬는날</strong><p class='info-custom'>" + item2.restdatefood + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 규모</strong><p class='info-custom'>" + item2.scalefood + "</p>");
			tags.push("<strong><i class='fa fa-check color-yellow'></i> 취급 메뉴</strong><p class='info-custom'>" + item2.treatmenu + "</p>");
			break;
		}
		for (var i = 0; i < tags.length; i++) {
			if(tags[i].indexOf('undefined') < 1) {
				if (tags[i].substr(-6) != '> </p>' && tags[i].substr(-6) != "'></p>") tag += tags[i];
			}
		}
		$("#text-info").html(tag);
		
		// 연락처
		var tag = "<li>";
		tag += "<i class='icon-custom icon-sm rounded-x icon-bg-yellow glyphicon glyphicon-earphone'></i><strong class='strong-custom'> 연락처</strong>";
		tag += "<p class='p-custom'>" + phone + "</p>";
		tag += "</li>";
		$("#ul-info").append(tag);
		
		// 부가정보
		console.log(item3);
		var item3tag = "";
		switch (item2.contenttypeid) {
		case 25:
			for (var i = 0; i < item3.length; i++) {
				item3tag += "<strong><i class='fa fa-check color-yellow'></i> " + item3[i].subname + "</strong>";
				item3tag += "<p class='info-custom'>" + item3[i].subdetailoverview + "</p>";
			}
			break;
		case 32:
			for (var i = 0; i < item3.length; i++) {
				item3tag += "<strong><i class='fa fa-check color-yellow'></i> " + item3[i].roomtitle + "</strong>";
				item3tag += "<p class='info-custom'>비수기 주중 " + item3[i].roomoffseasonminfee1 + "원/주말 " + item3[i].roomoffseasonminfee2 + "원<br>"
				+ "성수기 주중 " + item3[i].roompeakseasonminfee1 +"원/주말 " + item3[i].roompeakseasonminfee2 + "원</p>";
				if (item3[i].roomintro) {
					item3tag += "<p class='info-custom'>" + item3[i].roomintro + "</p>";
				} else {
					item3tag += "<br>";
				}
			}
			break;
		default:
			if (item3.length) {
				for (var i = 0; i < item3.length; i++) {
					item3tag += "<strong><i class='fa fa-check color-yellow'></i> " + item3[i].infoname.replace(/ /gi, '') + "</strong>";
					item3tag += "<p class='info-custom'>" + item3[i].infotext + "</p>";
				}
			} else {
				item3tag += "<strong><i class='fa fa-check color-yellow'></i> " + item3.infoname.replace(/ /gi, '') + "</strong>";
				item3tag += "<p class='info-custom'>" + item3.infotext + "</p>";
			}
			break;
		}
		
		$("#text-plusInfo").html(item3tag);
		
		// contentid 저장하기
		$("#contentid").val(item1.contentid);
		
		// 이미지 동적 생성
		imageProcess(item4);
	}
	
	var endpage = 0;
	
	function imageProcess(item) {
		var mainImg = $(".ms-brd");
		var panel = $(".bottom_slider_panel");
		var html = "";
		
		var widthPx = item.length * 120;
		panel.css("width", widthPx + "px");
		
		for (var i = 0; i < item.length; i++) {
			var m = item[i];
			if (i == 0) { mainImg.attr("src", m.originimgurl); }
			
			html += "<img src='" + m.originimgurl + "' class='bottom_slider_image' onclick='imageFnc(this)' style='width: 100px; height: 75px; float: left; margin: 5px 5px'>";
		}
		
		var portion = parseInt(item.length / 4);
		
		if (item.length % 4 != 0) {
			portion += 1;
		}
		
		endpage = portion;
		panel.html(html);
	}
	
	
	var locationVal = 1;
	
	function bottomMove(flag) {
		var w = 0;
		if (flag == 1) {
			if (locationVal == 1) {
				locationVal = 1;
			} else {
				locationVal -= 1;
			}
			w = - (locationVal - 1) * 440; 
		} else {
			if (locationVal == endpage) {
				locationVal = endpage;
			} else {
				locationVal += 1;
			}
			w = - (locationVal - 1) * 440; 
		}
		
		$('.bottom_slider_panel').animate({ left: w}, 'slow');
	}
	
	function imageFnc(e) {
		 $(".ms-brd").attr("src", e.src); 
	}
	
