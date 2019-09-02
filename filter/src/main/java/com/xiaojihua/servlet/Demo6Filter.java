package com.xiaojihua.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Demo6Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Demo6Filter  过滤到请求");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Demo6Filter  过滤到响应");
    }

    @Override
    public void destroy() {

    }
}
