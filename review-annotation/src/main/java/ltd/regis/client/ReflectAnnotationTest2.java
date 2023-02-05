package ltd.regis.client;

import ltd.regis.annotation.Component;

public class ReflectAnnotationTest2 {
    public static void main(String[] args) throws Exception {
        //通过反射机制读取注解
        Class<?> aClass = Class.forName("ltd.regis.bean.User");
        //判断类上有无注解
        if (aClass.isAnnotationPresent(Component.class)) {
            //获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            //访问注解属性
            String value = annotation.value();
            System.out.println(value);
        }
    }
}
