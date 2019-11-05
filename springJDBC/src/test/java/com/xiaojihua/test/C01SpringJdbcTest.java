package com.xiaojihua.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class C01SpringJdbcTest {

    /**
     * spring jdbc templete硬编码
     */
    @Test
    public void test1() throws PropertyVetoException {
        //设置c3p0
        ComboPooledDataSource ds = new ComboPooledDataSource();
        // 设置驱动
        ds.setDriverClass("com.mysql.jdbc.Driver");
        // 设置地址
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
        // 设置用户名
        ds.setUser("root");
        // 设置密码
        ds.setPassword("root");


        //Springjdbc 硬编码
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(ds);
        String sql = "INSERT INTO account VALUES(?,?)";
        template.update(sql,"jack","1000");
    }

    /**
     * 配置spring jdbctemplate后
     */
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = (JdbcTemplate)context.getBean("jdbcTemplate");
        String sql = "INSERT INTO account VALUES(?,?)";
        template.update(sql,"rose","1000");
    }
}
