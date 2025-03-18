package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise4.Lights;
import aut.isp.lab4.exercise5.Actuator;
import aut.isp.lab4.exercise5.LevelSensor;
import aut.isp.lab4.exercise5.TemperatureSensor;
import aut.isp.lab4.exercise6.PhSensor;

public class AquariumController {

    private String manufacturer;
    private String model;
    private float currentTime;
    private FishFeeder feeder;
    private float feedingTime;
    private int presetTemperature;
    private float presetLevel;
    private float lightOnTime;
    private float lightOffTime;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private Actuator alarm;
    private Actuator heater;
    private Lights lights;
    private PhSensor phSensor;
    private float targetPh;

    public AquariumController(FishFeeder feeder, LevelSensor levelSensor, TemperatureSensor temperatureSensor, Actuator heater, Actuator alarm) {
        this.feeder = feeder;
        this.levelSensor = levelSensor;
        this.temperatureSensor = temperatureSensor;
        this.heater = heater;
        this.alarm = alarm;
        this.currentTime = 0.0f;
        this.feedingTime = 0.0f;
        this.presetLevel = 0.0f;
        this.presetTemperature = 0;
    }

    public AquariumController(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;
    }

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public void setLightOffTime(float lightOffTime) {
        this.lightOffTime = lightOffTime;
    }

    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if (currentTime == feedingTime) feeder.feed();
        if (currentTime == lightOnTime) lights.turnOn();
        if (currentTime == lightOffTime) lights.turnOff();
    }

    public float getCurrentTime() {
        return currentTime;
    }

    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    public AquariumController(String manufacturer, String model, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
    }

    public AquariumController(String manufacturer, String model, Lights lights) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.lights = lights;
    }

    public void checkWaterLevel() {
        float currentLevel = levelSensor.getValue();
        if (currentLevel < presetLevel) {
            alarm.turnOn();
        } else {
            alarm.turnOff();
        }
    }

    public void checkTemperature() {
        int currentTemperature = temperatureSensor.getValue();
        if (currentTemperature < presetTemperature) {
            heater.turnOn();
        } else if (currentTemperature > presetTemperature) {
            heater.turnOff();
        }
    }

    public void setPresetTemperature(int presetTemperature) {
        this.presetTemperature = presetTemperature;
    }

    public void setPresetLevel(float presetLevel) {
        this.presetLevel = presetLevel;
    }

    public void setPhSensor(PhSensor phSensor) {
        this.phSensor = phSensor;
    }

    public void setTargetPh(float targetPh) {
        this.targetPh = targetPh;
    }

    public void checkWaterQuality(){
        float currentPh = phSensor.getValue();
        float phChangeLimit = 1.00F;
        if(Math.abs(currentPh-targetPh)>phChangeLimit){
            alarm.turnOn();
        }
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                '}';
    }

//attributs
    //constructors
    //methods
}
