package ltd.regis.spring6.service;

import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  10:23
 * @Description:
 * @Version: 1.0
 */
@Service
public class UserService {//目标类

    public void login() throws Exception {//目标方法

        try {

            System.out.println("系统正在进行身份认证....");
            int a = 3 / 0;
        }
        finally {
//            System.out.println("finally执行");
        }
    }

    public void logout() {//目标方法
        System.out.println("系统正在退出....");
        int a = 3 / 0;
    }
}
