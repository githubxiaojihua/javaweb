package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

/**
 * 通过ServletActionContext的方式获取servlet api
 */
public class ActionDemo5 extends ActionSupport {

    @Override
    public String execute() throws Exception{
        //获取页面数据，获取request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        Map<String, String[]> parameterMap = request.getParameterMap();
        for(String key : parameterMap.keySet()){
            System.out.println(key+":"+Arrays.toString(parameterMap.get(key)));
        }

        //获取response对象 写相应数据
       /* HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().print("abcd/1234");*/

        //封装数据到域对象中，在页面进行展示
        request.setAttribute("msg1","request.....");
        request.getSession().setAttribute("msg2","session....");
        ServletActionContext.getServletContext().setAttribute("msg3","servletContext....");
        return "ok";
    }
}
