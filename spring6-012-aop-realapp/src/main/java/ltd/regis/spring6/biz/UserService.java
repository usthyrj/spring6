package ltd.regis.spring6.biz;

import org.springframework.stereotype.Service;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.biz
 * @Author: Regis
 * @CreateTime: 2023-02-04  17:02
 * @Description:
 * @Version: 1.0
 */

@Service
public class UserService {

    public void saveUser() {
        System.out.println("保存用户信息....");
    }

    public void deleteUser() {
        System.out.println("删除用户信息....");
    }

    public void updateUser() {
        System.out.println("修改用户信息....");
    }

    public void getUser() {
        System.out.println("查询用户信息....");
    }
}
