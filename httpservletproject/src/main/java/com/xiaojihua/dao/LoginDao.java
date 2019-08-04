package com.xiaojihua.dao;

import com.xiaojihua.domain.Users;
import com.xiaojihua.utils.C3p0DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class LoginDao {

    public Users getUserByUserNameAndPassword(String userName, String passWord) throws SQLException {
        QueryRunner queryR = new QueryRunner(C3p0DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM users WHERE username=? and pass=?";
        //使用的domain对象应该跟数据库中的列名一致，否则是无法赋值的，下面的user的password是没有值的，因为跟数据库
        //中的不一致
        Users user = queryR.query(sql,new BeanHandler<Users>(Users.class),userName,passWord);
        return user;
    }
}
