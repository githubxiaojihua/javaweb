package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * request中请求头相关API
 */
public class C13RequestApiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        //获取请求的方式
        String method = request.getMethod();
        System.out.println("获取请求的方式:" + method);
        //获取项目的动态路径
        String path = request.getContextPath();
        System.out.println("获取项目的动态路径:" + path);
        //获取请求者的ip
        /*
            如果前端请求的地址是localhost:8080......
            那么这里获得到的IP地址是ip:0:0:0:0:0:0:0:1
            这是IPV6的格式，如果将地址栏换成127.0.0.1:8080.。。。
            那么这里得到的IP地址是：ip:127.0.0.1
         */
        String addr = request.getRemoteAddr();
        System.out.println("获取请求这的ip:" + addr);
        //获取请求的资源（不带IP)
        String uri = request.getRequestURI();
        System.out.println("获取请求的资源（不带ip):" + uri);
        //获取请求的参数
        String queryString= request.getQueryString();
        System.out.println("获取请求的参数：" + queryString);
        //获取协议和版本
        String protocal = request.getProtocol();
        System.out.println("获取协议和版本：" + protocal);
        //组装请求头
        System.out.println(method + " " + uri + "?" + queryString + " " + protocal);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
