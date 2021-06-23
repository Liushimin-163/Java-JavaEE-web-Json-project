package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    // define user reg
    boolean userreg(User user);
    // define login interface
    boolean userlogin(User user);
    //define userlist interface
    List <User> userlist();

    User queById(int uid);
}
