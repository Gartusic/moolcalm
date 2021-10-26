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

<script type="text/javascript"> String.prototype.trim = function() { return this.replace(/^\s+|\s+$/g,""); } </script>



    <section class="wrap">
        <main class="L_join_contents f_width_center">
            <h2>회원가입</h2>
            <form action="join" method="post" class="f_width_center">
                            
<h2 class="hide">이메일입니다.</h2> 
                    <label><span class="h3">E-mail</span><br>
                      <input id="" value="${email}" name="email" type="text" class="L_join_text f_input_box" autofocus placeholder="email" readonly>
                    </label>
                    <br><br>               
<h2 class="hide">비밀번호 입력란입니다.</h2> 
                    <label><span class="h3">Password</span><br>
                      <input id="pass1" name="password" type="password" class="L_join_text f_input_box" placeholder="password" required>
                    </label>
                    <aside class="L_join_explain f_bottom_margin">영어, 특수문자, 숫자를 사용하세요.</aside>
<h2 class="hide">비밀번호 확인을 위해 한 번 더 입력바랍니다.</h2> 
                    <label><span class="h3">Verify Password</span><br>
                      <input id="pass2" type="password" class="L_join_text f_input_box" placeholder="password">
                    </label>
                    <!-- <aside class="L_join_explain f_bottom_margin">비밀번호가 일치합니다.</aside> -->              
               
                
                 <fieldset class="L_join_btn_sort ">               	<br>
                                   
                    <button type="submit" class="f_btn_grey" onclick="join_pass_check()">가입</button>                  
                </fieldset>
            </form>
        </main>
    </section>

    <script>

    function join_pass_check() {
      var p1 = document.getElementById("pass1").value;
      var p2 = document.getElementById("pass2").value;
      
      if(p1==null){
        alert("비밀번호를 입력해주세요");  
        return false;       
      } else if(p1 != p2) {
        alert("비밀번호가 일치 하지 않습니다");
        return false;
      } else{
        alert("비밀번호가 일치합니다");
        return true;
      }

    }
    </script>
    
   </body>
</html>   
      
  