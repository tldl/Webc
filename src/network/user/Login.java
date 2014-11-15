package network.user;

import bean.Agenda;
import bean.Bussiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2014/11/6 0006.
 */
public class Login extends UserService {

    protected Bussiness mAgendaBussiness;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        mUser = mBussiness.findByName(mUserName);
        // PrintWriter out;
        // out = resp.getWriter();
        // out.print("1");
        findAge(req, resp);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void findAge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mAgendaBussiness = new Bussiness();
        System.out.print("find agenda start");
        List<Agenda> list = mAgendaBussiness.findAll();
        System.out.println(list);
        if (mUser == null || !mUser.getUserPsd().equals(mUserPsd)) {
            mAddress = "404.jsp";
        } else if (list != null) {
            System.out.println("登录成功 User : " + mUser);
            System.out.println("查找日程成功");
            mAddress = "showu.jsp";
            req.setAttribute("agendalist", list);
            System.out.println(list);
        } else {
            System.out.println("查找日程失败");

        }

        req.getRequestDispatcher(mAddress).forward(req, resp);
    }
}
