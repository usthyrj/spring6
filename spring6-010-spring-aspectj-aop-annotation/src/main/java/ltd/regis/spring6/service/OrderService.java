package ltd.regis.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  11:02
 * @Description:
 * @Version: 1.0
 */
@Service
public class OrderService {

    public void generate() {
        System.out.println("order is generating");
    }
}
