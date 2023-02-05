package ltd.regis.spring6.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vip {
    public Vip() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        DefaultListableBeanFactory factory = context.getBean("factory", DefaultListableBeanFactory.class);
//        从spring容器中获取
        Object studentBean = factory.getBean("studentBean");
    }
}
