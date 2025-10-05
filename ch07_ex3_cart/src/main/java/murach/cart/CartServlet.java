package murach.cart;

import murach.business.LineItem;
import murach.data.ProductIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import murach.business.Cart;
import murach.business.Product;

import java.io.IOException;

public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        ServletContext sc = getServletContext();

        String action = request.getParameter("action");
        if (action == null) {
            action = "cart";
        }

        if (action.equals("shop")) {
            url = "/index.jsp";
        }
        else if (action.equals("cart")) {
            String productCode = request.getParameter("productCode");

            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }

            int quantity;
            try {
                 quantity = Integer.parseInt(request.getParameter("quantity"));
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException e) {
                quantity = 1;
            }


            String path = sc.getRealPath("/WEB-INF/products.txt");
            Product product = ProductIO.getProduct(productCode, path);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);

            if (quantity > 0) {
                cart.addItem(lineItem);
            } else if (quantity == 0) {
                cart.removeItem(lineItem);
            }


            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        else if (action.equals("checkout")) {
            url = "/checkout.jsp";
        }

        sc.getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
