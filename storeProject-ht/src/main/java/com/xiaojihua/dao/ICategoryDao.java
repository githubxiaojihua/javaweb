package com.xiaojihua.dao;

import com.xiaojihua.domain.CateGory;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
    List<CateGory> findCategory() throws SQLException;
}
