<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="include/planHeader.css">
<div id="backGroundImage" class="parallax-quote parallaxBg" style="height: 300px; background-image:url('{{tourPlan.filePath}}');">
	<div class="container">
		<div class="parallax-quote-in">
			<h1 id="tourPlanTitle" style="color: white; font-size: 40px;" ng-bind="tourPlan.title" ng-click="changeTitle();" ng-hide="modTitle"></h1>
			<div ng-show="modTitle" style="height: 35px;">
				<input type="text" ng-model="tourPlan.title" style="vertical-align: middle; height:34px; width:500px; color:gray; font-size: 20px;" />
				<button class="btn-u btn-u-sea rounded" style="vertical-align: middle;" ng-click="updateTitle();">변경</button>
			</div>
			<h5 style="color: white;" ng-bind="tourPlan.period"></h5>
			<br>
			<button id="changeTourPlanBGImage" class="btn-u btn-u-sea" ng-click="changeTourPlanBGImage();" >배경화면 바꾸기</button>
		</div>
	</div>
</div>