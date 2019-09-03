package com.xiaojihua.bean;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 实现HttpSessionBindingListener接口，来对bean在session中的绑定和解绑（添加和删除）
 * 进行监听
 * 注意此接口不需要在配置文件中配置
 */
public class C01User implements HttpSessionBindingListener {
    private String username;
    private String password;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //绑定
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        // TODO Auto-generated method stub
        System.out.println("session和bean绑定了(添加)");
    }

    //解绑
    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session和bean解绑了(移除)");
    }
}
