package com.xiaojihua.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C08ServletGX2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取ServletContext对象
        ServletContext context = getServletContext();
        //从上下文对象中获取aa
        Object obj = context.getAttribute("aa");
        System.out.println(obj);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }

}
