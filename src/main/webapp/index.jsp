<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="css/bootstrap-table.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-combined.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
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
        <p><b><%=session.getAttribute("uName")%>的个人工作日志</b></p>
    </div>
    <div class="serch">
        <input type="text" name="" class="text" placeholder="按时间查找"/>
        <button id="findlog" class="submit" onclick="findLog()">查看</button>
        <!-- 按钮触发模态框 -->
        <button class="submit" data-toggle="modal" data-target="#myModal" onclick="">新增</button>
        <button class="submit" onclick="exportXls()">导出</button>
    </div>
    <div class="table-responsive">
        <table id="table" class="table table-striped table-hover" style="display: none">
            <thead>
            <tr>
                <%--<th data-field="workdate">日期</th>--%>
                <%--<th data-field="desribe">内容</th>--%>
                <%--<th data-field="worktime">时长</th>--%>
                <%--<th data-field="difficulty">难度</th>--%>
                <%--<th data-field="remark">备注</th>--%>
                <%--<th data-field="status">状态</th>--%>
                <th >序号</th>
                <th >日期</th>
                <th >内容</th>
                <th >时长</th>
                <th >难度</th>
                <th >备注</th>
                <th >状态</th>
                <th >操作</th>
            </tr>
            <tr v-for="log in logs" >
                <td>{{logs.indexOf(log)+1}} <span style="display: none">{{log.id}}</span></td>
                <td>{{log.workdate}}</td>
                <td>{{log.desribe}}</td>
                <td>{{log.worktime}}</td>
                <td>{{log.difficulty}}</td>
                <td>{{log.remark}}</td>
                <td>{{log.status}}</td>
                <td>
                    <span style="display: none">{{log.id}}</span>
                    <a class="btn btn-danger" onclick="acceptLog(this)">审核</a>
                    <a class="btn btn-danger" onclick="delLog(this)">删除</a>
                </td>
            </tr>
            </thead>
        </table>
    </div>


    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <%--<div class="modal-dialog">--%>
            <div class="modal-content">
                <div class="modal-header">
                    <button id="closeModel" type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h2 class="modal-title" id="myModalLabel">个人工作日志</h2>
                </div>

                    <div class="modal-body">
                        <form id="addfrom" name="addfrom" class="form-horizontal" role="from" method="get" action="/addlog" >
                        <fieldset>
                            <div class="control-group" style="display: none">
                                <!-- Text input-->
                                <label class="control-label" ></label>
                                <div class="controls">
                                    <input id="uid" name="uid" value='<%=session.getAttribute("uId")%>' hidden>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Text input-->
                                <label class="control-label" >姓名</label>
                                <div class="controls">
                                    <input class="input-mini" value='<%=session.getAttribute("uName")%>' readonly disabled>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">日期</label>
                                <div class="controls">
                                    <input id="workdate" type="date" name="workdate" id="time"/>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">时长</label>
                                <div class="controls">
                                    <select name="worktime" id="">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8" selected>8</option>
                                        <option value="9">9</option>
                                    </select>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Textarea -->
                                <label class="control-label">内容</label>
                                <div class="controls">
                                    <div class="textarea">
                                        <textarea type="" class="form-control" name="describe" rows="5" cols="10" > </textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">难度</label>
                                <div class="controls">
                                    <select name="difficulty" >
                                        <option value="易" selected>易</option>
                                        <option value="中">中</option>
                                        <option value="难">难</option>
                                    </select>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Textarea -->
                                <label class="control-label">备注</label>
                                <div class="controls">
                                    <div class="textarea">
                                        <textarea type="" class="form-control" name="remark" rows="4" cols="10" > </textarea>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button id="closeAddFrom" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submint" class="btn btn-primary" onclick="addLog()">提交</button>
                        <input type="reset" name="reset" style="display: none;" />
                    </div>

            </div><!-- /.modal-content -->
        <%--</div><!-- /.modal -->--%>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-datetimepicker.min.js"></script>
<script src="js/vue.js"></script>
<script src="js/app.js"></script>
</body>
</html>
