package aut.isp.lab4.exercise3;


import aut.isp.lab4.exercise1.AquariumController;
import aut.isp.lab4.exercise2.FishFeeder;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Aquatica", "V8", 10);
        AquariumController aquariumController = new AquariumController("Aquarium", "4", feeder);
        System.out.println(feeder.getMeals());
        aquariumController.setFeedingTime(10.00F);
        aquariumController.setCurrentTime(10.00F);
        System.out.println(feeder.getMeals());
    }
}
