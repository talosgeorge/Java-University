package aut.isp.lab4.exercise5;

import aut.isp.lab4.exercise1.AquariumController;

public class Actuator {

    public boolean isOn;

    public void turnOn() {
        isOn = true;
        System.out.println(this.getClass().getSimpleName()+" is on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(this.getClass().getSimpleName()+" is off.");
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "isOn=" + isOn +
                '}';
    }
}
