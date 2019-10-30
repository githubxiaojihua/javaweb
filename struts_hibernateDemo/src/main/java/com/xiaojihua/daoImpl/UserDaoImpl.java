package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.IUserDao;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDaoImpl implements IUserDao {
    @Override
    public User login(User user) {
        Session currentSession = HibernateUtils.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();
        Query query = currentSession.createQuery("from User where user_name=?1 and user_password=?2");
        query.setParameter(1,user.getUser_name());
        query.setParameter(2,user.getUser_password());
        User findUser = (User)query.uniqueResult();
        transaction.commit();

        return findUser;
    }
}
