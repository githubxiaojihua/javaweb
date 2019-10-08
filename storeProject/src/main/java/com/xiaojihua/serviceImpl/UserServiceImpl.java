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
}
