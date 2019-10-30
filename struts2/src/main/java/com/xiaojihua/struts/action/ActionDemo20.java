package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.xiaojihua.struts.domain.User;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面获取数据的另一种方式通过[index]的方式来获取
 * 由于root区域底层实际上是list，而context区域底层
 * 实际上是map，因此要获取root区域的数据可以使用[index]
 * 的方式来做。
 */
public class ActionDemo20 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        //往值栈中设置值
        User user = new User();
        user.setUserName("jack");
        user.setAge(29);

        User user2 = new User();
        user2.setAge(28);
        user2.setUserName("rose");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);

        //通过API的方式来设置
        ValueStack valueStack = ServletActionContext.getContext().getValueStack();
        valueStack.push(user);
        valueStack.push(list);

        return "success";
    }


}
