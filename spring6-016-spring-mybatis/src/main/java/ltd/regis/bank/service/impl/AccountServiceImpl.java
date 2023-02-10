package ltd.regis.bank.service.impl;

import jakarta.annotation.Resource;
import ltd.regis.bank.mapper.AccountMapper;
import ltd.regis.bank.pojo.Account;
import ltd.regis.bank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.service.impl
 * @Author: Regis
 * @CreateTime: 2023-02-09  10:37
 * @Description:
 * @Version: 1.0
 */
@Transactional
@Service
public class AccountServiceImpl implements AccountService {


    @Resource
    private AccountMapper accountMapper;

    @Override
    public int save(Account act) {
        return accountMapper.insert(act);
    }

    @Override
    public int dropByActno(String actno) {
        return accountMapper.deleteByActno(actno);
    }

    @Override
    public int modify(Account act) {
        return accountMapper.update(act);
    }

    @Override
    public Account getAccount(String actno) {
        return accountMapper.selectByActno(actno);
    }

    @Override
    public List<Account> getAccounts() {
        return accountMapper.selectAll();
    }

    @Override
    public void transfer(String fromAct, String toAct, double money) {

        Account from = accountMapper.selectByActno(fromAct);
        Account to = accountMapper.selectByActno(toAct);
        if (from.getBalance() < money) throw new RuntimeException("金钱不足");
        if(to == null) throw new RuntimeException("对方账户不存在");
        from.setBalance(from.getBalance() - money);
        to.setBalance(to.getBalance() + money);
        int count = accountMapper.update(from);
        count += accountMapper.update(to);
        String s = null;
        s.toString();
        assert count == 2;
    }
}
