package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.IOrderDao;
import com.xiaojihua.domain.Orders;
import com.xiaojihua.domain.OrdersItem;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDaoImpl implements IOrderDao {

    /**
     * 存储订单数据
     * @param orders
     * @param conn
     * @throws SQLException
     */
    @Override
    public void saveOrder(Orders orders, Connection conn) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?,?,?)";
        Object[] params = {orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),
                           orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUser().getUid()};
        queryRunner.update(conn,sql,params);
    }

    /**
     * 存储订单详情数据
     * @param ordersItem
     * @param conn
     * @throws SQLException
     */
    @Override
    public void saveOrderItem(OrdersItem ordersItem, Connection conn) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
        Object[] params = {ordersItem.getItemid(),ordersItem.getCount(),ordersItem.getSubtotal(),ordersItem.getProduct().getPid(),ordersItem.getOrders().getOid()};
        queryRunner.update(conn,sql,params);
    }
}
