package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.xiaojihua.struts.domain.User;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义拦截器测试
 */
public class ActionDemo21 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        System.out.println("Action中的方法");
        return "success";
    }


}
