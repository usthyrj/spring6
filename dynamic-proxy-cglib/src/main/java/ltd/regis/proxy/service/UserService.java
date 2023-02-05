package ltd.regis.proxy.service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.proxy.service
 * @Author: Regis
 * @CreateTime: 2023-02-04  08:38
 * @Description: 目标类
 * @Version: 1.0
 */

public class UserService {
    // 目标方法
    public boolean login(String username, String password){
        boolean res = false;
        if ("admin".equals(username) && "1234".equals(password)) {
            System.out.println("Login Successful!");
            res = true;
        }else {
            System.out.println("Login Failure...");
        }
        return res;
    }

    public void  logout() {
        System.out.println("系统正在退出...");
    }
}
