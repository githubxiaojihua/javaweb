package com.xiaojihua.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听httpsession的创建和销毁
 * 当请求2.jsp的时候会进行session的创建
 * 3.jsp内部进行了session的手动销毁。
 */
public class C03HttpSessionListener implements HttpSessionListener {
    //httpSession的创建
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("httpsession 创建了。。。。");
    }

    //httpSession的销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("httpsession 销毁了。。。。");
    }
}
