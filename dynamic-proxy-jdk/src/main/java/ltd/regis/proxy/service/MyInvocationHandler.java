package ltd.regis.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.proxy.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  08:21
 * @Description:
 * @Version: 1.0
 */

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 以下方法必须是invoke, 因为调用invoke方法的的程序已经提前写好了
     * invoke什么时候被调用？
     * 当代理对象调用代理方法时
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
        return retVal;

    }
}
