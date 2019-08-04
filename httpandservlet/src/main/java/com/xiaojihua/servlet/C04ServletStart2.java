package com.xiaojihua.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class C04ServletStart2 implements Servlet {

    @Override
    public void init(ServletConfig config){
        System.out.println("second load");
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
