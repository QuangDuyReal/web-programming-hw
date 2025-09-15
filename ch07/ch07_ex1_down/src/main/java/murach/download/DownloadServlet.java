package murach.download;

import javax.servlet.annotation.WebServlet;
import murach.business.User;
import murach.data.UserIO;
import murach.util.CookieUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String action = request.getParameter("action");
        if(action == null) action = "viewAlbums"; //default

        String url ="/index.jsp";
        if (action.equals("viewAlbums")){
            url ="/index.jsp";
        }else if (action.equals("checkUser")){
            url = checkUser(request, response);
        }else if (action.equals("viewCookies")){
            url = "/view_cookies.jsp";
        }else if (action.equals("deleteCookies")){
            url = deleteCookies(response,request);
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException{
        String action = request.getParameter("action");
        String url = "/index.jsp";
        if(action.equals("registerUser")){
            url = registerUser(response,request);
        }
        getServletContext().getRequestDispatcher(url).forward(request,response);
    }

    private String checkUser(HttpServletRequest request, HttpServletResponse response){
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        session.setAttribute("productCode", productCode);
        User user = (User) session.getAttribute("user");

        String url;
        // Nếu đối tượng User chưa tồn tại -> kiểm tra email cookie
        if(user == null){
            Cookie[] cookie = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookie, "emailCookie");

            //Nếu cookie chưa tồn tại -> Bắt phải đăng ký
            if(emailAddress == null || emailAddress.equals("")){ url = "/register.jsp"; }

            //Nếu đã tồn tại Cookie thì khởi tạo một đối tượng User và cho phép tải MP3 ;)
            else{
                ServletContext sc = getServletContext();
                String path = sc.getRealPath("/WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + productCode + "_download.jsp";
            }
        }
        //Nếu tồn tại User rồi thì cho phép tải luôn :vvv
        else{
            url = "/" + productCode + "_download.jsp";
        }
        return url;
    }

    private String registerUser(HttpServletResponse response, HttpServletRequest request){
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");

        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);

        ServletContext sc = getServletContext();
        String path = sc.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user,path);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        Cookie c = new  Cookie("emailCookie", email);
        c.setMaxAge(60); // a year
        c.setPath("/");                  // allow entire app to access it
        response.addCookie(c);

        String productCode = (String)session.getAttribute("productCode");
        String url = "/" + productCode + "_download.jsp";
        return url;
    }

    private String deleteCookies(HttpServletResponse response, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        String url = "/delete_cookies.jsp";
        return url;
    }
}
