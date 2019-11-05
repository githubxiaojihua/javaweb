package com.xiaojihua.test;

import com.xiaojihua.domain.Person;
import com.xiaojihua.springConfig.SpirngConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=SpirngConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringAnnotationTest {

    @Autowired
    private Person person;

    @Test
    public void test()
    {
        person.save();

    }
}
