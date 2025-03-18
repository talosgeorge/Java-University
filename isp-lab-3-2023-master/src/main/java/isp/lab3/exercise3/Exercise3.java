package isp.lab3.exercise3;

import java.sql.SQLOutput;
import java.util.Objects;

public class Exercise3 {
    public static class Vehicle {
        private String model;
        private String type;
        private int speed;
        private char fuelType;
        private static int numberOfVehicles = 0;

        public Vehicle(String model, String type, int speed, char fuelType) {
            this.model = model;
            this.type = type;
            this.speed = speed;
            this.fuelType = fuelType;
            numberOfVehicles++;
        }

        public static void displayNumberOfVehicles() {
            System.out.println("Number of Vehicle objects created:" + numberOfVehicles);
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public char getFuelType() {
            return fuelType;
        }

        public void setFuelType(char fuelType) {
            this.fuelType = fuelType;
        }

        @Override
        public String toString() {
            return model + "(" + type + ")" + " speed " + speed + " fuel type " + fuelType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vehicle vehicle = (Vehicle) o;
            return speed == vehicle.speed && fuelType == vehicle.fuelType && Objects.equals(model, vehicle.model) && Objects.equals(type, vehicle.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(model, type, speed, fuelType);
        }
    }

    public static void main(String[] args) {
        Vehicle Dacia = new Vehicle("Dacia", "Logan", 150, 'B');
        Vehicle BMW = new Vehicle("BMW", "Series 5", 250, 'D');
        System.out.println(Dacia);
        System.out.println(BMW);
        System.out.println("Test getters\n" +
                "model:" + Dacia.getModel() + "\n" +
                "type:" + Dacia.getType() + "\n" +
                "speed:" + Dacia.getSpeed() + "\n" +
                "fuelType:" + Dacia.getFuelType());
        BMW.setModel("Bentley");
        BMW.setType("Nova");
        BMW.setSpeed(300);
        BMW.setFuelType('B');
        System.out.println("Test setter after new values\n" +
                "model:" + BMW.getModel() + "\n" +
                "type:" + BMW.getType() + "\n" +
                "speed:" + BMW.getSpeed() + "\n" +
                "fuelType:" + BMW.getFuelType());
        boolean areEqual = BMW.equals(Dacia);
        System.out.println("Are they equal ? F/T " + areEqual);
        Vehicle.displayNumberOfVehicles();
    }
}
