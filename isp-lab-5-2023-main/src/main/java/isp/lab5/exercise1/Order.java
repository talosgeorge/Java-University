package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private Customer customer;
    private Product[] products = new Product[10];
    private int productNum;

    public Order(String orderId, LocalDateTime date, double totalPrice) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        this.products[this.productNum++] = product;
        this.totalPrice += product.getPrice();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", products=" + Arrays.toString(products) +
                ", productNum=" + productNum +
                '}';
    }
}
