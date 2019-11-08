package com.xiaojihua.service;

import com.xiaojihua.domain.BaseDict;
import com.xiaojihua.domain.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<BaseDict> findCode(String code);
}
