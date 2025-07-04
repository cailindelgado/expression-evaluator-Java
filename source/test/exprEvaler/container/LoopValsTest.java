package exprEvaler.container;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoopValsTest {

    @Test
    public void testInitialise() throws IndexOutOfBoundsException {
        LoopVals loops = new LoopVals(0, 0, 0);

        assert loops.getValue(0) == 0;
        assert loops.getValue(1) == 0;
        assert loops.getValue(2) == 0;
    }

    @Test
    public void testConstructorAndGetValues() {
        double start = 1.0;
        double increment = 0.5;
        double end = 2.0;

        LoopVals loopVals = new LoopVals(start, increment, end);
        double[] values = loopVals.getValues();

        assertEquals(start, values[0], "Start value should be correctly set.");
        assertEquals(increment, values[1], "Increment value should be correctly set.");
        assertEquals(end, values[2], "End value should be correctly set.");
    }

    @Test
    public void testGetValue() {
        double start = 1.0;
        double increment = 0.5;
        double end = 2.0;

        LoopVals loopVals = new LoopVals(start, increment, end);

        assertEquals(start, loopVals.getValue(0), "Retrieved start value should match.");
        assertEquals(increment, loopVals.getValue(1), "Retrieved increment value should match.");
        assertEquals(end, loopVals.getValue(2), "Retrieved end value should match.");
    }

    @Test
    public void testGetValueWithInvalidIndex() {
        LoopVals loopVals = new LoopVals(1.0, 0.5, 2.0);

        assertThrows(IndexOutOfBoundsException.class, () -> loopVals.getValue(-1),
                "Should throw IndexOutOfBoundsException for negative index.");

        assertThrows(IndexOutOfBoundsException.class, () -> loopVals.getValue(3),
                "Should throw IndexOutOfBoundsException for index >= 3.");
    }

    @Test
    public void testSetValues() {
        LoopVals loopVals = new LoopVals(1.0, 0.5, 2.0);

        loopVals.setValues(0, 3.0);
        loopVals.setValues(1, 0.25);
        loopVals.setValues(2, 4.0);

        assertEquals(3.0, loopVals.getValue(0), "Start value should be updated correctly.");
        assertEquals(0.25, loopVals.getValue(1), "Increment value should be updated correctly.");
        assertEquals(4.0, loopVals.getValue(2), "End value should be updated correctly.");
    }

    @Test
    public void testSetValuesWithInvalidIndex() {
        LoopVals loopVals = new LoopVals(1.0, 0.5, 2.0);

        assertThrows(IndexOutOfBoundsException.class, () -> loopVals.setValues(-1, 3.0),
                "Should throw IndexOutOfBoundsException for negative index.");

        assertThrows(IndexOutOfBoundsException.class, () -> loopVals.setValues(3, 3.0),
                "Should throw IndexOutOfBoundsException for index >= 3.");
    }
}