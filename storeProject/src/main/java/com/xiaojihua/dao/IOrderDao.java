package com.xiaojihua.dao;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Orders;
import com.xiaojihua.domain.OrdersItem;

import java.sql.Connection;
import java.sql.SQLException;

public interface IOrderDao {
    void saveOrder(Orders orders, Connection conn) throws SQLException;

    void saveOrderItem(OrdersItem ordersItem, Connection conn) throws SQLException;

    PageBean<Orders> findOrder(String uid, PageBean pageBean) throws Exception;

    int recordNum(String uid) throws SQLException;

    Orders findOrderByOID(String oid) throws Exception;

    void updateOrder(Orders orders) throws SQLException;
}
