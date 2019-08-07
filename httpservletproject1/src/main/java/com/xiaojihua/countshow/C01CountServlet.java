package com.xiaojihua.countshow;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于在servlet上下文中记录访问次数
 */
public class C01CountServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext context = getServletContext();

        //如果是第一次记录需要处理
        Integer count = (Integer) context.getAttribute("count");
        if(count == null){
            count = 1;
        }else{
            count++;
        }

        context.setAttribute("count",count);
        System.out.println(context.getAttribute("count"));
    }
}
