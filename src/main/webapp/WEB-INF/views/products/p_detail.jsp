<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@include file="../include/header.jsp"%>
	<div id="wrap">
        <div class="d_top">
            <h1>상품 상세페이지</h1>
            <a href="/products/p_list">뒤로</a>
        </div>
        <figure class="figure">
            <img src="${read.p_path}"
                class="figure-img img-fluid rounded" alt="...">
            <figcaption class="figure-caption text-end">${read.p_setname}</figcaption>
        </figure>
        
        
        <h1>${read.p_setname}</h1>



		<div class="d-grid gap-2">
		  <!-- action="Mapping이름" -->
		  <form action="buy" method="post">
		  <button class="btn btn-primary" type="button">모음집 전체 구매</button>
		  
		  <p>상품의 총 갯수: <span>${readProductCount.count}</span> 전체 가격: <span>${readProductCount.sum}</span></p>
		  
		 
		  	<input type="hidden" name="email" value="${ssn.email}">
		  	<input type="hidden" name="p_name" value="${read.p_name}">
		  	<button class="btn btn-primary" type="submit">낱개 구매</button>
		  </form>
		  
		  <p>낱개 가격: <span>${readProductCount.price}</span></p>		
		</div>
		
		
        <div>
        	${read.p_info}
        </div>
       	<div>
       		<ul>
       		<!-- var 안에는 임시로 사용할 변수명을 담고, items안에 mapper에서 사용하는id값을 담는다? -->
       		<c:forEach var="readL" items="${readList}">
     			<li><input type="checkbox" name="p_name" value="${readL.p_name}">${readL.p_name}</li>
       		</c:forEach>
       		</ul>
       	</div>
    </div>
</body>
</html>