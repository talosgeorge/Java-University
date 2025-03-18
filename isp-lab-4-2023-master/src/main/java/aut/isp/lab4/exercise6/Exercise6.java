package aut.isp.lab4.exercise6;

import aut.isp.lab4.exercise1.AquariumController;
import aut.isp.lab4.exercise5.Actuator;
import aut.isp.lab4.exercise5.Alarm;

public class Exercise6 {
    public static void main(String[] args) {
        PhSensor phSensor = new PhSensor("Aquatic","pH-35",7.2F);
        Alarm alarm = new Alarm();
        AquariumController aquariumController = new AquariumController(null,null,null,null,alarm);
        aquariumController.setPhSensor(phSensor);
        aquariumController.checkWaterQuality();
    }
}
