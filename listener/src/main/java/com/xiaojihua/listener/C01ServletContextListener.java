package com.xiaojihua.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * servletContext对象的监听器
 */
public class C01ServletContextListener implements ServletContextListener {
    //servletContext创建的时候执行
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext 创建了。。。。");
    }

    //servletContext销毁的时候执行
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext 销毁了。。。。");
    }
}
