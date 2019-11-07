package com.xiaojihua.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.UserService;

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
        service.save(user);
        return SUCCESS;
    }


}
