<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>

<style>
    #main {
        position: absolute;

    }

    #main #schedule {

        position: relative;
        top: 0px;
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
        background-image: url(image/book1.jpg);
        background-position: -4px -14px;

    }

    #main #schedule table tr td:nth-child(4) a:hover {

        background-image: url(image/openbook.jpg);
        background-position: -4px -14px;

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
        margin-left: 13px;
        background-image: url(image/kedelete.png);
        background-position: -7px -10px;
        cursor: pointer;

    }

    #main #schedule table tbody td #delete:active {
        background-position: -7px -10px;
    }

    #main #schedule table tbody td #delete:hover {
        background-position: -7px -13px;

    }

    #context {
        width: 641px;
        position: absolute;
        top: 0px;
    }

    #context table {
        float: left;
    }

    #context table td {
        height: 40px;
        width: 60px;
        text-align: center;

    }

    #context #text {
        width: 639px;
        height: 674px;
        border: 1px solid #000;
        border-radius: 7px;
        -webkit-border-radius: 7px;
        -moz-border-radius: 7px;
    }

    .invisual {
        display: none;
    }

    #asdf {
        position: absolute;
        top: 1000px;
        width: 10px;
        height: 10px;

    }
</style>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>


<script>
    /*	var contextlist=['sdfa1sdf','sdfa2sdf','sdfa3sdf','sdfas4df','sdfas5df','sdfas6df','sdfas7df','sdfa8sdf','sdfas9df','sdfas10df','sd11fasdf','sdfas12df','sdfa13sdf','sdfa14sdf','sdfas15df','sdf16asdf','sdfa17sdf','sdfas18df','sdf19asdf'];
    <%String a=request.getParameter("a");%> */
    var record = new Array();
    var num;
    <c:forEach items="${agendalist}" var="str" varStatus="vs">
    alert("nimeia");
    record[${vs.index}] = new Array();
    record[${vs.index}][0] ='${str.id}';
    record[${vs.index}][1] ='${str.title}';
    record[${vs.index}][2] ='${str.startDate}';
    record[${vs.index}][3] ='${str.content}';
    if (${vs.last}) {
        num = ${vs.index}+1;
    }
    </c:forEach>


    function init() {

        for (var i = 0; i < num; i++) {
            $('<tr id="tr_' + i + '"><td>' + (i + 1) + "</td><td>" + record[i][1] + "</td><td>" + record[i][2] + "</td><td>" + '<a onclick="showcontext(' + i + ')"></a>' + "</td><td>" + '<form  method="post" target="noneiframe" onclick=delete_(' + i + ') ><input type="submit" id="delete" value="" ><input type="hidden" name="id" value="' + record[i][0] + '"></form>' + "</td></tr>").appendTo("#tbody");
        }
        for (var i = 0; i < num; i++) {
            $('<tr><td id="index_' + i + '" onclick="showcontext(' + i + ')"><span>' + (i + 1) + '</span></td></tr>').appendTo("#index");
        }
        $('<tr><td><span onclick="returnschedule()">' + '返回' + '</span></td></tr>').appendTo("#index");
        var height = num * 62 + 54;
        document.getElementById("schedule").style.height = height + "px";
        $("#context").attr("class", "invisual");
        if (num == 0) {
            document.getElementById("schedule").style.height = "200px";
            $("#norecord").html("没有任何记录~~~<br>快点添加一条吧~~~");
        } else {
            $("#norecord").html("");
        }
    }

    function showcontext(i) {

        $("#schedule").attr("class", "invisual");
        $("#context").attr("class", "");
        $("#text").html(record[i][3]);
        for (var j = 0; j < num; j++) {
            $("#index_" + j).attr("class", "index_0");
        }
        $("#index_" + i).attr("class", "index_1");
    }
    function delete_(j) {
        num--;
        for (var i = j; i < num; i++) {

            record[i][0] = record[i + 1][0];
            record[i][1] = record[i + 1][1];
            record[i][2] = record[i + 1][2];
            record[i][3] = record[i + 1][3];

        }
        $("#index").html("");
        $("#tbody").html("");
        init();
    }
    function returnschedule() {
        $("#schedule").attr("class", "");
        $("#context").attr("class", "invisual");
    }

</script>
</head>
<body>
<div>
    <form method="post" action=JumpPage>
        <table border="0">
            <tr>
                <td><input type="button" value="添加日程" onclick="window.location.href='addagenda.jsp';"/>
                <td><input type="button" value="查询日程"/>&nbsp;</td>
                <td><input type="button" value="清除日程" /></td>
            </tr>
        </table>
    </form>
</div>
<div id="agendalist"></div>
<div id="main">
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
        <div id="text">

        </div>
    </div>
</div>
<div id="asdf">

</div>
<iframe name="noneiframe" style="display:none;"></iframe>
<script>
    $(function () {
        init();
    })
</script>
</body>
</html>