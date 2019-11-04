package com.xiaojihua.test;

import com.xiaojihua.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test // 自己new的对象
    public void test()
    {
        User user = new User();
        user.run();
    }

    @Test //通过springIOC来创建对象
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)context.getBean("user");
        user.run();
    }

    @Test // 测试scope属性 --singleton
    public void test3()
    {
        System.out.println("测试scope属性 --singleton");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User)context.getBean("user");
        User user2 = (User)context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test // 测试scope属性 --prototype
    public void test4()
    {
        System.out.println("测试scope属性 --prototype");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 =(User)context.getBean("user");
        User user2 =(User)context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test // 测试scope属性(singleton)---初始化时机和销毁时机
    // 初始化: 当对象被创建出来就执行初始化方法  配置文件一加载
    // 销毁: 容器关闭 对象销毁
    public void test5()
    {
        System.out.println("测试(singleton)---初始化时机和销毁时机");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 =(User)context.getBean("user");
        User user2 =(User)context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
        // 关闭容器
        context.close();
    }

    @Test // 测试scope属性(prototype)---初始化时机和销毁时机
    // 初始化: 当对象被创建出来就执行初始化方法 getbean的时候
    // 销毁: 长时间不用 被垃圾回收机制销毁
    public void test6()
    {
        System.out.println("测试(prototype)---初始化时机和销毁时机");
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 =(User)context.getBean("user");
        User user2 =(User)context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test // 测试bean的三种创建方式--无参构造器
    public void test7()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User)context.getBean("user");
        user.run();
    }

    @Test // 测试bean的三种创建方式--静态工厂方式
    public void test8()
    {
        System.out.println("静态工厂方式测试...");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User)context.getBean("user");
        User user2=(User)context.getBean("user");
        System.out.println(user);
        System.out.println(user2);
    }

    @Test // 测试bean的三种创建方式--实例工厂方式
    public void test9()
    {
        System.out.println("实例工厂方式测试...");
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User)context.getBean("user");
        User user2=(User)context.getBean("user");
        System.out.println(user);
        System.out.println(user2);
    }
}
