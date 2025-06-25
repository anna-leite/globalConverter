/**
 * Utility class to validate user inputs for the conversion program.
 */
public class InputValidator {

    /**
     * Checks if the input string contains only alphanumeric characters and spaces.
     *
     * @param input the string to validate
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValidString(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }

    /**
     * Checks if the provided base option string is valid.
     *
     * @param base the base option string to validate
     * @return true if the base option is recognized, false otherwise
     */
    public static boolean isValidBase(String base) {
        return base.equals("-h") || base.equals("-hexadecimal") ||
               base.equals("-o") || base.equals("-octal") ||
               base.equals("-d") || base.equals("-decimal") ||
               base.equals("-b") || base.equals("-binary") ||
               base.equals("-t") || base.equals("-text");
    }

    /**
     * Checks if the shift key for Caesar cipher is within the valid range.
     *
     * @param key the shift key to validate
     * @return true if the key is between 1 and 25 inclusive, false otherwise
     */
    public static boolean isValidShiftKey(int key) {
        return key >= 1 && key <= 25;
    }
}
