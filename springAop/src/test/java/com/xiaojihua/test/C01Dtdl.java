package com.xiaojihua.test;

import com.xiaojihua.domain.Person;
import com.xiaojihua.domain.UserForDtdl;
import com.xiaojihua.domain.UserForDtdlImpl;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * springAOP的底层实现原理：
 * JDK动态代理和CGLIB动态代理
 * 其中CGLIB的相关依赖在spring core包里面已经集成了
 */
public class C01Dtdl {

    /**
     * 普通的方法调用
     */
    @Test
    public void test1(){
        UserForDtdl user = new UserForDtdlImpl();
        user.save();

        // 想要对 UserImpl里面的save方法进行增强
        // 目标类: UserImpl
        // 增强方法:save()
    }

    /**
     * 使用JDK动态代理实现上面的需求
     * 关于JDK动态代理的说明：
     * 实际上就是生成了一个接口的实现类，这个实现类是jdk自己生成的，
     * 是否调用待增强的类则不是必须的
     * 但是如果要增强目标类的方法则必须调用原来类的方法
     */
    @Test
    public void test2(){
        //待增强的类
        final UserForDtdlImpl user = new UserForDtdlImpl();
        // jdk的动态代理
        // 参数一: 和目标类一样的类加载器
        // 参数二: 和目标类一样的接口
        // 参数三: 增强的业务
        UserForDtdl userProxy = (UserForDtdl) Proxy.newProxyInstance(user.getClass().getClassLoader(),
                user.getClass().getInterfaces(), new InvocationHandler() {
                    //增强的业务
                    // 参数一: 固定值
                    // 参数二: 要增强的方法 (原有的方法)
                    // 参数三: 方法运行时候需要的参数
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //对save方法进行增强
                        if("save".equals(method.getName())){
                            System.out.println("在save方法之前增强了");
                            method.invoke(user,args);
                            System.out.println("在save方法之后增强了");
                        }else{
                            // 执行原来的方法
                            method.invoke(user, args);
                        }
                        return null;
                    }
                });

        userProxy.save();// 只要执行,就会执行增强业务方法invoke方法,这个方法里面就是对save方法的增强
        userProxy.delete();// 只要执行,就会执行增强业务方法invoke方法,这个方法里面就是对delete方法的增强
    }

    /**
     * CGLIB方式的动态代理
     * 不要求被代理的对象必须实现接口
     * 直接从字节码文件继承
     */
    @Test
    public void test3(){
        //目标类
        final  Person person = new Person();

        // CGLIB的方式
        // 参数一: 目标类的字节码文件类型  因为用于继承
        // 参数二: 增强的业务逻辑
        Person personProx = (Person)Enhancer.create(Person.class, new MethodInterceptor() {
            // 参数一: 代理对象的类型 固定值
            // 参数二: 目标类要增强的方法
            // 参数三: 方法运行时期需要的参数
            // 参数四: 代理方法 忽略
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if("delete".equals(method.getName())){
                    System.out.println("在delete方法之前增强了");
                    // 让原有方法执行
                    method.invoke(person,objects);
                    System.out.println("在delete方法之后增强了");
                }else{
                    method.invoke(person,objects);
                }
                return null;
            }
        });

        personProx.delete();// 执行了它  增强业务intercept方法也会执行 这个方法里面就是对delete的增强
        personProx.find();// 执行了它  增强业务intercept方法也会执行 这个方法里面就是对find的增强
    }
}
