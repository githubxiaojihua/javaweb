package com.xiaojihua.dao;

import com.xiaojihua.bean.User;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LoginDao {
    public User getUserByUserNameAndPassword(String userName, String pass) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from users where username = ? and pass = ?";
        User user = query.query(sql,new BeanHandler<User>(User.class),userName,pass);
        return user;
    }
}
