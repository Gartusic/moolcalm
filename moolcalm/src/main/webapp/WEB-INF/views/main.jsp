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
	
	<style>
    
    .main_theme{
	  /* 애니메이션 이름 */
	  animation-name: poem;
	  animation-duration:60s;
	  animation-timing-function: linear;
	  animation-iteration-count:infinite;
	  animation-fill-mode: forwards;
}

		/* 키프레임 이름 = 애니메이션 이름 */
		@keyframes poem {
		  0% {
		    margin-bottom:-100%;
		  }
		  100% {
	        margin-top:-300%;
		  }
		}
		
	.snow_pungpung{
	position:absolute; color: transparent; font-size:55px;
	opacity:0.7;
	border:1px solid white;
	border-radius:50%;
	box-shadow: 2px 2px 2px 1px rgba(0, 0, 0, 0.2);
	}
    </style>
    
    <link rel="favicon" href="${path}/resources/image/favicon.ico">

	<link rel="icon" type="image/png" sizes="32x32" href="${path} /resources/image/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="${path} /resources/image/favicon-16x16.png">
	
	<link rel="icon" type="image/x-icon" sizes="32x32" href="${path} /resources/image/favicon-32x32.png">
	<link rel="icon" type="image/x-icon" sizes="16x16" href="${path} /resources/image/favicon-16x16.png">
	
	
	<link rel="manifest" href="${path} /resources/image/manifest.json">

	<link rel="icon" href="${path}http://localhost:8080/" />
</head>

<script id="snowAnimate">  
var flakeCnt;var delta_x=new Array(),delta_y=new Array();var move_x=new Array(),move_y=new Array();var resolution_x,resolution_y;$(function(){resolution_x=document.documentElement.clientWidth,resolution_y=document.documentElement.clientHeight;var position_x,position_y,i=0;flakeCnt=document.getElementById('petalCanvas').getElementsByTagName('span').length;$("#petalCanvas span").each(function(){position_x=Math.random()*resolution_x;position_y=-30-(Math.random()*100);$(this).css({"left":position_x+"px","top":position_y+"px"});$(this).attr("id","drop"+i);move_x[i]=position_x;move_y[i]=position_y;i++;});petalSet();});function petalSet(){var hei,speed;if(resolution_y<600){hei=600;}else{hei=resolution_y;}var max_angle=hei/2;for(var i=0;i<flakeCnt;i++){speed=Math.random();delta_x[i]=(speed*max_angle)/1200+i/100;delta_y[i]=(speed*0.4)+0.3;}petalDrop();}function petalDrop(){for(var i=0;i<flakeCnt;i++){move_x[i]-=delta_x[i];move_y[i]+=delta_y[i];if(move_x[i]<0)move_x[i]=resolution_x-30;if(move_y[i]>resolution_y-10)move_y[i]=-20;$("#drop"+i).css({"left":move_x[i]+"px","top":move_y[i]+"px"});}setTimeout("petalDrop()",10);}  
</script>  


<body>

<div id="petalCanvas" style="position:fixed;top:0;z-index:999;height:0;overflow:visible;">  
<span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
 <span class="snow_pungpung" >*</span>  
</div>  

    <section class="m_wrap" style=" z-index: 2;">
        <div class="m_contents f_top f_width_center" style=" z-index: 3;">

<h2 class="hide">메인화면 상품소개란입니다.</h2>
                <ul class="f_width_center" style="overflow:hidden; height:200px; margin-top:100px;">
                <div class="main_theme" style=" z-index: 2;">
                    <li><br><br><br><br><br><br>
<b>눈사람 자살 사건​</b><br><br>

최승호<br><br>​

그날 눈사람은 텅 빈 욕조에 누워 있었다.<br> 뜨거운 물을 틀기 전에 그는 더 살아야 하는지<br> 말아야 하는지 곰곰이 생각해 보았다.<br> 더 살아야 할 이유가 없다는 것이 자살의 이유가 될 수는 없었으며 <br>죽어야 할 이유가 없다는 것이 사는 이유 또한 될 수 없었다. <br>죽어야 할 이유도 없었고 더 살아야 할 이유도 없었다.
<br><br>
아무런 이유 없이 텅 빈 욕조에 혼자 누워 있을 때 <br>뜨거운 물과 찬물 중에서 어떤 물을 틀어야 하는 것일까. <br>눈사람은 그 결과는 같은 것이라고 생각했다. <br>뜨거운 물에는 빨리 녹고 찬물에는 좀 천천히 녹겠지만<br> 녹아 사라진다는 점에서는 다를 게 없었다.
<br><br>
나는 따뜻한 물에 녹고 싶다. <br>오랫동안 너무 춥게만 살지 않았는가. <br>눈사람은 온수를 틀고 자신의 몸이 점점 녹아 물이 되는 것을 지켜보다 잠이 들었다. <br>욕조에서는 무럭무럭 김이 피어올랐다.
<br><br><br>
- 『눈사람 자살 사건』(달아실, 2019)<br><br><br><br><br><br><br><br>
                    </li>
                </div>
                </ul><br><br>

            
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
	            		<li class="m_mypageBtn"><a href="/collections/myCollection"><i class="bi bi-suit-heart-fill" title="MyCollection"></i></a></li>
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