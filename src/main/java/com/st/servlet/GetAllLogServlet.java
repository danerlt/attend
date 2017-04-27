package com.st.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.st.dao.LogDao;
import com.st.dao.UserDao;
import com.st.entity.Log;
import com.st.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tao on 2017/4/9 0009.
 */
@WebServlet(name = "GetAllLogServlet",urlPatterns = "/admin/allLog")
public class GetAllLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            LogDao ld = new LogDao();
            List<Log> list = ld.findAll();
            UserDao ud = new UserDao();
            User u = new User();
            u = ud.get(list.get(0).getId());
            PrintWriter out = response.getWriter();
            out.println(u.toString());
            //将list的数据转换成JSON返回给前台
            JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
            //SerializerFeature.WriteDateUseDateFormat用来将日期格式化成yyyy-MM-dd的形式
            String json= JSON.toJSONString(list, SerializerFeature.WriteDateUseDateFormat);
            out.println(json);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
