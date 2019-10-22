import com.xiaojihua.domain.Customer;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDemo {

    /**
     * 保存操作
     * @throws SQLException
     */
    @Test// 使用hibernate提供的api来操作
    public void test1() throws SQLException {
        // 加载数据库的核心配置文件 (引入映射文件)
        Configuration configuration = new Configuration();
        configuration.configure();
        // 手动加载映射文件，当在核心配置文件中没有配置映射文件的时候可以通过这个来加载
        //configuration.addResource("cn/itcast/domain/Customer.hbm.xml");
        // 获取sessionFactory  session工厂
        SessionFactory sf = configuration.buildSessionFactory();
        // 获取session  相当于connection
        Session session = sf.openSession();
        // 开启事务 (小细节:hibernate对增删改一条sql语句 都得开事务手动提交一次)
        Transaction tx = session.beginTransaction();
        // 操作 (存一条数据到cst_customer)
        Customer customer = new Customer();
        customer.setCust_name("rose");
        // 执行完毕 会有返回值 这个返回值就是数据库保存成功一条数据的id主键值
        // Serializable : 数值类型和String类型都实现过
        //Serializable l1=1234L;
        //Serializable l2="abcd";
        // 多态
        Serializable id = session.save(customer);
        System.out.println(id);
        //提交
        tx.commit();
        //关闭链接
        session.close();
        //关闭连接池
        sf.close();

    }

    /**
     * 查询
     */
    @Test
    public void test2(){
        //加载核心配置文件
        Configuration configuration = new Configuration().configure();
        //获取sessionFactory
        SessionFactory sf = configuration.buildSessionFactory();
        //获取session
        Session session = sf.openSession();
        //开启事物
        Transaction tx = session.beginTransaction();
        //操作
        //get方式 主键查询  hibernate会自动生成sql语句
        Customer customer = session.get(Customer.class, 1L);
        System.out.println(customer.getCust_name());
        //load方式
        /*Customer customer = session.load(Customer.class, 1L);
        System.out.println(customer.getCust_name());*/

        /*get查询和load查询的区别: 都是根据id主键查询  面试题
         * 	     核心点:
         * 	      get查询是立即查询   只要查询就立马发送sql语句获取所有数据
         * 	      load是延迟查询       查询时候不会立马发送sql语句去查  当使用到这些数据的时候才会去查
         *
         *
         * 		  get查询返回的是Customer类型
         * 		  load查询返回的是Custoemr代理类型
         *
         * 		  get查询找不到返回null
         * 		  load查询找不到返回的报错信息
         *
         * */

        //提交事物
        tx.commit();
        //关闭链接
        session.close();
        //关闭连接池
        sf.close();
    }

    /**
     * 修改操作
     */
    @Test
    public void test3(){
        //加载核心配置文件
        Configuration configuration = new Configuration().configure();
        //获取SessionFactory相当与连接池
        SessionFactory sf = configuration.buildSessionFactory();
        //获取Session相当与connection
        Session session = sf.openSession();
        //开启事物
        Transaction tx = session.beginTransaction();
        //操作,修改的话是先查后改
        Customer customer = session.get(Customer.class, 1L);
        customer.setCust_name("张三");
        session.save(customer);
        //提交事物
        tx.commit();
        //关闭链接
        session.close();
        sf.close();
    }


    /**
     * 删除操作
     */
    @Test
    public void test4(){
        //使用工具类打开session
        Session session = HibernateUtils.openSession();
        //开启事物
        Transaction tx = session.beginTransaction();
        //操作,修改的话是先查后删除
        Customer customer = session.get(Customer.class, 2L);
        session.delete(customer);
        //提交事物
        tx.commit();
        //关闭链接
        session.close();

    }




}
