package com.xiaojihua.web;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.daoImpl.CategoryDaoImpl;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.serviceImpl.CategoryServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.UUIDUtils;
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
        try {
            //1、获取保存的类目
            String cName = request.getParameter("name");
            //2、创建类目对象
            CateGory cateGory = new CateGory();
            cateGory.setCid(UUIDUtils.getUUID());
            cateGory.setCname(cName);
            //3、调用dao保存对象
            ICategoryService service = new CategoryServiceImpl();
            //4、写回结果信息
            response.getWriter().print("ok");
            service.save(cateGory);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 更新类目
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public String updateCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            //1、获取Cname和Cid
            String cid = request.getParameter("cid");
            String cname = request.getParameter("cname");
            //2、根据Cid获取Category
            ICategoryService service = new CategoryServiceImpl();
            CateGory cateGory = new CateGory();
            //原则上是应该先从数据库中获取然后再设置
            cateGory.setCid(cid);
            cateGory.setCname(cname);
            //3、更改cname并且保存
            service.update(cateGory);
            //4、返回结果
            response.getWriter().print("ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
