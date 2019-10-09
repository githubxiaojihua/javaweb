package com.xiaojihua.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 一个普通的servlet
 */
public class SerletDemo1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("username");
        //输出看是否乱码
        System.out.println(name);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
