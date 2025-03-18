package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Set;

public class RegistrySystem {
    private Set<Vehicle> registry;

    public RegistrySystem() {
        this.registry = new HashSet<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (!registry.contains(vehicle)) {
            registry.add(vehicle);
            System.out.println("Vehicle added successfully: " + vehicle.getVin());
        } else {
            System.out.println("Vehicle with VIN " + vehicle.getVin() + " already exists.");
        }
    }

    public void removeVehicle(String vin) {
        Vehicle toRemove = null;
        for (Vehicle vehicle : registry) {
            if (vehicle.getVin().equals(vin)) {
                toRemove = vehicle;
                break;
            }
        }
        if (toRemove != null) {
            registry.remove(toRemove);
            System.out.println("Vehicle with VIN " + vin + " removed.");
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    public boolean checkVehicle(String vin) {
        for (Vehicle vehicle : registry) {
            if (vehicle.getVin().equals(vin)) {
                return true;
            }
        }
        return false;
    }

    public void displayVehicles() {
        if (registry.isEmpty()) {
            System.out.println("Registry is empty.");
        } else {
            System.out.println("Vehicles in registry:");
            for (Vehicle vehicle : registry) {
                System.out.println(vehicle);
            }
        }
    }
}

