package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.ICustomerDao;
import com.xiaojihua.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {
    @Override
    public List<Customer> findAll(){
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query<Customer> query = session.createQuery(" from Customer");
        List<Customer> list = query.list();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return list;
    }
}
