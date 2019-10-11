package com.xiaojihua;

public class C04UserServiceImpl implements C02IUserService {
    @Override
    public void save() {
        System.out.println("第二个service存储了100条数据");
    }
}
