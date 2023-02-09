package ltd.regis.bank.service.impl;

import jakarta.annotation.Resource;
import ltd.regis.bank.dao.AccountDao;
import ltd.regis.bank.pojo.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.service.impl
 * @Author: Regis
 * @CreateTime: 2023-02-07  09:17
 * @Description:
 * @Version: 1.0
 */

@Service("i2")
public class IsolationService2 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //2号service1
    //负责插入
//    @Transactional(timeout = 10)
//    @Transactional(rollbackFor = RuntimeException.class)
    @Transactional(noRollbackFor = NullPointerException.class)
    public void save(Account account) throws IOException {
        /*try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        int insert = accountDao.insert(account);
        //模拟异常
        String s = null;
        s.toString();
    }

    
}
