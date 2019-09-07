package com.xiaojihua.servlet;


import com.xiaojihua.bean.User;
import com.xiaojihua.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //把servletReuqest强转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //判断session中是否有用户存在
        String username1=(String)request.getSession().getAttribute("username");
        if(username1!=null){
            //放行
            filterChain.doFilter(request, response);
            return;
        }
        //获取所有的cookie
        Cookie[] cookies = request.getCookies();
        Cookie co = null;
        //判断cookies是否为null
        if(cookies!=null){
            //从cookies中查找与usernameAndPwd相匹配的cookie
            for(Cookie cookie:cookies){
                if("usernameAndPass".equals(cookie.getName())){
                    co=cookie;
                }
            }
        }

        //判断是否是第一次登录
        if(co!=null){

            //获取cookie中的用户名和密码
            String up = co.getValue();
            String[] sp = up.split("-");
            String username = sp[0];
            String password = sp[1];
            //完成自动登录,调用LoginService
            LoginService ls = new LoginService();
            try {
                User user = ls.getUserByUserNameAndPass(username, password);
                System.out.println("查询一次数据库");
                if(user!=null){
                    //保证用户在线
                    request.getSession().setAttribute("username", user.getUserName());
                }
                //放行
                filterChain.doFilter(request, response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
