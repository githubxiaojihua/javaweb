package com.xiaojihua.domain;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

// 没有接口--为了演示cglib的动态代理
@Component("person")
public class Person 
{
	
	public void save() {
		System.out.println("普通的保存方法...");
		
	}

	
	public void delete() {
		System.out.println("普通的删除方法...");
		
	}

	
	public void update() throws SQLException {
		System.out.println("普通的修改方法...");
		throw new SQLException("1");
		
	}

	
	public void find() {
		System.out.println("普通的查询方法...");
		
		
	}
}
