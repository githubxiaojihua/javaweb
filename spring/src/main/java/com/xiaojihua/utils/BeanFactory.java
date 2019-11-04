package com.xiaojihua.utils;

import com.xiaojihua.domain.User;

public class BeanFactory {

    // 静态方法---静态工厂
   /* public static User createUser(){
        return new User();
    }*/

    // 普通方法---实例工厂
    public User createUser()
    {
        return new User();
    }
}
