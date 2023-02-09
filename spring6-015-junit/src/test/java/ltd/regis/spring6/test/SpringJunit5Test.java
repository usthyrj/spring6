package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.test
 * @Author: Regis
 * @CreateTime: 2023-02-09  09:33
 * @Description:
 * @Version: 1.0
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:spring.xml"})
public class SpringJunit5Test {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }
}
