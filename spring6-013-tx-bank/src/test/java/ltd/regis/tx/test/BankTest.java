package ltd.regis.tx.test;

import ltd.regis.bank.config.SpringConfig;
import ltd.regis.bank.pojo.Account;
import ltd.regis.bank.service.AccountService;
import ltd.regis.bank.service.impl.AccountServiceImpl;
import ltd.regis.bank.service.impl.IsolationService1;
import ltd.regis.bank.service.impl.IsolationService2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.tx.test
 * @Author: Regis
 * @CreateTime: 2023-02-05  08:47
 * @Description:
 * @Version: 1.0
 */

public class BankTest {

    @Test
    public void testIsolation2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IsolationService1 is1 = context.getBean("i1", IsolationService1.class);
        is1.getByActno("act-004");
    }

    @Test
    public void testIsolation1() throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IsolationService2 accountService = context.getBean("i2", IsolationService2.class);
        Account act = new Account("act-004" ,1000.00);
        accountService.save(act);
    }

    @Test
    public void testPropagation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        Account act = new Account("act-003", 1000.00);
        accountService.save(act);
    }

    @Test
    public void testException() {

    }

    @Test
    public void testBank() {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.transfer("act-001", "act-002", 100);

    }
}
