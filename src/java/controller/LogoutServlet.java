// In package: com.ecommerce.controller
// File: LogoutServlet.java
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("auth") != null) {
            request.getSession().removeAttribute("auth");
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}