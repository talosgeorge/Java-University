package isp.lab3;

import isp.lab3.exercise4.Exercise4;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Exercise4Test {
    @Test
    public void MyPointTest() {
        Exercise4.MyPoint point1 = new Exercise4.MyPoint(1,2,3);
        Exercise4.MyPoint point2 = new Exercise4.MyPoint(4,5,6);
        double expectedDistance = Math.sqrt(27);
        double actualDistance = point1.distance(point2);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }
}
