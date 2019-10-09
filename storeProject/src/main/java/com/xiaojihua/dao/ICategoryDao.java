package com.xiaojihua.dao;

import com.xiaojihua.domain.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
    List<Category> findAll() throws SQLException;
}
