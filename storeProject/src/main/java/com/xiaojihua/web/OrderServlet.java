package com.xiaojihua.web;

import com.xiaojihua.domain.*;
import com.xiaojihua.service.IOrderService;
import com.xiaojihua.service.IProductService;
import com.xiaojihua.serviceImpl.OrderServiceImpl;
import com.xiaojihua.serviceImpl.ProductServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.UUIDUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 通过继承BaseServlet来，实现统一的模块化请求处理，
 * 这样子servlet中只需要有自己的方法即可
 */
public class OrderServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    public String addOrder(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        //1、判断用户是否登录，若未登录则提示登录
        User logedUser = (User) session.getAttribute("user");
        if(logedUser == null){
            request.setAttribute("msg","亲，请先登录！");
            return "jsp/info.jsp";
        }
        //2、从session域中获取购物车对象封装Order对象
        Cart cart = (Cart) session.getAttribute("cart");
        Orders orders = new Orders();
        orders.setOid(UUIDUtils.getUUID());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        orders.setOrdertime(format.format(new Date()));
        orders.setState(0);
        orders.setTotal(cart.getTotal());
        orders.setUser(logedUser);
        //3、从session域中获取购物车对象封装OrderItem对象
        List<OrdersItem> itemList = orders.getList();
        for(Map.Entry<String,CartItem> itemMap : cart.getItems().entrySet()){
            CartItem cartItem = itemMap.getValue();
            OrdersItem item = new OrdersItem();
            item.setCount(cartItem.getCount());
            item.setItemid(UUIDUtils.getUUID());
            item.setOrders(orders);
            item.setProduct(cartItem.getProduct());
            item.setSubtotal(cartItem.getSubTotal());
            //3.1将封装好的OrderItem对象增加到orders中
            itemList.add(item);
        }
        //4、调用service存储orders对象（事务）
        IOrderService service = new OrderServiceImpl();
        try {
            service.saveOrder(orders);
            request.setAttribute("orders",orders);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","亲，生成订单错误！");
            return "jsp/info.jsp";
        }
        //5、页面跳转
        return "/jsp/order_info.jsp";
    }

}
