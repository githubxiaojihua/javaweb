package com.xiaojihua.web;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.domain.Product;
import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.service.IProductService;
import com.xiaojihua.serviceImpl.CategoryServiceImpl;
import com.xiaojihua.serviceImpl.ProductServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.UUIDUtils;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductServletHt extends BaseServlet {
    private static final long serialVersionUID = 1L;

    //自己的方法

    /**
     * 分页显示产品列表
     * @param request
     * @param response
     * @return
     */
    public String findProduct(HttpServletRequest request,HttpServletResponse response) throws Exception {
        try {
            //1、获取当前页参数(easyUI分页组件会传递这两个参数)
            String pageNumber = request.getParameter("page");
            String pageSize = request.getParameter("rows");
            //2、调用Service获取PageBean对象
            IProductService service = new ProductServiceImpl();
            EasyuiPageBean<Product> pageBean = service.findProdut(pageNumber, pageSize);
            String pageStr = JSONObject.fromObject(pageBean).toString();
            //3、对easyUI写回json字符串
            response.getWriter().print(pageStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // 查所有分类 放在页面的下拉框中
    public String findCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            // 调用service 全查分类
            IProductService productService=new ProductServiceImpl();
            String value = productService.findCategory();
            System.out.println(value);
            response.getWriter().print(value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
