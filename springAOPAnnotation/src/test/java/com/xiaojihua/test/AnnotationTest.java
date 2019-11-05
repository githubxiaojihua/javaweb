package com.xiaojihua.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xiaojihua.domain.Person;

import java.sql.SQLException;

@ContextConfiguration(value="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationTest {

    @Autowired
    private Person person;
    @Test
    public void test1(){
        person.find();
        System.out.println(person);
    }

    /**
     * 异常增强方法，
     * @throws SQLException
     */
    @Test
    public void test2() throws SQLException {
        person.update();
        System.out.println(person);
    }
}
