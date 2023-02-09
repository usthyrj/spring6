package ltd.regis.tx.bank.test;

import ltd.regis.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.tx.bank.test
 * @Author: Regis
 * @CreateTime: 2023-02-09  08:45
 * @Description:
 * @Version: 1.0
 */

public class BankXMLTest {

    @Test
    public void testxml() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.queryOne("act-001");
    }
}
