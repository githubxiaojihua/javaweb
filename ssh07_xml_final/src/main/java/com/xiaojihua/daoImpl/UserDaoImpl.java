package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.UserDao;
import com.xiaojihua.domain.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDaoImpl implements UserDao {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void save(User user) {
        template.save(user);
    }
}
