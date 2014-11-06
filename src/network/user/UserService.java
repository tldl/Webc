package network.user;

import bean.User;
import bean.UserBussiness;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/11/5 0005.
 */
public class UserService extends HttpServlet {
    protected User mUser;
    protected String mUserName;
    protected String mUserPsd;
    protected UserBussiness mBussiness;
    protected String mAddress;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text;html;charset=utf-8");
        mUser = new User();
        mBussiness = new UserBussiness();
        mUserName = req.getParameter("userName");
        mUserPsd = req.getParameter("userPsd");
        if (mUserName == null) {
            System.out.println("userName为空");
        } else if (mUserPsd == null) {
            System.out.println("userName为空");
        } else {
            System.out.println(" userName : " + mUserName + "  userPsd : " + mUserPsd);
        }


    }
}
