package com.xiaojihua;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 *
 * 查询操作
 */
public class Demo2 {

    /**
     * 全查
     */
    // 全查
    // JPA方式: 类似query的方式
    @Test
    public void test1(){
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 全查  from 类名 from有时会有警告可以忽略
        Query qr = em.createQuery("from Customer");
        List<Customer> list = qr.getResultList(); // 之前的list()
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        em.close();

    }

    /**
     * 条件查
     */
    @Test
    public void test2(){
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 全查  from 类名 from有时会有警告可以忽略 注意?1的格式，最新的jpa规范，u
        Query qr = em.createQuery("from Customer where cust_name like ?1");
        qr.setParameter(1,"j%");// hibernate对于占位符?是从0开始 JPA是从1开始,需要与上面的？1回应起来
        List<Customer> list = qr.getResultList(); // 之前的list()
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        em.close();
    }

    // 聚合查
    @Test
    public void test3()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query qr = em.createQuery("select count(*) from Customer");
        Object obj = qr.getSingleResult(); // uniqueResult()
        System.out.println(obj);
        tx.commit();
        em.close();
    }

    @Test
    public void test()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 分页查
        Query qr = em.createQuery("from Customer");
        qr.setFirstResult(0);
        qr.setMaxResults(3);
        List<Customer> list = qr.getResultList();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        em.close();
    }
}
