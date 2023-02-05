package ltd.regis.bank.dao.impl;

import jakarta.annotation.Resource;
import ltd.regis.bank.dao.AccountDao;
import ltd.regis.bank.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.dao.impl
 * @Author: Regis
 * @CreateTime: 2023-02-05  08:13
 * @Description:
 * @Version: 1.0
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {

        String sql = "select actno, balance from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);

        return account;
    }

    @Override
    public int update(Account act) {

        String sql = "update t_act set balance = ? where actno = ?";

        int update = jdbcTemplate.update(sql, act.getBalance(), act.getActno());


        return update;
    }
}
