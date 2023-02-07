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
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    //控制事务
    @Override
//    @Transactional
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
        withdraw();
    }


    @Transactional(propagation = Propagation.NESTED)
    public void withdraw() {
        /*
        Propagation.REQUIRED:默认选择该事务，原来没有事务就新建事务，原来有事务就加入
        Propagation.SUPPORTS：原来有就加入，原来没有就不管了
        Propagation.MANDATORY：有就加入，没有就抛异常
        Propagation.REQUIRES_NEW:不管有没有，直接开启新事务，原事务被挂起（非嵌套）
        Propagation.NOT_SUPPORTED：若存在事务则挂起事务，来执行当前代码
        Propagation.NEVER：若存在事务就抛异常
        Propagation.NESTED：执行嵌套的事务，嵌套的事务可以独立提交和回滚，若原来没有事务则等同于Propagation.REQUIRED
         */
    }


    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {

        int insert = accountDao.insert(act);

        Account act2 = new Account("act-004", 1000.00);
        try {
            accountService.save(act2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
























}
