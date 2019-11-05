package com.xiaojihua.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration// 当前类是注解类
@ComponentScan(basePackages="com.xiaojihua")//<context:component-scan base-package="cn.itcast"></context:component-scan>
@EnableAspectJAutoProxy//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
public class SpirngConfig {
}
