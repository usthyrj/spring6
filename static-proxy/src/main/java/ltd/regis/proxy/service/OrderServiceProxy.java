package ltd.regis.proxy.service;

/**
 * 代理对象
 * 客户端在使用代理对象的时候就像再使用目标对象一样
 */
public class OrderServiceProxy implements OrderService {

    //将目标对象作为代理对象的一个属性，这种关系叫关联关系，比继承关系的耦合度低
    //代理对象中有目标对象的引用，关联关系， has a
    //这里写一个公共接口，公共接口耦合度低
    private OrderService target;//目标对象一定是实现的OrderService接口

    //创建代理对象时传一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {
        //增强
        long begin = System.currentTimeMillis();
        //调用目标对象的目标方法
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }
}
