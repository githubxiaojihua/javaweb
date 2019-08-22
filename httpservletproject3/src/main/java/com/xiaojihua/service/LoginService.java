package com.xiaojihua.service;

import com.xiaojihua.bean.User;
import com.xiaojihua.dao.LoginDao;

import java.sql.SQLException;

public class LoginService {
    public User getUserByUserNameAndPass(String userName,String pass) throws SQLException{
        LoginDao dao = new LoginDao();
        User user = null;
        user = dao.getUserByUserNameAndPassword(userName,pass);
        return user;
    }
}
