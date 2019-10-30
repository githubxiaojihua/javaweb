package com.xiaojihua.struts.interscepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 自定义拦截器，拦截指定方法
 */
public class MyInterceptor3 extends MethodFilterInterceptor {


    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("MyInterceptor3在action方法之前执行了");
        String bm = actionInvocation.invoke(); //action execute()
        System.out.println("MyInterceptor3在action方法之后执行了");
        return bm;
    }
}
