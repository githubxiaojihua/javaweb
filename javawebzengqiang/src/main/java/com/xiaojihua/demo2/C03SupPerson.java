package com.xiaojihua.demo2;

/**
 * 装饰者模式增强
 */
public class C03SupPerson implements C01Person {
    private C01Person person;

    public C03SupPerson(C01Person person){
        this.person = person;
    }

    @Override
    public void run(){
        //被装饰者以前的方法
        person.run();
        //增强的方法
        System.out.println("增强了，变成飞.....");
    }
}
