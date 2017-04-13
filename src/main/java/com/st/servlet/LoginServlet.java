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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //获取参数
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            //获取项目路径
            String ctxPath = request.getContextPath();
            UserDao ud = new UserDao();
            //通过用户id和password获取用户
            User u = ud.get(id,password);
            String loginPage = "/login.jsp";
            String indexPage = "/index.jsp";
            PrintWriter out  = response.getWriter();
            if(u == null) {
                //没有找到
                out.println("用户不存在或者密码错误!");
                out.close();
            } else {
                //找到用户,设置session
                request.getSession().setAttribute("uId",u.getId());
                request.getSession().setAttribute("uName",u.getUsername());
                //设置cookie
                URLEncoder.encode("Name","UTF-8");
                Cookie Id =new Cookie("userId",String.valueOf(u.getId()));
                Cookie Pass = new Cookie("userPwd",u.getPassword());
                Cookie Name = new Cookie("Name",u.getUsername());
                response.addCookie(Id);
                response.addCookie(Pass);
                response.addCookie(Name);
                //设置成功跳转到主页
                response.sendRedirect(ctxPath+indexPage);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
