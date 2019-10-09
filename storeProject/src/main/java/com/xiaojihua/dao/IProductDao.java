package com.xiaojihua.dao;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    PageBean<Product> findAllProsByCid(String cid,PageBean pageBean) throws SQLException;
    int recordNumber(String cid) throws SQLException;
}
