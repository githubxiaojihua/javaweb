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
 * 实现接口的形式来操作servlet api
 * 通过继承ServletRequestAware,ServletResponseAware,ServletContextAware
 * 来分别从struts中获取request,response,servletContext
 */
public class ActionDemo7 extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext context;

    @Override
    public String execute() throws Exception{
        //获取页面数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        for(String key : parameterMap.keySet()){
            System.out.println(key + ":" + Arrays.toString(parameterMap.get(key)));
        }

        //写页面响应数据
        /*response.getWriter().println("abcd/1234");*/

        //往域中存储数据 到页面展示
        request.setAttribute("msg1","request...");
        request.getSession().setAttribute("msg2","session...");
        context.setAttribute("msg3","servletContext...");
        return "ok";
    }


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }
}
