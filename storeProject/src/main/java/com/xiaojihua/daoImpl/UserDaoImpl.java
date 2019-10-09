package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.IUserDao;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

    /**
     * 根据激活码获取用户
     */
    @Override
    public User findByCode(String code) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM user WHERE code=?";
        User user = query.query(sql,new BeanHandler<User>(User.class),code);
        return user;
    }

    /**
     * 更新USER
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(User user) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "UPDATE user set state=? WHERE code=?";
        query.update(sql,user.getState(),user.getCode());
    }

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     * @throws SQLException
     */
    @Override
    public User login(String userName, String passWord) throws SQLException {
        QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "SELECT * FROM user WHERE username=? and password=?";
        User user = query.query(sql,new BeanHandler<User>(User.class),userName,passWord);
        return user;
    }
}
