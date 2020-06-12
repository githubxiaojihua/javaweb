package com.xiaojihua.demo;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 一对多查询
 */
public class Dome1 {

    /**
     * 1、通过hibernate自动创建表，但是自动创建的表的energin不是innodb
     * 无法创建外键，创建完成以后外键链接还是没建立，通常的方法还是自己建立表关系：
     * CREATE TABLE `cst_customer` (
     *   `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
     *   `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
     *   `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
     *   `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
     *   `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
     *   `cust_address` VARCHAR(128) DEFAULT NULL COMMENT '客户联系地址',
     *   `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '客户联系电话',
     *   PRIMARY KEY (`cust_id`)
     * ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
     *
     * CREATE TABLE `cst_linkman` (
     *   `lkm_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '联系人编号(主键)',
     *   `lkm_name` VARCHAR(16) DEFAULT NULL COMMENT '联系人姓名',
     *   `lkm_gender` CHAR(1) DEFAULT NULL COMMENT '联系人性别',
     *   `lkm_phone` VARCHAR(16) DEFAULT NULL COMMENT '联系人办公电话',
     *   `lkm_mobile` VARCHAR(16) DEFAULT NULL COMMENT '联系人手机',
     *   `lkm_email` VARCHAR(64) DEFAULT NULL COMMENT '联系人邮箱',
     *   `lkm_position` VARCHAR(16) DEFAULT NULL COMMENT '联系人职位',
     *   `lkm_memo` VARCHAR(512) DEFAULT NULL COMMENT '联系人备注',
     *   PRIMARY KEY (`lkm_id`)
     * ) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
     *
     * ALTER TABLE cst_linkman ADD COLUMN wj_id BIGINT(32);
     * ALTER TABLE cst_linkman ADD CONSTRAINT wj_id FOREIGN KEY (wj_id) REFERENCES cst_customer(cust_id)
     */
    @Test
    public void test1(){
        Session session = HibernateUtils.getCurrentSession();
        //开启事物
        Transaction tx = session.beginTransaction();

        //操作
        Customer customer = new Customer();
        customer.setCust_name("马总222");

        Linkman  linkman = new Linkman();
        linkman.setLkm_name("小秘222");

        customer.getLinkmans().add(linkman);
        linkman.setCustomer(customer);

        //保存
        /**
         * 默认情况下会产生三条语句，一条保存customer
         * 一条保存linkman，还有一条是更新linkman的外键
         * 主要原因是双方都维护了外键信息，解决方案是
         * 让一的一方放弃外键的维护
         * <set name="linkmans" inverse="true">
         */
        session.save(customer);
        session.save(linkman);
        //提交事物
        tx.commit();
    }

    @Test//级联保存
    public void test2(){
        Session session = HibernateUtils.getCurrentSession();
        //开启事物
        Transaction tx = session.beginTransaction();

        // 操作  保存一个客户和3个联系人
        // 创建一个客户人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        // 创建一个联系人
        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("小秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("大秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("中秘");

        // 让客户关联联系人
        customer.getLinkmans().add(linkman1);
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);
        // 让联系人关联客户
        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        linkman3.setCustomer(customer);

        // 保存 (保存一的一方把多的一方的数据也给保存了  掌握)
        //<set name="linkmans" inverse="true" cascade="save-update">
        session.save(customer);

        // (保存多的一方把一的一方的数据也给保存了  演示下)
        /*session.save(linkman1);
        session.save(linkman2);
        session.save(linkman3);*/

        //提交事物
        tx.commit();
        //关闭链接 currentSession会自动关闭session因此不需要close方法
    }

    @Test // 级联高级应用
    // 双方都做了级联
    public void test3()
    {
        // 需求:有一个客户 和3个联系人
        // 让联系人1关联客户
        // 让客户关联联系人2和3
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();


        Customer customer = new Customer();
        customer.setCust_name("马总");

        // 创建一个联系人
        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("小秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("大秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("中秘");

        // 联系人1关联客户
        linkman1.setCustomer(customer);

        // 客户关联联系人2和3
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);

        // 级联保存联系人1
        //session.save(linkman1); // 问:发送几条sql语句?  1+1+1+1=4

        //session.save(customer); // 问:发送几条sql语句? 1+1+1=3

        // session.save(linkman2); // 问:发送几条sql语句? 1
        session.save(linkman3); // 问:发送几条sql语句? 1
        tx.commit();
        session.close();

    }

    @Test  // 普通删除
    // 客户下面还有关联的联系人  删不了
    public void test4()
    {
        // 删除马总
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 操作
        Customer customer = session.get(Customer.class,5L);
        session.delete(customer);
        tx.commit();
        session.close();
    }

    @Test  // 级联删除
    // 删除谁  在谁身上设置级联
    // <set name="linkmans" cascade="save-update,delete">
    public void test5()
    {
        // 删除马总
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 删除1的时候,把下面关联的多的数据全都给删除(掌握)
        Customer customer = session.get(Customer.class,1L);
        session.delete(customer);
        tx.commit();
        session.close();
    }

    @Test  // 演示下级联删除-删除多的一方，一的一方也删除，由于一的一方设置了级联删除，因此所有数据都删除
    public void test6()
    {
        // 删除联系人
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        Linkman linkman = session.get(Linkman.class,12L);
        // 根据多的一方删除一的一方的数据(级联删除)
        session.delete(linkman);
        tx.commit();
        session.close();
    }
}
