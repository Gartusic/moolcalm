<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>NEW</title>
    <link rel="stylesheet" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" href="${path}/resources/css/login.css">
</head>
<body>
    <section class="wrap">
        <div class="L_new_contents f_width_center">
            <h2>새로운 비밀번호</h2>
            <form action="" method="POST" class="f_width_center">
                <fieldset class="f_width_center">

<h2 class="hide">비밀번호 입력란입니다.</h2>                
                  <label><span class="h3">New Password</span><br>
                    <input type="password" class="L_new_text f_input_box" autofocus placeholder="password">
                  </label>
                  <div class="L_join_explain f_bottom_margin">영어, 특수문자, 숫자를 사용하세요.</div>
<h2 class="hide">비밀번호 확인을 위해 한 번 더 입력바랍니다.</h2> 
                  <label><span class="h3">Verify Password</span><br>
                  <input type="password" class="L_new_text f_input_box" placeholder="password">
                  </label>
                  <div class="L_new_explain">비밀번호가 일치합니다.</div>

              
                </fieldset>
                
                <fieldset class="L_new_btn_sort ">
                  <legend>
                    <button type="submit" class="f_btn_grey">등록</button>
                  </legend>
                </fieldset>
            </form>
        </div>
    </section>
    
</body>
</html>