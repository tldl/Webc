<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>

<script type="text/javascript" src="../js/jquery.js"></script>
<script>
    /*以下为接收参数部分*/
    var record = new Array();
    record[${vs.index}] = new Array();
    var num;
    function doSearch() {
        {
            $.ajax({url: "FindAgenda", type: "post", dataType: "json",
                        success: function (agendalist)
                        {
                            <c:forEach items="${agendalist}" var="str" varStatus="vs">
                            alert(agendalist)
                            record[${vs.index}][0] = '${str.id}';
                            record[${vs.index}][1] = '${str.title}';
                            record[${vs.index}][2] = '${str.startDate}';
                            record[${vs.index}][3] = '${str.content}';
                            if (${vs.last}) {
                                num = ${vs.index}+1;
                            }
                            </c:forEach>
                        }
                        , error: function (data) {
                            alert("网络错误，请联系管理员");
                        }
                    }
            )


        }
    }



    /*over*/
    var str = ['Sun', 'Mon', 'Tue', 'Wen', 'Thu', 'Fri', 'Sat'];
    function init() {

        $("#index").html("");
        $("#tbody").html("");
        for (var i = 0; i < num; i++) {
            $('<tr id="tr_' + i + '"><td>' + (i + 1) + "</td><td>" + record[i][1] + "</td><td>" + record[i][2] + "</td><td>" + '<a onclick="showcontext(' + i + ')"></a>' + "</td><td>" + '<form  method="post" target="noneiframe" onclick=delete_1(' + i + ') action=DeleteAgenda ><input type="submit" id="delete" value="" ><input type="hidden" name="id" value="' + record[i][0] + '"></form>' + "</td></tr>").appendTo("#tbody");
        }

        for (var i = 0; i < num; i++) {
            $('<tr><td  onclick="showcontext(' + i + ')" id="index' + i + '"><div id="index_' + i + '"><span >' + (i + 1) + '</span></div></td></tr>').appendTo("#index");
        }

        $('<tr><td id="returns" onclick="returnschedule()"><span  >' + '返回' + '</span></td></tr>').appendTo("#index");
        var height = num * 62 + 52;
        document.getElementById("schedule").style.height = height + "px";
        $("#context").attr("class", "invisual");
        if (num == 0) {
            document.getElementById("schedule").style.height = "200px";
            $("#norecord").html("没有任何记录~~~<br>快点添加一条吧~~~");
        } else {
            $("#norecord").html("");
        }
        $("#select1").attr("class", "onfo");
        $("#select2").attr("class", "inonfo");
        $("#select2").attr("onclick", "addwindow()");
        alert("!");
        $("#addnew").attr("class", "invisual");
    }
    function addwindow() {
        $("#select1").attr("class", "inonfo");
        $("#select2").attr("class", "onfo");
        $("#select1").attr("onclick", "showwindow()");
        $("#select2").attr("onclick", "");
        $("#schedule").attr("class", "invisual");
        $("#addnew").attr("class", "");
        $("#context").attr("class", "invisual");
        inittime();
    }
    function inittime() {
        var time = new Date();
        var month = time.getMonth() + 1;
        var date = time.getDate();
        var day = time.getDay();
        var year = time.getFullYear();
        var hour = time.getHours();
        var min = time.getMinutes();
        document.getElementById("addda").value = year + "-" + month + "-" + date + "-" + hour + ":" + min + "@" + str[day];
    }
    function showwindow() {
        $("#select1").attr("class", "onfo");
        $("#select2").attr("class", "inonfo");
        $("#select2").attr("onclick", "addwindow()");
        $("#addnew").attr("class", "invisual");
        $("#schedule").attr("class", "");
    }
    function showcontext(i) {

        $("#schedule").attr("class", "invisual");
        $("#context").attr("class", "");
        $("#text").html(record[i][3]);
        $("#title_").html(record[i][1]);
        $("#date_").html(record[i][2]);
        for (var j = 0; j < num; j++) {
            $("#index_" + j).attr("class", "v");
        }
        $("#index_" + i).attr("class", "p");

    }

    function delete_1(j) {
        $("#main").attr("class", "transparent");
        $("#hide").attr("class", "");
        document.getElementById("delete_dialog").style.top = j * 60 + 20 + "px";

    }
    function delete_2(j) {
        num--;
        for (var i = j; i < num; i++) {
            record[i][0] = record[i + 1][0];
            record[i][1] = record[i + 1][1];
            record[i][2] = record[i + 1][2];
            record[i][3] = record[i + 1][3];
        }
        init();
        $("#main").attr("class", "");
        $("#hide").attr("class", "invisual");
    }
    function delete_cancel() {
        $("#main").attr("class", "");
        $("#hide").attr("class", "invisual");
    }
    function returnschedule() {
        $("#schedule").attr("class", "");
        $("#context").attr("class", "invisual");
    }
    function addnew() {
        var titl = document.getElementById("addti").value;
        if ((titl == null) || (titl == "")) {
            attend();
            return false;
        } else {
            num++;
            record[num - 1] = new Array();
            if (num == 1) {
                record[num - 1][0] = 1;
            } else {
                record[num - 1][0] = record[num - 2][0];
            }
            record[num - 1][1] = document.getElementById("addti").value;
            record[num - 1][2] = document.getElementById("addda").value;
            record[num - 1][3] = document.getElementById("addcon").value;
            showwindow();
            init();
            return true;
        }

    }
    function attend() {
        $("#attend").attr("class", "");
        document.getElementById("cancel").focus();
    }
    function attendinvisual() {
        $("#attend").attr("class", "invisual");
        document.getElementById("addti").focus();
    }
</script>


<style>
* {
    margin: 0;
    padding: 0;
    font-family: Verdana, Arial, sans-serif;
}

#hide {
    width: 100%;
    height: 640px;
    position: absolute;
    z-index: 1;
}

#hide #delete_dialog {
    position: absolute;
    width: 260px;
    top: 100px;
    left: 962px;
}

#delete_background {
    position: absolute;
    width: 260px;
    height: 180px;
    background-image: url(../images/clowd.jpg);
    background-position: -30px -14px;
}

#hide #delete_dialog p:nth-child(2) {
    position: absolute;
    left: 50px;

}

#hide #delete_dialog p:nth-child(3) {
    position: absolute;
    top: 40px;
    left: 50px;
    cursor: pointer;
}

#hide #delete_dialog p:nth-child(4) {
    position: absolute;
    top: 80px;
    left: 50px;
    cursor: pointer;
}

#main {
    position: absolute;
    top: 100px;
    left: 100px;

}

#main #schedule {

    position: relative;
    top: 0px;
    left: 220px;
    width: 639px;
    height: 450px;
    overflow: hidden;
    border: 1px solid #000;
    border-radius: 7px;
    -webkit-border-radius: 7px;
    -moz-border-radius: 7px;
}

#main #schedule table {
    margin: -1px;
    border: 1px solid #000;
    text-align: center;
}

#main #schedule table thead tr th:nth-child(1) {
    width: 70px;

}

#main #schedule table thead tr th:nth-child(2) {
    width: 210px;
}

#main #schedule table thead tr th:nth-child(3) {
    width: 170px;
}

#main #schedule table thead tr th:nth-child(4) {
    width: 100px;
}

#main #schedule table thead tr th:nth-child(5) {
    width: 80px;
}

#main #schedule table tr td {
    padding: 0px;
}

#main #schedule table tr td:nth-child(4) {

}

#main #schedule table tr td:nth-child(4) a {
    width: 100px;
    height: 58px;
    display: block;
    text-decoration: none;
    color: #00f;
    background-image: url(../images/book1.jpg);
    background-position: -4px -14px;

}

#main #schedule table tr td:nth-child(4) a:hover {

    background-image: url(../images/openbook.jpg);
    background-position: -4px -14px;
    cursor: pointer;
}

#main #schedule table tr td {
    height: 60px;
}

#main #schedule table th {
    height: 50px;
    background-color: #eeeeee;
    font-size: 23px;
}

#main #schedule table tbody td #delete {
    width: 52px;
    height: 52px;
    border: 0px black;
    margin-left: 0px;
    background-image: url(../images/kedelete.png);
    background-position: -7px -10px;
    cursor: pointer;

}

#main #schedule table tbody td #delete:hover {
    background-position: -7px -13px;

}

#main #schedule table tbody td #delete:active {
    background-position: -7px -10px;
}

#context {
    width: 639px;
    position: absolute;
    top: 0px;
    left: 220px;
    font-family: Verdana, Arial, sans-serif;
    height: 640px;
    border: 1px solid #000;
    border-radius: 7px;
    -webkit-border-radius: 7px;
    -moz-border-radius: 7px;
    overflow: hidden;
    background-image: url(../images/111.png);
    background-position: 0 -260px;
}

#context #title_ {
    position: absolute;
    text-align: center;
    width: 87%;
    top: 10px;
}

#context #date_ {
    position: absolute;
    text-align: right;
    width: 75%;
    top: 60px;
}

#context table {

    margin-top: -1px;
    margin-right: -2px;
    float: right;
    font-family: Verdana, Arial, sans-serif;
}

#context table td {
    height: 44px;
    width: 106px;
    text-align: center;
    cursor: pointer;
    font-size: 20px;

}

#context table td span {
    margin-top: 10px;
    margin-left: 80px;
    display: block;
}

#context #text {
    width: 80%;
    word-break: break-all;
    position: absolute;
    top: 100px;
    text-indent: 2em;
}

.invisual {
    display: none;
}

.transparent {
    filter: alpha(opacity=70);
    -moz-opacity: 0.7;
    -khtml-opacity: 0.7;
    opacity: 0.7;
}

.transparent_ {
    filter: alpha(opacity=80);
    -moz-opacity: 0.8;
    -khtml-opacity: 0.8;
    opacity: 0.8;
}

.v {
    float: left;
    width: 106px;
    height: 44px;
    background-image: url(../images/111.png);
    background-position: -16px -8px;
    opacity: 0.8;
    color: #000;
}

.p {
    float: left;
    width: 106px;
    height: 44px;
    background-image: url(../images/111.png);
    background-position: -128px -8px;
    color: rgb(66, 210, 91);
}

.v:hover {
    background-position: -258px -8px;
    color: #ff0000;
}

.p:hover {
    cursor: default;
}

#context #index #returns span {
    margin-top: 0px;
    margin-right: 80px;
    margin-left: 0px;
    font-size: 18px;
}

#context #index #returns {

}

#context #index #returns:hover {

}

#menu {
    border-radius: 7px;
    -webkit-border-radius: 7px;
    -moz-border-radius: 7px;
    position: absolute;
    width: 120px;
    height: 59px;
    border: 1px solid #d3d3d3;
    overflow: hidden;
}

#menu div {
    margin-left: -1px;
    margin-top: -1px;
    width: 100%;
    height: 29px;
    border: 1px solid #000;
    font-size: 20px;
    font-weight: bolder;
    padding-left: 17px;
}

.onfo {
    background-color: rgb(89, 163, 56);
    color: #ffffff;
}

.inonfo {
    cursor: pointer;
    color: #212121;
    background-color: #e6e6e6;
}

.inonfo:hover {
    color: #898989;
    background-color: #d3d3d3;
    border: 1px solid #444444;

}

#addnew {
    position: absolute;
    left: 200px;
    top: -20px;

}

#addnew tr td h2 {
    width: 50px;
    font-size: 20px;
}

#addnew tr:nth-child(3) td h2 {
    margin-top: -182px;
}

#addnew tr:nth-child(4) td input {
    width: 60px;
    height: 30px;

}

#addnew tr:nth-child(4) td:nth-child(2) input {
    margin-left: 0px;
}

#addcon {
    width: 540px;
    height: 360px;
}

#attend {
    background-image: url(../images/111.png);
    background-position: -12px -110px;
    width: 202px;
    height: 124px;
    position: absolute;
    left: 268px;
    top: -77px;
}

#attend p {
    position: absolute;
    top: 43px;
    left: 48px;
    width: 120px;
}
</style>


</head>
<body>
<div id="hide" class="invisual">
    <div id="hmain">
        <div id="delete_dialog">
            <div id="delete_background"></div>
            <p>真的要删除吗？</p>

            <p onclick="delete_2()">删的就是你！</p>

            <p onclick="delete_cancel()">还是算了吧~</p>
        </div>
    </div>
</div>

<div id="main">

    <div id="menu">
        <div id="select1" onclick="showwindow()">日程列表</div>
        <div id="select2" onclick="addwindow()">添加新的</div>
    </div>
    <div id="schedule">
        <table border="1px" cellspacing="0px">
            <thead>
            <tr>
                <th>序号</th>
                <th>标题</th>
                <th>日期</th>
                <th>内容</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody id="tbody">

            </tbody>
        </table>
        <div id="norecord">

        </div>
    </div>
    <div id="context">
        <table id="index" border="1px" cellspacing="0px">
        </table>
        <h3 id="title_">
        </h3>
        <h4 id="date_">
        </h4>

        <div>
            <span id="text"></span>
        </div>
    </div>
    <div id="addnew">
        <div id="attend" class="invisual">
            <p>给你的日程想个标题吧~</p>
        </div>
        <form id="new" target="_blank	" onsubmit="return addnew()" action="RELEASE-NOTES.txt">
            <table cellpadding="10" cellspacing="20">
                <tr>
                    <td><h2>标题:</h2></td>
                    <td><input type="text" name="title" id="addti"></td>
                </tr>
                <tr>
                    <td><h2>时间:</h2></td>
                    <td><input type="text" name="date" id="addda" onfocus="this.blur()"></td>
                </tr>
                <tr>
                    <td><h2>内容:</h2></td>
                    <td><textarea name="context" id="addcon" cols="100" form="new" rows="30"></textarea></td>
                </tr>
                <tr>
                    <td><input type="submit" value="添加"></td>
                    <td><input type="reset" value="取消" onclick="showwindow()" id="cancel" onblur="attendinvisual()">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<iframe name="noneiframe" class="invisual"></iframe>
<script>
    $(function () {
        init();
    })
</script>
</body>
</html>