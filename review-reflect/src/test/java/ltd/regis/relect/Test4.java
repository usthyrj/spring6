package ltd.regis.relect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test4 {
    /**
     * 1. 已知类名：ltd.regis.relect.User
     * 2. 符合javaBean规范
     * 3. 类当中有个属性为age
     * 4.age的类型是int
     * 需求：给age赋值
     */
    public static void main(String[] args) throws Exception{
        String className = "ltd.regis.relect.User";
        String propertype = "age";
        Class<?> clazz = Class.forName(className);
//        根据属性名获取属性类型
        Field field = clazz.getDeclaredField(propertype);
        System.out.println(field);
        String setName = "set" + propertype.toUpperCase().charAt(0) + propertype.substring(1);
        Method setAge = clazz.getDeclaredMethod("setAge", field.getType());
        Object user = clazz.getDeclaredConstructor().newInstance();
        setAge.invoke(user, 20);
        System.out.println(user.toString());

    }
}
