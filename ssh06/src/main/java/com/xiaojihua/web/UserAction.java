package com.xiaojihua.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.UserService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    @Override
    public User getModel() {
        return user;
    }

    private UserService service;

    public void setService(UserService service) {
        this.service = service;
    }

    public String save(){
        //调用service
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService)context.getBean("userService");*/
        //使用Spring注入service
        service.save(user);
        return SUCCESS;
    }


}
