package com.xiaojihua;

import com.xiaojihua.domain.Customer;
import com.xiaojihua.domain.Linkman;
import com.xiaojihua.domain.Role;
import com.xiaojihua.domain.User;
import com.xiaojihua.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * 多对多操作
 */
public class Demo4 {

    /**
     * 普通保存
     */
    @Test
    public void test1(){
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 2个用户 3个角色
        User user1 = new User();
        user1.setUser_name("jack");
        User user2 = new User();
        user2.setUser_name("rose");

        Role role1 = new Role();
        role1.setRole_name("员工");
        Role role2 = new Role();
        role2.setRole_name("班主任");
        Role role3 = new Role();
        role3.setRole_name("助教");

        // 双向关联
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);

        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);

        // 保存
        em.persist(user1);
        em.persist(user2);
        em.persist(role1);
        em.persist(role2);
        em.persist(role3);

        tx.commit();
        em.close();
    }

    @Test // 级联保存
    //@ManyToMany(targetEntity=Role.class,cascade=CascadeType.PERSIST)
    public void test2()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 2个用户 3个角色
        User user1 = new User();
        user1.setUser_name("jack");
        User user2 = new User();
        user2.setUser_name("rose");

        Role role1 = new Role();
        role1.setRole_name("员工");
        Role role2 = new Role();
        role2.setRole_name("班主任");
        Role role3 = new Role();
        role3.setRole_name("助教");

        // 双向关联
        user1.getRoles().add(role1);
        user1.getRoles().add(role2);
        user2.getRoles().add(role1);
        user2.getRoles().add(role3);

        role1.getUsers().add(user1);
        role1.getUsers().add(user2);
        role2.getUsers().add(user1);
        role3.getUsers().add(user2);

        // 保存用户的时候级联保存角色
        em.persist(user1);
        em.persist(user2);

        tx.commit();
        em.close();
    }


    @Test
    // 多对多以后操作的方向性
    // 给一个用户修改角色
    public void test3()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        // 操作 给jack用户将员工修改成助教
        // 获取jack
        User user = em.find(User.class, 13L);
        // 获取员工
        Role role1 = em.find(Role.class,21L);
        // 获取助教
        Role role3 = em.find(Role.class,23L);
        // 删除员工
        user.getRoles().remove(role1);
        // 添加助教
        user.getRoles().add(role3);
        tx.commit();
        em.close();
    }

    @Test  //普通删除，不能设置user cascate = all或者remove（包含保存和删除），普通删除即可满足所有操作，无需设置级联删除
    public void test5()
    {
        EntityManager em = JPAUtils.getEm();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        User user = em.find(User.class, 15L);
        em.remove(user);
        tx.commit();
        em.close();
    }

}
