package com.xiaojihua.downLoad;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * 设置下载有如下两种方式：
 * 1、在浏览器端使用a标签，直接连接到服务器的某些资源是可以完成部分下载的，但是如果
 * 下载的文档能够被浏览器解析比如txt,或者图片那么就会在浏览器直接显示并不会弹出下载框提供下载，
 * 只有浏览器不认识的格式才会弹出下载框。
 * 2、通过在serlet设置可以让所有下载都走下载框的样式，这样比较统一。
 * servlet设置下载的时候需要设置两个相应头和一个流：
 * response.setHeader("content-type",mimeType);
 * response.setHeader("content-disposition","attachment;filename=" + fileName);
 *
 * InputStream in = context.getResourceAsStream("/" + fileName);
 * ServletOutputStream out = response.getOutputStream();
 */
public class C01DownLoadServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        //获取servletContext对象
        ServletContext context = getServletContext();
        String fileName = request.getParameter("fileName");
        String mimeType = context.getMimeType("/" + fileName);

        //设置下载相应头，如果不设置是无法做到统一格式的。
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename=" + fileName);

        //读取文件内容输出到输出流，提供下载
        InputStream in = context.getResourceAsStream("/" + fileName);
        ServletOutputStream out = response.getOutputStream();
        byte[] byteArr = new byte[1024];
        int count = 0;
        while((count = in.read(byteArr)) != -1){
            out.write(byteArr,0,count);
        }

        out.close();
        in.close();

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        doGet(request,response);
    }
}
