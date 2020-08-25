package xiaojihua.domain;

import org.springframework.stereotype.Component;
import xiaojihua.annotation.NeedTest;

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

	public void testArgs(String name,int num){
		System.out.println("intestArgs=====");
		System.out.println("name:" + name);
		System.out.println("num:" + num);
	}

	@NeedTest("needTest")
	public void testAnnotation(String name,int num){
		System.out.println("intestArgs=====");
		System.out.println("name:" + name);
		System.out.println("num:" + num);
	}

	public String toString(){
		return "Person to String";
	}
}
