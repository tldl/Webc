
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>注册账号</title>
    <link href="http://images.qq190.com/CSS/getpwd.css"
          rel="stylesheet" type="text/css"/>
    <link href="http://images.qq190.com/CSS/common/msgbox.css"
          rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="main">
    <div class="content">
        <div class="header">
            <img src="http://images.qq190.com/images/logo.gif"/>

            <h3>
                注册账号</h3>
        </div>
        <FORM ACTION=Register METHOD="post">
            <p><span>用户名：</span> <input type="text" name="userName"/></p>
            <p><span>密码 ：</span><input type="text" name="userPsd"/></p>
            <p><input type="submit" value="Submit" name="Submit"/> </p>
        </FORM>

    </div>
</div>
<script src="http://images.qq190.com/JSCommon/jquery.min.js"
        type="text/javascript"></script>
<script src="http://images.qq190.com/JSCommon/msgbox.min.js"
        type="text/javascript"></script>
<script src="http://images.qq190.com/JS/webjs/getpwd.js"
        type="text/javascript"></script>
</body>
</html>
