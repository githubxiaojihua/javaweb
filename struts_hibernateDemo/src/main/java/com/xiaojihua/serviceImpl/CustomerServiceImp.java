package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.ICustomerDao;
import com.xiaojihua.daoImpl.CustomerDaoImpl;
import com.xiaojihua.domain.Customer;
import com.xiaojihua.service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImp implements ICustomerService {
    @Override
    public List<Customer> findAll() {
        ICustomerDao dao = new CustomerDaoImpl();
        return dao.findAll();
    }
}
