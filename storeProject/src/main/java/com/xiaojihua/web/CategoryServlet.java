package com.xiaojihua.web;

import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.serviceImpl.CategoryServiceImpl;
import com.xiaojihua.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 通过继承BaseServlet来，实现统一的模块化请求处理，
 * 这样子servlet中只需要有自己的方法即可
 */
public class CategoryServlet  extends BaseServlet {

    /**
     * 查询所有的category
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryService service = new CategoryServiceImpl();
        try {
            String categoryStr = service.findAll();
            System.out.println(categoryStr);
            //将json字符串相应到前端
            response.getWriter().println(categoryStr);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","查询数据失败!");
            return "jsp/info.jsp";
        }
        return null;
    }

    /**
     * 优化分类数据查询，都从redis中查询，
     * 如果redis中有则从redis中取，如果没有则从mysql中取
     * 然后放置到redis中
     * @param request
     * @param response
     * @return
     */
    public String fromRedis(HttpServletRequest request, HttpServletResponse response){
        ICategoryService service = new CategoryServiceImpl();
        try {
            String categoryStr = service.fromRedis();
            System.out.println(categoryStr);
            //将json字符串相应到前端
            response.getWriter().println(categoryStr);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","查询数据失败!");
            return "jsp/info.jsp";
        }
        return null;
    }
}
