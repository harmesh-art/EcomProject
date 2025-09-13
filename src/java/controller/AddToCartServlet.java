// In package: com.ecommerce.controller
// File: AddToCartServlet.java

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

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the current session
        HttpSession session = request.getSession();

        // 1. Get the existing cart from the session, or create a new one
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if (cart_list == null) {
            cart_list = new ArrayList<>();
            session.setAttribute("cart-list", cart_list);
        }

        // 2. Get the product ID from the request
        int id = Integer.parseInt(request.getParameter("id"));

        // 3. Check if the product is already in the cart
        boolean exist = false;
        for (Cart c : cart_list) {
            if (c.getId() == id) {
                exist = true;
                break; // Found it, no need to keep checking
            }
        }

        // 4. If it doesn't exist, create a new cart item and add it
        if (!exist) {
            Cart cm = new Cart();
            cm.setId(id);
            cm.setQuantity(1);
            cart_list.add(cm);
        }
        
        // 5. Always redirect back to the home page
        response.sendRedirect("index.jsp");
    }
}