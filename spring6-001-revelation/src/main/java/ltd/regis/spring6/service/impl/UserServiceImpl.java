package ltd.regis.spring6.service.impl;

import ltd.regis.spring6.dao.UserDao;
import ltd.regis.spring6.dao.impl.UserDaoImplForMySQL;
import ltd.regis.spring6.dao.impl.UserDaoImplForOracle;
import ltd.regis.spring6.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }


}
