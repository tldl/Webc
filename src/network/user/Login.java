package network.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2014/11/6 0006.
 */
public class Login extends UserService {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        req.setCharacterEncoding("UTF-8");
        mUser = mBussiness.findByName(mUserName);
        if (mUser == null) {
            System.out.println("用户不存在");
        } else if (!mUser.getUserPsd().equals(mUserPsd)) {
            System.out.println("密码错误");
        } else {
            System.out.println("登录成功 User : " + mUser);
            mAddress = "find.jsp";
            req.getRequestDispatcher(mAddress).forward(req, resp);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
