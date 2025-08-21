package murach.email;

import murach.business.User;
import murach.data.UserDB;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.html"; // URL mặc định

        // Lấy action từ request
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // gán action mặc định
        }

        // Thực hiện action và đặt URL đến trang thích hợp
        if (action.equals("join")) {
            url = "/index.html";    // trang "join"
        }
        else if (action.equals("add")) {
            // Lấy các tham số từ request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // Tạo đối tượng User (Model) và lưu vào database
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);

            // Đặt đối tượng user vào request scope để gửi cho View (JSP)
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // trang "thanks"
        }

        // Chuyển tiếp request và response đến URL đã xác định
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}