package com.xiaojihua;

import org.dom4j.DocumentException;

public class C06TestDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        C02IUserService service = (C02IUserService)C01BeanFactory.getBean("UserService");
        service.save();
    }
}
