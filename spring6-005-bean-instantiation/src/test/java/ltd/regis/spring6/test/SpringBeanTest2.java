package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SpringBeanTest2 {

    @Test
    public void testDate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
        Student stu = context.getBean("stu", Student.class);
        System.out.println(stu);

    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);

    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = context.getBean("gun", Gun.class);
        System.out.println(gun);

    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Star starBean = context.getBean("starBean", Star.class);
        System.out.println(starBean);

    }

    @Test
    public void testCons() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = context.getBean("sb", SpringBean.class);
        SpringBean sb2 = context.getBean("sb2", SpringBean.class);
        System.out.println(sb);
    }

}
