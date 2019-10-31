package com.xiaojihua.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * 使用注解代替action的配置
 */
@ParentPackage("struts-default")//用来代替extends="struts-default"
@Namespace("/")//用来代替namespace="/"
public class ActionAnnotationDemo extends ActionSupport {

    @Action(value="ad1",results={@Result(name="ok",location="/1.jsp"),@Result(name="oko",location="/2.jsp")})
    @Override
    public String execute() throws Exception {
    // 查了所有的订单
        System.out.println(1111111111);
        return "ok";
    }
}
