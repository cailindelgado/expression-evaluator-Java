package container;

/**
 * A class designed to hold three doubles
 */
class LoopVals {
    private final double[] values;

    /**
     * This takes in three doubles as a starting position, an increment, and an end position
     * @param start The starting value for the looping variable
     * @param increment The increment value for the looping variable
     * @param end The ending value for the looping variable
     */
    public LoopVals(double start, double increment, double end) {
        this.values = new double[]{start, increment, end};
    }

    /**
     * Getter method for the values structure within the class
     * @return The values array containing three doubles
     */
    public double[] getValues() {
        return values;
    }

    /**
     * This is a setter method for setting one of the three positions of the held array to be the
     * given value
     * @param index The index position of the array to be changed or set
     * @param value The value to set at the given @index@
     * @return 0 if successful and old(values) != /new(values), 1 if index provided is out of range
     */
    public int setValues(int index, double value) {
        if (index >= 3 || index < 0) {
            this.values[index] = value;
            return 0;
        }
        return 1;
    }
}
