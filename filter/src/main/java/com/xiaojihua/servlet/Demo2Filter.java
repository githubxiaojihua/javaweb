package com.xiaojihua.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Demo2Filter implements Filter {
    //服务器创建的时候执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("5555555555555555");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("666666666666666");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    //服务器正常关闭的时候执行
    @Override
    public void destroy() {
        System.out.println("4444444444444444444");
    }
}
