package com.xiaojihua.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Orders;

import java.sql.SQLException;

public interface IOrderService {
    void saveOrder(Orders orders) throws SQLException;
    PageBean<Orders> findOrder(String uid,PageBean pageBean) throws Exception;
    int recordNum(String uid) throws SQLException;
    Orders findOrderByOID(String oid) throws Exception;
    void updateOder(Orders orders) throws SQLException;
}
