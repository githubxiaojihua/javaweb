package com.xiaojihua.web;

import com.xiaojihua.domain.Cart;
import com.xiaojihua.domain.CartItem;
import com.xiaojihua.domain.Product;
import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.service.IProductService;
import com.xiaojihua.serviceImpl.CategoryServiceImpl;
import com.xiaojihua.serviceImpl.ProductServiceImpl;
import com.xiaojihua.utils.BaseServlet;

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
public class CartServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 从session中获取购物车，如果没有的话创建一个并存储
     * @param request
     * @return
     */
    public Cart getCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        return cart;

    }

    /**
     * 增加商品到购物车
     * @param request
     * @param response
     * @return
     */
    public String addCart(HttpServletRequest request, HttpServletResponse response){
        //1、获取购物车
        Cart cart = this.getCart(request);
        //2、获取页面属性封装购物项
        String pid = request.getParameter("pid");
        Integer count = Integer.parseInt(request.getParameter("count"));
        //2.1获取产品对象
        IProductService pService = new ProductServiceImpl();
        try {
            Product product = pService.findByPid(pid);
            CartItem item = new CartItem();
            item.setCount(count);
            item.setProduct(product);
            //3、增加到购物车
            cart.add(item);
            //4、返回页面，request中无数据，可以直接重定向
            response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","添加商品到购物车出错！");
            return "jsp/info.jsp";
        }
        return null;
    }

    /**
     * 从购物车中移除数据
     * @param request
     * @param response
     * @return
     */
    public String remove(HttpServletRequest request, HttpServletResponse response){
        //1、从页面获取要移除的PID
        String pid = request.getParameter("pid");
        //2、获取购物车
        Cart cart = this.getCart(request);
        //3、根据pid直接从购物车中删除
        cart.remove(pid);
        //4、重定向到购物车页面
        try {
            response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("msg","从购物车中删除商品出错！");
            return "jsp/info.jsp";
        }
        return null;
    }

    /**
     * 清空购物车
     * @param request
     * @param response
     * @return
     */
    public String clear(HttpServletRequest request, HttpServletResponse response){
        //1、获取购物车
        Cart cart = this.getCart(request);
        //2、清空购物车
        cart.clear();
        //3、返回购物车页面
        //4、重定向到购物车页面
        try {
            response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("msg","从购物车中删除商品出错！");
            return "jsp/info.jsp";
        }

        return null;
    }

}
