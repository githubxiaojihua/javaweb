package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.struts.domain.User;

import java.util.List;

/**
 * 测试struts   模型封装  需要实现ModelDriven接口
 *
 */
public class ActionDemo14 extends ActionSupport implements ModelDriven<User> {

    //需要new出来
    private User user = new User();

    //需要实现getModel方法
    @Override
    public User getModel() {
        return user;
    }

    @Override
    public String execute() throws Exception{
        //测试是否封装好了数据
        System.out.println(user);
        return null;
    }


}
