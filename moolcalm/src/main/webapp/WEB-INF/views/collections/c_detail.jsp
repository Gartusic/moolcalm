<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<%@include file="../include/header.jsp"%>
	
<div id="wrap_p_detail">
        <div class="d_top">
        	<h3>상세 페이지</h3>
        	<a class="navbar-brand p_logo" href="/">logo</a>
            <a href="/collections/myCollection" class="p_prev"><i class="bi bi-arrow-90deg-left" title="뒤로"></i></a>
        </div>
        <figure class="figure">
            <img src="${c_detail[0].p_path}"
                class="figure-img img-fluid rounded" alt="...">
            <figcaption class="figure-caption text-end">${read.p_setname}</figcaption>
        </figure>
        
        <div class="d-grid gap-2">
        	<h1>${c_detail[0].p_setname}</h1>
        	<h3>${c_detail[0].p_name}</h3>
        	<p>${c_detail[0].p_author}</p>
			<p>${c_detail[0].p_info}</p>
        </div>
        
        
        
	</div>

</body>
</html>