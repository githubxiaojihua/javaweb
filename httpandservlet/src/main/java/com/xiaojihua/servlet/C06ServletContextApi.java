package com.xiaojihua.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Enumeration;

public class C06ServletContextApi extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取servletContext对象，两种方法都可以获取到
        ServletContext context = getServletContext();
        //ServletContext context1 = getServletConfig().getServletContext();

        //获取全局初始化参数
        String db = context.getInitParameter("db");
        System.out.println("获取全局参数：" + db);
        //获取所有全局初始化参数
        Enumeration<String> parameters = context.getInitParameterNames();
        while(parameters.hasMoreElements()){
            String paraName = parameters.nextElement();
            System.out.println("获取全局参数：" + context.getInitParameter(paraName));
        }
        //获取一个资源在服务器上的真实路径（在服务器上的绝对路径）
        String path = context.getRealPath("/index.jsp");
        System.out.println("获取文件的真实路径：" + path);
        //以流的形式返回一个文件
        InputStream inputStream =  context.getResourceAsStream("/index.jsp");
        System.out.println("获取文件输入流：" + inputStream);
        //获取一个文件的MEMA类型（在http请求头的Accept和响应头中的Content-type）
        /*
            text/plain
            text/html
            text/css
            image/jpeg
            image/png
            image/svg+xml
            audio/mp4
            video/mp4
            application/javascript
            application/pdf
            application/zip
            application/atom+xml
            这些数据类型总称为MIME type，每个值包括一级类型和二级类型，之间用斜杠分隔
            MIME type还可以在尾部使用分号，添加参数。

            如果文件类型不在MIME type中那么返回null
            比如index.jsp那么返回的就是null
            下面的/1.html是绝对路径，绝对路径有两种
            一种是htt://。。。。。/1.html
            另一种就是/1.html这个/就代表了项目也就是webapp这一级
         */
        String mimeType = context.getMimeType("/1.html");
        System.out.println("获取文件的MIMETYPE:" + mimeType);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }

}
