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
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-table.css">
    <link rel="stylesheet" href="css/bootstrap-combined.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
    <script src="js/vue.js"></script>
    <script src="js/app.js"></script>
</head>
<body>
<div id="nav">
    <ul>
        <li class="menu" onclick="">导航</li>
        <li>><a href="#" onclick="findLog()">查询日志</a></li>
        <li>><a href="#">提交日志</a></li>
    </ul>
</div>
<div id="content">
    <div class="title">

    </div>
    <div class="display">
        <p><b><%=session.getAttribute("uname")%>的个人工作日志</b></p>
    </div>
    <div class="serch">
        <input type="text" name="" class="text" placeholder="按时间查找"/>
        <button class="submit" onclick="findLog()">查看</button>
        <!-- 按钮触发模态框 -->
        <button class="submit" data-toggle="modal" data-target="#myModal">新增</button>
    </div>
    <div class="table-responsive">
        <table id="table" class="table table-striped table-hover">
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
        </table>
    </div>


    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h2 class="modal-title" id="myModalLabel">个人工作日志</h2>
                </div>
                <form class="form-horizontal" method="post">
                    <div class="modal-body">
                        <fieldset>
                            <div class="control-group" style="display: none">
                                <!-- Text input-->
                                <label class="control-label" ></label>
                                <div class="controls">
                                    <input id="uid" name="uid" >
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Text input-->
                                <label class="control-label" >姓名</label>
                                <div class="controls">
                                    <input name="uid" class="input-mini" value='<%=session.getAttribute("uname")%>' readonly disabled>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">日期</label>
                                <div id="datetimepicker" class="input-append date" style="margin-left:20px;">
                                    <input type="text" name="workdate" id="time"/>
                                    <span class="add-on">
                                        <i data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">时长</label>
                                <div class="controls">
                                    <!-- Inline Radios -->
                                    <label class="radio inline">
                                        <input checked="checked" value="one day" name="group1" type="radio">
                                        一天
                                    </label>
                                    <label class="radio inline">
                                        <input value="just so so" value="half day" name="group1" type="radio">
                                        半天
                                    </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Textarea -->
                                <label class="control-label">内容</label>
                                <div class="controls">
                                    <div class="textarea">
                                        <textarea type="" class="" name="describe"> </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">难度</label>
                                <div class="controls">
                                    <!-- Inline Radios -->
                                    <label class="radio inline">
                                        <input checked="checked" value="易" name="difficulty" type="radio">
                                        易
                                    </label>
                                    <label class="radio inline">
                                        <input checked="checked" value="中" name="difficulty" type="radio">
                                        中
                                    </label>
                                    <label class="radio inline">
                                        <input checked="checked" value="难" name="difficulty" type="radio">
                                        难
                                    </label>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Textarea -->
                                <label class="control-label">备注</label>
                                <div class="controls">
                                    <div class="textarea">
                                        <textarea type="" class="" name="remark"> </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"></label>

                                <!-- Button -->
                                <div class="controls">
                                    <button class="btn btn-success">提交</button>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label"></label>
                            </div>
                        </fieldset>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    <

</div>
</body>
</html>
