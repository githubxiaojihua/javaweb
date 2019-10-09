package com.xiaojihua.daoImpl;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.dao.IProductDao;
import com.xiaojihua.domain.Product;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements IProductDao {

    /**
     * 根据cid查询商品列表然后返回一个pageBean
     * @param cid
     * @param page
     * @return
     * @throws SQLException
     */
    @Override
    public PageBean<Product> findAllProsByCid(String cid,PageBean page) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM product WHERE cid=? limit ?,?";
        List<Product> products = query.query(sql,new BeanListHandler<Product>(Product.class),cid,page.getStartIndex(),page.getPageSize());
        page.setData(products);
        return page;
    }

    /**
     * 查询记录总数
     * @param cid
     * @return
     * @throws SQLException
     */
    @Override
    public int recordNumber(String cid) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT count(*) FROM product WHERE cid=?";
        int count = ((Long)query.query(sql,new ScalarHandler(),cid)).intValue();
        return count;
    }
}
