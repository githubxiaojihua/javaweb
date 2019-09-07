package com.xiaojihua.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Demo1Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("demo1Filter1过滤到请求");
        //放行才能到达最终的servlet，如果没有这句的话会直接打印最后一句并不会到servlet中
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("demo1Filter1过滤到响应");
    }

    @Override
    public void destroy() {

    }
}
