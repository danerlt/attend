package com.st.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by tao on 2017/4/6 0006.
 */
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String currentURL = request.getRequestURI();
        String ctxPath = request.getContextPath();
        //除掉项目名称时访问页面当前路径
        String targetURL = currentURL.substring(ctxPath.length());
        //登录页面
        String loginPage = "/login.jsp";
        //登录的Servlet对应的url
        String loginServlet = "/login";
        HttpSession session = request.getSession(false);
        //对当前页面进行判断，如果当前页面不为登录页面
        if(loginPage.equals(targetURL)){
            //这里表示如果当前页面是登陆页面，跳转到登陆页面
            chain.doFilter(request, response);
            return;
        }else{
            if(loginServlet.equals(targetURL)){
                //Servlet验证
                chain.doFilter(request, response);
                return;
            }else{
                //在不为登陆页面时，再进行判断，如果不是登陆页面也没有session则跳转到登录页面，
                if(session == null || session.getAttribute("uid") == null || session.getAttribute("uname") == null){
                    response.sendRedirect(ctxPath+loginPage);
                    return;
                }else{
                    //这里表示正确，会去寻找下一个链，如果不存在，则进行正常的页面跳转
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
