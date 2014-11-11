package bean;


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
        boolean flag = true;
        String sql = "insert  into Agenda (title,content)values ('"
                + agenda.getTitle() + "', '"
                + agenda.getContent() + "')";
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

    public boolean deleteByTitle(Agenda agenda) {
        boolean flag = true;
        String sql = "delete from Agenda where id = " + "'" + agenda.getTitle() + "'";
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

    public void update(Agenda agenda) {
        try {
            String sql = "update Agenda" +
                    " set title = '" + agenda.getTitle()
                    + "', content = '" + agenda.getContent()
                    + "', startDate = '" + agenda.getStartDate() + "'";
            System.out.print(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Agenda findById(int id) {
        Agenda agenda = new Agenda();

        try {
            rs = stmt.executeQuery("select * from Agenda where Id = " + id);
            while (rs.next()) {
                agenda.setId(rs.getInt("id"));
                agenda.setTitle(rs.getString("title"));
                agenda.setContent(rs.getString("content"));
                agenda.setStartDate(rs.getDate("startDate"));
                return agenda;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print(agenda);
        return null;

    }

    public List<Agenda> findAll() {
        System.out.println("find start");
        List<Agenda> list = new ArrayList<Agenda>();
        try {
            rs = stmt.executeQuery("select * from Agenda");
            while (rs.next()) {
                Agenda agenda = new Agenda();
                agenda.setId(rs.getInt("id"));
                agenda.setTitle(rs.getString("title"));
                agenda.setContent(rs.getString("content"));
                list.add(agenda);
            }
        } catch (SQLException e) {
            System.out.println("查找失败");
            e.printStackTrace();
        }
        System.out.println();
        return list;
    }


}

