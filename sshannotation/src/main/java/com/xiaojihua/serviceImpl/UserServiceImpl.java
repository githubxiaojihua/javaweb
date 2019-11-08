package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import com.xiaojihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    @Transactional
    public void save(User user) {
        dao.save(user);
    }
}
