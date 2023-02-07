package ltd.regis.bank.service.impl;

import jakarta.annotation.Resource;
import ltd.regis.bank.dao.AccountDao;
import ltd.regis.bank.pojo.Account;
import ltd.regis.bank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.service.impl
 * @Author: Regis
 * @CreateTime: 2023-02-06  08:15
 * @Description:
 * @Version: 1.0
 */

@Service("accountService2")
public class AccountSeriveImpl2 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Account act) {
        int insert = accountDao.insert(act);
        System.out.println("service2成功insert了"+insert+"条语句");
        String s = null;
        s.toString();
    }
}
