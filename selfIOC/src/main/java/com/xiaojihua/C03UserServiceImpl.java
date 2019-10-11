package com.xiaojihua;

public class C03UserServiceImpl implements C02IUserService {
    @Override
    public void save() {
        System.out.println("第一个Service实现类存储了10条记录");
    }
}
