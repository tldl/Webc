
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id = "user" scope = "request" type = "User" />
	<html>
	<!- UserLogin.html- - >
	<head>Found User Info</title>
	</head>
	<body>
		<table border = 3>
		<tr><b>用户信息</b></tr>
		<tr>
		<td>用户名：</td>
		<td><jsp:getProperty name = "user" property = "username" /></td>
		</tr>
		<tr>
		<td>密　码：</td>
		<td><jsp:getProperty name = "user" property = "password" /></td>
		</tr>
		</table>
	</body>
	</html>