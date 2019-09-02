package com.xiaojihua.servlet;

import com.xiaojihua.bean.User;
import com.xiaojihua.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setHeader("content-type", "text/html;charset=utf-8");
        //获取请求的用户名和密码
        String username = request.getParameter("userName");
        String password = request.getParameter("pass");
        //获取前台录入的验证码
        String yzm = request.getParameter("yzm");
        //从session中获取图片中的验证码
        String sessionYzm=(String)request.getSession().getAttribute("sessionYzm");
        //清空session   保证点击登录的时候  验证码是最新的
        request.getSession().removeAttribute("sessionYzm");
        //创建LoginService
        LoginService ls = new LoginService();
        try {
            //校验验证码
            if(yzm==""||yzm.trim().length()==0){
                //把错误信息放入request域中
                request.setAttribute("msg", "请输入验证码");
                //请求转发，请求转发并不会直接返回，而不执行剩下的语句，
                //相反，他会执行，但是同样会执行剩下的语句，不同于return
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                //如果两个验证不一样  需要给出提示
                if(!yzm.equalsIgnoreCase(sessionYzm)){
                    //把错误信息放入request域中
                    request.setAttribute("msg", "请输入正确的验证码");
                    //请求转发
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
            //调用service中的方法
            User user=ls.getUserByUserNameAndPass(username,password);
            //根据返回的对象，判断提示信息的内容
            if(user==null){
                //response.getWriter().println("登录失败");
                //把错误信息放入request域对象中
                request.setAttribute("msg", "登录失败");
                //使用请求转发跳转到login.jsp
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                //不能使用重定向，因为使用重定向后request失效
                //response.sendRedirect("/day1102/login.jsp");
            }else{
                //登录成功后如果勾选了自动登录将user相关信息写入到cookie，写回到浏览器
                String flag = request.getParameter("flag");
                if("ok".equalsIgnoreCase(flag)){
                    //新建cookie
                    Cookie userCookie = new Cookie("usernameAndPass",user.getUserName() + "-" + user.getPass());
                    //设置cookie的有效期为1小时
                    userCookie.setMaxAge(3600);
                    //将cookie写回到浏览器
                    response.addCookie(userCookie);

                }
                request.getSession().setAttribute("username", user.getUserName());
                response.getWriter().println(user.getUserName()+":欢迎回来");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
