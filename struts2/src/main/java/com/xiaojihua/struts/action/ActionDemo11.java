package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * 测试struts属性封装----基本类型和String
 */
public class ActionDemo11 extends ActionSupport{

    //要封装的属性
    private String userName;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String execute() throws Exception{
        //测试是否封装好了数据
        System.out.println(userName + ":" + age);
        return null;
    }

}
