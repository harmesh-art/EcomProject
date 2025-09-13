// In package: com.ecommerce.model
// File: User.java

package model;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
     private String phone;

    // --- GETTERS ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    } 

    public String getPassword() {
        return password;
    }

    // --- SETTERS ---
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
     public void setPhone(String phone) 
     { 
         this.phone = phone; 
     }

    public void setPassword(String password) {
        this.password = password;
    }
}