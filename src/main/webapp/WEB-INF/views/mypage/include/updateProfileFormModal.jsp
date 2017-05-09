<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 회원정보수정 모달 -->

<div id="updateProfileFormModal" class="modal fade" tabindex="-1" role="dialog" style="top: 50px;">
	
	<div class="modal-dialog" role="document">
		
		<div class="modal-content">
			<div class="modal-body">
				<form id="sky-form" class="sky-form">
					<header>프로필 수정</header>
					<fieldset>
						<section>
							<label class="label"><strong>사용자명</strong></label>
							<label class="input"> 
								<i class="icon-prepend fa fa-user"></i>
								<input type="text" ng-model="updateUser.displayName">
							</label>
						</section>
						<section>
							<label class="label"><strong>전화번호</strong></label> 
							<label class="input">
								<i class="icon-prepend fa fa-phone"></i> 
								<input type="text" ng-model="updateUser.phoneNumber">
							</label>
						</section>
						<section>
							<label class="label"><strong>생년월일</strong></label>
							<label class="input"> 
								<i class="icon-prepend fa fa-calendar"></i>
								<input type="date" ng-model="updateUser.birthday">
							</label>
						</section>
						<section>
							<label class="label"><strong>홈페이지</strong></label> 
							<label class="input">
								<i class="icon-prepend fa fa-globe"></i>
								<input type="text" ng-model="updateUser.websiteUrl">
							</label>
						</section>
						<section>
							<label class="label"><strong>성별</strong></label> 
							<label class="select">
							<i></i>
								<select ng-model="updateUser.gender">
									<option value="m">남자</option>
									<option value="f">여자</option>
								</select>
							</label>
						</section>
						<section>
							<label class="label"><strong>거주지역</strong></label>
							<label class="select">
							<i></i>
								<select ng-options="location.locationNo as location.locationName for location in locations" ng-model="updateUser.locationNo">
	            				</select>
							</label>
						</section>
						<section>
							<label class="textarea"><strong>자기소개</strong>
							<textarea rows="5" name="info" placeholder="자기소개" ng-model="updateUser.introduce"></textarea>
							</label>
						</section>
					</fieldset>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn-u btn-u-default" data-dismiss="modal">닫기</button>
				<button type="button" class="btn-u" ng-click="updateProfile();">수정완료</button>
			</div>
			
		</div>
		
	</div>
	
</div>
