package exprEvaler;

import exprEvaler.container.Parameters;

import java.security.InvalidParameterException;

public class Main {
    final static String sigArg = "--sigfigs";
    final static String loopArg = "--looping";
    final static String defArg = "--define";

    final static int success = 0;
    final static int invalidErr = 3;

    /**
     * Start the expression evaluator program.
     *
     * @param args Parameters to the program.
     */
    public static int Main(String[] args) {
        try {
            Parameters params = parse_args(args);
        } catch (InvalidParameterException e) {
            System.err.println(
                    "Usage: expr [--sigfigs 2..7] [--looping string] [--define string] [filename]");
           return invalidErr;
        }

        return success;
    }

    /**
     * This function takes in the arguments passed into the programme parses them, stores it in an
     * instance of Parameters and then returns the instance. It expects the args to be of the form
     * "[--sigfigs 2..7] [--looping string] [--define string] [filename]" (Split on the space)
     * @param args An array of strings to be parsed and broken up.
     * @return An instance of Params containing the parsed args array, if it follows the right
     * format.
     * @throws InvalidParameterException If the provided args are not in the format specified in
     * the description.
     */
    private static Parameters parse_args(String[] args) throws InvalidParameterException {
        Parameters params = new Parameters();
        boolean seen = false;
        int pos = 0;

        for (int idx = 0; (args[idx] != null) && (args[idx].startsWith("--")); idx++) {
            if (!seen && args[idx].equals(sigArg) && args[idx + 1] != null) { // for --sigfigs
                try {
                    params.setSigs(args[idx + 1]);
                } catch (NumberFormatException e) {
                    throw new InvalidParameterException("Invalid Params");
                }
            } else if (args[idx].equals(loopArg) && args[idx + 1] != null) { // for --looping
                String[] bits = args[idx + 1].split(",", 1);
                params.addLoop(bits[0], bits[1]);
            } else if (args[idx].equals(defArg) && args[idx + 1] != null) { // for --define
                String[] bits = args[idx + 1].split(",", 1);
                double value = Double.parseDouble(bits[1]);
                params.addVar(bits[0], value);
            } else
                throw new InvalidParameterException("Invalid Params");

            pos = idx;
        }
        pos++;
        if (pos != args.length) // for if there is a fileName
            params.setFile(args[pos]);

        return params;
    }
}