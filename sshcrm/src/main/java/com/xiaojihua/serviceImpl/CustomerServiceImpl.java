package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.CustomerDao;
import com.xiaojihua.domain.BaseDict;
import com.xiaojihua.domain.Customer;
import com.xiaojihua.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao dao;

    @Override
    @Transactional
    public void save(Customer customer) {
        dao.save(customer);
    }

    @Override
    public List<BaseDict> findCode(String code) {
        return dao.findCode(code);
    }

    @Override
    public List<Customer> find() {
        return dao.find();
    }

    @Override
    public List<Customer> conditionFind(DetachedCriteria dc) {
        return dao.conditionFind(dc);
    }

    @Override
    public Customer findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        dao.update(customer);
    }

    @Override
    @Transactional
    public void delete(Customer customer) {
        dao.delete(customer);
    }
}
