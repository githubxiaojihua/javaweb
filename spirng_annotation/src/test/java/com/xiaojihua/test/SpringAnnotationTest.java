package com.xiaojihua.test;

import com.xiaojihua.service.UserService;
import com.xiaojihua.serviceImpl.UserServiceImpl;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
/*1:告诉spring配置文件在哪个地方*/
@ContextConfiguration(value="classpath:applicationContext.xml")
/*2:告诉spring谁加载配置文件*/
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringAnnotationTest {

    @Autowired
    private UserService service;

    /**
     * 测试普通的基于xml的spirng
     */
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)context.getBean("userService");
        service.save();
    }

    /**
     * 测试IOC注解
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)context.getBean("userService");
        service.save();
        ((ClassPathXmlApplicationContext) context).close();
    }

    /**
     * 基于spring整合junit的测试
     * 无需每次都还在一次context
     */
    @Test
    public void test3(){
        service.save();
    }
}
