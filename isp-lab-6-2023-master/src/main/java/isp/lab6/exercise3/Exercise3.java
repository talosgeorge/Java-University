package isp.lab6.exercise3;

public class Exercise3 {

    public static void main(String[] args) {
        OnlineStore onlineStore = new OnlineStore();
        LoginSystem loginSystem = new LoginSystem();
        UserInterface userInterface = new UserInterface(loginSystem, onlineStore);

        // Set up dependencies
        loginSystem.setOnlineStore(onlineStore);
        onlineStore.setLoginSystem(loginSystem);

        // Add some products to the store
        onlineStore.getProducts().add(new Product("Laptop", 1200.99));
        onlineStore.getProducts().add(new Product("Smartphone", 799.49));
        onlineStore.getProducts().add(new Product("Headphones", 150.75));

        // Start the store
        onlineStore.start();
    }
}
