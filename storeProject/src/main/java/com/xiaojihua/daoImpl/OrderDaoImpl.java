package com.xiaojihua.daoImpl;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.dao.IOrderDao;
import com.xiaojihua.domain.Orders;
import com.xiaojihua.domain.OrdersItem;
import com.xiaojihua.domain.Product;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询当前登录用户的订单信息
     * @param uid
     * @param pageBean
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Orders> findOrder(String uid, PageBean pageBean) throws Exception {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        //1、根据uid查询当前用户的所有订单对象orders(分页)
        String sql = "SELECT * FROM orders WHERE uid = ? limit ?,?";
        List<Orders> orders = query.query(sql, new BeanListHandler<Orders>(Orders.class),uid,pageBean.getStartIndex(),pageBean.getPageSize());
        //1.1、遍历orders，根据订单信息查询订单项信息以及产品信息的所有数据
        for(Orders order : orders){
            String itemSql = "SELECT * " +
                    "           FROM orderitem item,product pro " +
                    "          WHERE item.pid = pro.pid " +
                    "            AND item.oid = ?";
            List<Map<String, Object>> items = query.query(itemSql, new MapListHandler(), order.getOid());
            //获取每个订单下的订单项列表
            List<OrdersItem> ordersItems = order.getList();
            //1.1.1、遍历查询出的数据，将所与数据分别封装到订单项中，并添加到订单中。
            for(Map<String, Object> itemMap : items){
                //封装订单项目
                OrdersItem item = new OrdersItem();
                BeanUtils.populate(item,itemMap);
                //封装产品对象
                Product product = new Product();
                BeanUtils.populate(product,itemMap);
                //将产品对象封装到订单项目中
                item.setProduct(product);
                //将订单项增加到订单的List中
                ordersItems.add(item);
            }
        }

        //2、将orders封装到pagebean中，返回
        pageBean.setData(orders);
        return pageBean;
    }

    /**
     * 查询记录总数，用于复制pageBean的总记录数
     * @param uid
     * @return
     * @throws SQLException
     */
    @Override
    public int recordNum(String uid) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT count(*) FROM orders WHERE uid=?";
        int count = ((Long)query.query(sql,new ScalarHandler<>(),uid)).intValue();
        return count;
    }

    /**
     * 根据oid查询订单信息在页面展示
     * @param oid
     * @return
     * @throws SQLException
     */
    @Override
    public Orders findOrderByOID(String oid) throws Exception {
        //1、根据oid查询订单信息
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM orders WHERE oid=?";
        Orders order = query.query(sql, new BeanHandler<Orders>(Orders.class), oid);
        List<OrdersItem> itemList = order.getList();
        //2、根据订单编号使用关联查询所有相关的数据（购物项数据和产品数据）
        sql = "SELECT * " +
                "           FROM orderitem item,product pro " +
                "          WHERE item.pid = pro.pid " +
                "            AND item.oid = ?";
        List<Map<String, Object>> dataMap = query.query(sql, new MapListHandler(), order.getOid());
        //3、遍历列表，分别组装购物项和产品数据,组装订单数据返回
        for(Map<String, Object> map : dataMap){
            OrdersItem item = new OrdersItem();
            BeanUtils.populate(item,map);
            Product product = new Product();
            BeanUtils.populate(product,map);

            //将product封装到item中
            item.setProduct(product);
            //将item封装到order中
            itemList.add(item);
        }
        return order;
    }

    /**
     * 修改order
     * @param orders
     * @throws SQLException
     */
    @Override
    public void updateOrder(Orders orders) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "UPDATE orders set address=?,name=?,telephone=?,state=? WHERE oid=?";
        query.update(sql,orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getState(),orders.getOid());
    }
}
