package com.xiaojihua.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class C03ServletStart implements Servlet {

    @Override
    public void init(ServletConfig config){
        System.out.println("first load");
    }

    @Override
    public void service(ServletRequest request, ServletResponse response){
    }

    @Override
    public ServletConfig getServletConfig(){
        return null;
    }

    @Override
    public String getServletInfo(){
        return null;
    }

    @Override
    public void destroy(){

    }
}
