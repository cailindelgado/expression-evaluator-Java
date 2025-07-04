package exprEvaler.container;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParametersTest {

    private Parameters parameters;

    @BeforeEach
    public void setUp() {
        parameters = new Parameters();
    }

    @Test
    public void testInitialization() {
        assertEquals(5, parameters.getSigs(), "Default significant figures should be 5.");
        assertNull(parameters.getFile(), "File name should initially be null.");
        assertNull(parameters.getVar("nonExistentVar"), "Non-existent variable should return 0.0.");
        assertNull(parameters.getLoop("nonExistentLoop"), "Non-existent loop should return null.");
    }

    @Test
    public void testSetAndGetFile() {
        String fileName = "testFile.txt";
        parameters.setFile(fileName);
        assertEquals(fileName, parameters.getFile(), "File name should be correctly set and retrieved.");
    }

    @Test
    public void testSetSigsValid() {
        int result = parameters.setSigs("3");
        assertEquals(3, result, "Significant figures should be set to 3.");
        assertEquals(3, parameters.getSigs(), "Significant figures should be correctly retrieved.");
    }

    @Test
    public void testSetSigsInvalid() {
        int result = parameters.setSigs("1");
        assertEquals(0, result, "Invalid significant figures should return 0.");
        assertEquals(5, parameters.getSigs(), "Significant figures should remain unchanged.");
    }

    @Test
    public void testSetSigsNonNumeric() {
        int result = parameters.setSigs("invalid");
        assertEquals(0, result, "Non-numeric significant figures should return 0.");
        assertEquals(5, parameters.getSigs(), "Significant figures should remain unchanged.");
    }

    @Test
    public void testAddAndGetVar() {
        parameters.addVar("testVar", 10.5);
        assertEquals(10.5, parameters.getVar("testVar"), "Variable should be correctly added and retrieved.");
    }

    @Test
    public void testAddAndGetLoop() {
        parameters.addLoop("testLoop", "1.0,0.5,2.0");
        LoopVals loop = parameters.getLoop("testLoop");
        assertNotNull(loop, "Loop should be correctly added.");
        assertArrayEquals(new double[]{1.0, 0.5, 2.0}, loop.getValues(), "Loop values should match.");
    }

    @Test
    public void testAddLoopInvalidFormat() {
        assertDoesNotThrow(() -> parameters.addLoop("invalidLoop", "invalid"), "Adding loop with invalid format should not throw an exception.");
        assertNull(parameters.getLoop("invalidLoop"), "Invalid loop should not be added.");
    }

    @Test
    public void testAddLoopInvalidRange() {
        assertDoesNotThrow(() -> parameters.addLoop("invalidRangeLoop", "1.0,-0.5,2.0"), "Adding loop with invalid range should not throw an exception.");
        assertNull(parameters.getLoop("invalidRangeLoop"), "Loop with invalid range should not be added.");
    }
}