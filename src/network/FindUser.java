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
public class FindUser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text;html;charset=utf-8");
        String userName, userPsd = null;
        String address = null;
        userName = null;
        userName = req.getParameter("userName");
        userName = req.getParameter("userPsd");
        System.out.println("userName : " + userName);
        if (userName == null) {
            System.out.println("userName 为空" + userName);
            return;
        }
        if (userName != null) {
            PrintWriter output = resp.getWriter();
            resp.setContentType("text/html");
            User user = null;
            try {
                UserBussiness bussiness = new UserBussiness();
                user = bussiness.findByName(userName);
                if (user == null) {
                    System.out.println("用户不存在");
                    return;
                }
                if (userPsd != null && userPsd.equals(user.getUserPsd())) {
                    System.out.println("密码错误");
                    return;
                }

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
