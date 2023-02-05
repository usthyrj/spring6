package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.*;
import ltd.regis.spring6.jdbc.MyDataSource;
import ltd.regis.spring6.jdbc.MyDataSource1;
import ltd.regis.spring6.jdbc.MyDataSource2;
import ltd.regis.spring6.service.CustomerService;
import ltd.regis.spring6.service.OrderService;
import ltd.regis.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SpringDITest {
    public static void main(String[] args) {
        System.out.println(new Date());
    }

    @Test
    public void testProperties() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource dataSource = context.getBean("dataSource", MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testAutowire() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.generate();
        System.out.println(orderService);
        CustomerService cs = context.getBean("cs", CustomerService.class);
        cs.save();
    }

    @Test
    public void testUtil() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource1 ds1 = context.getBean("ds1", MyDataSource1.class);
        MyDataSource2 ds2 = context.getBean("ds2", MyDataSource2.class);
        System.out.println(ds1);
        System.out.println(ds2);
    }

    @Test
    public void testC() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-c.xml");
        People people = context.getBean("peopleBean", People.class);
        System.out.println(people);
    }

    @Test
    public void testP() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dog = context.getBean("dogBean", Dog.class);
        System.out.println(dog);
    }

    @Test
    public void testSpecial() {
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = context.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    @Test
    public void testCat() {
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        Cat cat = context.getBean("catBean", Cat.class);
        System.out.println(cat);
        System.out.println(cat.getName() == null);
    }

    @Test
    public void testCollection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person person = context.getBean("personBean", Person.class);
        System.out.println(person);

    }

    @Test
    public void testArray() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-array.xml");
        YuQian yuQian = context.getBean("yuQian", YuQian.class);
        System.out.println(yuQian);

    }

    @Test
    public void testCascade() {
        ApplicationContext context = new ClassPathXmlApplicationContext("cascade.xml");
        Student studentBean = context.getBean("studentBean", Student.class);
        Clazz clazzBean = context.getBean("clazzBean", Clazz.class);
        System.out.println(studentBean);
        System.out.println(clazzBean);

    }

    @Test
    public void testMyDataSource() {
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    public void testSimpleType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        User userBean = context.getBean("userBean", User.class);
        System.out.println(userBean);
        SimpleValueType svt = context.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }

    @Test
    public void testSetDI2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderServiceBean = context.getBean("orderServiceBean", OrderService.class);
        OrderService orderServiceBean2 = context.getBean("orderServiceBean2", OrderService.class);
        System.out.println(orderServiceBean);
        System.out.println(orderServiceBean2);
        orderServiceBean2.generate();
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService csBean = context.getBean("csBean", CustomerService.class);
        CustomerService csBean2 = context.getBean("csBean2", CustomerService.class);
        CustomerService csBean3 = context.getBean("csBean3", CustomerService.class);
        csBean.save();
        csBean2.save();
        csBean3.save();

    }

    @Test
    public void testSetDI() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceBean = context.getBean("userServiceBean", UserService.class);
        userServiceBean.saveUser();
    }
}
