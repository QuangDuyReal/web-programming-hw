package murach.sql; // Hoặc murach.data

import java.sql.*;

public class DBUtil {

    // Phương thức này nhận một câu lệnh SQL và thực thi nó
    public static String processSQL(String sqlStatement) {
        String resultMessage = "";
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = pool.getConnection();
            statement = connection.createStatement();

            sqlStatement = sqlStatement.trim();
            if (sqlStatement != null && !sqlStatement.isEmpty()) {
                String upperSql = sqlStatement.toUpperCase();

                if (upperSql.startsWith("SELECT")) {
                    resultSet = statement.executeQuery(sqlStatement);
                    resultMessage = SQLUtil.getHtmlTable(resultSet); // Dùng lại SQLUtil để tạo bảng HTML
                } else {
                    int i = statement.executeUpdate(sqlStatement);
                    if (i == 0) { // a DDL statement
                        resultMessage = "<p>The statement executed successfully.</p>";
                    } else { // an INSERT, UPDATE, or DELETE statement
                        resultMessage = "<p>The statement executed successfully.<br>"
                                + i + " row(s) affected.</p>";
                    }
                }
            } else {
                resultMessage = "<p>Please enter an SQL statement.</p>";
            }
        } catch (SQLException e) {
            resultMessage = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) pool.freeConnection(connection);
            } catch (SQLException e) {
                resultMessage = "<p>Error closing resources: <br>"
                        + e.getMessage() + "</p>";
            }
        }
        return resultMessage;
    }
}