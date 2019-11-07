package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }
}
