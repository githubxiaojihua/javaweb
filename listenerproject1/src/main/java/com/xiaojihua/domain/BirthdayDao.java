package com.xiaojihua.domain;

import com.xiaojihua.dao.User;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class BirthdayDao {
    public List<User> getUser() throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where birthday like ?";
        List<User> users = query.query(sql,new BeanListHandler<User>(User.class),"%-10-%");
        return users;
    }
}
