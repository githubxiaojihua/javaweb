package com.xiaojihua.dao;

import com.xiaojihua.domain.User;

import java.sql.SQLException;

public interface IUserDao {
    void save(User user) throws SQLException;
    User findByCode(String code) throws SQLException;
    void update(User user) throws SQLException;
    User login(String userName,String passWord) throws SQLException;
}
