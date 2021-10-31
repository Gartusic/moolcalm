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
      <a href="${path}/" style="font-size: 17px;line-height: 1.4em;">Home</a>
      <a href="${path}/member/member_info">mine</a>
      <br><br><br>
     <!--   <form action="t_table" method="get" class="">-->
        <section class="t_list">
	        <c:forEach var="boardlist" items="${list}">
	         <input type="hidden" value="${boardlist.r_num}">
	          <ol reversed class=" column">                                 
	              <li>
	                <div class="t_header">
	                  <span class="id">${email}</span>
	                  <span class="today">${boardlist.r_date}</span>
	                </div>
	                <hr>
	                <p class="t_opinion">
	                  ${boardlist.r_content}
	                </p>
	                <hr>
	                <div class="t_footer">
	                
	                <span>
	                 <!--  <a href="/board/modify?r_num=${boardlist.r_num}" class="t_btn">수정</a> -->
	                  </span>
	                  
	                  <span>
	                  <a  href="/board/remove?r_num=${boardlist.r_num}" class="t_btn">삭제</a>
	                  </span>
	                  
	                </div>
	              </li> 
	          </ol>          
          </c:forEach>
        </section>
     <!--  </form> -->
      
   <!-- <form id="" action="">	
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">	
	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
    </form>
    
    
	<ul>
	<c:if test="${pageMaker.prev}">
	<li class=""><a href="/board/t_table?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}">Previous</a></li>
	</c:if>
	
	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	<li class=" ${pageMaker.cri.pageNum==num?'active':''}">
	<a href="/board/t_table?pageNum=${num}&amount=${pageMaker.cri.amount}" class="page-link">${num}</a>
	</li>
	</c:forEach>
	
	<c:if test="${pageMaker.next}">
	<li class=""><a href="/board/t_table?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}">Next</a></li>
	</c:if>
	</ul>-->
    </div>
  </section>    
</body>
</html>