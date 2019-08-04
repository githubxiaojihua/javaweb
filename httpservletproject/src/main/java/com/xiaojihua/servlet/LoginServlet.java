package com.xiaojihua.servlet;

import com.xiaojihua.domain.Users;
import com.xiaojihua.service.LoginService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    LoginService service = new LoginService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        response.setHeader("content-Type","text/html;charset=utf-8");
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");

        Users user = service.loginByUserNameAndPassword(userName,pass);
        System.out.println(user);


        try{
            if(user != null){
                response.getWriter().println(userName + " 欢迎您！");
            }else{
                response.getWriter().println(userName + " 登录失败！");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
