package com.xiaojihua.dao;

import com.xiaojihua.bean.PageBean;
import com.xiaojihua.bean.Product;
import com.xiaojihua.utils.DataSourcesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public List<Product> findAll() throws SQLException {
        QueryRunner query = new QueryRunner(DataSourcesUtils.getDataSource());
        String sql = "select * from productforjdbc";
        List<Product> pros = query.query(sql,new BeanListHandler<Product>(Product.class));
        return pros;
    }

    public void add(Product product) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourcesUtils.getDataSource());
        String sql = "insert into productforjdbc values(?,?,?,?,?,?,?)";
        query.update(sql,product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),product.getPdate(),product.getPdesc());
    }

    public Product getProByPid(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourcesUtils.getDataSource());

        String sql = "select * from productforjdbc where pid=?";

        Product query = qr.query(sql, new BeanHandler<Product>(Product.class), id);
        return query;
    }

    public void updatePro(Product pro) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourcesUtils.getDataSource());

        String sql = "update productforjdbc set pname=?,market_price=?,shop_price=?,pdesc=? where pid=?";

        qr.update(sql, pro.getPname(),pro.getMarket_price(),pro.getShop_price(),pro.getPdesc(),pro.getPid());
    }

    public void deletePro(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourcesUtils.getDataSource());

        String sql = "delete from productforjdbc where pid = ?";

        qr.update(sql, pid);
    }

    public void deleteProSel(String pid) throws SQLException {
        QueryRunner query = new QueryRunner();
        String sql = "delete from productforjdbc where pid = ?";
        query.update(DataSourcesUtils.getConnection(),sql,pid);

    }

    public List<Product> select(String name, String kw) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourcesUtils.getDataSource());
        StringBuffer sb = new StringBuffer("select * from productforjdbc where 1=1");
        List<String> tj = new ArrayList<>();
        if(!"".equals(name)){
            sb.append(" and pname like ?");
            tj.add("%" + name + "%");
        }
        if(!"".equals(kw)){
            sb.append(" and pdesc like ?");
            tj.add("%" + kw + "%");
        }

        List<Product> products = query.query(sb.toString(),new BeanListHandler<Product>(Product.class),tj.toArray());
        return products;
    }

    public PageBean<Product> selectPage(PageBean pageBean) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourcesUtils.getDataSource());
        String sql = "select * from productforjdbc limit ?,?";
        List<Product> pros = query.query(sql,new BeanListHandler<Product>(Product.class),pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(pros);
        return pageBean;
    }

    public int getRecordNum() throws SQLException {
        QueryRunner query = new QueryRunner(DataSourcesUtils.getDataSource());
        String sql = "select count(*) from productforjdbc ";
        //这个地方要现转换成Long然后再转成int
        int count = ((Long)query.query(sql, new ScalarHandler())).intValue();
        return count;
    }
}
