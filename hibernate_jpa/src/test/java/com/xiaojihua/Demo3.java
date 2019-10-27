package com.xiaojihua;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * 级联操作
 */
public class Demo3 {

    /**
     * 普通保存
     */
    @Test
    public void test1(){
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 保存一个客户3个联系人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("大秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("中秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("小秘");

        // 双向关联(固定)
        customer.getLinkmans().add(linkman1);
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);

        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        linkman3.setCustomer(customer);

        // 保存
        em.persist(customer);
        em.persist(linkman1);
        em.persist(linkman2);
        em.persist(linkman3);

        tx.commit();
        em.close();
    }

    @Test //级联:在操作自己数据的时候 还会把自己关联的数据也操作了
    // 级联保存  保存客户同时把客户下面的联系人都保存了
    // @OneToMany(cascade=CascadeType.PERSIST)
    public void test2()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 保存一个客户3个联系人
        Customer customer = new Customer();
        customer.setCust_name("马总");

        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("大秘");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("中秘");
        Linkman linkman3 = new Linkman();
        linkman3.setLkm_name("小秘");

        // 双向关联(固定)
        customer.getLinkmans().add(linkman1);
        customer.getLinkmans().add(linkman2);
        customer.getLinkmans().add(linkman3);

        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        linkman3.setCustomer(customer);

        // 保存
        em.persist(customer);

        tx.commit();
        em.close();

    }

    @Test //普通删除--报错
    public void test3()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 删除一个客户
        Customer customer = em.find(Customer.class, 12L);
        em.remove(customer);
        tx.commit();
        em.close();
    }

    @Test // 级联删除
    //@OneToMany(targetEntity=Linkman.class,mappedBy="customer",cascade=CascadeType.ALL)
    public void test()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 删除一个客户级联下面关联的联系人
        Customer customer = em.find(Customer.class, 13L);
        em.remove(customer);
        tx.commit();
        em.close();
    }
}
