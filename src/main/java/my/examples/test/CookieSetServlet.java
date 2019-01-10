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
@WebServlet(name = "CookiesTesttt", urlPatterns = "cooksetteyt")
public class CookieSetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;Charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie cookie = new Cookie("test", "1");
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 24 * 365);
        resp.addCookie(cookie);
        out.println("쿠키를 설정합니다.");
    }
}
