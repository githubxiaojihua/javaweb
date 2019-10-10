package com.xiaojihua.web;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Product;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.IProductService;
import com.xiaojihua.service.IUserService;
import com.xiaojihua.serviceImpl.ProductServiceImpl;
import com.xiaojihua.serviceImpl.UserServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.MailUtils;
import com.xiaojihua.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 通过继承BaseServlet来，实现统一的模块化请求处理，
 * 这样子servlet中只需要有自己的方法即可
 */
public class ProductsServlet extends BaseServlet {

    /**
     * 根据类目获取商品列表
     * @param request
     * @param response
     * @return
     */
    public String findProsByCid(HttpServletRequest request, HttpServletResponse response){
        IProductService service = new ProductServiceImpl();
        String pageNum = request.getParameter("pageNum");
        String size = request.getParameter("size");
        String cid = request.getParameter("cid");
        try {
            PageBean<Product> page = service.findProsByCid(cid,pageNum,size);
            request.setAttribute("page",page);
            request.setAttribute("cid",cid);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","查询数据失败!");
            return "jsp/info.jsp";

        }
        return "/jsp/product_list.jsp";
    }

    /**
     * 根据Pid查询产品详情
     * @param request
     * @param response
     * @return
     */
    public String findByPid(HttpServletRequest request, HttpServletResponse response){
        //1、获取点击商品的PID
        String pid = request.getParameter("pid");
        //2、调用SERVICE查询商品信息并封装对象
        IProductService service = new ProductServiceImpl();
        try {
            Product product = service.findByPid(pid);
            //3、将对象设置到request域中，返回到product_list.jsp中
            request.setAttribute("product",product);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","查询商品详情失败！");
            return "jsp/info.jsp";
        }
        return "jsp/product_info.jsp";
    }

    /**
     * 自定义首页到达此方法进行查询最新商品和热门商品，并返回到
     * 真正的index.jsp，从前台到servlet来转一圈
     * @param request
     * @param response
     * @return
     */
    public String findHotAndNew(HttpServletRequest request, HttpServletResponse response){
        System.out.println(11111);
        IProductService service = new ProductServiceImpl();
        try {
            List<Product> hotList = service.findHot();
            List<Product> newList = service.findNew();
            request.setAttribute("hotList",hotList);
            request.setAttribute("newList",newList);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","数据查询失败！");
            return "/jsp/info.jsp";
        }
        return "/jsp/index.jsp";
    }
}
