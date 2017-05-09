<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="cd-user-modal">
	<!-- this is the entire modal form, including the background -->
	<div class="cd-user-modal-container">
		<!-- this is the container wrapper -->
		<ul class="cd-switcher">
			<li><a href="javascript:void(0);">로그인</a></li>
			<li><a href="javascript:void(0);">회원가입</a></li>
		</ul>

		<div id="cd-login">
			<!-- log in form -->
			<form id="signin-email-form" class="cd-form">
				<p class="social-login">
					<span class="social-login-facebook"><a href="#"	onclick="signinProvider('facebook');"><i class="fa fa-facebook"></i> Facebook</a></span>
					<span class="social-login-google"><a href="#" onclick="signinProvider('google');"><i class="fa fa-google"></i> Google</a></span> 
					<span class="social-login-twitter"><a href="#" onclick="signinProvider('twitter');"><i class="fa fa-twitter"></i> Twitter</a></span>
				</p>

				<div class="lined-text">
					<span>이메일 계정으로 로그인</span>
					<hr>
				</div>

				<p class="fieldset">
					<label class="image-replace cd-email" for="signin-email">E-mail</label>
					<input class="full-width has-padding has-border" id="signin-email"
						type="email" placeholder="E-mail" required> <span
						class="cd-error-message">Error message here!</span>
				</p>

				<p class="fieldset">
					<label class="image-replace cd-password" for="signin-password">Password</label>
					<input class="full-width has-padding has-border"
						id="signin-password" type="password" placeholder="Password"
						required> <a href="javascript:void(0);"
						class="hide-password">Show</a> <span id="signin-email-error"
						class="cd-error-message">Error message here!</span>
				</p>

				<p class="fieldset">
					<input type="checkbox" id="remember-me"> <label
						for="remember-me">로그인 유지하기</label>
				</p>

				<p class="fieldset">
					<input id="signin-email-btn" class="full-width" type="button"
						value="로그인">
				</p>
			</form>

			<p class="cd-form-bottom-message">
				<a href="javascript:void(0);" onclick="">비밀번호를 잊으셨나요?</a>
			</p>
			<a href="javascript:void(0);" class="cd-close-form">Close</a>
		</div>
		<!-- cd-login -->

		<div id="cd-signup">
			<!-- sign up form -->
			<form id="signup-email-form" class="cd-form">
				<p class="social-login">
					<span class="social-login-facebook"><a href="#"
						onclick="signinProvider('facebook');"><i
							class="fa fa-facebook"></i> Facebook</a></span> <span
						class="social-login-google"><a href="#"
						onclick="signinProvider('google');"><i class="fa fa-google"></i>
							Google</a></span> <span class="social-login-twitter"><a href="#"
						onclick="signinProvider('twitter');"><i class="fa fa-twitter"></i>
							Twitter</a></span>
				</p>

				<div class="lined-text">
					<span>새로운 이메일 계정 등록하기</span>
					<hr>
				</div>

				<p class="fieldset">
					<label class="image-replace cd-username" for="signup-username">Username</label>
					<input class="full-width has-padding has-border"
						id="signup-username" type="text" placeholder="Username" required>
					<span class="cd-error-message">Error message here!</span>
				</p>

				<p class="fieldset">
					<label class="image-replace cd-email" for="signup-email">E-mail</label>
					<input class="full-width has-padding has-border" id="signup-email"
						type="email" placeholder="E-mail" required> <span
						class="cd-error-message">Error message here!</span>
				</p>

				<p class="fieldset">
					<label class="image-replace cd-password" for="signup-password">Password</label>
					<input class="full-width has-padding has-border"
						id="signup-password" type="password" placeholder="Password"
						required> <a href="javascript:void(0);"
						class="hide-password">Show</a> <span id="signup-email-error"
						class="cd-error-message">Error message here!</span>
				</p>

				<p class="fieldset">
					<input type="checkbox" id="accept-terms"> <label
						for="accept-terms"> 본 사이트의 약관에 동의합니다. <a
						href="page_terms.html">약관보기</a></label>
				</p>

				<p class="fieldset">
					<input id="signup-email-btn" class="full-width has-padding"
						type="button" value="회원 가입하기">
				</p>
			</form>

			<!-- <a href="javascript:void(0);" class="cd-close-form">Close</a> -->
		</div>
		<!-- cd-signup -->

		<div id="cd-reset-password">
			<!-- reset password form -->
			<p class="cd-form-message">이메일 주소를 입력해 주세요. 당신의 이메일로 비밀번호 초기화 메일이
				발송될것 입니다.</p>

			<form id="reset-email-form" class="cd-form">
				<p class="fieldset">
					<label class="image-replace cd-email" for="reset-email">E-mail</label>
					<input class="full-width has-padding has-border" id="reset-email"
						type="email" placeholder="E-mail"> <span
						id="reset-email-error" class="cd-error-message">오류발생!</span>
				</p>

				<p class="fieldset">
					<input id="reset-password-btn" class="full-width has-padding"
						type="button" value="비밀번호 초기화">
				</p>
			</form>

			<p class="cd-form-bottom-message">
				<a href="javascript:void(0);">로그인창으로</a>
			</p>
		</div>
		<!-- cd-reset-password -->
		<a href="javascript:void(0);" class="cd-close-form">Close</a>
	</div>
	<!-- cd-user-modal-container -->
</div>
<!-- cd-user-modal -->