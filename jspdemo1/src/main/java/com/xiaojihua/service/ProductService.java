package com.xiaojihua.service;

import com.xiaojihua.bean.Product;
import com.xiaojihua.dao.ProductDao;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    public List<Product> findAllProduct() throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findAllProduct();
    }
}
