package isp.lab3.example;

public class MainShop {
    public static void main(String[] args){
        ShopSingleton shop = ShopSingleton.getInstance();
        System.out.println(shop);
    }
}
