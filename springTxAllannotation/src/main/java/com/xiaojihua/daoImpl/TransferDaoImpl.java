package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.TransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("transferDao")
public class TransferDaoImpl implements TransferDao {
    @Autowired
    private JdbcTemplate template;

    @Override
    public void toMoney(String toUser, double money) {
        String sql = "update account set mondy=mondy-? where username=?";
        template.update(sql,money,toUser);
    }

    @Override
    public void inMoney(String inUser, double money) {
        String sql="update account set mondy=mondy+? where username=?";
        template.update(sql, money,inUser);
    }
}
