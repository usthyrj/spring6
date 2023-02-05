package ltd.regis.proxy.service;

/**
 * 代理对象和目标对象的公共接口
 */
public interface OrderService {

    /**
     * 生成订单
     */
    void generate();

    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单详情
     */
    void detail();

    int getCount();
}
