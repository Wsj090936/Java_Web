<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	设置变量:<c:set var="num" value="${10 }" scope="request"></c:set><br/>
	输出变量:<c:out value="${num }"></c:out><br/>
	删除变量:<c:remove var="num"/><br/>
	删除后输出变量:<c:out value="${num }"></c:out><br/>
	<!-- if语句 -->
	if语句:<c:if test="${3>0 }">aaa</c:if><br/>
	<c:set var="a" value="3"></c:set>
	choose语句:<c:choose>
		<c:when test="${a==1 }">a为一</c:when>
		<c:when test="${a==2 }">a为二</c:when>
		<c:when test="${a==3 }">a为三</c:when>
		<c:otherwise>
			a为其他
		</c:otherwise>
	</c:choose>
</body>
</html>