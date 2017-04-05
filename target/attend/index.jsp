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
    <div class="title">
        工作日志导航
    </div>
    <ul>
        <li class="menu2" onclick="if(this.className=='menu2'){this.className='menu1'}else{this.className='menu2'}">导航一
            <div class="select">
                <a href="/findlog?uid=1001">查询日志</a>
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
            <input type="button" value="查看" class="submit" onclick="findLog()" />
            <input type="button" value="新增" class="submit" onclick="" />
            <input type="button" value="更改" class="submit" onclick="" />
            <input type="button" value="删除" class="submit" onclick="" />
        </from>
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
            </tr>
            </thead>
        </table>
    </div>

    <form class="form-horizontal">
        <fieldset>
            <div id="legend" class="">
                <legend class="">工作日志</legend>
            </div>
            <div class="control-group">
            <!-- Text input-->
            <label class="control-label" for="input01">姓名</label>
            <div class="controls">
                <input name="uid" hidden:true>
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
                </div><div class="control-group">
                <label class="control-label"></label>


                </div>

                </fieldset>
                </form>

</div>
</body>
</html>
