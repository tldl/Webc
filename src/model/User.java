package model;

/**
 * Created by Administrator on 2014/11/4 0004.
 */
public class User {
    private int userId;
    private String userName;
    private String userPsd;

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPsd='" + userPsd + '\'' +
                '}';
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }
}
