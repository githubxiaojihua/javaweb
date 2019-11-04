package com.xiaojihua.test;

import com.xiaojihua.domain.CollBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class CollBeanTest {

    /**
     * 设置数组、列表、map等复杂类型的ID注入
     * 默认情况下如果不注入则都是为空
     */
    @Test
    public void test()
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CollBean cb =(CollBean)context.getBean("collBean");
        System.out.println(cb);
    }

    @Test // 从磁盘路径下加载配置文件
    public void test2()
    {
        ApplicationContext context=new FileSystemXmlApplicationContext("e:/xml/applicationContext.xml");
        CollBean cb =(CollBean)context.getBean("collBean");
        System.out.println(cb);
    }

    @Test // 扩展 BeanFactory下面的实现类加载配置文件
    public void test3()
    {

        // beanFactory加载配置文件
        // 就算scope数默认singleton    配置文件被加载不会创建对象  getbean的时候
        System.out.println(1111);
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        CollBean cb1 =(CollBean)factory.getBean("collBean");
        CollBean cb2 =(CollBean)factory.getBean("collBean");
        System.out.println(cb1);
        System.out.println(cb2);
    }
}
