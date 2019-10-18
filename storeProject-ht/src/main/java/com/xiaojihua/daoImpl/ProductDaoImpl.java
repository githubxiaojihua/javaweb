package com.xiaojihua.daoImpl;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.dao.IProductDao;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.domain.Product;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements IProductDao {

    /**
     * 返回查询出的所有数据，在service层进行分别封装
     * @return
     * @throws SQLException
     */
    @Override
    public List<Map<String,Object>> findProduct(int start,int size) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM product pro,category cat WHERE pro.cid=cat.cid limit ?,?";
        List<Map<String,Object>> maps = queryRunner.query(sql, new MapListHandler(), start, size);
        return maps;
    }

    /**
     * 查询所有记录数用于分页
     * @return
     * @throws SQLException
     */
    @Override
    public int recordNum() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT count(*) FROM product";
        int recordNum = ((Long)queryRunner.query(sql,new ScalarHandler<>())).intValue();
        return recordNum;
    }

    /**
     * 查询类目信息用于显示
     * @return
     * @throws SQLException
     */
    @Override
    public List<CateGory> findCategory() throws SQLException {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from category";
        List<CateGory> list = qr.query(sql, new BeanListHandler<CateGory>(CateGory.class));
        return list;
    }
}
