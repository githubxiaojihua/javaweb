package com.xiaojihua.serviceImpl;

import com.xiaojihua.dao.TransferDao;
import com.xiaojihua.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferService")
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferDao dao;


    /**
     * Transactional注解就可以替代以下代码
     * <tx:advice transaction-manager="transactionManager" id="txAdvice">
     *         <tx:attributes>
     *
     *             <tx:method name="tranfer*" read-only="false" isolation="REPEATABLE_READ" timeout="-1"/>
     *         </tx:attributes>
     *  </tx:advice>
     *
     *  <aop:config>
     *
     *         <aop:pointcut id="pointcut1" expression="execution(* com.xiaojihua.serviceImpl.TransferServiceImpl.tranfer(..))"></aop:pointcut>
     *         <aop:advisor advice-ref="txAdvice" pointcut-ref="pointcut1"/>
     *  </aop:config>
     *  也可以设置相关的隔离级别，超时时间等参数
     * @param toUser
     * @param inUser
     * @param money
     */
    @Transactional
    @Override
    public void tranfer(String toUser, String inUser, double money) {
        // 减钱
        dao.toMoney(toUser,money);
        int i=1/0;
        // 加钱
        dao.inMoney(inUser,money);
    }
}
