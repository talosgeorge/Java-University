package isp.lab3.example;

public class ShopSingleton {
    private static final ShopSingleton INSTANCE = new ShopSingleton("Butyk",10);
    private String name;
    private int numOfEmployees;
    private ShopSingleton(String name, int numOfEmployees){
        this.name = name;
        this.numOfEmployees = numOfEmployees;
    }

    @Override
    public String toString() {
        return "ShopSingleton{" +
                "name='" + name + '\'' +
                ", numOfEmployees=" + numOfEmployees +
                '}';
    }

    public static ShopSingleton getInstance() {
        return INSTANCE;
    }
}
