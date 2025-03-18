package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private String username;
    private Map<String, Integer> shoppingCart = new HashMap<>();

    public ActiveSession(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public Map<String, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void addToCart(String username, String productName, int quantity) {
        shoppingCart.put(productName, quantity);
    }

    public void removeFromCart(String productName) {
        shoppingCart.remove(productName);
    }

    public int getQuantity(String productName) {
        if (shoppingCart.containsKey(productName)) {
            return shoppingCart.get(productName);
        } else {
            return 0;
        }
    }
}