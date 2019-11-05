package com.xiaojihua.daoImpl;

import com.xiaojihua.dao.AccountDao;
import com.xiaojihua.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 *
 * 这是第一种使用jdbctemplate的方式  注入方式（set）
 */
/*public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setTemplate(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public void save() {
        String sql = "insert into account values(?,?)";
        jdbcTemplate.update(sql,"tom",1000);
    }

    @Override
    public void delete() {
        String sql="delete from account where username=?";
        jdbcTemplate.update(sql,"tom");
    }

    @Override
    public void update() {
        String sql="update account set mondy=? where username=?";
        jdbcTemplate.update(sql, 999,"rose");
    }


    *//**
     * 使用较底层的实现
     *//*
    *//*@Override
    public void findAll() {
        String sql = "select * from account";
        List<Account> accounts = jdbcTemplate.query(sql, new RowMapper<Account>() {

            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setUsername(resultSet.getString("userName"));
                account.setMoney(resultSet.getDouble("mondy"));
                return account;
            }
        });
        for(Account a : accounts){
            System.out.println(a);
        }
    }*//*

    *//**
     * 较高层次的实现
     *//*
    @Override
    public void findAll() {
        String sql = "select * from account";
        List<Account> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for(Account a : query){
            System.out.println(a);
        }
    }

    @Override
    public void findByname() {
        String sql="select * from account where username=?";
        Account account= (Account) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Account.class),"jack");
        System.out.println(account);
    }

    @Override
    public void findCount() {
        String sql="select count(*) from account";
        Long l = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println(l);

    }
}*/

/**
 * 第二种使用jdbctemplate的方式
  */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    /*继承DaoSupport
     *
     *  1 在appliactionContext.xml文件中 使用set方式注入了  但是AccountDaoImpl没有set方法
     *  2 如果自己里面没有找到 要去父类里面找 setJdbcTempalte() 找到了 注入给父类的jdbcTempalte
     *  3 父类如果有了 自己子类为什么不能用jdbcTempalte 因为父类private私有化了
     *  4 但是父类里面有一个getJdbcTempalte 相当于子类里面也有一个
     *  5 就可以在子类中使用getJdbcTempalte的方法 获取到注入好的JdbcTempalte
     * */


    @Override
    public void save() {
        String sql="insert into account values(?,?)";
        getJdbcTemplate().update(sql,"Tom",100000);
    }


    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void findByname() {

    }

    @Override
    public void findCount() {

    }
}