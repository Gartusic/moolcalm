<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>JOIN</title>
    <link rel="stylesheet" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" href="${path}/resources/css/login.css">
</head>

<body>
    <section class="wrap">
        <main class="L_join_contents f_width_center">
            <h2>회원가입</h2>
            <form action="email_check" method="get" class="f_width_center">
                <fieldset class="f_width_center">                
<h2 class="hide">이메일 입력란입니다.</h2> 
                    <label><span class="h3">E-mail</span><br>
                      <input name="email" type="email" class="L_join_text f_input_box" autofocus placeholder="email">
                    </label>
                   <!-- <aside class="L_join_explain">사용 가능한 이메일입니다.</aside> -->                 
                </fieldset>
                <fieldset class="L_join_btn_sort ">
                  <button name="submit" type="submit" class="L_join_verify_email f_btn_grey">인증</button>
                </fieldset>
            </form>
        </main>
    </section>
