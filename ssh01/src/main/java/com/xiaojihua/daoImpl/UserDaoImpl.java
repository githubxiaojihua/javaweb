package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        //手写hibernate api
        //加载配置文件
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

    }
}
