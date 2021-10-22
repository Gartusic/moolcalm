<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>LOGIN</title>
    <link rel="stylesheet" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" href="${path}/resources/css/login.css">
</head>
<body>
    <section class="wrap">
        <div class="f_width_center">
            <h2>LOGIN</h2>
            <form action="" method="POST" class="f_width_center">
              <fieldset class="f_width_center">
<h2 class="hide">이메일 입력란입니다.</h2> 
                  <label><span class="h3">E-mail</span><br>
                    <input type="email" class="L_login_text f_input_box" autofocus placeholder="email">
                  </label>
                  <br>
<h2 class="hide">비밀번호 입력란입니다.</h2> 
                  <label><span class="h3">Password</span><br>
                  <input type="password" class="L_login_text f_input_box" placeholder="password">
                  </label>
              </fieldset>
              <br class="f_login_line_space">
              <fieldset class="L_login_btn_sort">
                  <button type="submit" class="f_btn_grey">로그인</button>
                  <a href="javascript:void(1);" onclick="window.open('./join.jsp', 'join', 'top=250, left=550, width=500, height=550, status=no, menubar=no, toolbar=no, resizable=no');">    
                    <input type="button" class="f_btn_grey" value="가입">
                  </a>
                  <a href="javascript:void(1);" onclick="window.open('./find_password.jsp', 'find_password', 'top=250, left=550, width=500, height=550, status=no, menubar=no, toolbar=no, resizable=no');">     
                  <input type="button" class="f_btn_grey" value="비밀번호">
                  </a>
              </fieldset>


            </form>
        </div>
    </section>
    
</body>
</html>