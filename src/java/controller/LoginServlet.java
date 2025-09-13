// In package: com.ecommerce.controller
// File: LoginServlet.java
package controller;

import dao.UserDao;
import db.DBConnection;
import model.User;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("login-email");
        String password = request.getParameter("login-password");

        try {
            UserDao udao = new UserDao(DBConnection.getConnection());
            User user = udao.userLogin(email, password);

            if (user != null) {
                request.getSession().setAttribute("auth", user);
                response.sendRedirect("index.jsp");
            } else {
                // Optional: Add an error message
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}