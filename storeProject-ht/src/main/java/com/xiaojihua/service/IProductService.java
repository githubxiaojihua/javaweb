package com.xiaojihua.service;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.domain.Product;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public interface IProductService {
    EasyuiPageBean<Product> findProdut(String page, String rows) throws Exception;
    String findCategory() throws SQLException;
}
