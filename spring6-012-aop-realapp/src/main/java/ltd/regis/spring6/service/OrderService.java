package ltd.regis.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  16:30
 * @Description:
 * @Version: 1.0
 */

@Service
public class OrderService {

    //生成订单
    public void generate() {
        System.out.println("正在生成订单....");
    }
    //取消订单

    public void cancel() {
        System.out.println("正在取消订单...");
        int a = 1 / 0;
    }
}
