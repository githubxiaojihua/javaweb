package com.xiaojihua.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class Demo7Filter implements Filter {
    FilterConfig fc = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Demo7Filter  过滤到请求");
        //获取Filter的名字
        String filterName = fc.getFilterName();
        System.out.println(filterName);
        //获取Filter的初始化参数
        String db = fc.getInitParameter("db");
        System.out.println(db);
        //获取所有初始化参数
        Enumeration<String> names = fc.getInitParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name + ":" + fc.getInitParameter(name));
        }
        //获取servletContext
        ServletContext context = fc.getServletContext();
        System.out.println(context);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
