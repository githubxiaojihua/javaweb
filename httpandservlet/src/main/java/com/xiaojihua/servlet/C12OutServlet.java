package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class C12OutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //字符流和字节流不能同时出现   俩流互斥
        //什么时候使用字符流什么时候使用字节流，有个比较好的区别：
        //输出能手写的文字比如文本，html,xml可以用字符流，
        //输出不能手写的比如图片，音频，视频等就用字节流
        /*ServletOutputStream outputStream = response.getOutputStream();*/
        //解决响应乱码第一种方式
        //response.setHeader("content-type", "text/html;charset=utf-8");
        //解决响应乱码第二种方式
        response.setContentType("text/html;charset=utf-8");


        response.getWriter().print("<table border=1px>");

        response.getWriter().print("<tr>");

        response.getWriter().print("<td>");
        response.getWriter().print("汤姆猫");
        response.getWriter().print("</td>");

        response.getWriter().print("<td>");
        response.getWriter().print("123");
        response.getWriter().print("</td>");

        response.getWriter().print("</tr>");

        response.getWriter().print("</table>");


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request,response);
    }
}
