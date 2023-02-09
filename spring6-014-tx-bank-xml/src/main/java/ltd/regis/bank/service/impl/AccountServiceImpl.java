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
 * @CreateTime: 2023-02-05  08:35
 * @Description:
 * @Version: 1.0
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //控制事务
    @Override
    public void transfer(String fromActno, String toActno, double money) {
        //查询转出账户的余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money) {
            throw new RuntimeException("余额不足！");
        }
        Account toAct = accountDao.selectByActno(toActno);
        if(toAct == null) {
            throw new RuntimeException("对方账户不存在！");
        }

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int update = accountDao.update(fromAct);
        //模拟异常
        String s = null;
//        s.toString();
        int update1 = accountDao.update(toAct);
        if(update + update1 != 2) throw new RuntimeException("转账失败");

        System.out.println("转账成功");
    }

    @Override
    public Account queryOne(String actno) {
        Account account = accountDao.selectByActno(actno);
        System.out.println(account);
        Account act = new Account("act-001", 500.00);
//        accountDao.update(act);
        return account;
    }
}
