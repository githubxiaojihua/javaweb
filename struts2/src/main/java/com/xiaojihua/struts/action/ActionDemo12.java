package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiaojihua.struts.domain.User;

/**
 * 测试struts属性封装----对象类型
 * 需要在对应的form表单中使用OGNL表达式 比如user.userName
 *
 */
public class ActionDemo12 extends ActionSupport{

    //要封装的对象一定要有get和set方法
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String execute() throws Exception{
        //测试是否封装好了数据
        System.out.println(user);
        return null;
    }

}
