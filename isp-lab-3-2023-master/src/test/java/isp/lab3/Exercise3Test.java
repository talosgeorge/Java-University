package isp.lab3;

import isp.lab3.exercise3.Exercise3;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise3Test {
    @Test
    public void VehicleTest(){
            Exercise3.Vehicle vehicle = new Exercise3.Vehicle("Toyota","Megan",100,'D');
            String expectedToString = "Toyota(Megan) speed 100 fuel type D";
            assertEquals(expectedToString,vehicle.toString());
    }
}
