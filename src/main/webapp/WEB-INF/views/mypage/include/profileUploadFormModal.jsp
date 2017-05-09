<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="profileImageUploadFormModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" style="top: 50px;">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 id="myLargeModalLabel3" class="modal-title">프로필 이미지 변경</h4>
			</div>
			<div class="modal-body">
				<form id="profileImageUploadForm" class="sky-form">
					<fieldset style="padding-top: 5px;">
						<section>
							<label class="label"><strong>미리보기</strong></label>
							<img id="profileImage" src="${pageContext.request.contextPath}/resources/img/default/default-image.png" alt="upload image" class="img-thumbnail" />
						</section>
						<section>
							<label class="label"><strong>프로필 사진 선택</strong></label>
							<label class="input file"> 
								<i class="icon-prepend fa fa-picture-o"></i>
								<input type="file" id="profileImageFile" ng-simple-upload web-api-url="{{uploadProfileUrl}}" callback-fn="uploadProfileCallBack" button-id="uploadProfile"/>
							</label>
						</section>
					</fieldset>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn-u btn-u-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn-u" id="uploadProfile">변경완료</button>
			</div>
			
		</div>
	</div>
</div>