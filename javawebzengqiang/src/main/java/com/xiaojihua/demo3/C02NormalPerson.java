package com.xiaojihua.demo3;

public class C02NormalPerson implements C01Person {
    @Override
    public void run() {
        System.out.println("走.....");
    }

    @Override
    public String sleep() {
        System.out.println("sleep...");
        return "睡觉了";
    }

    @Override
    public String eat(String food) {
        System.out.println("eat " + food);
        return "吃饱了";
    }
}
