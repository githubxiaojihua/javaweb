package com.xiaojihua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义一个自定义注解，用于：
 * 使用此注解的方法将自动执行。
 *
 * 如果注解中的方法的返回值是数组则，在使用的时候就用｛｝来放置多个值
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
