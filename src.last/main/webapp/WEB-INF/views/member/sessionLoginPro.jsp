<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%@ page import="javax.naming.*" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	Connection conn=null;
	PreparedStatement pstmt = null; // sql연결, 문장 실행
	String str=""; // 메세지출력
	ResultSet rs = null;
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
		conn=ds.getConnection();
		// id, pw 받아서 실제로 회원이 있는지 확인하는 select문
		String sql="select email,password from l_info where email=? and password=?";
		conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		if(rs.next()){// select된 결과가 있다는 것은 login 성공했다는 의미
			//					아이디값     을  아이디변수에 저장
			session.setAttribute("email", email); //session영역에 email값을 저장
			//					패스워드값  을   패스워드변수에 저장
			session.setAttribute("password",password);//session영역에 password값을 저장
			response.sendRedirect("home11.jsp");//성공하면, 메인페이지로 이동
		}else{ //select된 결과가 없다는 것은 login 실패했다는 의미
			response.sendRedirect("sessionLogin.jsp");//다시 login페이지로 이동
			
		}
		out.println("<h3>연결되었습니다.<h3>");
	} catch(Exception e){ // 오류 처리
		out.println("<h3>연결실패하였습니다.</h3>");
		e.printStackTrace();
	}
	%>
</body>
</html>