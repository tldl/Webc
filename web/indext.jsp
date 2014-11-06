<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
	function doSearch(){
		//使用ajax发送异常请求到test.do。把返回的 HTML文件代码插入ID为data的元素中
		$("#data").load('TestServlet?'+Math.random());
	}
</script>
</head>
<body>
	<div>
		<input type="button" value="查询数据" onclick="doSearch()"/>&nbsp;
		<input type="button" value="清除数据" onclick="$('#data').html('')"/>
	</div>
	<div id="data"></div>
</body>
</html>
