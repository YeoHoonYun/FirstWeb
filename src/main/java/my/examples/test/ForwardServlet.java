package my.examples.test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-09
 * Github : https://github.com/YeoHoonYun
 */
@WebServlet(name = "Forward2", urlPatterns = "/forward2")
public class ForwardServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str1 = "hello";
        String str2 = "world";
        req.setAttribute("str1",str1);
        req.setAttribute("str2",str2);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/result2");
        requestDispatcher.forward(req, resp);
    }
}
