<%--
  Created by IntelliJ IDEA.
  User: tao
  Date: 2017/4/7 0007
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录界面</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/bootstrap-table.min.css"/>
    <link rel="stylesheet" href="../css/bootstrap-combined.min.css"/>
    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="../css/style.css"/>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/bootstrap-table.js"></script>
    <script src="../js/bootstrap-datetimepicker.min.js"></script>
    <script src="../js/vue.js"></script>
    <script src="../js/app.js"></script>
</head>
<body>
<div id="content">
    <div class="title">

    </div>
    <div class="display">
        <p><b>管理员<%=session.getAttribute("adminName")%></b></p>
    </div>
    <div class="serch">
        <%--<form action="">--%>
            <%--<input type="text" name="serach" class="text" placeholder="按时间或者姓名查找"/>--%>
            <button class="submit" onclick="findAllLog()">查看</button>
            <button class="submit">审核</button>
            <button class="submit">驳回</button>
            <button class="submit" onclick="exportAllToXls()">导出</button>
        <%--</form>--%>

    </div>
    <div class="table-responsive">
        <table id="admintable" class="table table-striped table-hover">
            <thead>
            <tr>
                <th data-field="workdate">日期</th>
                <th data-field="desribe">内容</th>
                <th data-field="worktime">时长</th>
                <th data-field="difficulty">难度</th>
                <th data-field="remark">备注</th>
                <th data-field="status">状态</th>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>

</body>
</html>
