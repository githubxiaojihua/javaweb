package com.xiaojihua.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        filterChain.doFilter(new MyCode(request),servletResponse);
    }

    @Override
    public void destroy() {

    }
}

class MyCode extends HttpServletRequestWrapper{
    public MyCode(HttpServletRequest request){
        super(request);
    }

    @Override
    public String getParameter(String name){
        String method = super.getMethod();
        if("get".equalsIgnoreCase(method)){
            String value = super.getParameter(name);
            try {
                value = new String(value.getBytes("ISO-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return value;
        }else if("post".equalsIgnoreCase(method)){
            try {
                super.setCharacterEncoding("utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return super.getParameter(name);
        }
        return super.getParameter(name);
    }

}