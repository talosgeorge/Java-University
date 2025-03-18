package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import aut.isp.lab4.exercise5.Alarm;
import aut.isp.lab4.exercise5.LevelSensor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

public class AquariumControllerTest {
    @Test
    public void testCurrentTime() {
        AquariumController test1 = new AquariumController("Aquarium", "8", 13.0F);
        test1.setCurrentTime(15.00F);
        float expectedTime = 15.00F;
        float actualTime = test1.getCurrentTime();
        assertEquals(actualTime, expectedTime, 0.01);
    }

    @Test
    public void testToString() {
        AquariumController test1 = new AquariumController("Aquarium", "8", 13.0F);
        String expectedOutput = "AquariumController{manufacturer='Aquarium', model='8', currentTime=13.0}";
        assertEquals(expectedOutput, test1.toString());
    }

    @Test
    public void testFeeding() {
        FishFeeder feeder = new FishFeeder("Aquatica", "V8", 10);
        AquariumController aquariumController = new AquariumController("Aquarium", "4", feeder);
        aquariumController.setFeedingTime(10.00F);
        aquariumController.setCurrentTime(10.00F);
        int actualResult = feeder.getMeals();
        int expectedResult = 9;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testCheckWaterLevel() {
        LevelSensor levelSensor = new LevelSensor("HydroTech", "900", 80.5F);
        Alarm alarm = new Alarm();
        AquariumController aquariumController = new AquariumController(null, levelSensor, null, null, null);
        aquariumController.setPresetLevel(90.0F);
        aquariumController.checkWaterLevel();
    }


    public void testCheckTemperature() {
    }
}
