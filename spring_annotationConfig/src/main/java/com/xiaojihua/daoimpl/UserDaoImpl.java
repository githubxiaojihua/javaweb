package com.xiaojihua.daoimpl;

import com.xiaojihua.dao.UserDao;
import org.springframework.stereotype.Repository;


/*@Component("userDao")*///<bean id="userDao" class="com.xiaojihua.daoimpl.UserDaoImpl"></bean>
@Repository("userDao")
public class UserDaoImpl implements UserDao
{

	@Override
	public void save() {
		System.out.println("操作数据库:保存用户的数据..");
	}

}
