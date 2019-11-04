package com.xiaojihua.test;

import com.xiaojihua.service.Car;
import com.xiaojihua.service.Person;
import com.xiaojihua.serviceImp.CarImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

    @Test //自己new对象 自己属性赋值的方式
    public void test()
    {
        //不能使用接口作为返回值，因为接口没有setName方法
        CarImpl car=new CarImpl();
        // 设置属性
        car.setName("qq");
        car.run();
    }


    @Test // spring的DI第一种方式:构造器方式(了解)
    public void test3()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car =(Car)context.getBean("car");
        car.run();
    }

    @Test // spring的DI第二种方式:set属性方式(掌握)
    public void test4()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person =(Person)context.getBean("person");
        System.out.println(person);
    }

    @Test // spring的DI第三种方式:p名称空间的方式(知道)
    public void test5()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person =(Person)context.getBean("person");
        System.out.println(person);
    }
}
