package network.agenda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/11/11 0011.
 */
public class NotifyAgenda extends AgendaService {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        mTitle = req.getParameter("title");
        mContent = req.getParameter("content");
        mAgenda.setTitle(mTitle);
        mAgenda.setContent(mContent);
        // mAgenda.setStartDate(mDate);
        System.out.println(mAgenda);
        if (mBussiness.update(mAgenda)) {
            System.out.println("更新日程成功");
            mAddress = "login.jsp";
            req.getRequestDispatcher(mAddress).forward(req, resp);
        } else {
            System.out.println("删除日程失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
