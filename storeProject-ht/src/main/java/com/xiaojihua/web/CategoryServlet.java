package com.xiaojihua.web;

import com.xiaojihua.utils.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    //自己的方法
    public String findCategory(HttpServletRequest request, HttpServletResponse response){
        //1、调用dao查询所有category

        //2、将查询出的List转换成json，并协会给easyUI
        return null;
    }
}
