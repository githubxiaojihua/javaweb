package com.xiaojihua.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听request的创建和销毁，当请求index.jsp的时候会打印下面这两句，
 * 因为浏览器请求index.jsp，是先发送请求然后生成相应后销毁request
 */
public class C02ServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("servlet request 销毁了...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("servlet request 创建了...");
    }
}
