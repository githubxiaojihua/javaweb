package com.xiaojihua.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 知识点：
 * 还可以通过实现servlet接口的方式实现servelt
 * 重写其service方法
 */
public class C02ServletDemo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service 方法接收到请求");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
