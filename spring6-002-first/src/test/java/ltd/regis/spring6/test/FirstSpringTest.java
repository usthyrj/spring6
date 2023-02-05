package ltd.regis.spring6.test;

import ltd.regis.spring6.actrion.UserAction;
import ltd.regis.spring6.bean.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {

    @Test
    public void testBeginInitBean() {
        new ClassPathXmlApplicationContext("spring.xml");
//        自己使用log4j2记录日志信息
//        1.获取日志记录器，只要是FirstSpringTest类中的代码记录日志就输出相关日志信息
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);
//        2.记录日志,与全局配置的日志级别取交集,若全局ERROR则只能输出ERROR以上级别的日志信息
        logger.info("This is info message");
        logger.debug("This is debug message");
        logger.error("This is error message");

    }

    @Test
    public void testBeanFactory() {
        //ApplicationContext接口的超级父接口是BeanFactory，Bean工厂
        //spring的IoC使用了工厂模式
        //IoC实现方式：XML解析+工厂模式+反射机制
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "beans.xml");
        //根据bean的id获取对象
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testXmlPath() {
//        FileSystemXmlApplicationContext获取文件系统任意位置的配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("C:/Users/28198/Desktop/beans.xml");
        UserAction userActionBean1 = context.getBean("userActionBean1", UserAction.class);
        System.out.println(userActionBean1);
    }

    @Test
    public void testFirstSpringCode(){
        //获取spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml", "beans.xml");
        //根据bean的id获取对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);
        Object userDaoBean = applicationContext.getBean("userDaoBean");
        Object userServiceBean = applicationContext.getBean("userServiceBean");
        //beanId不存在会报错，而不是返回null
        Object userActionBean = applicationContext.getBean("userActionBean");
        System.out.println(userDaoBean);
        System.out.println(userServiceBean);
        System.out.println(userActionBean);
        //传入字节码文件直接无需返回Object
        Date nowTime = applicationContext.getBean("nowTime", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String format = sdf.format(nowTime);
        System.out.println(format);
    }
}
