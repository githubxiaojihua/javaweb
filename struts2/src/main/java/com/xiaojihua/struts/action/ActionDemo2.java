package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.Action;

public class ActionDemo2 implements Action {
    @Override
    public String execute() throws Exception {
        System.out.println("Action的第二种创建方法，实现Action接口");
        return SUCCESS;//"success"
    }
}
