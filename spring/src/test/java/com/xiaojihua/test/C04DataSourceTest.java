package com.xiaojihua.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C04DataSourceTest {

    /**
     * 硬编码方式---c3p0
     */
    @Test
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        // 设置驱动
        ds.setDriverClass("com.mysql.jdbc.Driver");
        // 设置地址
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/hibernate");
        // 设置用户名
        ds.setUser("root");
        // 设置密码
        ds.setPassword("root");
        // 问连接池要连接对象
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }

    /**
     * 硬编码方式----dbcp
     */
    @Test
    public void test2() throws SQLException {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test //spring的ioc+di替代以上硬编码的方式
    public void  test3() throws SQLException
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource ds =(DataSource)context.getBean("c3p0forprop");
        Connection con = ds.getConnection();
        System.out.println(con);
    }
}
