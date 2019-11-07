package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 方式一：将sessionFactory交给spring管理，并且使用特定的事物管理器进行事物管理
 *
 *       使用hibernateTemplate
 *
 */
public class UserDaoImpl implements UserDao {

    //IOC注入HibernateTemplate
    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate template) {
        this.hibernateTemplate = template;
    }

     /**
     * 将sessionFactory和事物都交给spring管理
     * @param user
     */
    @Override
    public void save(User user) {
        hibernateTemplate.save(user);
    }
}


/**
 * 方式一：将sessionFactory交给spring管理，并且使用特定的事物管理器进行事物管理
 *
 *       使用HibernateDaoSupport
 *       hibernateTemplate作为HibernateDaoSupport的属性被注入了
 *       通过getHibernateTemplate可以获取hibernateTemplate来继续使用
 *
 */
/*public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    *//**
     * 将sessionFactory和事物都交给spring管理
     * @param user
     *//*
    @Override
    public void save(User user) {
        getHibernateTemplate().save(user);
    }
}*/
