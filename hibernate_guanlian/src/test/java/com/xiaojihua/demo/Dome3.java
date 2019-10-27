package com.xiaojihua.demo;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.domain.Role;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

// 对象导航查询: 在hibernate玩查询 会把对象的数据查出来 还会看对象中是否有集合或别的对象
// 			     如果有一起全部查询出来
public class Dome3 {


    /**
     *  配置了映射关系后默认就是对象导航查询，也就是在查询customer的时候
     *  会将linkmans也查询出来。
     *
     *  但是默认是延迟加载的，就像load，在真正使用的时候才会发送SQL语句
     *  对应到本例：当get customer的时候会立即发送查询customerde 语句
     *  但是并不会立即发送查询linkman的sql,
     *  当在customer映射文件中配置如下信息的时候就会立即查询
     *  <set name="linkmans" inverse="true" cascade="save-update,delete" lazy="false">
     *  主要作用是，当查询出的customer需要传递给其他人的时候，就需要立即加载
     *  这样传给其他人的时候别人也能获取到联系人
     *
     */
    @Test
    public void test1(){
        // 1  查询客户下面所有的联系人数量
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = session.get(Customer.class, 7L);
        System.out.println(customer.getLinkmans().size());
        tx.commit();
        session.close();
    }

    @Test
    public void test2()
    {
        //2 查询当前联系人的所属客户名字?
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Linkman linkman = session.get(Linkman.class, 15L);
        System.out.println(linkman.getCustomer().getCust_name());
        tx.commit();
        session.close();
    }



}
