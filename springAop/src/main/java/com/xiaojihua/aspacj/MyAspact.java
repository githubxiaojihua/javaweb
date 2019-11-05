package com.xiaojihua.aspacj;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 定义一个切面类
 * 有增强方法
 *
 * 需要在配置文件中进行配置
 */
public class MyAspact {

    /**
     * 前置增强
     */
    public void beforeMethod(){
        System.out.println("----beforeMethod-----");
    }

    /**
     * 后置增强
     */
    public void afterRunningMethod(){
        System.out.println("-----afterRunningMethod-----");
    }

    /**
     * 环绕增强
     */
    public void aroundMethod(ProceedingJoinPoint pdp) throws Throwable {
        System.out.println("方法之前执行");
        pdp.proceed();
        System.out.println("方法之后执行");
    }

    /**
     * 异常增强
     */
    public void throwingMethod(){
        System.out.println("---throwingMethod----");
    }

    /**
     * finally增强
     */
    public void afterMethod(){
        System.out.println("--不管你有没有异常,我都出来了---");
    }
}
