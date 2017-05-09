<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="note_send" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" style="top: 50px;">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content" style="width: 600px;">
			<div class="modal-header" >
				<span style="font-size:20px; font-weight: bold;">쪽지 보내기</span>
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
			</div>

			<div class="modal-body">
				<form id="profileImageUploadForm" class="sky-form">
					<fieldset style="padding-top: 20px;">
						<section>
							<img style="height: 49px; width:49px; margin-bottom: 20px; margin-right: 10px;" id="project-icon" src="${pageContext.request.contextPath}/resources/img/default/default-image.png"	class="ui-state-default" alt=""> 
							<input id="project" placeholder="보낼사람"> 
							<input type="hidden" id="project-id">
							<p id="project-description"></p>
						</section>
						<section>
							<input type="text" class="form-control" id="inputNoteSendTitle" placeholder="제목">
						</section>
						<section>
							<textarea class="form-control" id="inputNoteSendContent" rows="6" placeholder="내용" style="margin-top: 10px;"></textarea>
						</section>
					</fieldset>
				</form>
			</div>
			
			<div class="modal-footer">
				<button type="button" class="btn-u btn-u-default" data-dismiss="modal">취소</button>
				<button type="button" class="btn-u" id="uploadNote">보내기</button>
			</div>
		</div>
	</div>
</div>

