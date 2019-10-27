package com.xiaojihua.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static final SessionFactory sf;
    private static final Configuration config;

    static{
        config = new Configuration().configure();
        sf = config.buildSessionFactory();
    }

    // 从连接池获取的
    public static Session openSession(){
        return sf.openSession();
    }

    // 从当前线程中获取绑定的session
    // 好处: 在多层之间调用方法获取的都是同一个session
    public static Session getCurrentSession()
    {
			/*特点: 1 默认是关闭的 需要配置开启
				   2 会自动给你关闭连接*/
        Session session = sf.getCurrentSession();
        return session;
    }
}
