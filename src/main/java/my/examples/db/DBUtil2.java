package my.examples.db;

import com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-16
 * Github : https://github.com/YeoHoonYun
 */
public class DBUtil2 {
    private static HikariConfig config = null;
    private static DataSource ds = null;
    private static DBUtil2 instance = new DBUtil2();

    private DBUtil2(){
        String configFile = "/datasource.properties";
        HikariConfig config = new HikariConfig(configFile);

        ds = new HikariDataSource(config);
    }

    public static DBUtil2 getInstance(){
        return instance;
    }

    public Connection getConnection(){
        Connection conn = null;
        try{
            conn = ds.getConnection();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("DB연결을 할 수 없습니다.");
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection conn){
        try{rs.close(); } catch (Exception ignore){}
        close(ps, conn);
    }

    public static void close(PreparedStatement ps, Connection conn){
        try{ps.close();} catch (Exception ignore){}
        try{conn.close();} catch (Exception ignore){}
    }

}
