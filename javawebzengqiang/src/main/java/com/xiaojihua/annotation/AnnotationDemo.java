package com.xiaojihua.annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用自定义注解
 */
public class AnnotationDemo {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> type = Class.forName("com.xiaojihua.annotation.AnnotationDemo");
        Method[] methods = type.getDeclaredMethods();
        for(Method m : methods){
            if(m.isAnnotationPresent(MyTest.class)){
                m.invoke(type.newInstance(),args);
            }
        }
    }

    @MyTest
    public void test1(){
        System.out.println(111111);
    }

    @MyTest
    public void test2(){
        System.out.println(222222);
    }

    @MyTest
    public void test3(){
        System.out.println(333333);
    }
}
