package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * 测试resultType=chain请求转发到action
 */
public class ActionDemo10 extends ActionSupport{

    @Override
    public String execute() throws Exception{
        //ad9的resulttype配置为chain的时候，是请求转发到的action中
        //因此在新的action中可以获取request域中的值
        Object msggg = ServletActionContext.getRequest().getAttribute("msggg");
        System.out.println(msggg);
        return null;
    }

}
