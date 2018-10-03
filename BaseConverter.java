package baseconverter;

/**
 *
 * @author mstiefel
 */
public class BaseConverter {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String command = "";
        String input = "";
        String output = "";
        
        if (args.length < 3) {
            System.out.println("\nNo command/input/output provided.\n");
            System.out.println("\tUSAGE: java lab1.BaseConverter <sub-command> <number>_<base> [<number>]_<base>");
        } else {
            command = args[0];
            input = args[1];
            output = args[2];
            System.out.println("INPUT IS " + input);
            System.out.println("OUTPUT IS" + output);
        }
        
        if (command.toUpperCase().equals("CONVERT")) {
            int indexOfUnderscore = input.indexOf("_");
            String inputValue = input.substring(0, indexOfUnderscore);
            String inputBase = input.substring(indexOfUnderscore);

            indexOfUnderscore = output.indexOf("_");
            String outputValue = "";
            String outputBase = output.substring(indexOfUnderscore);

            // convert input value to base 10
            outputValue = convertToBase10(inputValue, Integer.parseInt(inputBase));

            // convert from base 10
            outputValue = convertFromBase10(outputValue, Integer.parseInt(outputBase));

            // print conversion result
            System.out.println(inputValue + " (base " + inputBase + ") converted to base " + outputBase + " is " + outputValue);
        } else {
            System.out.println("Command not recognized.");
        }
    }

    public static char numberToChar(int value) {
        return ALPHABET.charAt(value - 10);
    }

    public static int charToNumber(char value) {
        return ALPHABET.indexOf(Character.toUpperCase(value)) + 10;
    }

    public static String convertToBase10(String inputValue, int inputBase) {
        int result = 0;
        char current;
        for (int i = inputValue.length() - 1; i >= 0; i--) {
            current = inputValue.charAt(inputValue.length()-i-1);
            if (NUMBERS.indexOf(current) == -1) {
                result += charToNumber(current) * Math.pow(inputBase, i);
            } else {
                result += Character.getNumericValue(current) * Math.pow(inputBase, i);
            }
        }
        return Integer.toString(result);
    }

    public static String convertFromBase10(String outputValue, int outputBase) {
        int remainder = 0;
        int quotient = Integer.parseInt(outputValue);
        // reset output value
        outputValue = "";

        while (quotient >= outputBase) {
            remainder = quotient % outputBase;
            quotient = quotient / outputBase;
            if (remainder >= 10) {
                outputValue += numberToChar(remainder);
            } else {
                outputValue += Integer.toString(remainder);
            }
        }
        remainder = quotient % outputBase;
        if (remainder >= 10) {
                outputValue += numberToChar(remainder);
            } else {
                outputValue += Integer.toString(remainder);
            }

        // reverse result
        return new StringBuilder(outputValue).reverse().toString();
    }
}
