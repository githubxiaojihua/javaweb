package com.xiaojihua.attr;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class C01ServletContextAttrListener implements ServletContextAttributeListener {

    //监听属性的增加
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext 属性增加了：" + servletContextAttributeEvent.getName() + ":" + servletContextAttributeEvent.getValue());
    }

    //监听属性的移除
    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext 移除了属性：" + servletContextAttributeEvent.getName() + ":" + servletContextAttributeEvent.getValue());
    }

    //监听属性的替换
    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext 替换了属性：" + servletContextAttributeEvent.getName() + ":" + servletContextAttributeEvent.getValue());
    }
}
