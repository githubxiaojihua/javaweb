package com.xiaojihua.demo1;

import org.junit.Test;

public class Demo {

    /**
     * 使用继承来增强
     */
    @Test
    public void test1(){
        C02NormalPerson p = new C02NormalPerson();
        //需求：对普通人走的方法进行增强 由走变成飞---增强一个对象的方法
        //由于接口的方法较少，并且知道要增强或者集成的具体类，因此可以使用集成增强
        //有的时候是不知道具体的实现了的，比如servlet doGet中的request参数，
        //他的具体实现类是由tomcat提供的，我们只知道他属于HttpServletRequest接口
        //但是不知道具体的类
        C03SupPerson sp = new C03SupPerson();
        sp.run();
    }
}
