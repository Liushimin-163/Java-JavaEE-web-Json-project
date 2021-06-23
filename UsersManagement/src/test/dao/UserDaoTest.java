package test.dao;

import dao.UserDao;
import dao.UserDaoImp;
import org.junit.Assert;
import org.junit.Test;
import pojo.User;

import java.util.List;

public class UserDaoTest {
    @Test
   public void testUserReg(){
        UserDao userDao=new UserDaoImp();
        User user=new User();
        user.setUsername("liushimin");
        user.setPassword("root123");
        boolean userreg=userDao.userreg(user);
        Assert.assertSame(true,userreg);
    }
    @Test
    public void testUserlogin(){
        UserDao userDao=new UserDaoImp();
        User user=new User();
        user.setUsername("liu");
        user.setPassword("root123");
        boolean login=userDao.userreg(user);
        Assert.assertSame(true,login);
    }
    @Test
    public void testUserlist(){
        UserDao userDao=new UserDaoImp();
        List<User> userlist=userDao.userlist();
        System.out.println(userlist);
        Assert.assertNotNull(userlist);
    }
}
