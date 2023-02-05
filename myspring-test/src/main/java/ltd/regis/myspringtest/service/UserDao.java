package ltd.regis.myspringtest.service;

import ltd.regis.myspringtest.bean.User;

public class UserDao {
    User user;

    public void save() {
        System.out.println(user + "install......");
    }

    public void setUser(User user) {
        this.user=user;
    }
}
