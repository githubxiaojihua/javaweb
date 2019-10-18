package com.xiaojihua.dao;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.domain.CateGory;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryDao {
    EasyuiPageBean<CateGory> findCategory(EasyuiPageBean pageBeans) throws SQLException;
    int recordCount() throws SQLException;
    void deleteByCid(String cid) throws SQLException;
    void save(CateGory cateGory) throws SQLException;
    void update(CateGory cateGory) throws SQLException;
}
