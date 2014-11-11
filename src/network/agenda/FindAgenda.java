package network.agenda;

import bean.Agenda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2014/11/7 0007.
 */
public class FindAgenda extends AgendaService {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Agenda> list = new ArrayList<Agenda>();
        list = mBussiness.findAll();
        System.out.println(list);

        if (list != null) {
            System.out.println("查找日程成功");
            mAddress = "show.jsp";
            req.setAttribute("agendalist", list);
            req.getRequestDispatcher(mAddress).forward(req, resp);
        } else {
            System.out.println("查找日程失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
