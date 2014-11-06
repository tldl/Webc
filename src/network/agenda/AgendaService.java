package network.agenda;

import bean.Agenda;
import bean.Bussiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2014/11/6 0006.
 */
public class AgendaService extends HttpServlet {
    protected Agenda mAgenda;
    protected Bussiness mBussiness;

    protected String mTitle;
    protected String mContent;
    protected Date mDate;
    protected String mAddress;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text;html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        mAgenda = new Agenda();
        mBussiness = new Bussiness();
        mTitle = req.getParameter("title");
        mContent = req.getParameter("content");
        //  mDate = new Date(req.getDateHeader("startDate"));

        if (mTitle == null) {
            System.out.println("title为空");
        } else {
            System.out.println(" Title : " + mTitle + "  Content : " + mContent + "  Date : " + mDate);
        }
    }
}
