package service;

import pojo.User;

import java.util.List;

public interface UsersService {
    boolean userreg(User user);
    // define login interface
    boolean userlogin(User user);
    //define userlist interface
    List <User> userlist();
    User queById(int uid);
}
