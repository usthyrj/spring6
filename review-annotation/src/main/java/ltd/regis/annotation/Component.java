package ltd.regis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */
//以下表示注解可以出现在类和属性上
//@Target(value = {ElementType.TYPE, ElementType.FIELD})
//标注注解的注解叫元注解，@Target修饰@Component出现的位置
//@Target(value = {ElementType.TYPE, ElementType.FIELD})
//使用注解时，如果注解的属性名是value则可以省略
//使用注解时，如果注解的属性值是数组并且数组中只有一个元素，大括号可以省略
@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)也是元注解，用于标注注解最终保留在class文件中，并且可以被反射机制读取，
//@Retention(RetentionPolicy.SOURCE)则只保留在java源文件中
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    //定义注解的属性
    //String:属性类型；value：属性名字
    String value();
//    String name();
//    String[] names();
//    int[] ages();

}































