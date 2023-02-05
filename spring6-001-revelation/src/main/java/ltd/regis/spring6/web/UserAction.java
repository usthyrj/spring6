package ltd.regis.spring6.web;

import ltd.regis.spring6.service.UserService;
import ltd.regis.spring6.service.impl.UserServiceImpl;

public class UserAction {
    private UserService userService;

    public void deleteRequest() {
        userService.deleteUser();
    }
}
