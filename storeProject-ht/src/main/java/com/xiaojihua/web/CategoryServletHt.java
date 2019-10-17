package com.xiaojihua.web;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.serviceImpl.CategoryServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryServletHt extends BaseServlet {
    private static final long serialVersionUID = 1L;

    //自己的方法

    /**
     * 分页查找所有分类，将结果转换成json字符串到前台给
     * easyUI显示
     * @param request
     * @param response
     * @return
     */
    public String findCategory(HttpServletRequest request, HttpServletResponse response){
        try {
            String rows = request.getParameter("rows");
            String page = request.getParameter("page");
            //1、调用service查询所有category
            ICategoryService service = new CategoryServiceImpl();
            EasyuiPageBean<CateGory> cateGories = service.findCategory(page,rows);
            String categories = JSONObject.fromObject(cateGories).toString();
            //2、将查询出的List转换成json，并写回给easyUI
            response.getWriter().println(categories);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据Cid删除一个分类
     * @param request
     * @param response
     * @return
     */
    public String deleteByCid(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String cid = request.getParameter("cid");
            ICategoryService service = new CategoryServiceImpl();
            service.deleteByCid(cid);
            /*
            尽量不要使用println因为，println在协会浏览器端的时候会在
            后面自动追加\r\n因为是换行打印
            */
            //response.getWriter().println("ok");
            response.getWriter().print("ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增类目
     */
    public String saveCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("ok");
        return null;
    }
}
