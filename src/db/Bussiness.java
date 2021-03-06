package db;


import model.Agenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/10/29 0029.
 */
public class Bussiness {
    public final static String DRIVERNAME = "sun.jdbc.odbc.JdbcOdbcDriver";
    public final static String URL = "jdbc:odbc:agenda";
    private static Statement stmt;
    private static ResultSet rs;

    public Bussiness() {
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

    public boolean add(Agenda agenda) {
        System.out.println(agenda);
        boolean flag = true;
        String sql = "insert  into Agenda (title,content,startDate)values ('"
                + agenda.getTitle() + "', '"
                + agenda.getContent() + "', '"
                + agenda.getStartDate() + "')";

        System.out.println(sql);
        try {
            stmt.execute(sql);

        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public boolean addByUser(Agenda agenda) {
        System.out.println(agenda);
        boolean flag = true;
        String sql = "insert  into Agenda (title,content,user,startDate)values ('"
                + agenda.getTitle() + "', '"
                + agenda.getContent() + "', '"
                + UserBussiness.getCurrentUser() + "', '"
                + agenda.getStartDate() + "')";

        System.out.println(sql);
        try {
            stmt.execute(sql);

        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public boolean delete(Agenda agenda) {
        boolean flag = true;
        String sql = "delete from Agenda where id =" + agenda.getId();
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @Deprecated
    public boolean deleteByTitle(String title) {
        boolean flag = true;
        String sql = "delete from Agenda where title = " + "'" + title + "'";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }


    public boolean deleteById(int id) {
        boolean flag = true;
        String sql = "delete from Agenda where id =" + id;
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public boolean update(Agenda agenda) {
        boolean flag = true;
        try {
            String sql = "update Agenda" +
                    " set title = '" + agenda.getTitle()
                    + "', content = '" + agenda.getContent()
                    + "', startDate = '" + agenda.getStartDate() + "'";
            System.out.print(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;

    }

    public Agenda findById(int id) {
        Agenda agenda = new Agenda();

        try {
            rs = stmt.executeQuery("select * from Agenda where Id = " + id);
            while (rs.next()) {
                agenda.setId(rs.getInt("id"));
                agenda.setTitle(rs.getString("title"));
                agenda.setContent(rs.getString("content"));
                agenda.setStartDate(rs.getString("startDate"));
                return agenda;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(agenda);
        return null;

    }

    public List<Agenda> findAll() {
        List<Agenda> list = new ArrayList<Agenda>();
        try {
            rs = stmt.executeQuery("select * from Agenda");
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setTitle(rs.getString("title"));
                agenda.setContent(rs.getString("content"));
                agenda.setStartDate(rs.getString("startDate"));
                list.add(agenda);
            }
        } catch (SQLException e) {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        System.out.println();
        return list;
    }

    public List<Agenda> findByUser() {
        List<Agenda> list = new ArrayList<Agenda>();
        try {
            rs = stmt.executeQuery("select * from Agenda where user = '" + UserBussiness.getCurrentUser() + "'");
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setTitle(rs.getString("title"));
                agenda.setContent(rs.getString("content"));
                agenda.setStartDate(rs.getString("startDate"));
                agenda.setUser(UserBussiness.getCurrentUser());
                list.add(agenda);
            }
        } catch (SQLException e) {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        return list;
    }


}

