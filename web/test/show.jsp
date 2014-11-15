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
    <c:forEach items="${agendalist}" var="str" varStatus="vs">
        <tr>
            <form method="post" action=DeleteAgenda>
                <table border = "0">
            <td>${str.id}</td>
            <td> <input type = "hidden" name = "id" value=${str.id}></td>
            <td>${str.title}</td>
            <td>${str.content}</td>
            <td>${str.startDate}</td>
            <td> <input type = "submit" name = "Submit" value = "删除">&nbsp;</td>
                </table>
            </form>
        </tr>
    </c:forEach>
</table>
<br>

</body>
</html>