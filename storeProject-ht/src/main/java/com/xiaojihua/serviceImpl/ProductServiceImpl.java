package com.xiaojihua.serviceImpl;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.dao.IProductDao;
import com.xiaojihua.daoImpl.CategoryDaoImpl;
import com.xiaojihua.daoImpl.ProductDaoImpl;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.domain.Product;
import com.xiaojihua.service.ICategoryService;
import com.xiaojihua.service.IProductService;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements IProductService {

    /**
     * 分页查询产品信息
     * @param page
     * @param rows
     * @return
     * @throws SQLException
     */
    @Override
    public EasyuiPageBean<Product> findProdut(String page, String rows) throws Exception {
        //设置默认分页和每页数据量
        int pageNumber = 1;
        int pageSize = 10;
        if(page != null && !"".equals(page)){
            pageNumber = Integer.parseInt(page);
        }
        if(rows != null && !"".equals(rows)){
            pageSize = Integer.parseInt(rows);
        }

        //获取数据并封装
        EasyuiPageBean<Product> pageBean = new EasyuiPageBean<>(pageNumber,pageSize);
        List<Product> products = new ArrayList<>();
        IProductDao dao = new ProductDaoImpl();
        //获取所有数据进行分开封装
        List<Map<String, Object>> maps = dao.findProduct(pageBean.getStartIndex(), pageBean.getPageSize());
        for(Map<String,Object> map : maps){
            Product product = new Product();
            BeanUtils.populate(product,map);
            CateGory cateGory = new CateGory();
            BeanUtils.populate(cateGory,map);
            product.setCategory(cateGory);
            products.add(product);
        }
        //设置pageBean的关键数据
        pageBean.setTotal(dao.recordNum());
        pageBean.setRows(products);
        return pageBean;
    }

    /**
     * 查询类目信息用于显示
     * @return
     * @throws SQLException
     */
    @Override
    public String findCategory() throws SQLException {
        IProductDao productDao=new ProductDaoImpl();
        List<CateGory> list = productDao.findCategory();
        // 将java转换成json数据
        JSONArray json = JSONArray.fromObject(list);
        return json.toString();
    }

    @Override
    public void saveProduct(Product product) throws SQLException {
        IProductDao productDao=new ProductDaoImpl();
        productDao.saveProduct(product);
    }
}
