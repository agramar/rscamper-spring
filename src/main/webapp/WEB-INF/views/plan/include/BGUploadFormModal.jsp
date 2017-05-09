<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="BGImageUploadFormModal" class="modal fade" tabindex="-1" role="dialog" style="top: 50px;">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 id="myLargeModalLabel3" class="modal-title">배경 이미지 변경</h4>
			</div>
			<div class="modal-body">
				<form id="BGImageUploadForm" class="sky-form">
					<fieldset style="padding-top: 5px;">
						<section>
							<label class="label"><strong>미리보기</strong></label>
							<img id="BGImage" style="length:100%, height:100%;" src="${pageContext.request.contextPath}/resources/img/default/default-image.png" alt="upload image" class="img-thumbnail" />
						</section>
						<section>
							<label class="label"><strong>배경 사진 선택</strong></label>
							<label class="input file"> 
								<i class="icon-prepend fa fa-picture-o"></i>
								<input type="file" id="BGImageFile" ng-simple-upload web-api-url="{{uploadBGUrl}}" callback-fn="uploadBGCallBack" button-id="uploadBG"/>
							</label>
						</section>
					</fieldset>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn-u btn-u-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn-u" id="uploadBG">변경완료</button>
			</div>
			
		</div>
	</div>
</div>