package com.xiaojihua.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Enumeration;

public class C07ServletGX1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取ServletContext对象
        ServletContext context = getServletContext();
        //往上下文对象中写入数据
        context.setAttribute("aa","AA");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }

}
