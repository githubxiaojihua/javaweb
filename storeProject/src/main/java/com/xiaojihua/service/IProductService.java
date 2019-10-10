package com.xiaojihua.service;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    PageBean<Product> findProsByCid(String cid,String pageNum,String size) throws SQLException;
    Product findByPid(String pid) throws SQLException;
    List<Product> findHot() throws SQLException;
    List<Product> findNew() throws SQLException;
}
