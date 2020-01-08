package com.xiaojihua.demo;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.domain.Role;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 多对多的操作
 */
public class Dome2 {


    /**
     * 普通的保存操作，默认是会出错的，因为双方都维护了外键，
     * 在插入的时候会出现问题
     * 解决方式就是被动的一方放弃外键维护(这里被动的一方是Role)在role中的set上设置
     * <set name="users" table="sys_user_role" inverse="true">
     */
    @Test
    public void test1(){
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 保存2个用户 3个角色

        // 创建了2个用户
        User user1 = new User();      // 1
        user1.setUser_name("jack");
        User user2 = new User();     //  2
        user2.setUser_name("rose");

        // 创建3个角色
        Role role1= new Role();      // 1
        role1.setRole_name("员工");
        Role role2= new Role();     //  2
        role2.setRole_name("班主任");
        Role role3= new Role();    //  3
        role3.setRole_name("助教");

        // 让用户1关联角色
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        // 让用户2关联角色
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);

        // 让角色关联用户
        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);

        // 保存用户
        session.save(user1);  // 1-1
        session.save(user2);
        // 保存角色
        session.save(role1);  // 1-1
        session.save(role2);
        session.save(role3);

        tx.commit();
        session.close();
    }

    @Test //级联操作
    // 保存用户的时候级联保存角色的数据
    public void test2()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 保存2个用户 3个角色

        // 创建了2个用户
        User user1 = new User();      // 1
        user1.setUser_name("jack");
        User user2 = new User();     //  2
        user2.setUser_name("rose");

        // 创建3个角色
        Role role1= new Role();      // 1
        role1.setRole_name("员工");
        Role role2= new Role();     //  2
        role2.setRole_name("班主任");
        Role role3= new Role();    //  3
        role3.setRole_name("助教");

        // 让用户1关联角色
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        // 让用户2关联角色
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);

        // 让角色关联用户
        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);

        // 保存用户，user的映射文件中
        //<set name="roles" table="sys_user_role" cascade="save-update">
        session.save(user1);  // 1-1
        session.save(user2);
        // 保存角色
		/*session.save(role1);
		session.save(role2);
		session.save(role3);*/

        tx.commit();
        session.close();
    }

    /**
     * 普通删除，可以完成，删除用户，同时删除在中间表的数据
     * 但是不会影响另一方的数据
     */
    @Test
    public void test3()
    {
        // 需求: 删除jack用户
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        User user = session.get(User.class, 7L);
        session.delete(user);

        tx.commit();
        session.close();

    }

    @Test  // 级联删除,不仅删除了用户，还将用户对应的角色也删除了
    public void test4()
    {
        // 需求: 级联删除rose用户
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        User user = session.get(User.class, 8L);
        session.delete(user);

        tx.commit();
        session.close();

    }

    @Test  // 多对多的其它操作
    // 给jack用户分配一个角色
    // 给rose用户删除一个角色
    // 给rose用户修改一个角色

    public void test5()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //给jack用户分配一个角色

        // 1先获取用户jack
        User user = session.get(User.class, 9L);
        // 2获取要分配的角色助教
        Role role = session.get(Role.class, 17L);

        // 3 给jack添加分配的角色助教
        // 配置了多对多的映射后获取user的时候会取得roles列表
        user.getRoles().add(role);


        tx.commit();
        session.close();
    }

    @Test
    public void test6()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        //给jack用户删除一个角色

        // 1先获取用户jack
        User user = session.get(User.class, 9L);
        // 2获取要删除的角色员工
        Role role = session.get(Role.class, 17L);

        // 3 给jack删除员工角色
        user.getRoles().remove(role);


        tx.commit();
        session.close();
    }

    @Test //给jack用户修改一个角色
    public void test7()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 1先获取用户jack
        User user = session.get(User.class, 9L);
        // 2在获取到助教角色
        Role role1 = session.get(Role.class, 15L);
        // 3在获取员工角色
        Role role2 = session.get(Role.class, 17L);

        // 4 先删除jack的助教角色 再添加员工角色
        user.getRoles().remove(role1);
        user.getRoles().add(role2);

        tx.commit();
        session.close();
    }

}
