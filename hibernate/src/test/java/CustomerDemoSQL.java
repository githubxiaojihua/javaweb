import com.xiaojihua.domain.Customer;
import com.xiaojihua.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.sql.SQLQueryParser;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CustomerDemoSQL {

    // 原生SQL查询
    @Test
    public void test1()
    {
        /*Session session = HibernateUtils.openSession();
        Transaction tx = session.beginTransaction();

        String sql = "SELECT * FROM cst_customer";
        SQLQueryParser parser = new SQLQueryParser(sql);

        tx.commit();
        session.close();*/

        // 只有增删改 一级oid查询 才会自动生成sql语句
    }


}
