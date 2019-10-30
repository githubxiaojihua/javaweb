package com.xiaojihua.struts.interscepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 通过继承AbstractInterceptor的方式自定义拦截器
 */
public class MyInterceptor2 extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("MyInterceptor2在action之前执行了..");
        String bm = actionInvocation.invoke();
        System.out.println("MyInterceptor2在action之后执行了..");
        return bm;
}
}
