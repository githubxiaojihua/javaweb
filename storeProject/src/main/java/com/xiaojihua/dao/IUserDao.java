package com.xiaojihua.dao;

import com.xiaojihua.domain.User;

import java.sql.SQLException;

public interface IUserDao {
    void save(User user) throws SQLException;
}
