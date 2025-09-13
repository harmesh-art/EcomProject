// In package: com.ecommerce.model
// File: Cart.java

package model;

public class Cart extends Product {
    private int quantity;

    public Cart() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}