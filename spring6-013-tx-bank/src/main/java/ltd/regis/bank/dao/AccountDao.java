package ltd.regis.bank.dao;

import ltd.regis.bank.pojo.Account;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.dao
 * @Author: Regis
 * @CreateTime: 2023-02-05  08:09
 * @Description: 负责账户信息的CRUD操作，DAO中只执行sql语句
 * @Version: 1.0
 */

public interface AccountDao {

    /**
     * 根据账号查询账户信息
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act
     * @return
     */
    int update(Account act);

    int insert(Account act);
}
