package com.xiaojihua.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xiaojihua.domain.Orders;

import java.sql.SQLException;

public interface IOrderService {
    void saveOrder(Orders orders) throws SQLException;
}
