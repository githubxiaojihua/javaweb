package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * 证明了action是多实例，也就是每次请求action都会创建一个新的action对象。
 * servlet是单实例。
 */
public class ActionDemo8 extends ActionSupport{

    public ActionDemo8(){
        System.out.println("我被创建了...");
    }

    @Override
    public String execute() throws Exception{
        System.out.println(111);
        return "ok";
    }

}
