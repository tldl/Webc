package bean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/4 0004.
 */
public class UserBussiness {

    public final static String DRIVERNAME = "sun.jdbc.odbc.JdbcOdbcDriver";
    public final static String URL = "jdbc:odbc:agenda";
    private static Statement stmt;
    private static ResultSet rs;

    public static String getCurrentUser() {
        if (user != null) {
            System.out.println("getCurrentUser  ： " + user);
            return user;
        } else {
            System.out.println("getCurrentUser default  ：" + "admin");
            return "admin";
        }
    }

    public static void setCurrentUser(String user) {
        System.out.println("setCurrnetUser  ：" + "user");
        UserBussiness.user = user;
    }

    private static String user;


    public UserBussiness() {
        init();
    }

    public static void init() {
        try {
            Class.forName(DRIVERNAME);
            Connection conn = DriverManager.getConnection(URL);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean add(User user) {
        boolean flag = true;
        try {
            String sql = "insert into User (userName,userPsd) values ('"
                    + user.getUserName() + "', '"
                    + user.getUserPsd() + "')";
            System.out.println(sql);
            stmt.execute(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public void delete(User user) {
        String sql = "delete from User where userId =" + user.getUserId();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteById(int id) {
        boolean flag = true;
        String sql = "delete from User where userId =" + id;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public void update(User user) {
        try {
            String sql = "update User" +
                    " set userName = '" + user.getUserName()
                    + "', userPsd = '" + user.getUserPsd() + "'";
            System.out.print(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User findById(int id) {
        User user = new User();

        try {
            rs = stmt.executeQuery("select * from User where userId = " + id);
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPsd(rs.getString("userPsd"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(user);
        return null;

    }

    public User findByName(String name) {
        User user = new User();

        try {
            String sql = "select * from User where userName = '" + name + "'";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPsd(rs.getString("userPsd"));
                System.out.print("user :" + user);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        try {
            rs = stmt.executeQuery("select * from User");
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPsd(rs.getString("userPsd"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

}
