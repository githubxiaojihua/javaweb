package com.xiaojihua.domain;

public class User {
    // 构造器
    public User()
    {
        System.out.println("我被创建了...");
    }

    public void run()
    {
        System.out.println("run");
    }

    // 指定一个方法为初始化方法
    public void init()
    {
        System.out.println("我要初始化了...");
    }
    // 指定一个方法为销毁方法
    public void destory()
    {
        System.out.println("我挂了..66666666");
    }
}
