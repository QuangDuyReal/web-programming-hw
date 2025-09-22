package murach.sql; // Hoặc package murach.data nếu bạn muốn

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Lớp ConnectionPool quản lý một "bể" các kết nối đến cơ sở dữ liệu.
 * Lớp này sử dụng mẫu thiết kế Singleton để đảm bảo chỉ có một thể hiện duy nhất
 * trong toàn bộ ứng dụng.
 */
public class ConnectionPool {

    // Thể hiện duy nhất của lớp ConnectionPool
    private static ConnectionPool pool = null;

    // Nguồn dữ liệu (DataSource) được lấy từ server (Tomcat)
    private static DataSource dataSource = null;

    /**
     * Constructor là private để ngăn việc tạo đối tượng từ bên ngoài,
     * bắt buộc phải thông qua phương thức getInstance().
     */
    private ConnectionPool() {
        try {
            // Sử dụng JNDI (Java Naming and Directory Interface) để tìm DataSource
            // mà chúng ta đã cấu hình trong file /META-INF/context.xml
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/murach_sql");
        } catch (NamingException e) {
            System.err.println("Lỗi JNDI lookup: Không tìm thấy DataSource!");
            e.printStackTrace(); // In ra chi tiết lỗi để gỡ lỗi
        }
    }

    /**
     * Phương thức static để lấy thể hiện duy nhất của ConnectionPool.
     * Từ khóa 'synchronized' đảm bảo rằng phương thức này an toàn trong môi trường đa luồng,
     * tránh trường hợp nhiều thread cùng lúc tạo ra nhiều pool.
     * @return Thể hiện của ConnectionPool.
     */
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    /**
     * Lấy một kết nối từ "bể".
     * @return Một đối tượng Connection, hoặc null nếu có lỗi.
     */
    public Connection getConnection() {
        try {
            // Lấy kết nối từ DataSource
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy kết nối từ pool!");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Trả một kết nối về lại cho "bể".
     * Khi dùng connection pool của Tomcat, việc gọi c.close() chính là hành động
     * trả kết nối về pool, chứ không phải đóng kết nối vật lý.
     * @param c Đối tượng Connection cần được trả về.
     */
    public void freeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi trả kết nối về pool!");
            e.printStackTrace();
        }
    }
}