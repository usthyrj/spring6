package ltd.regis.spring6.test;

import cn.regis.Spring6Config;
import cn.regis.service.StudentService;
import com.regis.service.OrderService;
import ltd.regis.spring6.bean.Order;
import ltd.regis.spring6.bean.STudent;
import ltd.regis.spring6.bean.User;
import ltd.regis.spring6.bean.Vip;
import ltd.regis.spring6.bean3.MyDataSource;
import ltd.regis.spring6.dao.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCAnnotationTest {

    @Test
    public void testAllAnnotation() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Spring6Config.class);
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();

    }

    @Test
    public void testResourceAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testAutowiredByAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generateOrder();

    }

    @Test
    public void testDIByAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
        ltd.regis.spring6.bean3.User user = context.getBean("user", ltd.regis.spring6.bean3.User.class);
        System.out.println(user);
    }

    @Test
    public void testChoose() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-choose.xml");

    }

    @Test
    public void testBeanComponent() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = context.getBean("userBean", User.class);
        Vip vipBean = context.getBean("vipBean", Vip.class);
        Order orderBean = context.getBean("order", Order.class);
        STudent studentBean = context.getBean("STudent", STudent.class);
        System.out.println(userBean);
        System.out.println(vipBean);
        System.out.println(orderBean);
        System.out.println(studentBean);

        OrderDao orderDao = context.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);

    }
}
