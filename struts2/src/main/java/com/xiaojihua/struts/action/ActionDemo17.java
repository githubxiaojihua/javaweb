package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.xiaojihua.struts.domain.User;

import java.util.List;

/**
 * 通过值栈API的方式往root区域中存储数据
 */
public class ActionDemo17 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        User user = new User();
        user.setAge(18);
        user.setUserName("jack");

        // 获取值栈的数据 当前action的username属性(了解)
        // 1 获取root区
		/*ValueStack vs = ActionContext.getContext().getValueStack();
		CompoundRoot root = vs.getRoot();
		root.push(user);*/ //在栈顶  底层:add(0, o);
        //直接获取值栈并push，底层也是上面的代码
        ActionContext context = ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
        valueStack.push(user);

        //会新建一个hashMap并且放到值栈中，虽然在值栈的debug下map的property为空但是依然能获取到值
        //放多个值依然是一个map
        valueStack.set("name","jj");
        valueStack.set("agee","12");
        System.out.println(valueStack.findValue("name"));
        return SUCCESS;
    }


}
