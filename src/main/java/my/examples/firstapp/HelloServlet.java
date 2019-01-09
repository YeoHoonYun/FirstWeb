package my.examples.firstapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HiServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("HelloServlet()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("   <head><title>hello</title></head>");
        out.println("   <body>");
        out.println("      <h1> hello </h1>");
        out.println("      <img src='github.gif'><br>");
        out.println("   </body>");
        out.println("</html>");
    }

    // 웹 애플리케이션을 갱신 및 종료
    @Override
    public void destroy() {
        System.out.println("----- destroy -----");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("----- init -----");
    }
}
