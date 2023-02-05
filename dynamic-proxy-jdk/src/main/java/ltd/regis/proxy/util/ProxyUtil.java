package ltd.regis.proxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.proxy.util
 * @Author: Regis
 * @CreateTime: 2023-02-04  08:10
 * @Description:代理工具类
 * @Version: 1.0
 */

public class ProxyUtil {

    public static Object  getProxyObject(Object target, InvocationHandler invocationHandler) {
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), invocationHandler);
        return proxyInstance;
    }
}
