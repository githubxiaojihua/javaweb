package com.xiaojihua.demo2;

import org.junit.Test;

public class Demo {

    /**
     * 使用装饰者模式来增强
     */
    @Test
    public void test1(){
        C01Person p = new C02NormalPerson();
        //需求：对普通人走的方法进行增强 由走变成飞---增强一个对象的方法
        //假装不知道具体的实现类

        //使用装饰着模式增强
        //1、装饰者和被装饰者实现同一个接口 Person
        //2、装饰者里面有被装饰者的引用
        C03SupPerson sp = new C03SupPerson(p);
        sp.run();
    }
}
