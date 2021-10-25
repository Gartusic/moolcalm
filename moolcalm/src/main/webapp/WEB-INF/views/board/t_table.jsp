<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>opinion</title>
  <link rel="stylesheet" href="${path}/resources/css/reset.css">
  <link rel="stylesheet" href="${path}/resources/css/table.css">
</head>
<body>
  <section class="wrap">
    <div class="f_top">
      <h2>수정 제안</h2>
      <form action="" method="get" class="">
        <section class="t_list">
	        <c:forEach var="boardlist" items="${list}">
	         <input type="hidden" value="${boardlist.r_num}">
	          <ol reversed class=" column">                                 
	              <li>
	                <div class="t_header">
	                  <span class="id">${boardlist.email}</span>
	                  <span class="today">${boardlist.r_date}</span>
	                </div>
	                <hr>
	                <p class="t_opinion">
	                  ${boardlist.r_content}
	                </p>
	                <hr>
	                <div class="t_footer">
	                  <a href="javascript:void(21);" onclick="window.open('/board/t_writemodify.jsp', 't_writemodify', 'top=200, left=500, width=500, height=400, status=no, menubar=no, toolbar=no, resizable=no');">
	                  
	                  <span  class="t_btn">
	                  	수정
	                  </span>
	                  
	                  </a>
	                  
	                  <span>
	                  <a  href="/board/remove?r_num=${boardlist.r_num}" class="t_btn">삭제</a>
	                  </span>
	                  
	                </div>
	              </li> 
	          </ol>
	          
          </c:forEach>
        </section>
      </form>
    </div>
  </section>  
</body>
</html>