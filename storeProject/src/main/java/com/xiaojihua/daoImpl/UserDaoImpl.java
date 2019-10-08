package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.IUserDao;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    @Override
    public void save(User user) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "INSERT INTO user values(?,?,?,?,?,?,?,?,?)";
        Object[] args = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
                         user.getEmail(),user.getBirthday(),user.getSex(),user.getState(),
                         user.getCode()};
        query.update(sql,args);
    }
}
