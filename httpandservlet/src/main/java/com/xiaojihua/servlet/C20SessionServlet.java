package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * session的创建。
 * 相关知识点可以参考课程思维导图。
 */
public class C20SessionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        /*
            当没有这句的时候，服务器是不会在http响应中设置sessionId的，
            只有在调用了getSession()方法后，Session才会被创建出来，并
            分配一个唯一的sessionId，然后通过http响应写入到浏览器端
            格式类似于：
            Set-Cookie: JSESSIONID=9C6BA11476E9D9CE248CF44336425614;
            浏览器在下一次进行请求的时候就会携带SESSIONid的cookie
         */
        request.getSession();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
