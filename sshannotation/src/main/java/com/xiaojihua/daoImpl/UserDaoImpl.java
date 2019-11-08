package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate template;
    @Override
    public void save(User user) {

        template.save(user);
    }
}
