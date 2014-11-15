package network.user;

import bean.Agenda;
import bean.Bussiness;
import bean.UserBussiness;

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

        if (mUser == null || !mUser.getUserPsd().equals(mUserPsd)) {
            mAddress = "404.jsp";
        } else {
            UserBussiness.setCurrentUser(mUser.getUserName());
            List<Agenda> list = mAgendaBussiness.findByUser();
            System.out.println("登录成功 User : " + mUser);
            mAddress = "showu.jsp";
            if (list != null)
                req.setAttribute("agendalist", list);
            System.out.println(list);
        }
        req.getRequestDispatcher(mAddress).forward(req, resp);
    }
}
