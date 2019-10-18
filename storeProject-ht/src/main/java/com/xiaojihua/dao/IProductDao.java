package com.xiaojihua.dao;

import com.xiaojihua.bean.EasyuiPageBean;
import com.xiaojihua.domain.CateGory;
import com.xiaojihua.domain.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProductDao {
    List<Map<String,Object>> findProduct(int start,int size) throws SQLException;
    int recordNum() throws SQLException;
    List<CateGory> findCategory() throws SQLException;
}
