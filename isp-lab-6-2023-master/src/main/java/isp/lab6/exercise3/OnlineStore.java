package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OnlineStore {

    private List<Product> products = new ArrayList<>();
    private LoginSystem loginSystem = new LoginSystem();
    private Scanner scanner = new Scanner(System.in);
    private Map<String, ActiveSession> sessions = new HashMap<>();

    public void setLoginSystem(LoginSystem loginSystem) {
        this.loginSystem = loginSystem;
    }

    public void start() {
        int choice;

        do {
            System.out.println("\nOnline Store Menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Exiting Online Store.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (loginSystem.login(username, password)) {
            System.out.println("Login successful!");
            loggedInMenu(username);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void register() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (loginSystem.register(username, password)) {
            System.out.println("Registration successful!");
            addSession(username);
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void loggedInMenu(String username) {
        int choice;

        do {
            System.out.println("\nLogged In Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    String message = addToCart(username, productName, quantity);
                    System.out.println(message);
                    break;
                case 3:
                    checkout(username);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    sessions.remove(username);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void viewProducts() {
        List<Product> products = loginSystem.getProducts();
        if (products.isEmpty()) {
            System.out.println("There are no products available.");
        } else {
            System.out.println("Products:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public String addToCart(String username, String productName, int quantity) {
        ActiveSession session = sessions.get(username);
        if (session == null) {
            return "User not logged in.";
        }

        // Find the product in the store
        Product product = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);

        if (product == null) {
            return "Product not found.";
        }

        session.addToCart(username, productName, quantity);
        return "Added " + quantity + " of " + productName + " to cart.";
    }


    public String checkout(String username) {
        ActiveSession session = sessions.get(username);
        if (session == null) {
            return "User not logged in.";
        }

        Map<String, Integer> shoppingCart = session.getShoppingCart();
        if (shoppingCart.isEmpty()) {
            return "Your cart is empty.";
        }

        // Afisare produse in cos
        System.out.println("\nCheckout Summary for " + username + ":");
        shoppingCart.forEach((productName, quantity) -> {
            System.out.println("Product: " + productName + " | Quantity: " + quantity);
        });

        return "Checkout completed for " + username;
    }


    public void addSession(String username) {
        sessions.put(username, new ActiveSession(username));
    }

    public List<Product> getProducts() {
        return products;
    }

    public ActiveSession getActiveSession(String username) {
        return sessions.get(username);
    }
}
