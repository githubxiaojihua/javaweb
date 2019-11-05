package com.xiaojihua.dao;

public interface TransferDao {
    void toMoney(String toUser, double money);

    void inMoney(String inUser, double money);
}
