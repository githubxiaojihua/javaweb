package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.ICategoryDao;
import com.xiaojihua.domain.Category;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryImpl implements ICategoryDao {
    /**
     * 查询所有分类
     * @return
     * @throws SQLException
     */
    @Override
    public List<Category> findAll() throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM category";
        List<Category> categories = query.query(sql,new BeanListHandler<Category>(Category.class));
        return categories;
    }
}
