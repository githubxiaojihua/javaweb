package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class ActionDemo3 extends ActionSupport {

    @Override
    public String execute() throws Exception{
        System.out.println("第三种创建Action的方式，继承方式");
        return null;
    }
}
