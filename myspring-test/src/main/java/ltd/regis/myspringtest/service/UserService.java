package ltd.regis.myspringtest.service;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void insert() {
        userDao.save();
    }
}
