package com.xiaojihua.servlet;

import javax.servlet.*;

public class C02ServletLeftTime implements Servlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("只在调用的时候初始化一次，是单例模式的");
        System.out.println(Thread.currentThread() + " " + this);
    }

    @Override
    public void service(ServletRequest request, ServletResponse response){
        System.out.println("每次请求服务器都会为请求分配一个线程，来调用service方法");
        System.out.println(Thread.currentThread() + " " + this);
    }

    @Override
    public void destroy(){
        System.out.println("只在服务器关闭或者项目卸载的时候调用一次。");
        System.out.println(Thread.currentThread() + " " + this);
    }

    @Override
    public ServletConfig getServletConfig(){
        return null;
    }

    @Override
    public String getServletInfo(){
        return null;
    }

}
