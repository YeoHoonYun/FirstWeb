package my.examples.firstapp;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-08
 * Github : https://github.com/YeoHoonYun
 */
// http://localshot:8080/triangle
// http://localhost:8080/triangle?height=5
// http://localhost:8080/triangle?height=5&num1=5&num2=6
@WebServlet(name = "TrigangleServlet", urlPatterns = "/triangle")
public class Jsptest extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        StringBuffer s = new StringBuffer();
        try {
            int num1 = Integer.parseInt(req.getParameter("num1"));
            int num2 = Integer.parseInt(req.getParameter("num2"));
            out.println("<h3>" + (num1 + num2) + "</h3>");
        }catch (Exception e){
            out.println("숫자는 입력 안 됬습니다.<br/>");
        }
        String heightStre = req.getParameter("height");
        int height = 10;
        try{
            height = Integer.parseInt(heightStre);
        }catch (Exception e){

        }
        for(int i = 0; i<height;i++){
            s.append("*");
            out.println(s.toString()+"<br/>");

        }
        for(int i = 0; i < height; i++){
            for(int k=0; k<=i; k++){
                out.print("*");
            }
            out.println("<br>");
        }
    }
}
