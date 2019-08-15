package com.xiaojihua.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * request 请求体相关API
 */
public class C15RequestBodyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        //获取前台单值的请求参数
        String username = request.getParameter("username");
        System.out.println(username);
        String hobby1 = request.getParameter("hobby");
        System.out.println(hobby1);
        //获取多值的请求参数
        String[] hobbys = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbys));
        //获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        for(String key:map.keySet()){
            System.out.println(key+":"+Arrays.toString(map.get(key)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }
}
