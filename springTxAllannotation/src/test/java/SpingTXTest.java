import com.xiaojihua.service.TransferService;
import com.xiaojihua.springConfig.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes=SpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpingTXTest {

    @Autowired
    private TransferService service;
    /**
     * 正常的转账，无事物
     * 如果不报错的话正常，报错的话
     * 就违反了数据库的一致性
     *
     * 使用注解配置了事物的时候，事物生效，去掉配置，还是如上出现一致性错误
     */
    @Test
    public void test1(){
        service.tranfer("jack", "rose", 500);
    }


}
