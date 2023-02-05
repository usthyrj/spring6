package ltd.regis.spring6.aoptx.test;

import ltd.regis.spring6.biz.UserService;
import ltd.regis.spring6.biz.VipService;
import ltd.regis.spring6.config.SpringConfig;
import ltd.regis.spring6.service.AccountService;
import ltd.regis.spring6.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.aoptx.test
 * @Author: Regis
 * @CreateTime: 2023-02-04  16:43
 * @Description:
 * @Version: 1.0
 */

public class AopTest {

    @Test
    public void testBiz() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        VipService vipService = context.getBean("vipService", VipService.class);
        userService.saveUser();
        userService.updateUser();
        vipService.deleteUser();
        vipService.saveUser();
    }

    @Test
    public void testTx() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = context.getBean("accountService", AccountService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
        accountService.transfer();
        orderService.cancel();
        accountService.withdraw();
    }
}
