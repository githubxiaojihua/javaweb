package com.xiaojihua;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Role;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.JPAUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * 离线查询
 */
public class Demo5 {

    @Test
    public void test1(){
        // web层
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        // 接收页面操作添加条件
        dc.add(Restrictions.like("cust_name", "b%"));

        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();



        tx.commit();
        em.close();
    }


}
