package com.xiaojihua.service;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.domain.CateGory;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryService {
    EasyuiPageBean<CateGory> findCategory(String page,String rows) throws SQLException;
    void deleteByCid(String cid) throws SQLException;
    void save(CateGory cateGory) throws SQLException;
    void update(CateGory cateGory)throws SQLException;
}
