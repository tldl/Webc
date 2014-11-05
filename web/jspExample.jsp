<%@page contentType = "text/html; charset = UTF-8" %>
<%@ page import="java.util.Date" %>
<html>
	<head>
		<title>JSP页面</title>
	</head>
	<body bgcolor = "#ffffff">
		<%
		Date now = new Date();
		out.println("当前时间是：" + now);
		%>
		<h1> 你好，这就是一个JSP页面。</h1>
	</body>
</html>