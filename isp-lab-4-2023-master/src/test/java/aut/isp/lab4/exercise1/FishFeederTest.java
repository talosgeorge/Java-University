package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise2.FishFeeder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FishFeederTest {
    @Test
    public void feedTest() {
        FishFeeder test1 = new FishFeeder("Aquatica", "V5", 10);
        test1.feed();
        int actualResult = test1.getMeals();
        int expectedResult = 9;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void fillUpTest() {
        FishFeeder test1 = new FishFeeder("Aquatica", "V5", 10);
        test1.fillUp();
        int expectedResult = 14;
        int actualResult = test1.getMeals();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void toStringTest() {
        FishFeeder test1 = new FishFeeder("Aquatica", "V5", 10);
        String expectedOutput = "FishFeeder{manufacturer='Aquatica', model='V5', meals=10}";
        assertEquals(expectedOutput, test1.toString());
    }
}
