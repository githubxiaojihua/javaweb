package com.xiaojihua.springConfig;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 代替xml配置文件
 */
@Configuration// 表示该类是一个注解类
//开启扫描
@ComponentScan(basePackages="com.xiaojihua")
//加载配置文件
@PropertySource(value="classpath:jdbc.properties")
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String dirver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String passWord;

    /**
     * 创建别人的类，代替XML中的c3p0连接池
     * @return
     */
    @Bean(name="c3p0")
    public DataSource createDataSourceC3p0() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass(dirver);
        ds.setJdbcUrl(url);
        ds.setUser(userName);
        ds.setPassword(passWord);
        return ds;
    }

    // 4.3以前 要给spring配置一个解析器 来解析 ${}
    @Bean
    public static PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
