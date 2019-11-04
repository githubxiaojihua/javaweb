package com.xiaojihua.serviceimpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/* action层
@Scope("prototype")*/
/*@Component("userService")*///<bean id="userService" class="com.xiaojihua.serviceImpl.UserServiceImpl">
@Service("userService")
public class UserServiceImpl implements UserService
{
	@Value("要开始访问dao了")//<property name="name" value="要开始访问dao了"/>
	private String name;

	/*@Resource*/
	@Autowired//不需要set方法
	//@Qualifier("userDaoxxx") // 指定用该类型的哪个名称的实例对象，必须和Autowired一起使用
	private UserDao userDao;

	@Override
	public void save() 
	{
		System.out.println(name);
		// 调用dao
		userDao.save();
		
	}

	// 初始化方法
	@PostConstruct
	public void init()
	{
		System.out.println("userService的初始化方法....");
	}
	
	// 销毁的方法
	@PreDestroy
	public void destory()
	{
		System.out.println("userService的销毁方法....");
	}
		

}
