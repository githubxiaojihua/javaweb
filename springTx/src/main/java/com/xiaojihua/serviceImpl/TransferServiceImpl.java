package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.TransferDao;
import com.xiaojihua.service.TransferService;

public class TransferServiceImpl implements TransferService {
    private TransferDao dao;

    public void setDao(TransferDao dao) {
        this.dao = dao;
    }

    @Override
    public void tranfer(String toUser, String inUser, double money) {
        // 减钱
        dao.toMoney(toUser,money);
        int i=1/0;
        // 加钱
        dao.inMoney(inUser,money);
    }
}
