package my.examples.firstapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResultServlet", urlPatterns = "/result/*")
public class ResultServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("URL : " + req.getRequestURL());
        System.out.println("URI : " + req.getRequestURI());
        System.out.println("1 : " + req.getContextPath());
        System.out.println("2 : " + req.getServletPath());
        System.out.println("3 : " + req.getPathInfo());
        System.out.println("4 : " + req.getQueryString());
        PrintWriter out = resp.getWriter();

        out.println(req.getAttribute("str1"));
        out.println(req.getAttribute("str2"));
    }
}
