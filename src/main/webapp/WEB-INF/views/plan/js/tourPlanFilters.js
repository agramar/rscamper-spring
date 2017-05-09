// 필터
angular.module("TourPlanApp")

	// 예산 타입 필터
	.filter("budgetType", function() {
		return budgetType
		function budgetType (priceType) {
			switch (priceType) {
			case 1:
				return "교통"
			case 2:
				return "음식"
			case 3:
				return "엑티비티"
			case 4:
				return "쇼핑"
			case 5:
				return "숙박"
			case 6:
				return "기타"
			}
		}
	})
	
	// 여행기 필터
	.filter("memoTypeName", function() {
		return memoTypeName
		function memoTypeName (memoType) {
			switch (memoType) {
			case 1:
				return "메모"
			case 2:
				return "여행기"
			}
		}
	})

	// 일정표 필터
	.filter("convertDate", function() {
		return convertDate
		function convertDate (scheduleDate) {
			var resultDate = scheduleDate.value.split("T");
			return resultDate[0];
		}
	})
	
	// 일정표 이벤트 색상 필터
	.filter("tourSpotColor", function() {
		return tourSpotColor
    	// contenttypeid에 따라 배경색 다르게
    	function tourSpotColor (contentTypeId) {
			switch (contentTypeId) {
			case "12":
				return "#f29e37"
			case "14":
				return "#f29e37"
			case "15":
				return "#f29e37"
			case "25":
				return "#f29e37"
			case "28":
				return "#f29e37"
			case "38":
				return "#f29e37"
			case "39" :
				return "#46c0fb"
			case "32" :
				return "#6bb130"
			}
    	}
	})

	// 여행지정보 카테고리 필터
	/** 
	* 	contentTypeId
	*  관광지 : 12, 14, 15, 25, 28
	*  음식점 : 39
	*  숙박업소 : 32
	*/
	.filter("tourSpotCategory", function() {
		return tourSpotCategory
		function tourSpotCategory (contentTypeId) {
			switch (contentTypeId) {
			case "12":
				return "관광지"
			case "14":
				return "문화시설"
			case "15":
				return "축제/공연/행사"
			case "25":
				return "여행코스"
			case "28":
				return "레포츠"
			case "38":
				return "쇼핑"
			case "39" :
				return "음식점"
			case "32" :
				return "숙박업소"
				
			case 12:
				return "관광지"
			case 14:
				return "문화시설"
			case 15:
				return "축제/공연/행사"
			case 25:
				return "여행코스"
			case 28:
				return "레포츠"
			case 38:
				return "쇼핑"
			case 39 :
				return "음식점"
			case 32 :
				return "숙박업소"
			}
		}
	})

	//성별 필터
	.filter("gender", function() {
		return gender
		function gender (gen) {
			if (gen == "m") {
				return "남자";
			} else if (gen == "f") {
				return "여자";
			}
		}
	})

	// 제공업체 필터
	.filter("provider", function() {
		return provider
		function provider (providerName) {
			switch (providerName) {
			case "twitter.com" :
				return "트위터"
			case "google.com" :
				return "구글"
			case "facebook.com" :
				return "페이스북"
			case "password" :
				return "이메일"
			}
		}
	})
	
	// ISO timezone filter
	.filter("convertISO", function () {
		return function (isoDate, dateformat) {
			return moment(isoDate).format(dateformat);
		}
	})

	// timesince 필터
	.filter('timesince', function() {
		return timeSince;
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

	});
