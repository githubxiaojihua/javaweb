package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.CustomerDao;
import com.xiaojihua.domain.BaseDict;
import com.xiaojihua.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private HibernateTemplate template;

    @Override
    public void save(Customer customer) {
        template.save(customer);
    }

    @Override
    public List<BaseDict> findCode(String code) {
        return (List<BaseDict>)template.find("from BaseDict where dict_type_code=?",code);
    }
}
