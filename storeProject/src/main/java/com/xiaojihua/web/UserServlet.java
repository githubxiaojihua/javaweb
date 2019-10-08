package com.xiaojihua.web;

import com.xiaojihua.domain.User;
import com.xiaojihua.service.IUserService;
import com.xiaojihua.serviceImpl.UserServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.MailUtils;
import com.xiaojihua.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    /**
     * 注册
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request,HttpServletResponse response){
        //获取页面数据
        Map<String,String[]> map = request.getParameterMap();
        User user = new User();
        //面向接口编程
        IUserService service = new UserServiceImpl();
        try {
            //使用工具类将map中的值拷贝到对象中
            BeanUtils.populate(user,map);
            //设置UUID
            user.setUid(UUIDUtils.getUUID());
            user.setState(0);//初始是未激活
            //设置激活码：两个UUID
            user.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());
            service.save(user);
            //给注册的用户发送邮件
            String email = user.getEmail();
            //邮件中附带了激活链接（通过激活码唯一确定一个用户）
            String emailMsg = "这是一封激活邮件，请<a href='http://localhost:8080/storeProject/user?method=active&code="+user.getCode()+"'>点击激活</a>";
            //调用工具类发送邮件
            MailUtils.sendMail(email,emailMsg);
            request.setAttribute("msg","亲，注册成功了，赶快去激活吧！");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","注册失败，请稍后再试！");
            return "jsp/info.jsp";
        }
        return "jsp/info.jsp";
    }

    /**
     * 激活用户
     * @param request
     * @param response
     * @return
     */
    public String active(HttpServletRequest request,HttpServletResponse response){
        //获取激活码
        String code = request.getParameter("code");
        IUserService service = new UserServiceImpl();
        try {
            //根据激活码来查找用户
            User user = service.findByCode(code);
            //为空
            if(user == null){
                request.setAttribute("msg","亲，您的注册信息已经过期，请重新注册！");
                return "jsp/info.jsp";
            }
            //不为空
            user.setState(1);
            service.update(user);
            request.setAttribute("msg","亲，激活成功，请登录！");
        } catch (SQLException e) {
            e.printStackTrace();
            // 跳到一个页面 告诉失败
            request.setAttribute("msg", "激活失败,请稍后重试..");
            return "/jsp/info.jsp";
        }
        return "/jsp/info.jsp";
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    public String login(HttpServletRequest request,HttpServletResponse response){
        String userName = request.getParameter("username");
        String passWord = request.getParameter("password");
        IUserService service = new UserServiceImpl();
        try {
            User user = service.login(userName,passWord);
            if(user == null){
                request.setAttribute("msg","用户名或者密码错误");
                return "jsp/login.jsp";
            }

            if(user.getState() != 1){
                request.setAttribute("msg","亲，您还没有激活！");
                return "jsp/info.jsp";
            }

            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //使用重定向，而非请求转发的主要原因是，保证浏览器的地址栏也是index.jsp防止用户刷新
            //如果使用请求转发则浏览器地址不会改变，用户刷新会出现错误
            response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
        } catch (Exception e) {
            e.printStackTrace(); //会记录到日志
            // 跳到一个页面 告诉失败
            request.setAttribute("msg", "登录失败...");
            return "/jsp/info.jsp";
        }
        return null;
    }

    /**
     * 用户登出
     * @param request
     * @param response
     * @return
     */
    public String quit(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        try {
            response.sendRedirect(request.getContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
