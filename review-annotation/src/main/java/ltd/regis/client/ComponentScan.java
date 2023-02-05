package ltd.regis.client;

import ltd.regis.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
//        目前只知道包名，扫描包下所有类，当对象上有@Component注解时，实例化该对象，然后放到Map集合中
        String packageName = "ltd.regis.bean";
        //写扫描程序
        String packagePath = packageName.replaceAll("\\.", "/");
        //ltd在类的根路径下面
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
//        System.out.println(url.getPath());
        //获取绝对路径下的文件
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {
            String name = f.getName().split("\\.")[0];
            try {
                Class<?> aClass = Class.forName(packageName + "." + name);
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component annotation = aClass.getAnnotation(Component.class);
                    String key = annotation.value();
                    Object instance = aClass.getDeclaredConstructor().newInstance();
                    map.put(key, instance);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        System.out.println(map);
    }
}
