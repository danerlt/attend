# attend
JSP+Servlet+JDBC+MySQL+Bootstrap+Maven搭建的一个简单的考勤系统
![登录界面][1]

## 目录说明
|目录|作用|
|--|--|
|src|存放源码和资源文件|
|target|项目生成的目标文件|
|web|WEB-INF目录和web.xml文件存放位置|
![image_1bcnmpbkohcktfe6em1fj51ene9.png-13.8kB][2]
### src
java目录下是所有Java源码,resources存放资源文件,test目录下是测试源码,webapp下是jsp页面和前端资源
![src 目录][3]
### main > java
存放所有的java源代码,基础包名为com.st

#### entity
- Log
对应日志表
- User
对应用户表
#### dao
- LogDao
>包含对Log的增删改查等操作
- UserDao
>包含对User的增删改查等操作
#### filter
- AdminLoginFilter.java
>管理员登录过滤器,管理员未登录时会被重定向到admin/login.jsp,**暂时未实现**,
- CharSetFilter
>中文乱码过滤器
- LoginFilter.java
>用户登录过滤器,当用户未登录时会重定向到login.jsp,
#### servlet
- AddLogServlet 
> 添加日志,已实现
- AdminLoginServlet
> 管理员登录Servlet,有bug,style.css会被重定向
- DelLogServlet
>删除日志,未实现
- ExportExcelServlet
>导出日志,未实现
- GetLogServlet
> 根据用户id查询所有日志,以实现
- LoginServlet
>用户根据id和密码登录,以实现
#### util
- DBUtil.java
> 封装的数据库工具,
- ExportExcel
> 导出excel工具,未实现
### main > resources
存放资源目录,其下的attend.sql为sql语句
### main > webapp
WEB-INF存放web.xml,js存放js文件,css存放css文件
### test > java
存放所有的测试源代码,其中的报名与main下java目录下包名对应
### test > resources
存放测试用的资源文件

  [1]: http://static.zybuluo.com/danerlt/u96sl90kt7et23wb2sc5bao2/image_1bcnm2ivpspinqq1d2s21h75d9.png
  [2]: http://static.zybuluo.com/danerlt/x5cog2vq8g7ssnwg3delrm98/image_1bcnmpbkohcktfe6em1fj51ene9.png
  [3]: http://static.zybuluo.com/danerlt/bgbyqeg97qc24m8ux9lfxpxs/image_1bcnn3t7i1lhe1sphpj81csn1lrr1j.png