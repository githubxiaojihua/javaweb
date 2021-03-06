package com.xiaojihua.service;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.bean.Product;
import com.xiaojihua.dao.ProductDao;
import com.xiaojihua.utils.DataSourcesUtils;

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

    public void deleteProSel(String[] ids) throws SQLException {
        if(ids != null){
            try{
                DataSourcesUtils.beginTransaction();
                ProductDao dao = new ProductDao();
                for(String id : ids){
                    dao.deleteProSel(id);
                }
                //int i = 1/0;
                DataSourcesUtils.commitAndClose();
            }catch(Exception e){
                e.printStackTrace();
                DataSourcesUtils.rollbackAndClose();
                throw e;
            }
        }
    }

    public List<Product> select(String name, String kw) throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.select(name,kw);
    }

    public PageBean<Product> selectPage(String pageNumberStr,String pageSizeStr) throws SQLException {
        int pageNumber = 1;
        int pageSize = 3;
        if(pageNumberStr!="" && pageNumberStr != null){
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        if(pageSizeStr!="" && pageSizeStr != null){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        PageBean<Product> pageBean = new PageBean<>(pageNumber,pageSize);
        ProductDao dao = new ProductDao();
        pageBean = dao.selectPage(pageBean);
        pageBean.setTotalNumber(dao.getRecordNum());
        return pageBean;
    }
}
