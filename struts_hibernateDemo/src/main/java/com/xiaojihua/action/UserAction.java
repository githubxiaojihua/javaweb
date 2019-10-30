package com.xiaojihua.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.IUserService;
import com.xiaojihua.serviceImpl.UserServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user=new User();
    @Override
    public User getModel() {
        return user;
    }

    public String login(){
        // 拿着用户名和密码去匹配
        IUserService service = new UserServiceImpl();
        User findUser = service.login(user);
        if(findUser==null){
            // 到登录页面展示  用户名或密码错误
            // ActionSupport的方法  会自动在成员位置上创建一个属性ActionMessage 并赋值
            this.addActionMessage("用户名或者密码错误");
            return "login";
        }
        // 放在session中 带到首页展示
        HttpSession session = ServletActionContext.getRequest().getSession();
        session.setAttribute("user",findUser);
        return SUCCESS;
    }


}
