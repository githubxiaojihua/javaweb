package com.xiaojihua.service;

import com.xiaojihua.bean.Product;
import com.xiaojihua.dao.ProductDao;

import java.sql.SQLException;
import java.util.List;

public class ProductService {

    public List<Product> findAll() throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findAll();
    }

    public void add(Product product) throws SQLException {
        ProductDao dao = new ProductDao();
        dao.add(product);
    }

    public Product getProByPid(String id) throws SQLException {
        ProductDao pd = new ProductDao();
        return pd.getProByPid(id);
    }

    public void updatePro(Product pro) throws SQLException {
        ProductDao pd = new ProductDao();
        pd.updatePro(pro);
    }

    public void deletePro(String pid) throws SQLException {
        ProductDao pd = new ProductDao();
        pd.deletePro(pid);
    }
}
