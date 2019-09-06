package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class AjaxJqueryDemo1Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //解决响应乱码
        resp.setContentType("text/html;charset=utf-8");
        String userName = req.getParameter("userName");
        //解决请求乱码
        userName = new String(userName.getBytes("ISO8859-1"),"UTF-8");
        //生成相应，向前台写数据
        resp.getWriter().println(userName);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //解决响应乱码
        resp.setContentType("text/html;charset=utf-8");
        //解决请求乱码
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("userName");
        String pass = req.getParameter("pass");
        resp.getWriter().println(userName + ";" + pass);
    }
}
