package service;

import dao.UserDao;
import dao.UserDaoImp;
import pojo.User;

import java.util.List;

public class UsersServiceImp implements UsersService {
    UserDao userDao=new UserDaoImp();
    @Override
    public boolean userreg(User user) {
        return userDao.userreg(user);
    }

    @Override
    public boolean userlogin(User user) {
        return userDao.userlogin(user);
    }

    @Override
    public List<User> userlist() {
        return userDao.userlist();
    }
    @Override
    public User queById(int uid){
        return userDao.queById(uid);
    }
}
