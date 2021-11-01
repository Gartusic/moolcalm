<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Email</title>
	<style>
	body{
		width: 500px;
		margin: 0 auto;
	}

	div{
		margin-left: 10px;
	}

	div,
	button{
		margin-left: 50%;
		transform: translateX(-50%);
	}

	input{
		width: 80px;
	}

	button{
		width: 80px;
		height: 30px;
	}
	
	</style>

</head>

<body>
	
<form action="join_injeung${dice}" method="post">
	<div>
	<br><br><br><br>
	인증번호 입력: <input name="email_injeung" type="text">
	<br><br>
	</div>
	<button type="submit" name="submit">전송</button>

</form>
</body>
</html> 