package com.xiaojihua.test;

import com.xiaojihua.service.UserService;
import com.xiaojihua.springConfig.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * spring对于 配置类的方式（取代xml）也提供了
 * 集成junit的方式
 * 与xml形式的时候使用的是同一个注解
 * 只是参数换成了classes来指定配置类
 */
@ContextConfiguration(classes=SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class springAnnotationConfigTest {

    @Autowired
    private UserService userService;

    /**
     * 测试全注解配置
     */
    @Test
    public void test1() throws SQLException {
        // 加载注解类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = (UserService)context.getBean("userService");
        service.save();
        DataSource ds = (DataSource) context.getBean("c3p0");
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }

    /**
     * 基于spring对junit的封装的测试
     */
    @Test
    public void test2(){
        userService.save();
    }
}
