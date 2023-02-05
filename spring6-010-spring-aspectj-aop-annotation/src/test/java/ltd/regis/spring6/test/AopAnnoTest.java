package ltd.regis.spring6.test;

import ltd.regis.spring6.SpringConfig;
import ltd.regis.spring6.service.OrderService;
import ltd.regis.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.test
 * @Author: Regis
 * @CreateTime: 2023-02-04  10:38
 * @Description:
 * @Version: 1.0
 */

public class AopAnnoTest {

    @Test
    public void testAopAnno() throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.login();
//        userService.logout();
//        OrderService orderService = context.getBean("orderService", OrderService.class);
//        orderService.generate();
    }
}
