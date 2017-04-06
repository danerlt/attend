package com.st.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tao on 2017/4/3 0003.
 */
public class CharSetFilter implements Filter {
    private String myEncoding;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding(myEncoding);
        response.setCharacterEncoding(myEncoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //从web.xml文件读取默认编码
        this.myEncoding = config.getInitParameter("initEncoding");
    }

}
