package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise1.AquariumController;
import aut.isp.lab4.exercise5.Actuator;

public class Exercise4 {
    public static void main(String[] args) {
        Lights lights = new Lights("Aquarium", "8");
        AquariumController aquariumController = new AquariumController("Aquarium", "8", lights);
        aquariumController.setLightOnTime(22.00F);
        aquariumController.setLightOffTime(08.00F);
        aquariumController.setCurrentTime(22.00F);
        aquariumController.setCurrentTime(07.00F);
        System.out.println(lights.isOn);
        aquariumController.setCurrentTime(08.00F);
    }
}
