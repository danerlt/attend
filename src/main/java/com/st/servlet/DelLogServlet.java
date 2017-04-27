package com.st.servlet;

import com.st.dao.LogDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tao on 2017/4/26 0026.
 */
@WebServlet(name = "DelLogServlet",urlPatterns = "/delLog")
public class DelLogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String param = request.getParameter("id");
            PrintWriter out = response.getWriter();
            if (param != null){
                int id = Integer.parseInt(param);
                LogDao ld = new LogDao();
                boolean result = ld.delete(id);
                out.println(result);
                out.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
