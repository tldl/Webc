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
	<table border="1" width="500px">
		<tr>
			<td>序号</td>
			<td>标题</td>
            <td>内容</td>
            <td>日期</td>
		</tr>
	<c:forEach items="${account}" var="str" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${str}</td>

		</tr>
	</c:forEach>
	</table>
</body>
</html>