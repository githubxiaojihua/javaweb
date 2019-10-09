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
import java.util.Map;

/**
 * 通过继承BaseServlet来，实现统一的模块化请求处理，
 * 这样子servlet中只需要有自己的方法即可
 */
public class ProductsServlet extends BaseServlet {

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
}
