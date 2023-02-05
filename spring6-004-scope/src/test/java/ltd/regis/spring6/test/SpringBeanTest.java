package ltd.regis.spring6.test;

import ltd.regis.spring6.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanTest {

    @Test
    public void testThreadScope() {
        ApplicationContext context =  new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = context.getBean("sb", SpringBean.class);
        System.out.println(sb);
        SpringBean sb1 = context.getBean("sb", SpringBean.class);
        System.out.println(sb1);

//        启动一个新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpringBean sb2 = context.getBean("sb", SpringBean.class);
                System.out.println(sb2);
                SpringBean sb3 = context.getBean("sb", SpringBean.class);
                System.out.println(sb3);
            }
        }).start();
    }

    @Test
    public void testBeanScope() {
        /*
         *默认单例模式，在 new ClassPathXmlApplicationContext时创建对象
         * scope="prototype"时多例模式，在getbean时创建对象
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean sb = context.getBean("sb", SpringBean.class);
//        sb.setName("xxx");
//        System.out.println(sb + " " + sb.getName());
        SpringBean sb1 = context.getBean("sb", SpringBean.class);
//        System.out.println(sb1 + " " + sb1.getName());
    }
}
