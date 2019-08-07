package com.xiaojihua.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class C10RedirictOne extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("开始重定向：");
        //方式1：通过设置相应头来实现重定向
        //主要是借助状态码以及location相应头来完成
        /*response.setStatus(302);
        response.setHeader("location","/httpservlet/redirictTwo");*/

        //方式2：底层还是使用上面的方法来实现的
        response.sendRedirect("/httpservlet/redirictTwo");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
