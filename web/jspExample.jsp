<%@page contentType = "text/html; charset = UTF-8" %>
<%@ page import="java.util.Date" %>
<html>
	<head>
		<title>JSPҳ��</title>
	</head>
	<body bgcolor = "#ffffff">
		<%
		Date now = new Date();
		out.println("��ǰʱ���ǣ�" + now);
		%>
		<h1> ��ã������һ��JSPҳ�档</h1>
	</body>
</html>