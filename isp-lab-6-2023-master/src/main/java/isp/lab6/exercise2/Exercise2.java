package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        RegistrySystem registry = new RegistrySystem();

        registry.addVehicle(new Vehicle("1HGBH41AKJ1234567", "SM28TLS", "Audi", "A3", 2020));
        registry.addVehicle(new Vehicle("2GCHU53AKJ7890123", "SM02TLS", "Volkswagen", "Golf 6", 2022));
        registry.addVehicle(new Vehicle("1HGBH41AKJ1234567", "SM05CST", "Volkswagen", "Golf 7", 2024));

        registry.removeVehicle("2GCHU53AKJ7890123");
        registry.removeVehicle("1234567890");

        if (registry.checkVehicle("1HGBH41AKJ1234567")) {
            System.out.println("Vehicle with VIN 1HGBH41AKJ1234567 exists in the registry.");
        } else {
            System.out.println("Vehicle with VIN 1HGBH41AKJ1234567 not found.");
        }
        registry.displayVehicles();
    }
}
