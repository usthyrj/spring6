package org.myspringframework.core;

/**
 * myspring框架应用上下文接口
 */
public interface ApplicationContext {

    /**
     * 根据bean名称获取bean对象
     * @param beanName myspring配置文件中bean的id
     * @return
     */
    Object getBean(String beanName);

}
