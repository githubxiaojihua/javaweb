package com.xiaojihua.servlet.C19Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C03CookieTimeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie1 = new Cookie("bkey","bvalue");
        Cookie cookie2 = new Cookie("ckey","cvalue");
        Cookie cookie3 = new Cookie("dkey","dvalue");

        //设置超时时间
        cookie2.setMaxAge(3600);

        response.addCookie(cookie1);;
        response.addCookie(cookie2);
        response.addCookie(cookie3);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
