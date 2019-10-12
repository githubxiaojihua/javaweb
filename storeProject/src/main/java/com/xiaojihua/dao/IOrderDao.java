package com.xiaojihua.dao;

import com.xiaojihua.domain.Orders;
import com.xiaojihua.domain.OrdersItem;

import java.sql.Connection;
import java.sql.SQLException;

public interface IOrderDao {
    void saveOrder(Orders orders, Connection conn) throws SQLException;
    void saveOrderItem(OrdersItem ordersItem,Connection conn) throws SQLException;
}
