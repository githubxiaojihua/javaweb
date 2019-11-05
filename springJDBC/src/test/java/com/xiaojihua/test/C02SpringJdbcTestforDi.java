package com.xiaojihua.test;

import com.xiaojihua.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(value="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class C02SpringJdbcTestforDi {
    @Autowired
    private AccountService service;

    @Test
    public void test1(){
        //增
        service.save();
        //删
        //service.delete();
        //改
        //service.update();
        //查
        //service.findAll();
        //查单个对象
        //service.findByname();
        //查询总个数
        //service.findCount();
    }
}
