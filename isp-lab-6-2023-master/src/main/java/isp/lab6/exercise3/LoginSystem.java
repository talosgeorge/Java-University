package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LoginSystem {

    private Set<User> users = new HashSet<>();
    private OnlineStore onlineStore;


    public void setOnlineStore(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
    }

    public boolean login(String username, String password) {
        Optional<User> optionalUser = users.stream()
                .filter(u -> u.getPassword() != null && u.getUsername() != null
                        && u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            onlineStore.addSession(username);
            return true;
        }

        return false;
    }

    public boolean register(String username, String password) {
        if (users.stream().anyMatch(u -> u.getUsername().equals(username))) {
            return false;
        }

        users.add(new User(username, password));
        return true;
    }

    public List<Product> getProducts() {
        return onlineStore.getProducts();
    }

    public String addToCart(String username, String productName, int quantity) {
        return onlineStore.addToCart(username, productName, quantity);
    }

    public String checkout(String username) {
        // Verifică dacă utilizatorul este activ în sesiune
        if (onlineStore.getActiveSession(username) != null) {
            // Dacă utilizatorul este activ, nu mai apelăm recursiv metoda
            return "Proceeding to checkout for " + username;
        } else {
            return "No active session for user " + username;
        }
    }

}

