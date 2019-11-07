package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 方式一：将sessionFactory交给spring管理，并且使用特定的事物管理器进行事物管理
 *
 */
public class UserDaoImpl implements UserDao {

    //使用ioc注入
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 只是sessionFactory由spring管理
     * 但是事物还是由手工API来控制
     * @param user
     */
    //@Override
    public void save_bak(User user) {
        /*//手写hibernate api
        //加载配置文件*/
        /*Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();*/
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();

    }

    /**
     * 将sessionFactory和事物都交给spring管理
     * @param user
     */
    @Override
    public void save(User user) {
        //当将sessionFactory和事物均交给spring的时候，需要使用getCurrentSession()
        //因为HibernateTransactionManager从配置的sessionFactory中获取session
        //将获取的该session开启事务,并且将开启了事务的该session绑定到了当前线程中
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
