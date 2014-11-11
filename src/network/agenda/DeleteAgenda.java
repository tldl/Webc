package network.agenda;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/11/6 0006.
 */
public class DeleteAgenda extends AgendaService {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        System.out.println(mAgenda);
        if (mBussiness.deleteById(mId)) {
            System.out.println("删除日程成功");
            mAddress = "index.jsp";
            req.getRequestDispatcher(mAddress).forward(req, resp);
        } else {
            System.out.println("删除日程失败");
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
