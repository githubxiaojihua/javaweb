package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 自定义拦截器，拦截指定方法，测试
 */
public class ActionDemo22 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        System.out.println("Action中的方法");
        return "success";
    }

    public String findAll(){
        System.out.println("Action中的查询方法");
        return "success";
    }
}
