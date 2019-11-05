package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.TransferDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class TransferDaoImpl implements TransferDao {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

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
