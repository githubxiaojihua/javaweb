package com.xiaojihua.daoImpl;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    /**
     * 查询所有的分类信息
     * @return
     * @throws SQLException
     */
    @Override
    public EasyuiPageBean<CateGory> findCategory(EasyuiPageBean pageBean) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM category limit ?,?";
        List<CateGory> cateGories = queryRunner.query(sql, new BeanListHandler<CateGory>(CateGory.class),pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setRows(cateGories);
        return pageBean;
    }

    /**
     * 查询记录总数
     */
    @Override
    public int recordCount() throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT COUNT(*) FROM category";
        int recordCount = ((Long)query.query(sql,new ScalarHandler<>())).intValue();
        return recordCount;
    }

    /**
     * 根据Cid删除类目
     * @param cid
     * @throws SQLException
     */
    @Override
    public void deleteByCid(String cid) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "DELETE FROM category WHERE cid=?";
        query.update(sql,cid);
    }
}
