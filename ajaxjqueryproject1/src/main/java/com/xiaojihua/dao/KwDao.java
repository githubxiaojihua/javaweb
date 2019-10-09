package com.xiaojihua.dao;

import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.ColumnHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import java.sql.SQLException;
import java.util.List;

public class KwDao {
    public List<Object> findList(String kwName) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select username from kw where username like ? limit 0,4";
        List<Object> resutlts = query.query(sql, new ColumnListHandler<>(),"%" + kwName + "%");
        return resutlts;
    }
}
