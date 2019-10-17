package com.xiaojihua.utils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 通过抽取BaseServlet达到，根据请求中的不同方法调用同一个servlet中不同方法的目的，
 * 通过反射机制实现了一次编码（如果是使用if else的方法根据请求参数来判断的话，当有新的
 * 方法请求的时候还需要改动if else语句块，但是通过反射则可以达到无论调用什么方法都可以
 * 的目的。
 *
 * 按照模块的思想，一个模块一个servlet，比如用户模块一个servlet，分类模块一个servlet
 * ，一个模块中的所有方法都集中到模块servlet中。
 * 所有的模块servlet都继承BaseServlet，模块servlet只需要实现自己模块中的需要的方法。
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

//        //解决响应乱码移动到filter统一解决
//        response.setCharacterEncoding("UTF-8");
        /**
         * 实现根据请求中的方法参数，来动态的调用对应的方法，而且编码一次即可
         */
        //当子类servlet调用方法的时候this代表的就是子类servlet
        Class clazz = this.getClass();
        try {
            //获取请求的方法
            String method1 = request.getParameter("method");
            Method method = clazz.getDeclaredMethod(request.getParameter("method"),HttpServletRequest.class,HttpServletResponse.class);
            //调用请求的方法（由子类servlet自己实现），并且接收返回URL作为请求转发的URL
            String url = (String) method.invoke(this,request,response);
            //如果返回不为空则进行请求转发
            if(url != null){
                request.getRequestDispatcher(url).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
