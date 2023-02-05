package ltd.regis.proxy.client;

import ltd.regis.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.proxy.client
 * @Author: Regis
 * @CreateTime: 2023-02-04  08:44
 * @Description:
 * @Version: 1.0
 */

public class Client {
    public static void main(String[] args) {
        //1. 创建字节码增强器对象，该对象是cglib核心对象，就是依靠它来生成代理类
        Enhancer enhancer = new Enhancer();

        //2. 告诉cglib父类（目标类）是谁
        enhancer.setSuperclass(UserService.class);

        //3. 设置回调
        //在cglib中不是InvocationHandler，而是方法拦截器MethodInterceptor
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long begin = System.currentTimeMillis();
                //怎么调用目标方法
                Object retVal = methodProxy.invokeSuper(target, objects);
                long end = System.currentTimeMillis();

                System.out.println(end - begin);
                return retVal;
            }
        });

        //4. 创建代理对象，这一步两件事1.在内存中生成子类，2.创建对象
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("admin", "12");
        userServiceProxy.logout();


    }
}
