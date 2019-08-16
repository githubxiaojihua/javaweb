package com.xiaojihua.servlet;

import javafx.scene.input.DataFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * 通过cookie来实现，记录并提示上次登录的时间
 */
public class C21CaseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        //处理响应乱码
        response.setContentType("text/html;charset=utf-8");

        //获得所有的cookies
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if(cookies != null){
            for(Cookie cookie1 : cookies){
                if("lastTime".equals(cookie1.getName())){
                    cookie = cookie1;
                    break;
                }
            }
        }

        try{
            if(cookie != null){
                response.getWriter().println("您上次访问的时间是：" + cookie.getValue());
            }else{
                response.getWriter().println("欢迎访问！");
            }
        }catch(IOException e){
            System.out.println(e);
        }


        DateFormat format = DateFormat.getInstance();
        String time = format.format(new Date());
        cookie = new Cookie("lastTime",time);
        response.addCookie(cookie);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
