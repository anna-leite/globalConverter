import java.util.Scanner;

/**
 * Handles all user input and output interactions for the Global Converter program.
 * Provides input validation prompts and displays conversion results.
 */
public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to enter a valid alphanumeric string.
     *
     * @return A valid input string.
     */
    public static String promptForValidString() {
        String input;
        boolean isValid = false;
        
        do {
            System.out.print("Enter a string to convert (alphanumeric characters only): ");
            input = scanner.nextLine();
            
            if (InputValidator.isValidString(input)) {
                isValid = true;
            } else {
                System.out.println("Error: Invalid input. Please use only alphanumeric characters.");
            }
        } while (!isValid);
        
        return input;
    }

    /**
     * Prompts the user to select a valid base conversion option.
     *
     * @return A valid base option string.
     */
    public static String promptForValidBase() {
        String base;
        boolean isValid = false;
        
        do {
            System.out.println("Choose conversion base:");
            System.out.println("  -h or -hexadecimal: Convert to hexadecimal");
            System.out.println("  -o or -octal: Convert to octal");
            System.out.println("  -d or -decimal: Convert to decimal");
            System.out.println("  -b or -binary: Convert to binary");
            System.out.println("  -t or -text: Keep as text");
            System.out.print("Enter your choice: ");
            
            base = scanner.nextLine().toLowerCase();
            
            if (InputValidator.isValidBase(base)) {
                isValid = true;
            } else {
                System.out.println("Error: Invalid base option. Please try again.");
            }
        } while (!isValid);
        
        return base;
    }

    /**
     * Asks the user whether they want to encrypt the text.
     *
     * @return true if encryption is requested, false otherwise.
     */
    public static boolean promptForEncryption() {
        System.out.print("Do you want to encrypt the text using Caesar cipher? (y/n): ");
        String response = scanner.nextLine().toLowerCase();
        return response.startsWith("y");
    }

    /**
     * Prompts the user to provide a shift key for Caesar cipher encryption.
     *
     * @return The valid shift key, or a default value (3) if invalid.
     */
    public static int promptForShiftKey() {
        System.out.print("Enter shift key for Caesar cipher (1-25): ");
        try {
            int key = Integer.parseInt(scanner.nextLine());
            if (InputValidator.isValidShiftKey(key)) {
                return key;
            } else {
                System.out.println("Invalid key range. Using default key of 3.");
                return 3;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Using default key of 3.");
            return 3;
        }
    }

    /**
     * Asks the user whether to convert the result back to text.
     *
     * @return true if reverse conversion is requested, false otherwise.
     */
    public static boolean promptForConvertBack() {
        System.out.print("Do you want to convert back to text? (y/n): ");
        String response = scanner.nextLine().toLowerCase();
        return response.startsWith("y");
    }

    /**
     * Displays the original (input or decrypted) text.
     *
     * @param text The text to display.
     */
    public static void displayOriginalText(String text) {
        System.out.println("Original text: " + text);
    }

    /**
     * Displays the result of base conversion.
     *
     * @param text     The converted text.
     * @param baseType The name of the base used.
     */
    public static void displayConversionResult(String text, String baseType) {
        System.out.println("Converted to " + baseType + ": " + text);
    }

    /**
     * Displays the result after encryption.
     *
     * @param text The encrypted text.
     */
    public static void displayEncryptionResult(String text) {
        System.out.println("Text after encryption: " + text);
    }

    /**
     * Displays the result after decryption.
     *
     * @param text The decrypted text.
     */
    public static void displayDecryptionResult(String text) {
        System.out.println("Text after decryption: " + text);
    }

    /**
     * Returns the full base name corresponding to a given base option.
     *
     * @param baseOption The base option entered by the user.
     * @return The full name of the base.
     */
    public static String getFullBaseName(String baseOption) {
        switch (baseOption) {
            case "-h":
            case "-hexadecimal":
                return "hexadecimal";
            case "-o":
            case "-octal":
                return "octal";
            case "-d":
            case "-decimal":
                return "decimal";
            case "-b":
            case "-binary":
                return "binary";
            case "-t":
            case "-text":
                return "text";
            default:
                return "unknown";
        }
    }
}
