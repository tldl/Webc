<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>注 册 账 号(^_^)</title>
    <link href="http://images.qq190.com/CSS/getpwd.css"
          rel="stylesheet" type="text/css"/>
    <link href="http://images.qq190.com/CSS/common/msgbox.css"
          rel="stylesheet" type="text/css"/>
    <style>
        p#a {
            padding-left: 100px;
        }
    </style>
</head>
<body>
<div class="main">
    <div class="content">
        <div class="header">
            <img src="images/logo.png"/>

            <h3>
                注册账号</h3>
        </div>
        <div class="container">
            <form ACTION=Register METHOD="post">
                <p>
                    <span>用户名：</span><input type="text" name="userName" class="userName"/>
                </p>

                <p>
                    <span>密码 ：</span><input type="password" name="userPsd" class="userPsd"/>
                </p>

                <p id="a">
                    <a><input type="submit" value="注册账号" name="Submit"/></a>
                    <a href="login.jsp">前往登录</a>
                </p>
            </form>
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
