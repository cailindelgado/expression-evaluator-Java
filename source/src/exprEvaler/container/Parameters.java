package container;

import container.LoopVals;
import java.util.HashMap;
import java.util.Map;

/**
 * A custom class for holding a set of information for evaluating expressions
 */
public class Parameters {
    private int significantFigs; // predefined number of significant figures to be displayed
    private String fName;
    private Map<String, Double> vars;
    private Map<String, LoopVals> loops;

    /**
     * Initialises all the private members of the class
     */
    public Parameters() {
        this.significantFigs = 5;
        this.vars = new HashMap<>();
        this.loops = new HashMap<>();
    }

    /**
     * This function sets the file name in this
     * @param name The name of the file to be opened and read
     */
    public void setFile(String name) {
        this.fName = name;
    }

    /**
     * Getter method for returning the stored name of the file
     * @return The name of the file that is currently being stored
     */
    public String getFile() {
        return this.fName;
    }

    /**
     * This function takes in a string representation of an integer, converts it to an integer and
     * sets the existing significant figures to be said value
     * @param value A string representation of an integer
     */
    public int setSigs(String value) {
        try {
            int val = Integer.parseInt(value);
            if (val >= 2 && val <= 7) {
                this.significantFigs = val;
                return val;
            } else {
                return 0;
            }
        } catch (NumberFormatException e) {
            System.err.println("The given value is not a valid integer\n");
            return 0;
        }
    }

    /**
     * Getter method for the number of significant figures.
     * @return The number of significant figures to round to
     */
    public int getSigs() {
        return this.significantFigs;
    }

    /**
     * Add a given variable to the HashMap within the class
     * @param var The string name of the variable to be added
     * @param val The value of the variable to be added into the HashMap
     */
    public void addVar(String var, double val) {
        this.vars.put(var, val);
    }

    /**
     * This is a getter method for getting the value for any given name
     * @param var The name of the variable
     * @return It's value within the HashMap, if it exists
     */
    public double getVar(String var) {
        return this.vars.get(var);
    }

    /**
     * This function takes in the name of the looping variable and the string representation of
     * its values in the form "start,increment,end", parses it into three doubles, inserts it
     * into a LoopVar and then adds it into the stored HashMap of variables. If the provided
     * string is invalid then this does nothing
     * @param loop The name of the looping variable as a string
     * @param vals The details of how the loop is supposed to work
     */
    public void addLoop(String loop, String vals) {
        String[] bits = vals.split(",");
        if (bits.length == 3) {
            LoopVals newLoop = null;
            for (int idx = 0; idx < 3; idx++) {
                try {
                    double value = Double.parseDouble(bits[idx]);
                    newLoop.setValues(idx, value);

                } catch (NumberFormatException e) {
                    System.err.println("Invalid parameter for looping variable");
                }

            }

        }
    }

    /**
     *
     * @param loop
     * @return
     */
    public LoopVals getLoop(String loop) {
        return this.loops.get(loop);
    }
}