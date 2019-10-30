package com.xiaojihua.struts.interscepter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 通过实现Interceptor接口的方式自定义拦截器
 */
public class MyInterceptor1 implements Interceptor {
    @Override//销毁
    public void destroy() {

    }

    @Override//初始化
    public void init() {

    }

    @Override// 核心拦截方法
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("MyInterceptor1在action之前执行了..");
        // 放行
        String bm = actionInvocation.invoke();//判断有没有下一个 如果没有直接执行action
        System.out.println("MyInterceptor1在action之后执行了..");
        return bm;
    }
}
