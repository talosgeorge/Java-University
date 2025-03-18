package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise1.AquariumController;

public abstract class Sensor {
    private String manufacturer;
    private String model;
    private String unitOfMeasurement;

    public Sensor(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                '}';
    }
}
