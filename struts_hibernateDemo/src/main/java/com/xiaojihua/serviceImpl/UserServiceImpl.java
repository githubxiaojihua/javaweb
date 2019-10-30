package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.IUserDao;
import com.xiaojihua.daoImpl.UserDaoImpl;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.IUserService;

public class UserServiceImpl implements IUserService {
    @Override
    public User login(User user) {
        IUserDao dao = new UserDaoImpl();
        return dao.login(user);
    }
}
