package com.xiaojihua.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过jdk动态代理重写后的filter
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //被代理的对象，首先强制转化成HttpServletRequest
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        //创建动态代理对象
        HttpServletRequest reqProxy = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //对getParameter方法进行代理，并分别对get和post进行不同的乱码解决
                if("getParameter".equalsIgnoreCase(method.getName())){
                    //解决get乱码
                    if("get".equalsIgnoreCase(request.getMethod())){

                        String obj = (String) method.invoke(request,args);
                        String result = new String(obj.getBytes("iso8859-1"),"utf-8");
                        return result;
                    }
                    //解决post乱码
                    if("post".equalsIgnoreCase(request.getMethod())){
                        request.setCharacterEncoding("utf-8");
                        //写不写下面这一句都可以
                        //return method.invoke(request,args);
                    }
                }

                //其他方法原样返回
                return method.invoke(request,args);
            }
        });

        //放行
        filterChain.doFilter(reqProxy,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
