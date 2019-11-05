package com.xiaojihua.test;

import com.xiaojihua.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class C02AspeacTest {

    @Autowired
    private Person person;
    @Test
    public void test1(){
        person.find();
        System.out.println(person);
    }
}
