import com.xiaojihua.domain.Customer;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * QBC查询以及离线查询
 */
public class CustomerDemoQBC {
    // Criteria方式 :  如果是使用这种方式做查询,又被称作为QBC查询
    // 特点: 完全面相对象
    //全查
    @Test
    public void test1(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> list = criteria.list();
        for(Customer c : list){
            System.out.println(c);
        }
        transaction.commit();
    }

    //条件差
    @Test
    public void test2(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        //设置条件，条件的设置，有like ,lg，其他可以查询hibernate第二天讲义
        criteria.add(Restrictions.like("cust_name","h%"));
        List<Customer> list = criteria.list();
        for(Customer c : list){
            System.out.println(c);
        }
        transaction.commit();
    }

    //分页查
    @Test
    public void test3(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        //设置limit的值
        criteria.setFirstResult(0);
        criteria.setMaxResults(3);
        List<Customer> list = criteria.list();
        for(Customer c : list){
            System.out.println(c);
        }
        transaction.commit();
    }

    //排序查
    @Test
    public void test4(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        //设置排序
        criteria.addOrder(Order.desc("cust_id"));
        List<Customer> list = criteria.list();
        for(Customer c : list){
            System.out.println(c);
        }
        transaction.commit();
    }

    //聚合查
    @Test
    public void test5(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        //设置聚合
        criteria.setProjection(Projections.avg("cust_id"));
        Object obj = criteria.uniqueResult();
        System.out.println(obj);
        transaction.commit();
    }

    //单例查询或者多列查询
    @Test
    public void test6(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        //设置列
        ProjectionList list = Projections.projectionList();
        list.add(Projections.property("cust_id"));
        list.add(Projections.property("cust_name"));
        criteria.setProjection(list);
        //返回的是Object数组
        List<Object[]> list1 = criteria.list();
        for(Object[] c : list1){
            System.out.println(Arrays.toString(c));
        }

        transaction.commit();
    }

    //离线查询

    /**
     * 所谓的离线就是脱离session管理的Critia对象
     * 默认的Critia对象都是通过session创建的，使用离线Criteria可以在web
     * 层没有session的情况先先组装critia对象，然后经过web和service层的
     * 各种业务逻辑判断，最后传到dao层的时候再转换成在线Criteria
     * 也就是交给session管理，这时候才可以执行相关查询操作比如list
     */
    @Test
    public void test7(){
        // web层
        DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
        // 接收页面操作添加条件
        dc.add(Restrictions.like("cust_name","h%"));
        /*service.find(dc);*/

        // service
        /*	dao.find(dc);*/

        // dao层
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //离线转在线  (给session管理)
        Criteria executableCriteria = dc.getExecutableCriteria(session);
        List<Customer> list = executableCriteria.list();
        for(Customer c: list){
            System.out.println(c);
        }
        transaction.commit();
    }


}
