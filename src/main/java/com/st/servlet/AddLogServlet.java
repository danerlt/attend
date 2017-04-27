package com.st.servlet;
import com.st.dao.LogDao;
import com.st.entity.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by tao on 2017/4/5 0005.
 */
@WebServlet(name = "AddLogServlet",urlPatterns = "/addlog")
public class AddLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //获取参数
           int uid = Integer.parseInt(request.getParameter("uid"));
           Date workdate = Date.valueOf(request.getParameter("workdate"));
           String describe = request.getParameter("describe");
           int worktime = Integer.parseInt(request.getParameter("worktime"));
           String difficulty = request.getParameter("difficulty");
           String remark =  request.getParameter("remark");
           String status = "未审核";
          //生成日志对象
           Log log = new Log(0,uid,workdate,describe,worktime,difficulty,remark,status);
           LogDao ld = new LogDao();
           //插入数据
           boolean result = ld.addWithoutId(log);
           PrintWriter out = response.getWriter();
           boolean returnMsg = false;
           if (result == true){
               returnMsg = true;
           }
           out.println(returnMsg);
           out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
