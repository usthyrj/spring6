package ltd.regis.spring6.Test;

import ltd.regis.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.Test
 * @Author: Regis
 * @CreateTime: 2023-02-04  12:18
 * @Description:
 * @Version: 1.0
 */

public class AopXMLTest {
    @Test
    public void testXMLAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.logout();
    }
}
