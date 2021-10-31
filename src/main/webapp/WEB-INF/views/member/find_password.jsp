<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>FIND</title>
    <link rel="stylesheet" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" href="${path}/resources/css/login.css">
</head>
<body>
    <section class="wrap">
        <div class="L_find_contents f_width_center">
            <h2>비밀번호 찾기</h2>
            <form action="find_password" method="post" class="f_width_center">
                <fieldset class="f_width_center">
                <legend>
                  <label><span class="h3">E-mail</span><br>
                    <input name="email" type="email" class="L_find_text f_input_box" autofocus placeholder="email" required>
                  </label>
                  <!-- <br>
                  <label><span class="h3">Verify Number</span><br>
                  <input type="password" class="L_find_text f_input_box" placeholder="인증번호 6자리">
                  </label>
                  <br> -->
                </legend>                 
                </fieldset>
                
                <fieldset class="L_find_btn_sort ">
                  <legend>
                    <button type="submit"class="L_find_verify_email f_btn_grey">인증</button>
                   <!--  <button type="submit" class="f_btn_grey">확인</button> -->
                  </legend>
                </fieldset>
            </form>
        </div>
    </section>
    
</body>
</html>