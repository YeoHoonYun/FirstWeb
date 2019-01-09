<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: cjswo
  Date: 2019-01-09
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%--지시문 : 이부분을 text/html 로 만들어 준다. resp.setContentType("text/html");--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello.jsp</title>
</head>
<body>
    <h1>helloJsp</h1>
    <%--스크립트릿--%>
    <%
        for(int i = 0; i < 100; i++){
            %>
            out.write(i+"<br/>");
            i = <%=i%><br/>
    <%
        }
    %>
</body>
</html>
