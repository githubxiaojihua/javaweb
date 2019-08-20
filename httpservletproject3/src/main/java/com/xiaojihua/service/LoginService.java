package com.xiaojihua.service;

import com.xiaojihua.bean.User;
import com.xiaojihua.dao.LoginDao;

import java.sql.SQLException;

public class LoginService {
    public User getUserByUserNameAndPass(String userName,String pass){
        LoginDao dao = new LoginDao();
        User user = null;
        try{
            user = dao.getUserByUserNameAndPassword(userName,pass);
        }catch(SQLException exception){
            System.out.println(exception);
        }
        return user;
    }
}
