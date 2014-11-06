package network;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2014/11/5 0005.
 */
public class Register extends UserService {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        PrintWriter output = resp.getWriter();
        mUser.setUserName(mUserName);
        mUser.setUserPsd(mUserPsd);

        if (mBussiness.add(mUser)) {
            System.out.println("注册成功 User : " + mUser);
            mAddress = "index.jsp";
            req.getRequestDispatcher(mAddress).forward(req, resp);
        }
        output.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
