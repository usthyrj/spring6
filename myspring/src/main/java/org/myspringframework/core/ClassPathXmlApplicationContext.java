package org.myspringframework.core;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析spring配置文件，然后初始化所有bean
     * @param configLocation myspring配置文件的路径，要放到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {

        /*
        * <bean id="user" class="ltd.regis.myspring.bean.User">
        <property name="name" value="zhangsan"/>
        <property name="age" value="23"/>
    </bean>

    <bean id="userDaoBean" class="ltd.regis.myspring.bean.UserDao"/>
    <bean id="userService" class="ltd.regis.myspring.bean.UserService">
        <property name="userDao" ref="userDaoBean"/>
    </bean>
        * */
//
//        Map<String, String> map = new HashMap<>();
//        map.put("user", "ltd.regis.myspring.bean.User");
//        map.put("userDaoBean", "ltd.regis.myspring.bean.UserDao");
//        map.put("userService", "ltd.regis.myspring.bean.userService");
//        for (String key : map.keySet()) {
//            forName()
//
//        }
//        wire()
        try {
            //解析xml文件，实例化bean，将bean放入singletonObjects中
            //dom4j解析XML的核心对象
            SAXReader saxReader = new SAXReader();
            //获取输入流指向配置文件
            InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            //读文件
            Document document = saxReader.read(resourceAsStream);
            //获取所有bean标签
            List<Node> nodes = document.selectNodes("//bean");
            //遍历bean标签
            nodes.forEach(node -> {
                try {
                    //向下转型，为了使用Element中更丰富的方法
                    Element beanElt = (Element) node;
                    //获取id
                    String id = beanElt.attributeValue("id");
                    //获取class
                    String className = beanElt.attributeValue("class");
                    logger.info("beanName=" + id);
                    logger.info("beanClassName=" + className);
                    //获取Class
                    Class<?> aClass = Class.forName(className);
                    //获取无参数构造方法
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    //实例化bean
                    Object instance = declaredConstructor.newInstance();
                    //将bean曝光，加入map
                    singletonObjects.put(id, instance);
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //再次遍历bean标签，给对象属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    //获取id
                    String id = beanElt.attributeValue("id");
                    //获取className
                    String className = beanElt.attributeValue("class");
                    //获取class
                    Class<?> aClass = Class.forName(className);

                    //获取该bean标签下所有的属性标签
                    List<Element> properties = beanElt.elements("property");
                    properties.forEach(property -> {
                        try {
                            //获取属性名
                            String name = property.attributeValue("name");
                            logger.info("属性名：" + name);
                            //获取value
                            String propertyValue = property.attributeValue("value");
                            //获取ref
                            String ref = property.attributeValue("ref");
                            //通过属性名获取属性类型
                            Field declaredField = aClass.getDeclaredField(name);
                            //获取set方法名
                            String setMethodName = "set" + name.toUpperCase().charAt(0) + name.substring(1);
                            //获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, declaredField.getType());
                            //调用set方法
                            logger.info(propertyValue + "--" + ref);
                            if(propertyValue == null && ref == null){
                                setMethod.invoke(singletonObjects.get(id));
                            }else if(propertyValue == null) {
                                //propertyValue == null && ref != null
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));

                            }else if(ref == null){
                                //通过类型转换属性
                                Object propertyVal = null;

                                // 该属性是简单属性
                                String propertyTypeSimpleName = declaredField.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte", "Byte" -> propertyVal = Byte.valueOf(propertyValue);
                                    case "short", "Short" -> propertyVal = Short.valueOf(propertyValue);
                                    case "int", "Integer" -> propertyVal = Integer.valueOf(propertyValue);
                                    case "long", "Long" -> propertyVal = Long.valueOf(propertyValue);
                                    case "float", "Float" -> propertyVal = Float.valueOf(propertyValue);
                                    case "double", "Double" -> propertyVal = Double.valueOf(propertyValue);
                                    case "boolean", "Boolean" -> propertyVal = Boolean.valueOf(propertyValue);
                                    case "char", "Character" -> propertyVal = propertyValue.charAt(0);
                                    case "String" -> propertyVal = propertyValue;
                                }
                                setMethod.invoke(singletonObjects.get(id), propertyVal);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(singletonObjects);
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
