package com.xiaojihua.service;

import com.xiaojihua.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    public int getFlag(String userName) throws SQLException {
        UserDao dao = new UserDao();
        return dao.getFlag(userName);
    }
}
