package com.xiaojihua.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 默认servlet不会跟随服务器启动而初始化的
 * 通过在web.xml中设置load-on-startup参数来实现。
 * 并且可以根据参数的大小来决定初始化的顺序，数值越小那么优先级越高
 */
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
