package com.xiaojihua.web;

import com.xiaojihua.domain.User;
import com.xiaojihua.service.IUserService;
import com.xiaojihua.serviceImpl.UserServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Map;

/**
 * 通过继承BaseServlet来，实现统一的模块化请求处理，
 * 这样子servlet中只需要有自己的方法即可
 */
public class UserServlet extends BaseServlet {

    /**
     * 转向到登录页面
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loginUI(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        return "jsp/login.jsp";
    }

    /**
     * 转向到注册页面吧
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String registerUI(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("/jsp/register.jsp").forward(request,response);
        return "jsp/register.jsp";
    }

    public String register(HttpServletRequest request,HttpServletResponse response){
        Map<String,String[]> map = request.getParameterMap();
        User user = new User();
        IUserService service = new UserServiceImpl();
        try {
            BeanUtils.populate(user,map);
            user.setUid(UUIDUtils.getUUID());
            user.setState(0);
            user.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());
            service.save(user);
            request.setAttribute("msg","亲，注册成功了，赶快去激活吧！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","注册失败，请稍后再试！");
            return "jsp/info.jsp";
        }
        return "jsp/info.jsp";
    }
}
