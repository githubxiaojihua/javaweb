import com.xiaojihua.domain.Customer;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;
import java.sql.SQLException;

public class CustomerDemoDay02 {

    // 演示持久类被final修饰
    // 现象: hibernate的延迟加载优化手段会失效   延迟加载会变成立即加载
    @Test
    public void test1()
    {
        // 获取连接
        Session session = HibernateUtils.openSession();
        // 开启事务
        Transaction tx = session.beginTransaction();
        // 操作 (主键查询)
        //  load查询返回的是Custoemr代理类型 而这个代理类型是Customer的子类产生的
        // 如果你将Customer类用final修饰了 Customer就不能有子类了
        // 导致load查询返回的是Custoemr代理类型就没发生成
        Customer customer = session.load(Customer.class, 3L);
        System.out.println(customer.getCust_name());
        // 测试代理类型的父类是不是Customer
        System.out.println(customer.getClass().getSuperclass());
        //提交事务
        tx.commit();
        // 关闭
        session.close();
    }

    // 持久化类的3中状态
    @Test
    public void test2()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 瞬时态
        Customer customer = new Customer(); // oid属性没有值  session没有管理

        customer.setCust_name("abcd");

        // 持久态
        session.save(customer); // oid属性被生成策略(uuid)设置了 而且也被session管理

        tx.commit();
        session.close();

        // 脱管态 (离线态)
        System.out.println(customer.getCust_id()); //有oid属性值  没有被session操作管理
    }

    // 持久态对象的特点: 如果持久态对象修改完属性,不需要执行更新操作,会自动更新数据库数据
    @Test
    public void test3()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 先获取持久态对象: 只要涉及到查询返回的就都是持久化类的持久态对象
        Customer customer = session.get(Customer.class,3L);
        customer.setCust_name("hhhhhhhhhhhhhvvvvvvvvv");

        /*	session.update(customer);*/

        tx.commit();
        session.close();
    }


    // 一级缓存的存在
    @Test
    public void test4()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 保存  不止保存在数据库一份 还放在一级缓存中一份
        Customer customer = new Customer();
        customer.setCust_name("jjjjjjjjj");
        Serializable sl = session.save(customer);
        tx.commit();

        // 查询 先去一级缓存中查 查到了直接返回 差不到再去数据库
        Customer customer2 = session.get(Customer.class, sl);
        System.out.println(customer2.getCust_name());
        session.close();
    }

    @Test
    public void test5()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 查询 先去一级缓存中查 查不到再去数据库查 而且还会放在一级缓存中把
        Customer customer1 = session.get(Customer.class, 3L);
        System.out.println(customer1.getCust_name());

        //session.clear();
        session.evict(customer1);

        // 查询 先去一级缓存中查 查不到再去数据库查 而且还会放在一级缓存中把
        Customer customer2 = session.get(Customer.class, 3L);
        System.out.println(customer2.getCust_name());
        tx.commit();
        session.close();
    }

    /*结论:
     *  session在保存数据到数据库的时候 确实会将保存数据库的数据放在一级缓存中一份
     *
     *  session在做查询的时候,会先去一级缓存中查,查到了会直接返回 查不到再去数据库查询  而且查完后会放在一级缓存中一份
     *
     *  session只要已关闭 一级缓存就销毁
     *
     */


}
