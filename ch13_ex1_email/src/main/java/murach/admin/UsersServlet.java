package murach.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import murach.business.User;
import murach.data.UserDB;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/users") // URL cho trang quản lý
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy danh sách tất cả người dùng
        List<User> users = UserDB.selectUsers();

        // Đặt danh sách vào request
        request.setAttribute("users", users);

        // Chuyển đến trang JSP để hiển thị
        String url = "/admin/users.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}