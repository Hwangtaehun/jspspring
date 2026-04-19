<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("admin") && pw.equals("1234")) {
		session.setAttribute("userId", id);
		session.setAttribute("userName", "관리자");
		
		response.sendRedirect("login_main.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>

<script>
	alert('아이디 또는 비밀번호가 틀립니다!');
	history.back();
</script>

</body>
</html>