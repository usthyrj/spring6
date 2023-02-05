package ltd.regis.spring6.service;

import ltd.regis.spring6.dao.UserDao;
import ltd.regis.spring6.dao.VipDao;

public class UserService {

    private UserDao userDao;
    private VipDao vipDao;
//    set注入必须提供一个set方法，Spring容器会调用set方法给userDao赋值
//    自己写的set不符合规范，但方法名需要set开头
    public void setMyUserDao(UserDao xxx) {
        this.userDao = xxx;

    }

    //Idea生成符合规范
    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    public void saveUser() {
        //save info to database
        userDao.insert();

    }
}
