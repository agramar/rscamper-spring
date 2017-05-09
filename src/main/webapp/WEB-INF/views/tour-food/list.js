	// 버튼으로 바꿔버려서 전역변수로 뺏어요!!
	var typeid = "";	

	function typeChange(contenttypeid) {
		// 버튼 눌린 상태로 보이게 하려고 클래스에 active 추가/삭제
		$('button[onclick="typeChange(this)"]').removeClass('active');
		$(contenttypeid).addClass('active');
		
		typeid = $(contenttypeid).val();

    	$("select[name=cat3]:eq(0)").empty();	        	
		$("select[name=cat3]:eq(0)").append("<option value='"+typeid+"' selected>"+ contenttypeid.innerText +"</option>");
	}
	
		
	// 서비스 분류 소분류
	function getCat3List(cat2, initFlag, selectedValue){
		var index = $("select[name=cat2]").index(cat2);
	    var params = {"cat2":$(cat2).val() ,"langtype":"KOR"};	    		
	    
	    if( $(cat2).val() == ""){        	
        	$("select[name=cat3]:eq("+index+")").empty();
        	$("select[name=cat3]:eq("+index+")").append("<option value=''>소분류</option>");
	    	return;
	    }
	    
	    $.ajax({
	    	url : "http://api.visitkorea.or.kr/guide/serviceCodeAjax.do",
	        type: "post",
	        dataType: "json",
	        data : params,
	        success:function(data){
	        	$("select[name=cat3]:eq("+index+")").empty();	        	
	        	$("select[name=cat3]:eq("+index+")").append("<option value=''>소분류</option>");
	        	
	        	for(var  i = 0;  i < data.list.length; i ++){	        		
	        		if (selectedValue == data.list[i].cat3) {
	        			$("select[name=cat3]:eq("+index+")").append("<option value='"+data.list[i].cat3+"' selected>"+ data.list[i].catname3 +"</option>");
	        		} else {
	        			$("select[name=cat3]:eq("+index+")").append("<option value='"+data.list[i].cat3+"'>"+ data.list[i].catname3 +"</option>");
	        		}
	        	}
	        	
	        	if( initFlag == "N") {
	        	}else{
	        		$("select[name=cat3]:eq("+index+") > option").each(function(){	    				
	    				if( $(this).val() == selectedValue){
	    					$(this).attr("selected","selected");	    	
	    				}
	    			});	
	        	}	        	
	        },
			error:function(args){
				alert("serviceCodeAjax2:error:"+request+"status:"+status+"error:"+error);
			}
	    });
	}		
		
		
	function tourList(e) {
		var contenttypeid = '39';
		var areaCode = $("select[name=areacode]").val();
		var sigunguCode = $("select[name=sigungucode]").val();
		var cat1 = 'A05';
		var cat2 = 'A0502';
		var cat3 = $("select[name=cat3]").val();
		var pageNo = e;
		
		console.log(areaCode);
		console.log(sigunguCode);
		
		
		var params = new Object();
		params.contentTypeid = contenttypeid;
		params.areaCode = areaCode;
		params.sigunguCode = sigunguCode;
		params.cat1 = cat1;
		params.cat2 = cat2;
		params.cat3 = cat3;
		params.pageNo = pageNo;
		
	    $.ajax({
	    	url : myConfig.homeUrl + "/tour/api/list",
	        type: "get",
	        dataType: "json",
	        data : params,
	        success:function(data){
	        	console.dir(data);
	        	
	        	var data = JSON.parse(data);
	        	listPrint(data)
	        	
	        	pageing(data);
	        },
			error:function(args){
				alert("serviceCodeAjax2:error:"+request+"status:"+status+"error:"+error);
			}
	    });
	};

	
	// 페이지 로딩과 동시에 리스트 출력
	tourList();
	
	function pageing(data) {
		var body = data.response.body;
		var totalCount = body.totalCount;
		var displayPageNum = 10;
		var page = body.pageNo;
		var numOfRows = body.numOfRows;
		var endPage = Math.ceil(page / displayPageNum) * displayPageNum;
		var startPage = (endPage - displayPageNum) + 1;
		
		var tempEndPage = Math.ceil(totalCount / numOfRows);
		
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		var prev = startPage == 1? false : true;
		var next = endPage * numOfRows >= totalCount ? false : true;
		
		html = "";
		var pageination = $(".pagination");
		
		if (prev) {
			html += "<li class='page-item'>";
			html += "<a class='page-link' href='#' aria-label='Previous'>";
			html += "<span aria-hidden='true' onclick=previousNextFn('P') >&laquo;</span>";
			html += "<span class='sr-only'>Previous</span>";
			html += "</a>";
			html += "</li>";
		}

		for (var i = startPage; i <= endPage; i++) {
			html += "<li class='page-item'>";
			html += "<a href='#' onclick= tourList(this.text)>" + i + "</a>";
			html += "</li>";
		}

		if (next && endPage > 0) {
			html += "<li class='page-item'>";
			html += "<a class='page-link' href='#' aria-label='Next'>";
			html += "<span aria-hidden='true' onclick=previousNextFn('N') >&raquo;</span>";
			html += "<span class='sr-only'>Next</span>";
			html += "</a>";
			html += "</li>";
		}
		pageination.html(html);
	} 
	
	
	// 지역 
	function getSigunguList(areacode){    
		console.log(areacode);
		initFlag = 'N';
		var langtype = 'KOR';			
	    var params = {"areacode":areacode,"langtype":langtype};
	    	    
	    $.ajax({
	    	url : "http://api.visitkorea.or.kr/search/signguCodeAjax.do",
	        type: "post",
	        dataType: "json",
	        data : params,
	        success:function(data){
	        	console.dir(data);
	        	$("select[name=sigungucode]").empty();	        	
	        	$("select[name=sigungucode]").append("<option value=''>시군구 선택</option>");
	        	
	        	for(var  i = 0;  i < data.list.length; i ++){	        		
	        		$("select[name=sigungucode]").append("<option value="+data.list[i].signguCode+">"+ data.list[i].signguNm +"</option>");
	        	}
	        	
	        	if( initFlag == "N") {
	        		// 시군구 selected	        	
		    		$("select[name=sigungucode] > option").each(function(){
		    			if( $(this).val() == ""){
		    				$(this).attr("selected","selected");
		    			}	    			
		    		});
	        	}
	        },
			error:function(args){
				//alert('error' + args);
			}
	    });
	}
		
		
	function listPrint(data) {
		console.log("in listPrint");
		
		var item = data.response.body.items.item;
		var list = $("#list");
		var html = "";
		for (var i = 0; i < item.length; i++) {
			var v = item[i];
			
			if (i % 4 == 0) {
				html += "<div id='grid-container' class='cbp-caption-active cbp-caption-zoom cbp-l-grid-agency cbp-ready'>";
			}
			
			var sAddr = v.addr1.split(" ");
			var addr = sAddr[0] + " " + sAddr[1];
			
			html += "<div class='cbp-item graphic'>";
			html += "<div class='cbp-caption margin-bottom-20'>";
			html += "<div class='cbp-caption-defaultWrap'>";
			if (v.firstimage2) {
				html += "<img src='" + v.firstimage2 + "' alt='' style='width:263px; height:174px;'>";
			} else {
				html += "<img src='/rscamper-web/resources/img/default/default-image.png' alt='' style='width:263px; height:174px;'>";
			}
			html += "</div>";
			html += "<div id='list-div-" + v.contentid + "' class='cbp-caption-activeWrap'>";
			html += "<div class='cbp-l-caption-alignCenter'>";
			html += "<div class='cbp-l-caption-body'>";
			html += "<ul class='link-captions no-bottom-space'>";
			html += "<li><a href='#' onclick='goDetail(this)' data-value1='" + v.contentid + "' data-value2='" + v.contenttypeid + "'><i class='rounded-x fa fa-link'></i></a></li>";
			if (v.firstimage2) {
				html += "<li><a href='" + v.firstimage2 + "' class='cbp-lightbox' data-title='Design Object'><i class='rounded-x fa fa-search'></i></a></li>";
			} else {
				html += "<li><a href='/rscamper-web/resources/img/default/default-image.png' class='cbp-lightbox' data-title='Design Object'><i class='rounded-x fa fa-search'></i></a></li>";
			}
			html += "</ul>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			html += "<div class='cbp-title-dark'>";
			html += "<div id='list-title-" + v.contentid + "' class='cbp-l-grid-agency-title'>" + v.title + "</div>";
			html += "<div class='cbp-l-grid-agency-desc'>" + addr + "</div>";
			html += "</div>";
			html += "</div>";
			
			if (i % 4 == 3) {
				html += "</div>";
			}
		}	
		
		list.html(html);
	}


	function goDetail(e) {
		console.log(e.getAttribute("data-value1"));
		console.log(e.getAttribute("data-value2"));
		
		var url = myConfig.webServerUrl + "/rscamper-web/views/tour-food/detail.jsp?contentid=" + e.getAttribute("data-value1") + "&contenttypeid=" + e.getAttribute("data-value2");
		$(e).attr('href', url);
	}