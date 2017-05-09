	// 버튼으로 바꿔버려서 전역변수로 뺏어요!!
	var typeid = "";
	
	function typeChange(contenttypeid) {
		// 버튼 눌린 상태로 보이게 하려고 클래스에 active 추가/삭제
		$('button[onclick="typeChange(this)"]').removeClass('active');
		$(contenttypeid).addClass('active');
		
		typeid = $(contenttypeid).val();
		var params = {"contenttypeid":typeid ,"langtype":"KOR"};
		
	    $.ajax({
	    	url : "http://api.visitkorea.or.kr/guide/typeServiceCodeAjax.do",
	        type: "post",
	        dataType: "json",
	        data : params,
	        success:function(data){
	    		console.dir(data);
	        	$("select[name=cat1]:eq(0)").empty();	        	
	        	$("select[name=cat1]:eq(0)").append("<option value=''>대분류</option>");
	        	
	        	for(var  i = 0;  i < data.list.length; i ++){	        		
        			$("select[name=cat1]:eq(0)").append("<option value='"+data.list[i].cat1+"'>"+ data.list[i].catname1 +"</option>");
	        	}
	        },
			error:function(args){
				alert("dateserviceCodeAjax:error:"+request+"status:"+status+"error:"+error);
			}
	    });
	}
	
	function getCat2List(cat1 , initFlag, cat2Value, cat3Value){
		var index = $("select[name=cat1]").index(cat1);		
	    var params = {"cat1":$(cat1).val() ,"langtype":"KOR"};	    
	    
	    if( $(cat1).val() == ""){
	    	$("select[name=cat2]:eq("+index+")").empty();	        	
        	$("select[name=cat2]:eq("+index+")").append("<option value=''>중분류</option>");
        	
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
	        	
	        	$("select[name=cat2]:eq("+index+")").empty();	        	
	        	$("select[name=cat2]:eq("+index+")").append("<option value=''>중분류</option>");
	        	
	        	$("select[name=cat3]:eq("+index+")").empty();
	        	$("select[name=cat3]:eq("+index+")").append("<option value=''>소분류</option>");
	        	
	        	
	        	for(var  i = 0;  i < data.list.length; i ++){	        		
	        		if(cat2Value == data.list[i].cat2){
	        			$("select[name=cat2]:eq("+index+")").append("<option value='"+data.list[i].cat2+"' selected>"+ data.list[i].catname2 +"</option>");
	        		}else{
	        			$("select[name=cat2]:eq("+index+")").append("<option value='"+data.list[i].cat2+"'>"+ data.list[i].catname2 +"</option>");
	        		}
	        	}
	        		    
	        	if( initFlag == "N") {	        		
		    		getCat3List(	$("select[name=cat2]:eq("+index+")") , initFlag, cat3Value);
	        	}else{
	        		getCat3List(	$("select[name=cat2]:eq("+index+")") , initFlag, cat3Value);
	        	}
	        },
			error:function(args){
				   alert("serviceCodeAjax:error:"+request+"status:"+status+"error:"+error);
			}
	    });
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
		console.log("in tourList");
		var areaCode = $("select[name=areacode]").val();
		var sigunguCode = $("select[name=sigungucode]").val();
		var cat1 = $("select[name=cat1]").val();
		var cat2 = $("select[name=cat2]").val();
		var cat3 = $("select[name=cat3]").val();
		var pageNo = e;
		
		console.log(areaCode);
		console.log(sigunguCode);
		
		var params = new Object();
		params.contentTypeId = typeid;
		params.areaCode = areaCode;
		params.sigunguCode = sigunguCode;
		params.cat1 = cat1;
		params.cat2 = cat2;
		params.cat3 = cat3;
		params.pageNo = pageNo;
		
		console.log(params);
		
	    $.ajax({
	    	url : myConfig.serverUrl + "/tour/api/list",
	        type: "get",
	        dataType: "json",
	        data : params,
	        success:function(data){
	        	console.log("tourList success");
	        	console.dir(data);
	        	var data = JSON.parse(data);
	        	listPrint(data)
	        	
	        	pageing(data);
	        },
			error:function(args){
				console.log("tourList error");
				alert("serviceCodeAjax2:error:"+request+"status:"+status+"error:"+error);
			}
	    });
	};
		
	
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
		var pageination = $(".pagination");
		html = "";
		
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
	
	// 이미지 모달
	(function($, window, document, undefined) {
	    'use strict';

	    // init cubeportfolio
	    $('#js-grid-masonry-projects').cubeportfolio({
	        filters: '#js-filters-masonry-projects',
	        loadMore: '#js-loadMore-masonry-projects',
	        loadMoreAction: 'click',
	        layoutMode: 'grid',
	        defaultFilter: '*',
	        animationType: 'quicksand',
	        gapHorizontal: 35,
	        gapVertical: 25,
	        gridAdjustment: 'responsive',
	        mediaQueries: [{
	            width: 1500,
	            cols: 5
	        }, {
	            width: 1100,
	            cols: 4
	        }, {
	            width: 800,
	            cols: 3
	        }, {
	            width: 480,
	            cols: 2
	        }, {
	            width: 320,
	            cols: 1
	        }],
	        caption: 'zoom',
	        displayType: 'fadeIn',
	        displayTypeSpeed: 100,

	        // lightbox
	        lightboxDelegate: '.cbp-lightbox',
	        lightboxGallery: true,
	        lightboxTitleSrc: 'data-title',
	        lightboxCounter: '<div class="cbp-popup-lightbox-counter">{{current}} of {{total}}</div>',

	        // singlePage popup
	        singlePageDelegate: '.cbp-singlePage',
	        singlePageDeeplinking: true,
	        singlePageStickyNavigation: true,
	        singlePageCounter: '<div class="cbp-popup-singlePage-counter">{{current}} of {{total}}</div>',
	        singlePageCallback: function(url, element) {
	            // to update singlePage content use the following method: this.updateSinglePage(yourContent)
	            var t = this;

	            $.ajax({
	                    url: url,
	                    type: 'GET',
	                    dataType: 'html',
	                    timeout: 30000
	                })
	                .done(function(result) {
	                    t.updateSinglePage(result);
	                })
	                .fail(function() {
	                    t.updateSinglePage('AJAX Error! Please refresh the page!');
	                });
	        },
	    });
	})(jQuery, window, document);

	
	function listPrint(data) {
		var item = data.response.body.items.item;
		var list = $("#list");
		var html = "";
		for (var i = 0; i < item.length; i++) {
			var v = item[i];
			if (i % 4 == 0) {
				console.log(i);
				html += "<div id='grid-container' class='cbp-caption-active cbp-caption-zoom cbp-l-grid-agency cbp-ready'>";
			}
			console.log(v.addr1);
			
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
		
		var url = myConfig.webServerUrl + "/rscamper-web/views/tour-all/detail.jsp?contentid=" + e.getAttribute("data-value1") + "&contenttypeid=" + e.getAttribute("data-value2");
		$(e).attr('href', url);
	}
	
		