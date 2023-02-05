package ltd.regis.myspring;

import ltd.regis.myspringtest.bean.User;
import ltd.regis.myspringtest.service.UserService;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    public static void main(String[] args) {
        ApplicationContext mycontext = new ClassPathXmlApplicationContext("myspring.xml");
        User user = (User) mycontext.getBean("user");
        UserService userService = (UserService) mycontext.getBean("userService");
        System.out.println(user);
        userService.insert();
    }
}
