<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="textml; charset=utf-8"/>
    <title>登录</title>
    <style type="text/css">
        #form1 {
            border-top-color: #0CF;
            border-right-color: #0CF;
            border-bottom-color: #0CF;
            border-left-color: #0CF;
        }

        #form2 {
            border-top-color: #09C;
            border-right-color: #09C;
            border-bottom-color: #09C;
            border-left-color: #09C;
        }

        #form1 #form1 {
            text-align: center;
            font-family: Arial, Helvetica, sans-serif;
        }

        #form2 #form2 {
            text-align: center;
            top: 600px;
            right: 450px;
        }

        .submit {
            position: absolute;
            top: 0px;
            left: 251px;
        }

        #signin {
            position: absolute;
            top: 318px;
            right: 399px;
        }
    </style>
</head>

<body style="right: 450px; top: 600px;">
<p><img src="images/background.jpg" width="767" height="569"/></p>

<div id="signin">
    <form  method="post" action=Login>
        <p id="form2">账号：
            <label for="name"></label>
            <input type="text" name="name" id="name"/>
        </p>
        <label for="m"></label>

        <p id="form3">密码：
            <label for="mima"></label>
            <input type="password" name="mima" id="mima"/>
        </p>
        <input type="submit"/>
        <p class="submit"><img src="images/login.png" width="91" height="79"/></p>
        <span class="submit"></span>
    </form>
</div>

</body>
<html>
