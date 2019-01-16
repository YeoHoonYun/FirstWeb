package my.examples.my.exampes.jdbcboard;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-14
 * Github : https://github.com/YeoHoonYun
 */
public class SelectOneExam {
    public static void main(String[] args) {
        final String driverClassname = "com.mysql.cj.jdbc.Driver";
        final String driverURL = "jdbc:mysql://localhost:3306/fastcampus?characterEncoding=UTF-8&serverTimezone=UTC";
        final String dbUserId = "yun";
        final String dbUserPassword = "hadoop";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        long idParam = 1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName(driverClassname);
            conn = DriverManager.getConnection(driverURL, dbUserId, dbUserPassword);
            if(conn != null){
                System.out.println("conn OK");
                System.out.println(conn.getClass().getName());
            }

            String sql = "select id, title, writer, content, regdate, read_count from board where id = ?";
            ps = conn.prepareStatement(sql);

            ps.setLong(1, idParam);

            rs = ps.executeQuery();

            if(rs.next()){
                long id = rs.getLong(1);
                String title = rs.getString(2);
                String writer = rs.getString(3);
                String content = rs.getString(4);
                Date regdate = rs.getDate(5);
                int readCount = rs.getInt(6);

                System.out.println(id + "," + title + ", " + content + ", " + writer + ", "+ content + ", " + dateFormat.format(regdate) + ", " + readCount);

            }else{
                System.out.println("해당하는 ID에 값이 없습니다.");
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
