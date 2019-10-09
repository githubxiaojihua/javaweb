package com.xiaojihua.service;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.domain.Product;

import java.sql.SQLException;

public interface IProductService {
    PageBean<Product> findProsByCid(String cid,String pageNum,String size) throws SQLException;
}
