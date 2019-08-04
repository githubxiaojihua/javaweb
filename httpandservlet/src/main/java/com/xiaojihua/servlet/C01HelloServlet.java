package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 知识点：
 * servlet的使用。
 * 1、导入servlet和jsp依赖包。
 * 2、继承HttpServlet，然后重写doGet，或者其他方法
 * 3、在web.xml中配置servlet
 * 4、运行tomcat，按照配置的路径请求servlet
 */
public class C01HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("get 请求将执行");
    }
}
