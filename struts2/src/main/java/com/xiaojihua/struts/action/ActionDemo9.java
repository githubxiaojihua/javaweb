package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * 证明了action是多实例，也就是每次请求action都会创建一个新的action对象。
 * servlet是单实例。
 */
public class ActionDemo9 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        ServletActionContext.getRequest().setAttribute("msggg", "abcd");

        return "success";
    }

}
