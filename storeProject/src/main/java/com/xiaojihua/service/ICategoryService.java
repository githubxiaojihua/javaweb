package com.xiaojihua.service;

import java.sql.SQLException;

public interface ICategoryService {
    String findAll() throws SQLException;
    String fromRedis() throws SQLException;
}
