package com.xiaojihua.service;

import com.xiaojihua.dao.User;
import com.xiaojihua.domain.BirthdayDao;

import java.sql.SQLException;
import java.util.List;

public class BirthdayService {

    public List<User> getUsers() throws SQLException {
        BirthdayDao dao = new BirthdayDao();
        return dao.getUser();
    }
}
