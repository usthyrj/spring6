package ltd.regis.proxy.service;

/**
 * 目标对象，里面的方法是目标方法
 */
public class OrderServiceImpl implements OrderService{
    /**
     * 统计所有方法耗时
     *  1. 硬编码写到方法中
     *        缺点：1. 违背OCP原则
     *             2. 代码未得到复用
     *
     *  2. 编写业务类的子类，让子类继承父类，对每个业务方法进行重写
     *        缺点：1. 虽然解决了OCP,但采用继承关系，代码耦合度过高
     *             2. 代码未得到复用
     *  3. 代理模式
     *        优点：1. 解决OCP
     *             2. 降低了耦合度
     *  目前使用的是静态代理，静态代理的缺点是什么？
     *      类爆炸，假设系统中有1000接口就要写1000个代理类，这样类会急剧增加不好维护
     *      怎么解决？
     *          使用动态代理
     *      动态代理还是代理模式，只不过添加了字节码生成技术，可以再内存中为我们动态的生成class字节码，这个字节码就是代理类
     */
    @Override
    public void generate() {
        System.out.println("开始生成...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("生成订单信息完成");
    }

    @Override
    public void modify() {
//        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("修改订单信息.....");
//        long end = System.currentTimeMillis();
//        System.out.println(end - begin);
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("查看");
    }
}
