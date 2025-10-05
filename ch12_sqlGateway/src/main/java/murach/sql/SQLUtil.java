package murach.sql;

import java.sql.*;

/**
 * Lớp tiện ích để xử lý các tác vụ liên quan đến SQL.
 */
public class SQLUtil {

    /**
     * Chuyển đổi một đối tượng ResultSet thành một chuỗi HTML chứa bảng.
     * @param results ResultSet từ một câu lệnh SELECT.
     * @return Một chuỗi String chứa mã HTML cho thẻ <table>.
     * @throws SQLException Nếu có lỗi khi truy cập ResultSet.
     */
    public static String getHtmlTable(ResultSet results) throws SQLException {
        if (results == null) {
            return "<p>No results found.</p>";
        }

        StringBuilder htmlTable = new StringBuilder();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();

        htmlTable.append("<table class='table table-bordered table-striped'>"); // Thêm class của Bootstrap cho đẹp

        // 1. Tạo hàng tiêu đề (header row) <thead>
        htmlTable.append("<thead>");
        htmlTable.append("<tr>");
        for (int i = 1; i <= columnCount; i++) {
            htmlTable.append("<th>");
            htmlTable.append(metaData.getColumnName(i));
            htmlTable.append("</th>");
        }
        htmlTable.append("</tr>");
        htmlTable.append("</thead>");

        // 2. Tạo các hàng dữ liệu (data rows) <tbody>
        htmlTable.append("<tbody>");
        while (results.next()) {
            htmlTable.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                String cellValue = results.getString(i);
                htmlTable.append("<td>");
                // Quan trọng: Vô hiệu hóa các thẻ HTML trong dữ liệu để chống XSS
                htmlTable.append(escapeHtml(cellValue));
                htmlTable.append("</td>");
            }
            htmlTable.append("</tr>");
        }
        htmlTable.append("</tbody>");

        htmlTable.append("</table>");
        return htmlTable.toString();
    }

    /**
     * Vô hiệu hóa các ký tự HTML đặc biệt trong một chuỗi để ngăn chặn tấn công XSS.
     * @param data Chuỗi đầu vào có thể chứa mã HTML.
     * @return Chuỗi đã được làm sạch, an toàn để hiển thị trên trang web.
     */
    private static String escapeHtml(String data) {
        if (data == null) {
            return ""; // Trả về chuỗi rỗng thay vì "null"
        }
        return data.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}