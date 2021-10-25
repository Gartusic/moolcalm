<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>write</title>
  <link rel="stylesheet" href="${path}/resources/css/reset.css">
  <link rel="stylesheet" href="${path}/resources/css/table.css">
</head>
<body>
  <section class="wrap">
    <div class="f_top f_width_center">
      <h2>글쓰기</h2>
      <form action="register" method="get" class="f_width_center">
        <textarea name="content" id="" cols="30" rows="10" autofocus>${register.r_content}</textarea>
        <br>
        <fieldset class="t_w_btns_box">
          <legend class="t_w_btns">
            <button type="reset" class="f_btn_blue t_w_btn">취소</button>
            <button type="submit" class="f_btn_grey t_w_btn">등록</button>    
          </legend>
        </fieldset>
      </form>
    </div>
  </section>  
</body>
</html>