package com.xiaojihua.service;

import com.xiaojihua.domain.User;

import java.sql.SQLException;

public interface IUserService {
    void save(User user) throws SQLException;
}
