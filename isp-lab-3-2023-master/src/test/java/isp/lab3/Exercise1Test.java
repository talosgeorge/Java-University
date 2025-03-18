package isp.lab3;

import isp.lab3.exercise1.Exercise1;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise1Test {
    @Test
    public void testGrow(){
        Exercise1.Tree fag = new Exercise1.Tree();
        assertEquals(30, fag.grow(15));
    }
    @Test
    public void testToString(){
        Exercise1.Tree fag = new Exercise1.Tree();
        assertEquals("Tree{height=15}", fag.toString());
    }
}
