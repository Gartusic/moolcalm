<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%@include file="../include/header.jsp"%>
<section class="wrap">
<form action="/member/sessionLogin" method="post" class="f_width_center">
	<fieldset  class="f_width_center">
		<div>
			<h2>LOGIN</h2>
		</div>
		<div>
			<span class="h3">E-mail</span><br>
			<input type="email" name="email" value="${email}" class="L_login_text f_input_box" autofocus placeholder="email">
		</div>
		<div>
			<span class="h3">Password</span><br><input type="password" name="password" value="${password}" class="L_login_text f_input_box" placeholder="password">
		</div>
		<br class="f_login_line_space">
		<div>
			<fieldset class="L_login_btn_sort"><input type="submit" value="로그인"  class="f_btn_grey">
			<a href="${path}/member/email_check">    
                    <input type="button" class="f_btn_grey" value="가입">
                  </a>
                  <a href="${path}/member/find_password">    
                  <input type="button" class="f_btn_grey" value="비밀번호">
                  </a>
			</fieldset>
		</div>
	</fieldset>
</form>
</section>
</body>
</html>