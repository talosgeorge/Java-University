package isp.lab5.exercise1;

import java.time.LocalDateTime;

public class Exercise1 {

    public static void main(String[] args) {
        Address address1 = new Address("2nd Long Str.","New York");
        Customer customer1 = new Customer("cust007","James B.","007-007-007");

        customer1.setAddress(address1);

        Product product1 = new Product("prod1","best shampoo",250,ProductCategory.BEAUTY);
        Product product2 = new Product("prod2","screwdriver",15,ProductCategory.HOME_AND_GARDEN);
        Product product3 = new Product("prod3","Teddy Bear",60,ProductCategory.TOYS);

        Order order1 = new Order("order123", LocalDateTime.now(),0);
        order1.setCustomer(customer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.addProduct(product3);

        System.out.println(order1);

    }
}
