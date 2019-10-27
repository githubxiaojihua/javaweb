package com.xiaojihua;

import com.xiaojihua.domain.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 一对一关系操作
 * CRUD操作
 */
public class Demo {

    /**
     * 保存
     */
    @Test
    public void test1(){
        // 加载数据库信息  sessionFactory
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        // 获取连接  session
        EntityManager em = factory.createEntityManager();
        // 开启事务
        EntityTransaction transaction = em.getTransaction(); //先获取事务
        transaction.begin();// 开启事务

        Customer customer = new Customer();
        customer.setCust_name("李四1");
        // 相当于save()
        em.persist(customer);

        transaction.commit();
        em.close();
    }

    /**
     * 查询
     */
    @Test
    public void test2(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // get()方法 立即加载
//        Customer customer = entityManager.find(Customer.class, 7L);
//        System.out.println(customer.getCust_name());

        // load()方法 延迟加载
        Customer reference = entityManager.getReference(Customer.class, 7L);
        System.out.println(reference.getCust_name());

        transaction.commit();;
        entityManager.close();
    }

    /**
     * 修改
     */
    //修改
    // 测试jpa中的一级缓存 完全可以使用
    @Test
    public void test3(){
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // 先查后改
        Customer customer = entityManager.find(Customer.class, 10L);
        System.out.println(customer.getCust_name());
        customer.setCust_name("rose11112");

        // update()
        // 由于有一级缓存的存在因此可以不写这一句，这是持久态对象的一个特性（快照区，存储区，commit的时候比较，不一致的更新数据库）
//        entityManager.merge(customer);

        transaction.commit();
        entityManager.close();
    }

    @Test
    public void  test4()
    {
        // 加载持久化单元
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        // 获取连接
        EntityManager em = factory.createEntityManager();
        // 开启事务
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // 删除  先查后删
        Customer customer = em.find(Customer.class, 9L);
        // delete()
        em.remove(customer);
        // 提交
        tx.commit();
        // 关闭资源
        em.close();
    }
}
