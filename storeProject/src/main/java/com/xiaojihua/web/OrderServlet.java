package com.xiaojihua.web;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.*;
import com.xiaojihua.service.IOrderService;
import com.xiaojihua.service.IProductService;
import com.xiaojihua.serviceImpl.OrderServiceImpl;
import com.xiaojihua.serviceImpl.ProductServiceImpl;
import com.xiaojihua.utils.BaseServlet;
import com.xiaojihua.utils.PaymentUtil;
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

    /**
     * 保存订单
     * @param request
     * @param response
     * @return
     */
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
            //清空购物车
            cart.clear();
            request.setAttribute("orders",orders);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg","亲，生成订单错误！");
            return "jsp/info.jsp";
        }
        //5、页面跳转
        return "/jsp/order_info.jsp";
    }

    /**
     * 查询登录用户的订单
     */
    public String findOrder(HttpServletRequest request, HttpServletResponse response){
        try {
            //1、获取当前登录的用户
            User currUser = (User) request.getSession().getAttribute("user");
            //2、获取分页数据构造PageBean
            int pageNum = 1,pageSize=3;
            String pageNumStr = (String) request.getParameter("pageNum");
            String pageSizeStr = (String) request.getParameter("pageSize");
            if(pageNumStr != null && !"".equals(pageNumStr)){
                pageNum = Integer.parseInt(pageNumStr);
            }
            if(pageSizeStr != null && !"".equals(pageSizeStr)){
                pageSize = Integer.parseInt(pageSizeStr);
            }
            PageBean<Orders> pageBean = new PageBean<>(pageNum,pageSize);
            IOrderService service = new OrderServiceImpl();
            pageBean.setTotalNumber(service.recordNum(currUser.getUid()));
            //3、调用service查询订单数据并封装到pageBean中
            PageBean<Orders> page = service.findOrder(currUser.getUid(), pageBean);
            //4、将pagebean放到request域中
            request.setAttribute("page",page);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg","查询订单出错！");
            return "jsp/info.jsp";
        }
        //4、返回到页面展示：order_info.jsp
        return "jsp/order_list.jsp";
    }


    /**
     * 查询oid查询订单详情
     */
    public String findOrderByOID(HttpServletRequest request, HttpServletResponse response){
        try {

            // 获取点击订单的订单号
            String oid = request.getParameter("oid");
            // 根据点击的订单号  查出来该订单以及该订单下面的所有订单项信息
            IOrderService orderService=new OrderServiceImpl();
            // 需要有订单的数据还有订单项集合的数据
            Orders orders=orderService.findOrderByOID(oid);
            // 把封装好的orders给request
            request.setAttribute("orders", orders);

        } catch (Exception e) {
            // TODO: handle exception
        }
        // 到order_info.jsp页面展示该订单的详情
        return "/jsp/order_info.jsp";
    }

    /**
     * 订单支付
     * 使用易宝支付
     * @param request
     * @param response
     * @return
     */
    public String payOrders(HttpServletRequest request, HttpServletResponse response){
        try {
            //1、获取oid，根据oid获取Orders对象。
            String oid = (String)request.getParameter("oid");
            IOrderService service = new OrderServiceImpl();
            Orders order = service.findOrderByOID(oid);
            //2、获取地址、收货人、电话，并设置到orders对象中
            String address = (String)request.getParameter("address");
            String name = (String)request.getParameter("name");
            String telephone = (String)request.getParameter("telephone");
            order.setAddress(address);
            order.setName(name);
            order.setTelephone(telephone);
            //2.1 调用service做一次通用的修改
            service.updateOder(order);
            //3、根据易宝支付要求拼接相关参数
            String p0_Cmd = "Buy";
            String p1_MerId = "10001126856";
            String p2_Order = order.getOid(); // 订单号
            String p3_Amt = "0.01";//测试用1分钱，真正开发中用order.getTotal();
            String p4_Cur = "CNY";
            String p5_Pid = "";
            String p6_Pcat = "";
            String p7_Pdesc = "";
            String p8_Url = "http://localhost:8080"+request.getContextPath()+"/order?method=payCallBack";
            String p9_SAF = "0";
            String pa_MP = "";
            String pd_FrpId = request.getParameter("pd_FrpId");
            String pr_NeedResponse = "1";
            // 电子签名
            String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
            //4、向易宝支付发送付款请求
            StringBuffer buffer = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
            buffer.append("p0_Cmd="+p0_Cmd);
            buffer.append("&p1_MerId="+p1_MerId);
            buffer.append("&p2_Order="+p2_Order);
            buffer.append("&p3_Amt="+p3_Amt);
            buffer.append("&p4_Cur="+p4_Cur);
            buffer.append("&p5_Pid="+p5_Pid);
            buffer.append("&p6_Pcat="+p6_Pcat);
            buffer.append("&p7_Pdesc="+p7_Pdesc);
            buffer.append("&p8_Url="+p8_Url);
            buffer.append("&p9_SAF="+p9_SAF);
            buffer.append("&pa_MP="+pa_MP);
            buffer.append("&pd_FrpId="+pd_FrpId);
            buffer.append("&pr_NeedResponse="+pr_NeedResponse);
            buffer.append("&hmac="+hmac);

            response.sendRedirect(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 支付成功后回调方法
     * @param request
     * @param response
     * @return
     */
    public String payCallBack(HttpServletRequest request, HttpServletResponse response){
        try {
            // 获取支付的订单id
            String r6_Order = request.getParameter("r6_Order");
            // 修改状态为1 已付款
            IOrderService orderService=new OrderServiceImpl();
            Orders order = orderService.findOrderByOID(r6_Order);
            order.setState(1);
            // 修改
            orderService.updateOder(order);
            // 给页面显示支付成功或则失败
            request.setAttribute("msg","恭喜你,支付成功,你为"+r6_Order+"支付了"+request.getParameter("r3_Amt")+"钱");

        } catch (Exception e) {
            // TODO: handle exception
        }
        return "/jsp/info.jsp";
    }
}
