package com.xiaojihua.filter;

import com.xiaojihua.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QxFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1、强转servletRequest为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        //2、从session中获取用户
        HttpSession session = request.getSession();
        User currUser = (User) session.getAttribute("user");
        //2.1判断是否存在，不存在则提示登陆
        if(currUser == null){
            request.setAttribute("msg","亲，请先登录！");
            request.getRequestDispatcher("/jsp/info.jsp").forward(request,servletResponse);
            return;
        }

        //2.2存在则放行
        filterChain.doFilter(request,servletResponse);


    }

    @Override
    public void destroy() {

    }
}
