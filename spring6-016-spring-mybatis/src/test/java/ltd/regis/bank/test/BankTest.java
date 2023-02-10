package ltd.regis.bank.test;

import ltd.regis.bank.pojo.Account;
import ltd.regis.bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.bank.test
 * @Author: Regis
 * @CreateTime: 2023-02-09  11:30
 * @Description:
 * @Version: 1.0
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:spring.xml"})
public class BankTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testBank() {
        Account account = accountService.getAccount("act-001");
        System.out.println(account);
        Account act = new Account("act-002", 0.0);
//        accountService.save(act);
//        accountService.dropByActno("act-003");
//        accountService.modify(act);
        accountService.transfer("act-001", "act-002", 1000);
    }
}
