package com.xiaojihua.dao;

import java.sql.SQLException;

import com.xiaojihua.bean.User;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class LoginDao {

	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		//创建QueryRunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//编写sql
		String sql ="select * from users where username=? and pass = ?";
		//执行sql
		User user = qr.query(sql, new BeanHandler<User>(User.class), username,password);
		return user;
	}

}
