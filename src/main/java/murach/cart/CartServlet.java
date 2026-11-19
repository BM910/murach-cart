package murach.cart;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import murach.business.*;

public class CartServlet extends  HttpServlet{
    Product[] ALL_PRODUCTS = {
            new Product("id01", "86 (the band) - True Life Songs and Pictures", 14.95f),
            new Product("id02", "Paddlefoot - The first CD", 12.95f),
            new Product("id03", "Paddlefoot - The second CD", 14.95f),
            new Product("id04", "Joe Rut - Genuine Wood Grained Finish", 12.95f)
    };

    @Override 
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String url = "/index.html";

            String action = request.getParameter("action");
            if (action == null) {
                action = "cart";
            }
            
            if (action.equals("shop")) {
                url = "/index.html";
            }
            
            else if (action.equals("cart")) {
                HttpSession session = request.getSession();

                String productCode = request.getParameter("productCode");
                String quantityString = request.getParameter("quantity");

                Cart cart = (Cart) session.getAttribute("cart");

                int quantity;
                Product product = null;

                try {
                    quantity = Integer.parseInt(quantityString);
                    if (quantity < 0) {
                        quantity = 1;
                    }
                } catch (NumberFormatException nfe) {
                    quantity = 1;
                }

                if (cart == null) {
                    cart = new Cart();
                }

                for (Product p:ALL_PRODUCTS) {
                    if (p.getProductCode().equals(productCode)) {
                        product = p;
                        break;
                    }
                }

                if (product == null) {
                    url = "/index.html";
                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    return;
                }

                LineItem lineItem = new LineItem(product, quantity);

                if (quantity == 0) {
                    cart.removeItem(lineItem);
                } else {
                    cart.addItem(lineItem);
                }
                
                session.setAttribute("cart", cart);

                url = "/yourCart.jsp";
            }

            else if (action.equals("checkOut")) {
                HttpSession session = request.getSession();

                Cart cart = (Cart) session.getAttribute("cart");

                if (cart == null) {
                    cart = new Cart();
                }

                session.setAttribute("cart", cart);

                url = "/checkOut.jsp";
            }

            getServletContext().getRequestDispatcher(url).forward(request, response);
        }

        @Override 
        protected  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                doPost (request, response);
            }
}