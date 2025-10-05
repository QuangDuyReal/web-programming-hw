package murach.email;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet; // Thêm import này
import javax.servlet.http.*;

import murach.business.User;
import murach.data.UserDB;

@WebServlet("/emailList") // Thêm annotation này
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";
        String action = request.getParameter("action");

        if (action.equals("add")) {
            // Lấy các tham số từ request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            User user = new User();
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            // Kiểm tra email đã tồn tại chưa
            String message;
            if (UserDB.emailExists(user.getEmail())) {
                message = "This email address already exists.<br>" +
                        "Please enter another email address.";
                url = "/index.jsp";
            }
            else {
                message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        // SỬA: Lấy lại danh sách users để hiển thị trên trang JSP
        List<User> users = UserDB.selectUsers();
        request.setAttribute("users", users);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        // Lấy danh sách users và gửi đến trang index
        List<User> users = UserDB.selectUsers();
        request.setAttribute("users", users);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}