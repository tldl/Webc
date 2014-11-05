<%@ page import="sample.HelloWorld"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sample jsp page  </title>
    <link rel="stylesheet" type="text/css" >
</head>
<body>
<h3 class="message"><%=HelloWorld.getMessage()%></h3>
</body>
</html>
