package com.xiaojihua.service;

import java.sql.SQLException;

import com.xiaojihua.bean.User;
import com.xiaojihua.dao.LoginDao;

public class LoginService {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		//创建LoginDao
		LoginDao ld = new LoginDao();
		
		return ld.getUserByUsernameAndPwd(username,password);
	}

}
