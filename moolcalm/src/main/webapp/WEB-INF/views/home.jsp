<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Moolgam</title>
    <link rel="stylesheet" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" href="${path}/resources/css/main.css">
</head>
<body>
    <section class="m_wrap">
        <div class="m_contents f_top f_width_center">
            <figure class="m_img">
<h2 class="hide">메인화면 상품소개란입니다.</h2>
                <ul class="f_width_center">
                    <li>
                        <a href="">
                            <img src="${path}/resources/images/moolgam_image_unknown_sunshine001.png" alt="햇살과 숲">
                        </a>
                    </li>
                </ul>
            </figure><!--.F_main_image-->

            <aside class="m_login_text f_bottom_margin">로그인 하세요.</aside>

<h2 class="hide">검색창입니다.</h2>
            <aside class="m_search">
                <form action="" method="get" class="m_form f_width_center f_bottom_margin">
                    <input type="text" name="m_search_text" class="m_search_text f_input_box">
                    <button type="submit" class="m_search_btn f_btn_grey"></button>
                    <button type="reset" class="m_btn_reset f_btn_blue"></button>
                </form>
            </aside><!--F_main_search-->
<h2 class="hide">메뉴입니다.</h2>
            <nav class="m_nav">
                <ul>
                    <li><a href="${path}/member/login">
                        로그인</a></li>
                    <li><a href="member/member_info">
                        mine
                    </a></li>
                    <li><a href=""></a></li>
                </ul>
            </nav>
        </div><!--.contents-->
    </section><!--.wrap-->
</body>
</html>