package my.examples.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-10
 * Github : https://github.com/YeoHoonYun
 */
@WebServlet(name = "CookieGetServlet", urlPatterns = "cookgette")
public class CookieGetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;Charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie c : cookies){
                out.println(c.getName());
            }
        }
        else{
            out.println("쿠키가 없습니다.");
        }
    }
}
