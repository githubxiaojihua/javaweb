package com.xiaojihua.servlet;

import com.xiaojihua.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //解决乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        System.out.println(pass);
        UserService service = new UserService();
        try {
            int flag = service.getFlag(userName);
            response.getWriter().println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        doGet(request,response);
    }
}
