
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>注册账号</title>
    <link href="http://images.qq190.com/CSS/getpwd.css"
          rel="stylesheet" type="text/css"/>
    <link href="http://images.qq190.com/CSS/common/msgbox.css"
          rel="stylesheet" type="text/css"/>
</head>
<body>
<div>
    <div>
        <div>
            <img src="http://images.qq190.com/images/logo.gif"/>

            <h3>
                注册账号</h3>
        </div>
        <div>
            <FORM
                ACTION=Register
                METHOD="post">

            <p>
                <span>用户名：</span><input type="text" name="userName"/>
            </p>

            <p>
                <span>密码 ：</span><input type="text" name="userPsd"/>
            </p>

            <p>
                <a> <input type="submit" value="注册账号" name="Submit"/></a>
                <a href="/">返回首页</a>
            </p>

        </div>
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
