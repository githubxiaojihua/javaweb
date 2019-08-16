package com.xiaojihua.servlet.C19Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除路径为/httpservlet/aa/bb的dkey cookie
 *
 */
public class C05KillCookieServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        Cookie cookie = new Cookie("dkey","sdfsdfsdsfdf");
        //设置
        cookie.setPath(request.getContextPath() + "/aa/bb");
        //删除，只需要设置存活时间为0即可
        cookie.setMaxAge(0);
        //写回浏览器
        response.addCookie(cookie);;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
