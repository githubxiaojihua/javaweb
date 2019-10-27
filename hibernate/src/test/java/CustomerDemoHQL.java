import com.xiaojihua.domain.Customer;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CustomerDemoHQL {

    // oid查询
    @Test
    public void test1()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        Customer customser = session.get(Customer.class, 3L);
        System.out.println(customser);

        tx.commit();
        session.close();

        // 只有增删改 一级oid查询 才会自动生成sql语句
    }

    @Test
    public void test2()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 全查   类似sql语句的表达式  from 持久化类
        Query qr = session.createQuery("from Customer");
        List<Customer> list = qr.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        session.close();

    }


    @Test
    public void test3()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 条件查   类似sql语句的表达式  from 持久化类  where 属性=?
        // 这里用的hibernate版本对于like 后面的？不在支持了，而是改成了?1、？2的形式
        // 后面跟的数字是参数的索引，在setParameter的时候指定
        Query qr = session.createQuery("from Customer where cust_name like ?2");
        qr.setParameter(2, "h%");
        List<Customer> list = qr.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test4()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 分页查   类似sql语句的表达式  from 持久化类  where 属性=?
        Query qr = session.createQuery("from Customer");
        // from Customer limit 1,3;
        qr.setFirstResult(1);
        qr.setMaxResults(3);

        List<Customer> list = qr.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test5()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 单列查  返回是Object
        Query qr = session.createQuery("select cust_id from Customer");
        List<Object> list = qr.list();
        for (Object object : list) {
            System.out.println(object);
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test6()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 多列查 返回的是Object数组
        Query qr = session.createQuery("select cust_id,cust_name from Customer");
        List<Object[]> list = qr.list();
        for (Object[] object : list) {
            System.out.println(Arrays.toString(object));
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test7()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 投影查询
        // 1 查多少字段 就需要在持久化类中写多少个构造参数
        // 2 语法的书写: select new Customer(cust_id,cust_name) from Customer;
        Query qr = session.createQuery("select new Customer(cust_id,cust_name) from Customer");
        List<Customer> list = qr.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test8()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        // 排序查
        Query qr = session.createQuery("from Customer order by cust_id asc");
        List<Customer> list = qr.list();
        for (Customer customer : list) {
            System.out.println(customer);
        }
        tx.commit();
        session.close();
    }

    @Test
    public void test9()
    {
        Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();
        // 聚合查
        Query qr = session.createQuery("select count(*) from Customer");
        Object obj = qr.uniqueResult();
        System.out.println(obj);
        tx.commit();
        session.close();
    }


    // 从当前线程种获取session使用
    @Test
    public void test10()
    {
        // 从当前线程中获取绑定的session
        // 好处: 那一层调用这个方法 获取的都是同一个session
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("下课");
        session.save(customer);
        tx.commit();
        //session.close();
    }


}
