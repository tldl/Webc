<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Insert title here</title>
    <script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
    <script type="text/javascript">
        function doSearch() {
            //使用ajax发送异常请求到TestServlet。把返回的 HTML文件代码插入ID为data的元素中
            $("#agendalist").load('FindAgenda');
        }
    </script>
</head>
<body>
<div>
    <body>
    <form method="post" action=JumpPage>
        <table border="0">
            <tr>
                <td><input type="button" value="添加日程" onclick="window.location.href='test/addagenda.jsp';"/>
                <td><input type="button" value="查询日程" onclick="doSearch()"/>&nbsp;</td>
                <td><input type="button" value="清除日程" onclick="$('#agendalist').html('')"/></td>
            </tr>
        </table>
    </form>
</div>
<div id="agendalist"></div>
</body>
</html>
