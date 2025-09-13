// In package: com.ecommerce.controller
// File: RemoveFromCartServlet.java

package controller;

import model.Cart;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // 1. Get the product ID from the URL
            String productId = request.getParameter("id");
            if (productId != null) {
                
                // 2. Get the session cart list
                HttpSession session = request.getSession();
                ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

                if (cart_list != null) {
                    // 3. Find and remove the item from the cart
                    for (Cart c : cart_list) {
                        if (c.getId() == Integer.parseInt(productId)) {
                            cart_list.remove(cart_list.indexOf(c));
                            break; // Exit the loop once the item is found and removed
                        }
                    }
                }
            }
            
            // 4. Redirect back to the cart page
            response.sendRedirect("cart.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}