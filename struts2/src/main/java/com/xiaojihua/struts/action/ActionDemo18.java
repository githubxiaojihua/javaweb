package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.xiaojihua.struts.domain.User;

import java.util.Map;

/**
 * 往context区域存储数据
 */
public class ActionDemo18 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        //往值栈的context区域存储数据
        ActionContext context = ActionContext.getContext();
        //获取session底层的map
        Map<String, Object> session = context.getSession();
        session.put("msg1","session...");
        //获取servletContext底层的map
        Map<String, Object> application = context.getApplication();
        application.put("msg2","servletContext");

        //自定义context区域的key 和 value
        context.put("msg","msgssssss");
        //获取context区域的值
        System.out.println(context.get("msg"));
        return SUCCESS;
    }


}
