package network;

import config.Constant;
import bean.Agenda;
import bean.Bussiness;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Administrator on 2014/11/4 0004.
 */
public class FindAgenda extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        int id = 0;
        String title, note;
        Date date;
        String address = null;
        id = req.getIntHeader("id");
        if (id != 0) {

            PrintWriter output = resp.getWriter();
            resp.setContentType("text/html");
            Agenda agenda = null;
            try {

                Bussiness bussiness = new Bussiness();
                agenda = bussiness.findById(id);
                output.println("<h3>Record found<br>" + agenda);
            } catch (Exception e) {
                e.printStackTrace();
                output.println("»’≥ÃŒ¥’“µΩ");
            }
            req.setAttribute("Agenda", agenda);
            address = Constant.getProjectPath() + "/web/jsp.index.jsp";
            output.close();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(address);
        dispatcher.forward(req, resp);

    }
}
