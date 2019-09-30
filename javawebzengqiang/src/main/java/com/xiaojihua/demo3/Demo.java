package com.xiaojihua.demo3;

import com.xiaojihua.demo2.C03SupPerson;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo {

    /**
     * 使用jdk动态代理模式来增强
     */
    @Test
    public void test1(){
        final C01Person p = new C02NormalPerson();

        C01Person proxy = (C01Person) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(p,args);
                System.out.println("增强了，变成飞.....");
                return null;
            }
        });

        //调用代理对象中方法（也就是接口中的方法）
        proxy.run();
    }

    /**
     * 使用jdk动态代理模式来增强
     * 细节一：返回值
     */
    @Test
    public void test2(){
        final C01Person p = new C02NormalPerson();

        C01Person proxy = (C01Person) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //调用以前的方法并且有返回值
                String result = (String) method.invoke(p,args);
                System.out.println(result);
                //增强业务逻辑
                System.out.println("增强了，变成飞.....");
                //谁调用返回给谁
                return method.invoke(p,args);
            }
        });

        //调用代理对象中方法（也就是接口中的方法）
        proxy.run();//由于run没有返回值因此即使写了return abc也不会有返回

        //使用新增加的带有返回值的方法
        String result = proxy.sleep();
        System.out.println(result);
    }


    /**
     * 使用jdk动态代理
     * 细节二：增强带参数的方法以及只增强指定的方法
     * 将接口中增加了eat方法（带有参数）并且只增强这个方法
     */
    @Test
    public void test3(){
        final C01Person p = new C02NormalPerson();

        C01Person proxy = (C01Person) Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //eat方法进行增强
                if("eat".equals(method.getName())){
                    String result = (String) method.invoke(p,args);
                    System.out.println(result);
                    System.out.println("增强了，变飞了。。。。。");
                    return null;
                }
                //判断非eat方法不进行增强
                return method.invoke(p,args);
            }
        });

        //调用所有方法，只有eat方法增强了
        proxy.run();
        proxy.sleep();
        proxy.eat("榴莲");
    }
}
