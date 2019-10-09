package com.xiaojihua.dao;

import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
    public int getFlag(String userName) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user where username = ?";
        int flag = ((Long)query.query(sql,new ScalarHandler<>(),userName)).intValue();
        return flag;
    }
}
