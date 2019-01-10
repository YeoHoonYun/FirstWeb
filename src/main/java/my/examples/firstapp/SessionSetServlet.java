package my.examples.firstapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-10
 * Github : https://github.com/YeoHoonYun
 */
@WebServlet(name="SessionSetServlet", urlPatterns = "/sessionset")
public class SessionSetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        if(session.isNew()){
            out.println("방금 만들었다.. <br>");
        }

        int rand = (int)(Math.random() * 1000);
        session.setAttribute("name" + rand, rand);
        out.println("세션을 설정합니다.");
    }
}
