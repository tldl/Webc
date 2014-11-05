package network;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/11/5 0005.
 */
public abstract class Service extends HttpServlet {

    protected abstract void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;

}
