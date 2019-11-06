package com.xiaojihua.springConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 全配置模式
 */
@Configuration
@ComponentScan(basePackages="com.xiaojihua")
@PropertySource(value="classpath:jdbc.properties")
//它是按照类型来注入的 PlatformTransactionManager
//而<tx:annotation-driven transaction-manager="transactionManager"/>
//是按照名称来注入的，默认是transactionManager
@EnableTransactionManagement //<tx:annotation-driven transaction-manager="transactionManager"/>
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String pass;

    // 创建出来c3p0 给spring
    @Bean(name="c3p0")
    public DataSource createC3p0() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(driver);
        ds.setJdbcUrl(url);
        ds.setUser(user);
        ds.setPassword(pass);
        return ds;
    }

    // 4.3以前 要给spring配置一个解析器 来解析 ${}
    @Bean
    public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // 创建出来jdbcTemplate 给spring
    // 注意参数DataSource是从spring中获取，使用Qualifier来获取，
    // Quailifier在参数上使用的时候可以单独使用，但是在属性上使用的时候
    // 必须跟AutoWare一起使用
    @Bean(name="jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Qualifier("c3p0") DataSource ds){
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(ds);
        return template;
    }

    // 创建transactionManager给spring
    @Bean(name="transactionManager")
    public DataSourceTransactionManager createDataSourceTransactionManager(@Qualifier("c3p0") DataSource ds)  // 使用注解问spring要
    {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(ds);
        return dataSourceTransactionManager;
    }
}
