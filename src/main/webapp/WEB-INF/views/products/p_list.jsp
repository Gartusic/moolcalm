<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<%@include file="../include/header.jsp"%>
	
	
	<c:forEach var="productList" items="${list}">
		${item}<br>
	</c:forEach>
	
	<div id="wrap_p_list">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <a class="navbar-brand p_logo" href="/">logo</a>
              <a href="/" class="p_prev"><i class="bi bi-arrow-90deg-left" title="뒤로"></i></a>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">상품 유형</li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            글
                        </a>
                        <ul class="dropdown-menu s_drop" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">명언</a><input type="checkbox" name="s_type"></li>
                            <li><a class="dropdown-item" href="#">따뜻한 한마디</a><input type="checkbox" name="s_type"></li>
                            <li><a class="dropdown-item" href="#">편지</a><input type="checkbox" name="s_type"></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            이미지
                        </a>
                        <ul class="dropdown-menu s_drop" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">사진</a><input type="checkbox" name="s_type"></li>
                            <li><a class="dropdown-item" href="#">그림</a><input type="checkbox" name="s_type"></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            소리
                        </a>
                        <ul class="dropdown-menu s_drop" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">음악</a><input type="checkbox" name="s_type"></li>
                            <li><a class="dropdown-item" href="#">백색소음</a><input type="checkbox" name="s_type"></li>
                            <li><a class="dropdown-item" href="#">특이한 소리</a><input type="checkbox" name="s_type"></li>
                        </ul>
                    </li>
                </ul>
                <form class="d-flex">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
              </div>
            </div>
          </nav>

          <div class="p_catg">
            <a class="p_on">전체</a>
            <a>맞춤</a>
            <a>관심</a>  
          </div>
          <div class="row p_cardRow">
          <c:forEach var="productList" items="${list}">
            <div class="col-6">
                <div class="card"> 
                 <a href="/products/p_detail?p_setname=${productList.p_setname}">
                <img src="${productList.p_path}"
                        class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${productList.p_setname}</h5>
                        <p class="card-text">${productList.p_author}</p>
                    </div>
                    </a>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>