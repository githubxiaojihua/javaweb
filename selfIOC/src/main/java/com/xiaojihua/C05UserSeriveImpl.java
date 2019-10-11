package com.xiaojihua;

public class C05UserSeriveImpl implements C02IUserService {
    @Override
    public void save() {
        System.out.println("第三个userservice存储了1000条数据！！！");
    }
}
