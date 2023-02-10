package ltd.regis.bank.service;

import ltd.regis.bank.pojo.Account;

import java.util.List;

public interface AccountService {

    int save(Account act);

    int dropByActno(String actno);

    int modify(Account act);

    Account getAccount(String actno);

    List<Account> getAccounts();

    void transfer(String fromAct, String toAct, double money);
}
