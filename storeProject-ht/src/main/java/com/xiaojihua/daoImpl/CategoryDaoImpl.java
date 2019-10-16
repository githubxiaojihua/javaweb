package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    /**
     * 查询所有的分类信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<CateGory> findCategory() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        return null;
    }
}
