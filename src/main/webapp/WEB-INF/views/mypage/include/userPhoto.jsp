<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="include/userPhoto.css">
<div class="parallax-quote parallaxBg" style="background-image:url('{{user.bgPhotoUrl}}');">
	<div class="container">
		<div class="parallax-quote-in">
			<img class="rounded-x" ng-src="{{user.photoUrl}}" id="profile_image" ng-click="updateProfileImage();">
			<h1 style="color: white;" ng-bind="user.displayName"></h1>
			<button class="btn-u btn-u-light-green" ng-click="updateBGImage();">배경화면 바꾸기</button>
		</div>
	</div>
</div>