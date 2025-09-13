// In package: com.ecommerce.dao
// File: UserDao.java
package dao;

import db.DBConnection;
import model.User;
import java.sql.*;

public class UserDao {
    private Connection con;

    public UserDao(Connection connection) throws ClassNotFoundException, SQLException {
        this.con = DBConnection.getConnection();
    }
    
    public User userLogin(String email, String password) {
        User user = null;
        try {
            // IMPORTANT: This uses plain text passwords. For production,
            // you MUST implement password hashing as required.
            String query = "SELECT * FROM users WHERE email=? AND password_hash=?";
            PreparedStatement pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    
    // In package: com.ecommerce.dao
// Add this method to UserDao.java

public boolean registerUser(User user) {
    boolean success = false;
    String query = "INSERT INTO users (name, email, password_hash,phone) VALUES (?, ?, ?,?)";
    
    try {
        PreparedStatement pst = this.con.prepareStatement(query);
        pst.setString(1, user.getName());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getPhone());// The password should already be hashed by the servlet
        
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            success = true;
        }
    } catch (SQLException e) {
        // Handle potential SQL exceptions, e.g., duplicate email
        e.printStackTrace();
    }
    return success;
}
}