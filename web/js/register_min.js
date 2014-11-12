function checkUserName(value) {
        var reg = new RegExp(/^[a-zA-Z]{1}\w{3,14}/);
        if (!reg.test(value)) {
        JustKeepMoving.msgbox.show("用户名有误，用户名必须以字母开头，且长度小于15个字符. ")
        return false;
        }
        return true;
        }
        function checkEmail(value) {
        var reg = new RegExp(/^[\w_-]+@[\w_-]+(\.[\w_-]+)+$/);
        if (!reg.test(value)) {
        JustKeepMoving.msgbox.show("邮件格式不正确.");
        return false;
        }
        return true;
        }
        function submitRequst() {
        var username = $(".username").val();
        var email = $(".email").val();
        if (!checkUserName(username) || !checkEmail(email))
        return;
        JustKeepMoving.msgbox.show("请稍候，提交中... ", 6);
        $.ajax({
        url: "/ashx/ProcessAjax.ashx",
        type: "post",
        dataType: "json",
        data: { m: "o", username: encodeURIComponent(username), email: encodeURIComponent(email) },
        success: function (msg) {
        if (msg.status) {
        JustKeepMoving.msgbox.show(msg.msg, 4);
        setTimeout(function () {
        location.href = "/";
        }, 2000)
        }
        else {
        JustKeepMoving.msgbox.show(msg.msg, 5);
        }

        }, error: function () { }
        })
        return false;

        }
        function resetPwd() {
        var username = $(".username").val();
        var pwd = $(".pwd").val();
        var rpwd = $(".rpwd").val();
        var reg = new RegExp(/^.{6,20}$/);
        if (!checkUserName(username))
        return;
        if (pwd.length < 6) {
        JustKeepMoving.msgbox.show("密码输入有误,请输入至少6位的密码");
        return false;

        }
        if (pwd != rpwd) {
        JustKeepMoving.msgbox.show("2次输入的密码不匹配");
        return false;
        }
        JustKeepMoving.msgbox.show("请稍候，提交中... ", 6);
        $.ajax({
        url: "/ashx/ProcessAjax.ashx",
        type: "post",
        dataType: "json",
        data: { m: "p", username: username, pwd: encodeURIComponent(rpwd), code: xcode },
        success: function (msg) {
        if (msg.status) {
        JustKeepMoving.msgbox.show(msg.msg, 4);
        setTimeout(function () {
        location.href = "/Auth/Login.html";
        }, 2000)
        }
        else {
        JustKeepMoving.msgbox.show(msg.msg, 5);
        }

        }, error: function () { }
        })

        return false;

        }