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

        // Chỉ có một nhiệm vụ cho doGet: hiển thị danh sách người dùng
        List<User> users = UserDB.selectUsers();
        request.setAttribute("users", users);

        String url = "/admin/users.jsp";
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "display_users"; // Mặc định là hiển thị danh sách
        }

        String url = "/admin/users.jsp"; // URL mặc định

        switch (action) {
            case "display_users":
                List<User> users = UserDB.selectUsers();
                request.setAttribute("users", users);
                break;

            case "display_user_for_edit":
                try {
                    long userId = Long.parseLong(request.getParameter("userId"));
                    User user = UserDB.selectUserById(userId);
                    request.setAttribute("user", user);
                    url = "/admin/user.jsp"; // Chuyển đến trang sửa
                } catch (NumberFormatException e) {
                    // Lỗi nếu userId không hợp lệ
                    System.err.println("Invalid user ID for edit");
                }
                break;

            case "update_user":
                try {
                    long userId = Long.parseLong(request.getParameter("userId"));
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");

                    // Lấy user hiện tại từ DB để giữ lại email
                    User user = UserDB.selectUserById(userId);
                    if (user != null) {
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        UserDB.update(user);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid user ID for update");
                }
                // Sau khi update, tải lại danh sách và quay về trang users.jsp
                request.setAttribute("users", UserDB.selectUsers());
                break;

            case "delete_user":
                try {
                    long userId = Long.parseLong(request.getParameter("userId"));
                    User user = UserDB.selectUserById(userId);
                    if (user != null) {
                        UserDB.delete(user);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid user ID for delete");
                }
                // Sau khi delete, tải lại danh sách và quay về trang users.jsp
                request.setAttribute("users", UserDB.selectUsers());
                break;
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}