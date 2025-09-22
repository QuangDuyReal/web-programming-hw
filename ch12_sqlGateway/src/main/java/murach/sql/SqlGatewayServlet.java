package murach.sql;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sqlGateway")
public class SqlGatewayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Lấy tham số từ request
        String sqlStatement = request.getParameter("sqlStatement");

        // 2. Gọi lớp Data Access để thực thi
        String sqlResult = DBUtil.processSQL(sqlStatement);

        // 3. Đặt kết quả vào request scope
        request.setAttribute("sqlResult", sqlResult);
        request.setAttribute("sqlStatement", sqlStatement);

        // 4. Chuyển hướng đến View (JSP)
        String url = "/index.jsp";
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}