<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="createTourPlanFormModal" class="modal fade" tabindex="-1" role="dialog" style="top: 50px;">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<form id="sky-form" class="sky-form">
					<header style="text-align: center">
						<b>신규 여행 일정 만들기</b>	
					</header>
					<fieldset>
						<section>
							<label class="label"><strong>제목</strong></label>
							<label class="input"> 
								<i class="icon-prepend fa fa-pencil-square-o"></i>
								<input type="text" placeholder="제목을 입력해 주세요" ng-model="writeTourPlan.title">
							</label>
						</section>
						<section>
							<label class="label"><strong>소제목</strong></label>
							<label class="input"> 
								<i class="icon-prepend fa fa-pencil-square-o"></i>
								<input type="text" placeholder="소제목을 입력해 주세요" ng-model="writeTourPlan.strapline">
							</label>
						</section>
						<section>
							<label class="label"><strong>상세 소개글</strong></label>
							<label class="textarea">
								<textarea rows="5" placeholder="일정에 대한 간략한 소개글을 입력해 주세요" ng-model="writeTourPlan.introduce"></textarea>
							</label>
						</section>
						<section>
							<div class="row">
								<section class="col col-6">
									<label class="label"><strong>여행시작일</strong></label>
									<label class="input">
										<i class="icon-prepend fa fa-calendar"></i>
										<input type="date" ng-model="writeTourPlan.departureDate">
									</label>
								</section>
								<section class="col col-6">
									<label class="label"><strong>여행종료일</strong></label>
									<label class="input">
										<i class="icon-prepend fa fa-calendar"></i>
										<input type="date" ng-model="writeTourPlan.arriveDate">
									</label>
								</section>
							</div>
						</section>
					</fieldset>
					<footer>
						<button type="button" class="btn-u btn-u-default pull-right" data-dismiss="modal">닫기</button>
						<button type="button" class="btn-u pull-right  margin-right-10" ng-click="insertTourPlan();">여행일정 만들기</button>
					</footer>
				</form>
			</div>
		</div>
	</div>
</div>
