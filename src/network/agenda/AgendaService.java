package network.agenda;

import model.Agenda;
import db.Bussiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/11/6 0006.
 */
public class AgendaService extends HttpServlet {
    protected Agenda mAgenda;
    protected Bussiness mBussiness;

    protected String mTitle;
    protected String mContent;
    protected String mDate;
    protected String mAddress;
    protected int mId;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text;html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        mAgenda = new Agenda();
        mBussiness = new Bussiness();
        //  mDate = new Date(req.getDateHeader("startDate"));


    }
}
