package ltd.regis.bank.mapper;

import ltd.regis.bank.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.mapper
 * @Author: Regis
 * @CreateTime: 2023-02-09  10:17
 * @Description: 该接口的实现类不需要写，是通过MyBatis通过动态代理机制生成的实现类
 * @Version: 1.0
 */

@Repository
public interface AccountMapper {

    //这就是DAO, 只要编写CRUD方法即可

    /**
     * 新增账户
     * @param account
     * @return
     */
    int insert(Account account);

    /**
     * 根据账号删除账户
     * @param actno
     * @return
     */
    int deleteByActno(String actno);

    /**
     * 更新账户
     * @param account
     * @return
     */
    int update(Account account);

    /**
     * 通过账号查询账户
     * @param actno
     * @return
     */
    Account selectByActno(String actno);

    /**
     * 查询全部账户
     * @return
     */
    List<Account> selectAll();


}
