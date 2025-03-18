package isp.lab5.exercise1;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address;

    public Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
