package pojo;

public class User {
    int userId;
    String username;
    String password;
    String headimg;

    public User(int userId, String username, String password, String headimg) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.headimg = headimg;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headimg='" + headimg + '\'' +
                '}';
    }
}
