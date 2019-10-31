package com.xiaojihua.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.xiaojihua.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * 对指定的方法检验是否进行了登录，如果没有登陆则跳转到登陆页面
 *
 */
public class MyInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User)session.getAttribute("user");
        // 如果没有登录
        if(user == null){
            // 获取到action  因为action才有addActionMessage方法
            ActionSupport action = (ActionSupport)actionInvocation.getAction();
            // 记录数据权限不足 请先登录  到login.jsp页面显示
            action.addActionMessage("权限不足，请先登录");
            return "login";
        }
        //放行
        return actionInvocation.invoke();
    }
}
