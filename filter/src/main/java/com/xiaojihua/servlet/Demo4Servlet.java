package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Demo4Servlet 接收到请求");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }
}
