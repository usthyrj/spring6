package ltd.regis.relect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取类
        Class<?> clazz = Class.forName("ltd.regis.relect.SomeService");
        //获取方法
        Method doSome = clazz.getDeclaredMethod("doSome", String.class, int.class);
        //获取对象
        SomeService instance = (SomeService) clazz.getDeclaredConstructor().newInstance();
        //调用方法
        String res = (String) doSome.invoke(instance, "111", 11);
        System.out.println(res);
        instance.doSome();
        String ss = instance.doSome("ss");
        String sss = instance.doSome("sss", 1);

    }
}
