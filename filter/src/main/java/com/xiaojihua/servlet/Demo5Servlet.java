package com.xiaojihua.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo5Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo5Servlet 接收到请求");
        request.getRequestDispatcher("/demo6").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doPost(request,response);
    }
}
