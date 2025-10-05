package murach.email;

import murach.business.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// Ánh xạ servlet này với URL /emailList (Slide 7, 10)
@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    // Xử lý các yêu cầu POST từ form (Slide 6)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp"; // Trang mặc định nếu có lỗi

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String heardFrom = request.getParameter("heardFrom");
        String wantsUpdates = request.getParameter("wantsUpdates");
        String contactVia = request.getParameter("contactVia");

        User user = new User(email, firstName, lastName,dateOfBirth, heardFrom, wantsUpdates, contactVia);

        String message;
        if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            message = "Please fill out all three text boxes.";
            url = "/index.html"; // Quay lại trang index nếu lỗi
        } else {
            message = ""; // Không có lỗi
            url = "/thanks.jsp"; // Chuyển đến trang thanks nếu thành công
        }

        // Đặt các đối tượng vào request scope để JSP có thể truy cập (Slide 21, 22)
        request.setAttribute("user", user);
        request.setAttribute("message", message);

        // Chuyển tiếp request đến trang JSP tương ứng (Slide 23, 24)
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // Chuyển các yêu cầu GET đến doPost để xử lý
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}