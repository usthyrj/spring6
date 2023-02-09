package ltd.regis.spring6.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: ltd.regis.spring6.bean
 * @Author: Regis
 * @CreateTime: 2023-02-09  09:19
 * @Description:
 * @Version: 1.0
 */

@Component
public class User {

    @Value("张三")
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
