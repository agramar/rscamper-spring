<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../assets/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=baa252939d1c912aaac343a434ff0cc4"></script>
</head>
<body>
	<div id="message"></div>
	
	<script>
	function googleapisView() {
	    var address = encodeURIComponent('목포역');
	    var geocode = "http://maps.googleapis.com/maps/api/geocode/json?address="+address+"&sensor=false";
	    jQuery.ajax({
	        url: geocode,
	        type: 'POST',
	           success: function(myJSONResult){
	                    if(myJSONResult.status == 'OK') {
	                        var tag = "";
	                        var i;
	                        for (i = 0; i < myJSONResult.results.length; i++) {
	                          tag += "주소 : " +myJSONResult.results[i].formatted_address+" <br />";
	                          tag += "위도 : " +myJSONResult.results[i].geometry.location.lat+" <br />";
	                          tag += "경도 : " +myJSONResult.results[i].geometry.location.lng+" <br />";
	                        }
	                        document.getElementById("message").innerHTML = tag;
	                    } else if(myJSONResult.status == 'ZERO_RESULTS') {
	                        alert("지오코딩이 성공했지만 반환된 결과가 없음을 나타냅니다.\n\n이는 지오코딩이 존재하지 않는 address 또는 원격 지역의 latlng을 전달받는 경우 발생할 수 있습니다.")
	                    } else if(myJSONResult.status == 'OVER_QUERY_LIMIT') {
	                        alert("할당량이 초과되었습니다.");
	                    } else if(myJSONResult.status == 'REQUEST_DENIED') {
	                        alert("요청이 거부되었습니다.\n\n대부분의 경우 sensor 매개변수가 없기 때문입니다.");
	                    } else if(myJSONResult.status == 'INVALID_REQUEST') {
	                        alert("일반적으로 쿼리(address 또는 latlng)가 누락되었음을 나타냅니다.");
	                    }
	            }
	    });
	}
	googleapisView();
	</script>
</body>
</html>