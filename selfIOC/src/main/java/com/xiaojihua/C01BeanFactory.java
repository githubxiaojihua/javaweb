package com.xiaojihua;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class C01BeanFactory {

    /**
     * 工厂模式+反射+配置文件，达到只修改配置文件不修改源码，来
     * 创建并获取不同的对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1、创建XML解析器
        SAXReader reader = new SAXReader();
        //2、加载配置文件，使用file加载的时候（文件放到了src下面）
        //Document doc = reader.read(new File("src/beans.xml"));
        //使用classLoader加载的时候文件要放在java下面，因为maven项目java下面的才是classPath，
        // 非maven项目可以放到src下面
        Document doc = reader.read(C01BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
        //3、获取根元素
        Element rootElement = doc.getRootElement();
        //4、遍历子元素
        for(Element beanEle : (List<Element>)rootElement.elements()){
            //4.1 读取子元素的id属性，并进行判断如果id属性值和beanName相同则读取其class属性值
            String idStr = beanEle.attributeValue("id");
            if(idStr.equals(beanName)){
                String classStr = beanEle.attributeValue("class");
                //4.2 通过反射根据读取到的class属性值创建对象并返回
                Class clazz = Class.forName(classStr);
                return clazz.newInstance();
            }

        }
        return null;
    }
}
