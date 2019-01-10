package my.examples.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-10
 * Github : https://github.com/YeoHoonYun
 */
@WebServlet(name="sessions", urlPatterns = "serviette")
public class SessionGetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(true);
        if(session.isNew()){
            out.println();
        }
        Enumeration<String> stringEnumeration = session.getAttributeNames();
        while(stringEnumeration.hasMoreElements()){
            out.println(stringEnumeration.nextElement());
        }
    }
}
