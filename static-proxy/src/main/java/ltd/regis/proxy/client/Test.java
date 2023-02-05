package ltd.regis.proxy.client;

import ltd.regis.proxy.service.OrderService;
import ltd.regis.proxy.service.OrderServiceImpl;
import ltd.regis.proxy.service.OrderServiceImplSub;
import ltd.regis.proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
//        OrderService orderService = new OrderServiceImplSub();
//        orderService.generate();
//        orderService.modify();
//        orderService.detail();

        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        //代理对象执行代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
