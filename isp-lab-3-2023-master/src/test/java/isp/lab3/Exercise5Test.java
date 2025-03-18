package isp.lab3;

import isp.lab3.exercise5.Exercise5;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Exercise5Test {
    @Test
    public void VendingMachineTest() {
        Exercise5.VendingMachine aparat1 = new Exercise5.VendingMachine();
        aparat1.addProduct(1, "Coca-Cola");
        aparat1.addProduct(2, "Sprite");
        aparat1.addProduct(3, "Pepsi");
        String displayActualOutput = aparat1.displayProducts();
        String displayExpectedOutput = "Available products:\n" +
                "1:Coca-Cola\n" +
                "2:Sprite\n" +
                "3:Pepsi\n";
        assertEquals(displayExpectedOutput, displayActualOutput);
        int insertExpectedOutput = 1;
        assertEquals(aparat1.insertCoins(1),insertExpectedOutput);
        assertEquals("Selected product Coca-Cola", aparat1.selectProduct(1));
        assertEquals("Insufficient funds.", aparat1.selectProduct(2));
        assertEquals("Invalid selection id.", aparat1.selectProduct(4));
    }
}
