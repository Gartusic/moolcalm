<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원정보</title>
  <link rel="stylesheet" href="${path}/resources/css/reset.css">
  <link rel="stylesheet" href="${path}/resources/css/member.css">
</head>
<body>
  <section class="wrap info_main">
    <div class="f_width_center">
      <h2>마이페이지</h2>

      <details open>
        <summary>잔여포인트</summary>
          <p class="info_point">
            1209412
          </p>
      </details>

      <section class="info_list">
        <ul>
          <li><a href="${path}/member/new_password">
            비밀번호 변경하기</a></li>
          <li><a href="">보관함 가기</a></li>
          <!-- <li><a href="javascript:void(11);" onclick="window.open('/board/l_point.jsp', 'l_point', 'top=300, left=600, width=500, height=400, status=no, menubar=no, toolbar=no, resizable=no');">
            point 내역</a></li>  -->
          <li><a href="">내가 쓴 후기</a></li>
          <li style="width: 100px; height: 10px; margin: 5px 0;"></li>
          <li><a href="">회원탈퇴</a></li>
          <li><a href="${path}/board/t_write">
            의견제시</a></li>
          <li style="width: 100px; height: 10px; margin: 5px 0;"></li>
          <li><a href="">로그아웃</a></li>
        </ul>
      </section>    
    </div>
  </section>
</body>
</html>