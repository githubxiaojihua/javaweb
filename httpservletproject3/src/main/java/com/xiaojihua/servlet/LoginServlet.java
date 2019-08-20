package com.xiaojihua.servlet;

import com.xiaojihua.bean.User;
import com.xiaojihua.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        LoginService service = new LoginService();
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        User user = service.getUserByUserNameAndPass(userName,pass);
        try{
            if(user == null){
                request.setAttribute("msg","登录出错");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                response.getWriter().println(user.getUserName() + ",欢迎回来");
            }
        }catch(ServletException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
