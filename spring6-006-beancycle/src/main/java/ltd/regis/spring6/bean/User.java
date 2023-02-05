package ltd.regis.spring6.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean五步生命周期
 * 1. 实例化
 * 2. 赋值
 * 3. 初始化--调用init方法，init()需要自己写自己配
 * 4. 使用bean
 * 5. 销毁bean 调用bean的destroy()方法，需自己写自己配
 */

public class User implements BeanNameAware, BeanFactoryAware,
        BeanClassLoaderAware, InitializingBean, DisposableBean {

    private String name;

    public void setName(String name) {
        System.out.println("2. 给对象属性赋值");
        this.name = name;
    }

    public User() {
        System.out.println("1. 无参构造执行");
    }

//    自己写自己配，方法名称随意
    public void initBean() {
        System.out.println("6. 初始化Bean");
    }
//    自己写自己配，方法名称随意
    public void destroyBean() {
        System.out.println("10. 销毁Bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("3. setBeanClassLoader.." + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("3. setBeanFactory..." + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3. setBeanName..." + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5. afterPropertiesSet...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("9. destroy...");
    }
}
