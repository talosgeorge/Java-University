package isp.lab6.exercise2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Exercise2Test {
    private RegistrySystem registry;

    @Before
    public void setUp() {
        registry = new RegistrySystem();
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle("1HGBH41AKJ1234567", "SM28TLS", "Audi", "A3", 2020);
        registry.addVehicle(vehicle);
        assertTrue(registry.checkVehicle("1HGBH41AKJ1234567"));
    }

    @Test
    public void testRemoveVehicle() {
        Vehicle vehicle = new Vehicle("2GCHU53AKJ7890123", "SM02TLS", "Volkswagen", "Golf 6", 2022);
        registry.addVehicle(vehicle);
        registry.removeVehicle("2GCHU53AKJ7890123");
        assertFalse(registry.checkVehicle("2GCHU53AKJ7890123"));
    }

    @Test
    public void testCheckVehicle() {
        Vehicle vehicle = new Vehicle("1HGBH41AKJ1234567", "SM28TLS", "Audi", "A3", 2020);
        registry.addVehicle(vehicle);
        assertTrue(registry.checkVehicle("1HGBH41AKJ1234567"));
        assertFalse(registry.checkVehicle("1234567890"));
    }
}