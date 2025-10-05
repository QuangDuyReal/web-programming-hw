package murach.sql;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool() {
        try {
            BasicDataSource ds = new BasicDataSource();

            // Đọc các biến môi trường trực tiếp từ hệ thống
            String dbHost = System.getenv("DB_HOST");
            String dbPort = System.getenv("DB_PORT");
            String dbName = System.getenv("DB_NAME");
            String dbUser = System.getenv("DB_USER");
            String dbPassword = System.getenv("DB_PASSWORD");

            // Xây dựng chuỗi URL
            // Kết nối nội bộ không cần SSL, nhưng thêm vào cũng không sao và an toàn hơn
            String url = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName + "?sslmode=require";

            // Thiết lập các thuộc tính cho DataSource
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUrl(url);
            ds.setUsername(dbUser);
            ds.setPassword(dbPassword);

            // Cấu hình các thuộc tính của "bể kết nối"
            ds.setMaxTotal(20);
            ds.setMaxIdle(10);
            ds.setMaxWaitMillis(5000);
            ds.setValidationQuery("SELECT 1");
            ds.setTestOnBorrow(true);

            dataSource = ds;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}