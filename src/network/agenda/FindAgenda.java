package network.agenda;

import bean.Agenda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class FindAgenda extends AgendaService {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.print("find agenda start");
        List<Agenda> list = mBussiness.findAll();
        System.out.println(list);

        if (list != null) {
            System.out.println("查找日程成功");
            mAddress = "showu.jsp";
            req.setAttribute("agendalist", list);
            System.out.println(list);
            req.getRequestDispatcher(mAddress).forward(req, resp);
        } else {
            System.out.println("查找日程失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
