package com.st.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.st.dao.LogDao;
import com.st.entity.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by tao on 2017/4/4 0004.
 */
@WebServlet("/findlog")
public class GetLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int uid = Integer.parseInt(request.getParameter("uid"));
            LogDao ld = new LogDao();
            List<Log> list = ld.getByUid(uid);
            PrintWriter out = response.getWriter();
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
