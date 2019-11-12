package com.xiaojihua.service;

import com.xiaojihua.domain.BaseDict;
import com.xiaojihua.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<BaseDict> findCode(String code);
    List<Customer> find();
    List<Customer> conditionFind(DetachedCriteria dc);
    Customer findById(Integer id);
    void update(Customer customer);
    void delete(Customer customer);
}
