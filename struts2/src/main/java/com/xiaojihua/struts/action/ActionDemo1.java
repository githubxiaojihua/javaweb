package com.xiaojihua.struts.action;

public class ActionDemo1 {

    // 需要有一个方法:execute
    // 需要有一个返回值String
    public String execute(){
        System.out.println("点击浏览器的超链接访问到我了....");
        return "abc";
    }

    public String save()
    {
        System.out.println("执行了save方法");
        return null;
    }
}
