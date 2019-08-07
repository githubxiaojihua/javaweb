package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C11RedirictTwo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("thiis is redirect two");
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
