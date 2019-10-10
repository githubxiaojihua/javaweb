package com.xiaojihua.serviceImpl;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.dao.IProductDao;
import com.xiaojihua.daoImpl.ProductDaoImpl;
import com.xiaojihua.domain.Product;
import com.xiaojihua.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {

    /**
     * 根据cid来查询商品列表，然后返回pageBean
     * @param cid
     * @param pageNumStr
     * @param sizeStr
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Product> findProsByCid(String cid, String pageNumStr, String sizeStr) throws SQLException {
        int pageNum = 1;
        int size = 12;
        if(pageNumStr != null && pageNumStr != "" ){
            pageNum = Integer.parseInt(pageNumStr);
        }
        if(sizeStr != null && sizeStr != ""){
            size = Integer.parseInt(sizeStr);
        }
        PageBean<Product> page = new PageBean<>(pageNum,size);
        IProductDao dao = new ProductDaoImpl();
        page = dao.findAllProsByCid(cid,page);
        int recordCount = dao.recordNumber(cid);
        page.setTotalNumber(recordCount);
        return page;
    }

    /**
     * 根据pid查询产品详情
     * @param pid
     * @return
     * @throws SQLException
     */
    @Override
    public Product findByPid(String pid) throws SQLException {
        IProductDao dao = new ProductDaoImpl();
        Product product = dao.findByPid(pid);
        return product;
    }

    /**
     * 查询热门商品
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findHot() throws SQLException {
        IProductDao dao = new ProductDaoImpl();
        List<Product> hotList = dao.findHotList();
        return hotList;
    }

    /**
     * 查询最新商品
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findNew() throws SQLException {
        IProductDao dao = new ProductDaoImpl();
        List<Product> newList = dao.findNewList();
        return newList;
    }
}
