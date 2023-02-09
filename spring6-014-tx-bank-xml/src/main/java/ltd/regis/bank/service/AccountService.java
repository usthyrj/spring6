package ltd.regis.bank.service;

import ltd.regis.bank.pojo.Account;

public interface AccountService {

    /**
     * 转账业务方法
     * @param fromActno 从这个账户转出
     * @param toActno 转到这个账户
     * @param money 转账金额
     */
    void transfer(String fromActno, String toActno, double money);

    Account queryOne(String actno);
}
