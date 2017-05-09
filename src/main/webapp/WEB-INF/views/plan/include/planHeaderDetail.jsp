<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="include/planHeaderDetail.css">
<div id="backGroundImage" class="parallax-quote parallaxBg" style="height: 300px; background-image:url('{{tourPlan.filePath}}');">
	<div class="container">
		<div class="parallax-quote-in">
			<h1 id="tourPlanTitle" style="color: white; font-size: 40px;" ng-bind="tourPlan.title"></h1>
			<h5 style="color: white;" ng-bind="tourPlan.period"></h5>
			<br>
		</div>
	</div>
</div>