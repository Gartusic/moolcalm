<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moolcalm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">

</head>
<body>
	<div id="wrap">
        <div class="d_top">
            <h1>상품 상세페이지</h1>
            <a class="p_back">뒤로</a>
        </div>
        <figure class="figure">
            <img src="${read.p_path}"
                class="figure-img img-fluid rounded" alt="...">
            <figcaption class="figure-caption text-end">${read.p_setname}</figcaption>
        </figure>
        <h1>${read.p_setname}</h1>

		<div class="d-grid gap-2">
		  <button class="btn btn-primary" type="button">모음집 전체 구매</button>
		  <p>전체 가격: </p>
		  <button class="btn btn-primary" type="button">낱개 구매</button>
		  <p>낱개 가격: </p>		
		</div>
        <div>
        	${read.p_info}
        </div>
    </div>
</body>
</html>