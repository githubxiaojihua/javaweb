package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;

/**
 * 通过成员属性的方式往root区域中存储数据
 */
public class ActionDemo16 extends ActionSupport{
    // 放在root区域了 因为整个ActionDemo2都在root区域
    private String userName;
    private List list;

    public String getUserName() {
        return userName;
    }

    public List getList() {
        return list;
    }

    @Override
    public String execute() throws Exception{
        //设置值栈中存储的成员属性
        userName = "张三";

        // 获取值栈的数据 当前action的username属性(了解)
        //获取值栈
        ActionContext context = ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
        Object userName = valueStack.findValue("userName");
        System.out.println(userName);
        return SUCCESS;
    }


}
