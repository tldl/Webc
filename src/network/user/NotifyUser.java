package network.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2014/11/16 0016.
 */
public class NotifyUser extends UserService {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        PrintWriter output = resp.getWriter();
        mUser=mBussiness.findByName(mUserName);
        mUser.setUserPsd(mUserPsd);
        if (mBussiness.update(mUser)) {
            System.out.println("更改密码成功 User : " + mUser);
            mAddress = "login.jsp";
        }
        else
        {
            System.out.println("更改密码失败  User : " + mUser);
            mAddress = "404.jsp";
        }
        req.getRequestDispatcher(mAddress).forward(req, resp);
        output.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
