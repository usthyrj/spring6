package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.test
 * @Author: Regis
 * @CreateTime: 2023-02-09  09:21
 * @Description:
 * @Version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringJunit4Test {

    @Autowired
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
    }

    @Test
    public void testUser2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testUser3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
