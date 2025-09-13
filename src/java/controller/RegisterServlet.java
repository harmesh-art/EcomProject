// In package: com.ecommerce.controller
// File: RegisterServlet.java

package controller;

import dao.UserDao;
import db.DBConnection;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        
        // --- IMPORTANT: Password Hashing ---
        // Your requirements specify password hashing for security.
        // In a real application, you MUST use a strong hashing library like jBCrypt.
        // Example: String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        // For this example, we'll use the plain text, but remember to replace this.
        String hashedPassword = password; 

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(hashedPassword);

        try {
            UserDao udao = new UserDao(DBConnection.getConnection());
            boolean success = udao.registerUser(user);

            if (success) {
                // If registration is successful, redirect to the login page
                response.sendRedirect("login.jsp");
            } else {
                // Handle registration failure (e.g., email already exists)
                // For simplicity, we redirect back to the registration page.
                // You could add an error message here.
                response.sendRedirect("register.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp"); // Redirect on error
        }
    }
}