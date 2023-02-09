package ltd.regis.bank.service.impl;

import jakarta.annotation.Resource;
import ltd.regis.bank.dao.AccountDao;
import ltd.regis.bank.pojo.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.service.impl
 * @Author: Regis
 * @CreateTime: 2023-02-07  09:15
 * @Description:
 * @Version: 1.0
 */

@Service("i1")
public class IsolationService1 {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //1号service,
    //负责查询
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void getByActno(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println("查询到的账户信息:" + account);
    }

}
