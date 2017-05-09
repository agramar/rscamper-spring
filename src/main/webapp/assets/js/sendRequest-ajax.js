/************************************************************************************
*
* version : 1.2
* author : http://tistory.serpiko.com
* update : 2015.02.02
* 
* var param = encodeURI('type=jsons');
* sendRequest('data.php', param, 'GET', complete, true, 'text');
* function complete(xhr, res){
*	res;			//text
*	res.name;		//json
*	res[0].value;   //jsons
* }
*
************************************************************************************/
var xhr = null;

//url경로, 전달파라메터, get/post, 동기화여부
function sendRequest(url, param, method, callback, asyncBool, type)
{

	if(window.ActiveXObject) // IE 이전 버전
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	else
		xhr = new XMLHttpRequest();

	method = (method.toLowerCase() == "get") ? "GET" : "POST";
	
	param = ( param == null || param == '' ) ? null : param;

	if(method == "GET" && param != null) url = url + "?" + param;
	
	xhr.onreadystatechange = function()
	{	
		if(xhr.readyState == 4){  //응답을 다 받은 경우

			if(xhr.status == 200){ //응답이 정상인 경우

				var myData;
				switch(type)
				{
					/*
					* 1. 문자열일 경우 직접 사용 가능.
					*    var myData = xhr.responseText; //serpiko
					*/	
					case 'text' :
						myData = xhr.responseText;
					break;
					
					/*
					* 2. 오브젝트일 경우 eval로 값으로 변환해야 하는데 이때 '()'로 감싸준다.
					*	 데이터 형식 : {'label':'serpiko', 'value':'99999'}
					*    var myData = eval( '('+ xhr.resonseText + ')' ); //
					*    myData.label
					*    myData.value
					*/
					case 'json' :
						myData = eval( '('+xhr.responseText+')' );
					break;
					
					/*
					* 3. 반복된 오브젝트({~~},{~~}... )일 경우 eval로 값으로 변환해야 하는데 이때 '[]'로 감싸준다.
					*    데이터 형식 : {'label':'serpiko', 'value':'99999'}, {'label':'serpiko', 'value':'8888'}
					*    var myData = eval( '['+ xhr.resonseText + ']' );
					*    myData[0].label
					*    myData[1].value
					*/
					case 'jsons' :
						myData = eval( '['+xhr.responseText+']' );
					break;
					
					/* 기본은 text */
					default :
						myData = xhr.responseText;
					break;
				}
				callback( xhr, myData );
			}else
				console.log( url + '의 ' + param + '로드를 실패했습니다. 에러코드 :' + xhr.status );
		}
	};

	xhr.open(method, url, asyncBool); //true:비동기적- and 콜백, false:동기적

	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	
	xhr.send(  (method == "POST")? param : null   );
}