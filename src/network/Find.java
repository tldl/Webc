package network;

import bean.User;
import bean.UserBussiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2014/11/5 0005.
 */
public class Find extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("out");
        String userName, userPsd;
        String address = null;
        userName=null;
        userName = req.getParameter("userName");
        System.out.println("userName : " + userName);
        if (userName == null) {

        }
        if (userName != null) {
            PrintWriter output = resp.getWriter();
            resp.setContentType("text/html");
            User user = null;
            try {
                UserBussiness bussiness = new UserBussiness();
                user = bussiness.findByName(userName);
                output.println("<h3>Record found<br>" + user);
            } catch (Exception e) {
                e.printStackTrace();
                output.println("wrong");
            }
            req.setAttribute("User", user);
            address = "index.jsp";
            output.close();
        }
       /* RequestDispatcher dispatcher = req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);*/
        req.getRequestDispatcher("index.jsp").forward(req, resp);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
