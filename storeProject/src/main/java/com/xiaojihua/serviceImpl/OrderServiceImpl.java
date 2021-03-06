package com.xiaojihua.serviceImpl;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.dao.IOrderDao;
import com.xiaojihua.daoImpl.OrderDaoImpl;
import com.xiaojihua.domain.Orders;
import com.xiaojihua.domain.OrdersItem;
import com.xiaojihua.service.IOrderService;
import com.xiaojihua.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderServiceImpl implements IOrderService {

    /**
     * 存储订单信息（事务）
     * @param orders
     * @throws SQLException
     */
    @Override
    public void saveOrder(Orders orders) throws SQLException {
        try{
            //1、获取Connection链接，并开启事务（不需要获取conn，因为此方法同时获取了并存储到threadLocal中
            DataSourceUtils.beginTransaction();
            //2、调用dao存储订单对象
            IOrderDao dao = new OrderDaoImpl();
            dao.saveOrder(orders,DataSourceUtils.getConnection());
            //3、调用dao存储订单详情对象
            for(OrdersItem item : orders.getList()){
                dao.saveOrderItem(item,DataSourceUtils.getConnection());
            }
            //4、提交事务，关闭链接
            DataSourceUtils.commitAndClose();
        }catch(Exception e){
            //回滚事务
            DataSourceUtils.rollbackAndClose();
            throw new SQLException(e);
        }


    }

    /**
     * 查询当前登录用户的订单数据
     */
    @Override
    public PageBean<Orders> findOrder(String uid, PageBean pageBean) throws Exception {
        IOrderDao orderDao = new OrderDaoImpl();
        PageBean<Orders> page = orderDao.findOrder(uid, pageBean);
        return page;
    }

    /**
     * 查询当前用户的订单数量
     * @param uid
     * @return
     */
    public int recordNum(String uid) throws SQLException{
        IOrderDao orderDao = new OrderDaoImpl();
        return orderDao.recordNum(uid);
    }

    /**
     * 根据oid查询订单数据
     * @param oid
     * @return
     * @throws Exception
     */
    @Override
    public Orders findOrderByOID(String oid) throws Exception {
        IOrderDao orderDao = new OrderDaoImpl();
        return orderDao.findOrderByOID(oid);
    }

    /**
     * 更改订单
     * @param orders
     * @throws SQLException
     */
    @Override
    public void updateOder(Orders orders) throws SQLException {
        IOrderDao dao = new OrderDaoImpl();
        dao.updateOrder(orders);
    }
}
