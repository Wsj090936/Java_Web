<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL表达式 -->
	<% 
		pageContext.setAttribute("p", "page");
		request.setAttribute("p", "request");
		session.setAttribute("p", "session");
		application.setAttribute("p", "application");
	%>
	${requestScope.p }
</body>
</html>