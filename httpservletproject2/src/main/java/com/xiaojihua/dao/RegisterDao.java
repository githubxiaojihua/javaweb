package com.xiaojihua.dao;

import java.sql.SQLException;

import com.xiaojihua.bean.Customer;
import com.xiaojihua.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;

public class RegisterDao {

	public void saveCustomer(Customer cus) throws SQLException {
		//创建QueryRunner对象
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//编写sql
		String sql = "insert into customer values(null,?,?,?,?,?,?)";
		//执行sql
		qr.update(sql, cus.getUsername(),cus.getPassword(),cus.getEmail(),cus.getName(),cus.getSex(),cus.getBirthday());
	}

}
