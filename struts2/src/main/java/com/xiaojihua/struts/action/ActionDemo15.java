package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.xiaojihua.struts.domain.User;

/**
 * 获取值栈
 *
 */
public class ActionDemo15 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        //获取值栈
        ActionContext context = ActionContext.getContext();
        ValueStack valueStack = context.getValueStack();
        return SUCCESS;
    }


}
