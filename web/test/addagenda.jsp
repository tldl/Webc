<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-StudentFind.html-->

<head>
    <title>Agenda Form</title>
</head>
<body>
<h1>添加日程</h1>

<FORM
        ACTION=AddAgenda
        METHOD="post">
    <table border="0">
        <tr>
            <td>日程标题</td>
            <td><input type="text" name="title"/></td>
            <td>日程内容</td>
            <td><input type="text" name="content"/></td>
            <td><input type="submit" value="Submit" name="Submit"/></td>
        </tr>
    </table>
</FORM>


</body>
</html>