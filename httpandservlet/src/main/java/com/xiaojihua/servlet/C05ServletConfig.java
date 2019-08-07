package com.xiaojihua.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * servletConfig对象API
 */
public class C05ServletConfig extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取ServletConfig对象
        ServletConfig config = getServletConfig();
        //获取servletName
        String servletName = config.getServletName();
        System.out.println("servletName:" + servletName);

        //获取servlet的初始化参数
        String db = config.getInitParameter("db");
        System.out.println("db:" + db);

        //获取所有的初始化参数
        Enumeration<String> parameters = config.getInitParameterNames();
        while(parameters.hasMoreElements()){
            String name = parameters.nextElement();
            System.out.println(name + ":" + config.getInitParameter(name));
        }

        //获取servletContext对象
        ServletContext servletContext = config.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request, response);
    }

}
