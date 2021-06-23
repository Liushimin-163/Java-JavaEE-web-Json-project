package dao;

import pojo.User;
import util.dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {

    @Override
    public boolean userreg(User user) {
        String sql="insert into users(username,password) values (?,?);";
        Connection conn= dbUtil.getCon();
        try{
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.setString(1,user.getUsername());
            stat.setString(2,user.getPassword());
            int count=stat.executeUpdate();
            if(count>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }}
        return false;
    }

    public boolean userlogin(User user) {
        String sql="select * from users where username=? and password=?;";
        Connection conn= dbUtil.getCon();
        try{
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.setString(1,user.getUsername());
            stat.setString(2,user.getPassword());
            ResultSet resultSet=stat.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){e.printStackTrace();}finally{try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }}
        return false;
    }

    @Override
    public List<User> userlist() {
        String sql="select * from users; ";
        Connection conn= dbUtil.getCon();
         List <User> userlist=new ArrayList<>();
        try{
            PreparedStatement stat=conn.prepareStatement(sql);
            ResultSet resultSet=stat.executeQuery();
            while(resultSet.next()){
               User user=new User();
               user.setUserId(resultSet.getInt("id"));
               user.setUsername(resultSet.getString("username"));
               user.setPassword(resultSet.getString("password"));
               userlist.add(user);

            }
            return userlist;
        }catch(SQLException e){e.printStackTrace();
        }
        finally{

            try{
                conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        }
        return null;
    }
    @Override
    public User queById(int uid){
        String sql="select * from users where id=?;";
        Connection conn= dbUtil.getCon();
        User user=new User();
        try{
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.setInt(1,uid);
            ResultSet resultSet=stat.executeQuery();
            if(resultSet.next()){
                user.setUserId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setHeadimg(resultSet.getString("headimg"));
            }
        }catch(SQLException e){e.printStackTrace();}finally{try{
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }}
        return user;

    }
}
