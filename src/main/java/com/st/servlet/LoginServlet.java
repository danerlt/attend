package com.st.servlet;

import com.st.entity.User;
import com.st.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import com.st.dao.UserDao;
/**
 * Created by tao on 2017/4/2 0002.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            UserDao ud = new UserDao();
            User u = ud.get(id,password);
            if(u == null){
                response.sendRedirect("login.jsp");
            }else{
                request.getSession().setAttribute("uid",u.getId());
                request.getSession().setAttribute("uname",u.getUsername());
                URLEncoder.encode("Name","UTF-8");
                Cookie Id =new Cookie("userId",String.valueOf(u.getId()));
                Cookie Pass = new Cookie("userPwd",u.getPassword());
                Cookie Name = new Cookie("Name",u.getUsername());
                response.addCookie(Id);
                response.addCookie(Pass);
                response.addCookie(Name);
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
