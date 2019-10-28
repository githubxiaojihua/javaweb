package com.xiaojihua.service;

import com.xiaojihua.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
