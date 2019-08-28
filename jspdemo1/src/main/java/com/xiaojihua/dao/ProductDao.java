package com.xiaojihua.dao;

import com.xiaojihua.bean.Product;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    public List<Product> findAllProduct() throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product";
        List<Product> products = query.query(sql,new BeanListHandler<Product>(Product.class));
        return products;
    }
}
