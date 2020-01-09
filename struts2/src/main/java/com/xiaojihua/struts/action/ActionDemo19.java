package com.xiaojihua.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * 特殊符号$的使用（在配置文件中获取值栈中的数据）
 * $通常用于文件下载
 * <action name=”download” class=””>
 * 	<result name=”” type=”stream”>${fileName}</result>
 * </action>
 */
public class ActionDemo19 extends ActionSupport{

    //存储到值栈中
    private String ym;

    public String getYm() {
        return ym;
    }

    @Override
    public String execute() throws Exception{

        //设置值栈中的数据
        ym="/jsp/valueStackDemo7.jsp";

        return "success";
    }


}
