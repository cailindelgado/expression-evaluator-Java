package exprEvaler.container;

/**
 * A class designed to hold three doubles
 */
public class LoopVals {
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
     * This is a getter function to retrieve the value at the specified position in the
     * array. If an invalid index is provided then {@link IndexOutOfBoundsException} is
     * thrown.
     * @param index An index to retrieve the value of the held array at a certain position
     * @throws IndexOutOfBoundsException if an invalid index is provided
     * @return The value held at the given index
     */
    public double getValue(int index) {
        if (index <= 2 && index >= 0) {
            return this.values[index];
        }
        throw new IndexOutOfBoundsException("Invlid index provided");
    }

    /**
     * This is a setter method for setting one of the three positions of the held array to be the
     * given value
     * @param index The index position of the array to be changed or set
     * @param value The value to set at the given @index@
     * @throws IndexOutOfBoundsException if the given index is not within the a valid range.
     */
    public void setValues(int index, double value) {
        if (index <= 2 && index >= 0) {
            this.values[index] = value;
            return;
        }
        throw new IndexOutOfBoundsException("Invalid index provided");
    }
}
