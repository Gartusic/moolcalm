<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@include file="../include/header.jsp"%>
	<div id="wrap_p_detail">
        <div class="d_top">
        <h3>상세 페이지</h3>
            <a href="/products/p_list" class="p_prev"><i class="bi bi-arrow-90deg-left" title="뒤로"></i></a>
        </div>
        <figure class="figure">
            <img src="${read.p_path}"
                class="figure-img img-fluid rounded" alt="...">
            <figcaption class="figure-caption text-end">${read.p_setname}</figcaption>
        </figure>
        
        
        <h1>${read.p_setname}</h1>



		<div class="d-grid gap-2">

		  
		  <p>상품의 총 갯수: <span>${readProductCount.count} </span><br>
		   전체 가격: <span>${readProductCount.sum} </span><br>
		   낱개 가격: <span>${readProductCount.price} </span></p>	
		  
		 
		  	<input type="hidden" name="email" value="${ssn.email}">
		  	<input type="hidden" name="p_name" value="${read.p_name}">
		  	<p>
		  		현재 보유 포인트: <span>${ssn.point}</span>
		  	</p>
		  	
		  	
		  	<!-- action="Mapping이름" -->
		  	<form action="buy" method="post">
		  	<button class="btn btn-primary buyBtn" type="submit">구매하기</button>
		  
		  <div class="productlist_div">
		  <p><input type="checkbox" name="p_name" value="전체 선택" onclick='p_selectAll(this)'>전체 선택</p>
       		<ul class="productReadList">
       		<!-- var 안에는 임시로 사용할 변수명을 담고, items안에 mapper에서 사용하는id값을 담는다? -->
       		<c:forEach var="readL" items="${readList}">
     			<li><input type="checkbox" name="p_name" value="${readL.p_name}">${readL.p_name}</li>
       		</c:forEach>
       		</ul>
       	</div>
		</form>
		</div>
		
		
        <div>
        	${read.p_info}
        </div>
       	
    </div>
    
<script>
	function p_selectAll(selectAll)  {
	  const checkboxes 
	       = document.getElementsByName('p_name');
	  
	  checkboxes.forEach((checkbox) => {
	    checkbox.checked = selectAll.checked;
	  })
	}
</script>
</body>
</html>