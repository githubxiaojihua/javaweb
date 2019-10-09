package com.xiaojihua.service;

import com.xiaojihua.dao.KwDao;

import java.sql.SQLException;
import java.util.List;

public class KwService {
    public List<Object> findList(String kwName) throws SQLException {
        KwDao dao = new KwDao();
        return dao.findList(kwName);
    }
}
