package ltd.regis.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  16:29
 * @Description:
 * @Version: 1.0
 */

@Service
public class AccountService {

    //转账的业务方法
    public void transfer() {
        System.out.println("银行账户正在完成转账操作....");
    }

    //取款
    public void withdraw() {
        System.out.println("正在取款....");
    }
}
