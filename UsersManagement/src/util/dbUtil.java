package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil {
    private static String drive="com.mysql.cj.jdbc.Driver";
    private static String urls="jdbc:mysql://localhost:3306/usersdb?characterEncoding=utf-8&serverTimezone=UTC";
    private static String username="root";

    private static String userPw="rootroot";

    public static Connection getCon(){
        try{
            Class.forName(drive);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection conn=null;
        try{
            conn= DriverManager.getConnection(urls,username,userPw);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}

