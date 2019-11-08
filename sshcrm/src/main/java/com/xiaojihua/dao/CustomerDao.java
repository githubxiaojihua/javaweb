package com.xiaojihua.dao;

import com.xiaojihua.domain.BaseDict;
import com.xiaojihua.domain.Customer;

import java.util.List;

public interface CustomerDao {
    void save(Customer customer);
    List<BaseDict> findCode(String code);
}
