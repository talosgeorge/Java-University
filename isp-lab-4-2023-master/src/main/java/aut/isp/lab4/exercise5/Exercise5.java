package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise1.AquariumController;

public class Exercise5 {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureSensor("AquaTech","TH100",2);
        LevelSensor levelSensor = new LevelSensor("HydroTech","900", 80.5F);
        Heater heater = new Heater();
        Alarm alarm = new Alarm();
        AquariumController aquariumController=new AquariumController(null,levelSensor,temperatureSensor,heater,alarm);
        System.out.println("Current temperature: " + temperatureSensor.getValue() + " degrees");
        System.out.println("Current water level: " + levelSensor.getValue() + " liters");
        aquariumController.checkTemperature();
        aquariumController.checkWaterLevel();
        aquariumController.setPresetTemperature(23);
        aquariumController.setPresetLevel(100);
        aquariumController.checkWaterLevel();
        aquariumController.checkTemperature();
    }
}
