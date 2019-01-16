package my.examples.db;

import java.sql.*;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-10
 * Github : https://github.com/YeoHoonYun
 */
public class DbConnect {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        String server = "localhost"; // MySQL 서버 주소
        String database = "fastcampus"; // MySQL DATABASE 이름
        String user_name = "yun"; //  MySQL 서버 아이디
        String password = "hadoop"; // MySQL 서버 비밀번호

        // 1.드라이버 로딩
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 2.연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?useSSL=false"+"&characterEncoding=UTF-8&serverTimezone=UTC", user_name, password);
            System.out.println("정상적으로 연결었습니다.");

            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from board");

            while(rs.next()){
                System.out.print(rs.getString("num"));
                System.out.print(" : ");
                System.out.println(rs.getString("name"));
            }
        } catch(SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }

        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }

}
