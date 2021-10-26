<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Moolcalm</title>
    
    <!-- icons bootstrap -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.0/font/bootstrap-icons.css" integrity="sha384-7ynz3n3tAGNUYFZD3cWe5PDcE36xj85vyFkawcF6tIwxvIecqKvfwLiaFdizhPpN" crossorigin="anonymous">
    
    <link rel="stylesheet" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" href="${path}/resources/css/main.css">
    
<!-- jQuery 연결 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- jQuery UI 연결 -->
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>       
    <script type="text/javascript" src="${path}/resources/js/main.js"></script>
</head>
<body>
    <section class="m_wrap">
        <div class="m_contents f_top f_width_center">
            <figure class="m_img">
<h2 class="hide">메인화면 상품소개란입니다.</h2>
                <ul class="f_width_center">
                    <li>
                        <a href="">
                            <img src="${path}/resources/image/moolgam_image_unknown_sunshine001.png" alt="햇살과 숲">
                        </a>
                    </li>
                </ul>
            </figure>
            
            <c:set var="email" value="${ssn.email}" />
            	<c:choose>
            		<c:when test="${ssn.email eq null}">
            			<aside class="m_login_text f_bottom_margin">
            				로그인 해주세요.
            			</aside>
            		</c:when>
            		<c:otherwise>
            		<aside class="m_login_text f_bottom_margin">
            				${ssn.email}님, 반갑습니다!
            			</aside>
            		</c:otherwise>
            	</c:choose>

<h2 class="hide">검색창입니다.</h2>
            <aside class="m_search">
                <form action="" method="get" class="m_form f_width_center f_bottom_margin">
                    <input type="text" name="m_search_text" class="m_search_text f_input_box">
                    <button type="submit" class="m_search_btn f_btn_grey"><i class="bi bi-search" title="search"></i></button>
                </form>
            </aside><!--F_main_search-->
            
            <div id="m_mainMenu">
				<h2 class="hide">메뉴입니다.</h2>
	            <nav class="m_nav">
	                <ul>
	                	<c:set var="email" value="${ssn.email}" />
	            	<c:choose>
	            		<c:when test="${ssn.email eq null}">
	            			<li class="m_loginBtn"><a href="/member/sessionLogin"><i class="bi bi-person-circle" title="Login"></i></a></li>
	            		</c:when>
	            		<c:otherwise>
	            		<li class="m_mypageBtn"><a href="/member/member_info"><i class="bi bi-gear-fill" title="MyPage"></i></a></li>
	            		<li class="m_mypageBtn"><a href="/products/myCollection"><i class="bi bi-suit-heart-fill" title="MyCollection"></i></a></li>
	            		<li class="m_logoutBtn"><a><form action="/member/logout" method="post"><button type="submit"><i class="bi bi-box-arrow-right" title="logout"></i></button></form></a></li>
	            		</c:otherwise>
	            	</c:choose>
	                    <li class="m_productBtn"><a href="/products/p_list"><i class="bi bi-cart-fill" title="products"></i></a></li>
	                </ul>
	            </nav>
	            <button type="button" id="m_mainBtn" class="f_btn_blue">Menu</button>
            </div>
        </div><!--.contents-->
        
    </section><!--.wrap-->
</body>
</html>