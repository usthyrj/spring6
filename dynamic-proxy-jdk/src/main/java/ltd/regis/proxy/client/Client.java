package ltd.regis.proxy.client;


import ltd.regis.proxy.service.MyInvocationHandler;
import ltd.regis.proxy.service.OrderService;
import ltd.regis.proxy.service.OrderServiceImpl;
import ltd.regis.proxy.util.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        /*
        //Proxy.newProxyInstance(类加载器, 代理类要实现的接口, 调用处理器);
        通过调用这个方法可以创建代理对象
        本质上该方法做了两件事1.动态生成了代理类的字节码，2. 创建了一个对象
        newProxyInstance(类加载器, 代理类要实现的接口, 调用处理器)的三个重要参数有什么含义？
            ClassLoader loader: 类加载器， 有什么用？
                在内存中生成的字节码是class文件，也需要加载内存中，加载类就需要类加载器， 所以这里需要指定类加载器。
                并且JDK要求目标类的类加载器与代理类的类加载器是同一个
            Class<?>[] interfaces:接口
                代理类和目标类要实现的同一个或同一些接口
            InvocationHandler h
                通过InvocationHandler传我们要增强的程序
         */
       /* Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            *//**
             * 以下方法必须是invoke, 因为调用invoke方法的的程序已经提前写好了
             * invoke什么时候被调用？
             *      当代理对象调用代理方法时
             *
             * @return
             * @throws Throwable
             *//*
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                long begin = System.currentTimeMillis();
                Object retVal = method.invoke(target, args);
                long end = System.currentTimeMillis();
                System.out.println("耗时" + (end - begin) + "毫秒");
                return retVal;
            }
        });*/
        Object proxyObject = ProxyUtil.getProxyObject(target, new MyInvocationHandler(target));
        //调用代理对象的代理方法
        OrderService proxy = (OrderService) proxyObject;
        proxy.generate();
        proxy.modify();
        proxy.detail();
        int count = proxy.getCount();
        System.out.println(count);
    }
}
