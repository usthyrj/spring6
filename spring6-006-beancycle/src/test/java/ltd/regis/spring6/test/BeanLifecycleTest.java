package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.Student;
import ltd.regis.spring6.bean.User;
import ltd.regis.spring6.bean.Vip;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleTest {

    @Test
    public void testRegisterBean() {

        DefaultListableBeanFactory factory;
        // 自己new的对象
        Student student = new Student();
        System.out.println(student);

//        将自己new的对象纳入spring管理，半路上交给spring来管理
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context);
        System.out.println(context1);
        factory = context.getBean("factory", DefaultListableBeanFactory.class);
        factory.registerSingleton("studentBean", student);
//        从spring容器中获取
        Object studentBean = factory.getBean("studentBean");
        Vip vip = new Vip();
        System.out.println(studentBean);
//        不可以如下方式获取自己半路添加的bean
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Student studentBean1 = context.getBean("studentBean", Student.class);
//        System.out.println(studentBean1);
    }

    @Test
    public void testBeanLifecycleFive() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println("8. 使用bean...");
//        必须关闭spring容器才能销毁bean
        ((ClassPathXmlApplicationContext)context).close();

    }
}
