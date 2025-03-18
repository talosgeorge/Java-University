package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise1.AquariumController;

public class Lights extends AquariumController {
    public Lights(String manufacturer, String model) {
        super(manufacturer, model);
    }

    public boolean isOn;

    public void turnOn() {
        System.out.println("Light is on.");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("Light is off.");
        isOn = false;
    }
}
