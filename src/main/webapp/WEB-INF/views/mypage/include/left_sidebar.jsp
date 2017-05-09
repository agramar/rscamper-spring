<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-md-3 md-margin-bottom-40">
	<ul class="list-group sidebar-nav-v1 margin-bottom-40" id="sidebar-nav-1">
		<li id="profile_menu" class="list-group-item">
			<a href="profile.jsp"><i class="fa fa-user"></i> 프로필</a>
		</li>
		<li id="notification_menu" class="list-group-item">
			<span class="badge badge-u rounded" ng-bind="menuCount.notificationCnt"></span>
			<a href="notification.jsp"><i class="fa fa-bell"></i> 알림</a>
		</li>
		<li id="message_menu" class="list-group-item">
			<span class="badge badge-u rounded" ng-bind="menuCount.messageCnt"></span>
			<a href="message.jsp"><i class="fa fa-envelope"></i> 쪽지함</a>
		</li>
		<li id="my_tour_plan_menu" class="list-group-item">
			<span class="badge badge-u rounded" ng-bind="menuCount.myTourPlanCnt"></span>
			<a href="mytourplan.jsp"><i class="fa fa-calendar"></i> 내 여행일정</a>
		</li>
		<li id="my_post_menu" class="list-group-item">
			<span class="badge badge-u rounded" ng-bind="menuCount.myPostCnt"></span>
			<a href="mypost.jsp"><i class="fa fa-pencil"></i> 내 포스트</a>
		</li>
		<li id="bookmark_menu" class="list-group-item">
			<span class="badge badge-u rounded" ng-bind="menuCount.bookmarkPostCnt + menuCount.bookmarkTourPlanCnt + menuCount.bookmarkTourSpotCnt"></span>
			<a href="bookmark.jsp"><i class="fa fa-bookmark-o"></i> 북마크</a>
		</li>
	</ul>
</div>