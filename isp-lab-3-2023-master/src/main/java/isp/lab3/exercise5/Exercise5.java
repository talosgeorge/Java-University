package isp.lab3.exercise5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise5 {
    public static class VendingMachine {
        private Map<Integer, String> products;
        private int credit;

        public VendingMachine() {
            products = new HashMap<>();
            credit = 0;
        }

        public void addProduct(int id, String productName) {
            products.put(id, productName);
        }

        public String displayProducts() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Available products:\n");
            for (Map.Entry<Integer, String> entry : products.entrySet()) {
                stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
            }
            return stringBuilder.toString();
        }
        public int insertCoins(int value) {
            credit += value;
            System.out.println(value + " coins inserted. Current credit is:" + credit);
            return credit;
        }

        public String selectProduct(int id) {
            if (products.containsKey(id)) {
                String productName = products.get(id);
                if (credit > 0) {
                    credit -= 1;
                    return "Selected product " + productName;
                } else {
                    return "Insufficient funds.";
                }
            } else {
                return "Invalid selection id.";
            }
        }

        public void displayCredit() {
            System.out.println("Current available credit: " + credit);
        }

        public void userMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;
            System.out.println("Please select an option:\n");
            System.out.println("1.Display available products");
            System.out.println("2.Insert coins");
            System.out.println("3.Select a product");
            System.out.println("4.Display current available credit");
            System.out.println("5.Exit.");
            while (!exit) {
                int option = scanner.nextInt();
                switch (option) {
                    case 1 -> System.out.println(displayProducts());
                    case 2 -> {
                        System.out.println("How many coins do you want to insert ?");
                        int value = scanner.nextInt();
                        insertCoins(value);
                    }
                    case 3 -> {
                        System.out.println("Enter the id of the product you want to select");
                        int productId = scanner.nextInt();
                        System.out.println(selectProduct(productId));
                    }
                    case 4 -> displayCredit();
                    case 5 -> exit = true;
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }
    public static void main(String[] args) {
        VendingMachine aparat1 = new VendingMachine();
        aparat1.addProduct(1, "Coca-Cola");
        aparat1.addProduct(2, "Sprite");
        aparat1.addProduct(3, "Pepsi");
        aparat1.addProduct(4, "Lays");
        aparat1.addProduct(5, "Chio");
        aparat1.addProduct(6, "Twixul stang");
        aparat1.addProduct(7, "Twixul drept");
        aparat1.userMenu();
    }
}
