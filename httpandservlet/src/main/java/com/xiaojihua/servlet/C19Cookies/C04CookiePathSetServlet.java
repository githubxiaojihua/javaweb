package com.xiaojihua.servlet.C19Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class C04CookiePathSetServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie1 = new Cookie("bkey","bvalue");
        Cookie cookie2 = new Cookie("ckey","cvalue");
        Cookie cookie3 = new Cookie("dkey","dvalue");
        Cookie cookie4 = new Cookie("dkey","dvalue");

        /**
         * 在未设置path的情况下如果dkey重复那么会覆盖。也就是说
         * 虽然上面设置了4个COOKIE也往浏览器里面写入了4个但是实际上
         * 只会有三个，因为第三个被第四个覆盖了。
         * 但是如果他们属于不同的path那么就不会。
         *
         * 在未设置path的情况下默认的path是从项目路径开始到最后一个/结束
         * 比如http://localhost/httpservlet/aa/bb/cc。那么其设置的
         * cookie默认路径是/httpservlet/aa/bb
         *
         * 并且浏览器在HTTP请求头中携带的cookie是根据path来判断的，
         * 如果请求的地址包含cookie的地址，那么所属的cookie才会被携带
         */
        cookie3.setPath(request.getContextPath() + "/aa/bb");

        response.addCookie(cookie1);;
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        response.addCookie(cookie4);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
