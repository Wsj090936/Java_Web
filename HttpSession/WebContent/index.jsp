<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<script type="text/javascript">
	function ChangeCode(){
		var img = document.getElementsByTagName("img")[0];//得到图片元素
		img.src = "/HttpSession/Session/code?time="+new Date().getTime();
	} 
</script>
</head>
<body>
	<form action="/HttpSession/Session/dologin" method="post">
		用户名:<input type="text" name="userName"><br/>
		密码:<input type="password" name="pwd"><br/>
		验证码:<input type="text" name="code">
		<img src="/HttpSession/Session/code" onclick="ChangeCode()"/><a href="javascrpit:ChangeCode()">看不清，换一张</a><br/>
  	<%
  		String msg = (String)request.getAttribute("msg");
  		if(msg!=null){
  			out.print(msg);
  		}
  	 %>
		<input type="submit" value="登录">
	</form>
</body>
</html>