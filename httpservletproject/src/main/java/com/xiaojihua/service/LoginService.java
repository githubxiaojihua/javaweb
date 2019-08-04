package com.xiaojihua.service;

import com.xiaojihua.dao.LoginDao;
import com.xiaojihua.domain.Users;

import java.sql.SQLException;

public class LoginService {
    private LoginDao loginDao = new LoginDao();

    public Users loginByUserNameAndPassword(String userName, String password){
        Users user = null;
        try{
            user = loginDao.getUserByUserNameAndPassword(userName,password);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return user;
    }
}
