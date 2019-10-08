package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.IUserDao;
import com.xiaojihua.daoImpl.UserDaoImpl;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.IUserService;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    @Override
    public void save(User user) throws SQLException {
        IUserDao userDao = new UserDaoImpl();
        userDao.save(user);
    }

    /**
     * 根据激活码查询用户
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public User findByCode(String code) throws SQLException {
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.findByCode(code);
        return user;
    }

    /**
     * 更新用户信息
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(User user) throws SQLException {
        IUserDao userDao = new UserDaoImpl();
        userDao.update(user);
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
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.login(userName,passWord);
        return user;
    }
}
