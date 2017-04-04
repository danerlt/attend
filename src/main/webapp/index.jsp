<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2017/4/1 0001
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/vue.js"></script>
</head>
<body>
<div id="nav">
    <div class="title">
        工作日志导航
    </div>
    <ul>
        <li class="menu2" onclick="if(this.className=='menu2'){this.className='menu1'}else{this.className='menu2'}">导航一
            <div class="select">
                <a href="login.html">查询日志</a>
                <a href="#">提交日志</a>
                <a href="#">更新日志</a>
                <a href="#">删除日志</a>
            </div>
        </li>
    </ul>
</div>
<div id="content">
    <div class="title">

    </div>
    <div class="display">
        <p><b>XXX个人工作日志</b></p>
    </div>
    <div class="serch">
        <from name="from1">
            <input type="text" name="" class="text" placeholder="按时间查找" />
            <input type="button" value="查询" class="submit" onclick="" />
            <input type="button" value="新增" class="submit" onclick="" />
            <input type="button" value="更改" class="submit" onclick="" />
            <input type="button" value="删除" class="submit" onclick="" />
        </from>
    </div>
    <div class="table">
        <table>
            <tr class="th">
                <td>时间</td>
                <td class="text">内容</td>
                <td>时长</td>
                <td>难度</td>
                <td>备注</td>
            </tr>
            <tr>
                <td>123</td>
                <td class="text">123</td>
                <td>123</td>
                <td>123</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
