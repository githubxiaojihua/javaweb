package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

/**
 * 通过ActionContext的方式获取servlet api
 *
 * ActionContext是struts2的一个对象，从他可以获取request,session和servletcontext的底层map
 * 对象，并且可以直接put，而且对应的request,session和servletcontext中的map也就有
 * 数据了
 */
public class ActionDemo6 extends ActionSupport {

    @Override
    public String execute() throws Exception{
       //获取session底层的map集合
        ActionContext actionContext = ActionContext.getContext();
        Map<String, Object> session = actionContext.getSession();
        session.put("msg","abcd");
        //验证是否设置进去了
        HttpSession session1 = ServletActionContext.getRequest().getSession();
        System.out.println(session1.getAttribute("msg"));

        //获取页面数据
        Map<String, Object> parameters = actionContext.getParameters();//类似request.getParameterMap();
        for(String key : parameters.keySet()){
            System.out.println(key+":"+Arrays.toString((String[])parameters.get(key)));
        }
        //封装数据到页面展示
        actionContext.put("msg1","request...");
        actionContext.getSession().put("msg2","session....");
        actionContext.getApplication().put("msg3","serletContext...");
        return "ok";
    }
}
