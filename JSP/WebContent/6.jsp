<%@page import="demo1.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 六大内置对象的例子 -->
<%-- 	<jsp:useBean class="demo1.Student" id="stu"></jsp:useBean>
	<jsp:setProperty property="name" name="stu" value="tom"/>
	<jsp:getProperty property="name" name="stu"/> --%>
<!-- 例子二，请求转发 -->
<%-- 	<jsp:forward page="/index.jsp">
		<jsp:param value="2" name="age"/>
	</jsp:forward> --%>
<!-- EL表达式例子 -->
	<%
		Student stu1 = new Student();
		stu1.setName("tom");
		request.setAttribute("stu", stu1);
		request.getRequestDispatcher("/1.jsp").forward(request, response);
	%>
</body>
</html>