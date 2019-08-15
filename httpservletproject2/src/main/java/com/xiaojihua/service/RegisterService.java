package com.xiaojihua.service;

import java.sql.SQLException;

import com.xiaojihua.bean.Customer;
import com.xiaojihua.dao.RegisterDao;

public class RegisterService {

	public void saveCustomer(Customer cus) throws SQLException {
		//创建RegisterDao
		RegisterDao rd = new RegisterDao();
		//调用方法
		rd.saveCustomer(cus);
	}

}
