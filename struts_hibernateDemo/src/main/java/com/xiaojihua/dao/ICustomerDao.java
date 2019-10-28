package com.xiaojihua.dao;

import com.xiaojihua.domain.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDao {

    List<Customer> findAll();
}
