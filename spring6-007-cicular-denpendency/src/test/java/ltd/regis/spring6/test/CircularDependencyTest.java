package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.Husband;
import ltd.regis.spring6.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {

    @Test
    public void testCD2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring2.xml");
        Husband husbandBean = context.getBean("husbandBean2", Husband.class);
        Wife wifeBean = context.getBean("wifeBean2", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }

    @Test
    public void testCD() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = context.getBean("husbandBean", Husband.class);
        Wife wifeBean = context.getBean("wifeBean", Wife.class);
        System.out.println(husbandBean);
        System.out.println(wifeBean);
    }
}
