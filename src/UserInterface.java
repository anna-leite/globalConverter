import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    
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
    
    public static boolean promptForEncryption() {
        System.out.print("Do you want to encrypt the text using Caesar cipher? (y/n): ");
        String response = scanner.nextLine().toLowerCase();
        return response.startsWith("y");
    }
    
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
    
    public static boolean promptForConvertBack() {
        System.out.print("Do you want to convert back to text? (y/n): ");
        String response = scanner.nextLine().toLowerCase();
        return response.startsWith("y");
    }
    
    public static void displayOriginalText(String text) {
        System.out.println("Original text: " + text);
    }
    
    public static void displayConversionResult(String text, String baseType) {
        System.out.println("Converted to " + baseType + ": " + text);
    }
    
    public static void displayEncryptionResult(String text) {
        System.out.println("Text after encryption: " + text);
    }
    
    public static void displayDecryptionResult(String text) {
        System.out.println("Text after decryption: " + text);
    }
}
