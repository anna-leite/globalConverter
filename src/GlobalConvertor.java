 /**
 * Entry point for the Global Converter application.
 * Handles user interaction, optional Caesar cipher encryption,
 * base conversion, and optional reverse conversion.
 */
public class GlobalConvertor {
     private static final String RESET = "\u001B[0m";
     private static final String RED = "\u001B[31m";
     private static final String YELLOW = "\u001B[33m";
     private static final String CYAN = "\u001B[36m";
     private static final String PURPLE = "\u001B[35m";
     private static final String BOLD = "\u001B[1m";

//    public static void main(String[] args) {
//        System.out.println("=== Global Converter ===");
//
//        // Prompt the user for the input string
//        String inputText = UserInterface.promptForValidString();
//
//        // Prompt the user for the desired base conversion option
//        String baseOption = UserInterface.promptForValidBase();
//
//        int shiftKey = 0;
//
//        // Ask if the user wants to apply Caesar cipher encryption
//        boolean encrypt = UserInterface.promptForEncryption();
//        if (encrypt) {
//            shiftKey = UserInterface.promptForShiftKey();
//            UserInterface.displayOriginalText(inputText);
//            inputText = CaesarCipher.encrypt(inputText, shiftKey);
//            UserInterface.displayEncryptionResult(inputText);
//        } else {
//            UserInterface.displayOriginalText(inputText);
//        }
//
//        // Perform the base conversion
//        String result = Controler.convertString(inputText, baseOption);
//
//        // Display the converted result
//        UserInterface.displayConversionResult(result, UserInterface.getFullBaseName(baseOption));
//
//        // Ask the user whether to convert back
//        if (UserInterface.promptForConvertBack()) {
//            String originalText = Controler.convertBack(result, baseOption);
//
//            // Decrypt the text if it was encrypted earlier
//            if (encrypt) {
//                originalText = CaesarCipher.decrypt(originalText, shiftKey);
//                UserInterface.displayDecryptionResult(originalText);
//            } else {
//                UserInterface.displayOriginalText(originalText);
//            }
//        }
//    }

     /**
      * Entry point of the GlobalConvertor program.
      * Validates arguments, performs optional Caesar encryption,
      * converts the input to the selected base, and optionally reverses the process.
      *
      * @param args Command-line arguments:
      *             - args[0] : base option (-h, -o, -d, -b, -t)
      *             - args[1] : input text
      *             - args[2] : optional cipher flag (-k or -key)
      *             - args[3] : optional Caesar cipher key (integer from 1 to 25)
      */
     public static void main(String[] args) {
         // Validate command-line arguments before processing
         validateArgs(args);

         String baseOption = args[0];
         String inputText = args[1];
         String cipherOption = (args.length == 4) ? args[2] : "";
         int shiftKey = 0;

         // Encrypt the input text if Caesar cipher is enabled
         if (cipherOption.equals("-k") || cipherOption.equals("-key")) {
             shiftKey = Integer.parseInt(args[3]);
             UserInterface.displayOriginalText(inputText);
             inputText = CaesarCipher.encrypt(inputText, shiftKey);
             UserInterface.displayEncryptionResult(inputText);
         } else {
             // Display original input when no encryption is applied
             UserInterface.displayOriginalText(inputText);
         }

         // Convert the (possibly encrypted) text to the selected base
         String result = Controler.convertString(inputText, baseOption);
         UserInterface.displayConversionResult(result, UserInterface.getFullBaseName(baseOption));

         // Ask the user whether to convert back
         if (UserInterface.promptForConvertBack()) {
             String originalText = Controler.convertBack(result, baseOption);

             // Decrypt the text if it was encrypted earlier
             if (cipherOption.equals("-k") || cipherOption.equals("-key")) {
                 originalText = CaesarCipher.decrypt(originalText, shiftKey);
                 UserInterface.displayDecryptionResult(originalText);
             } else {
                 UserInterface.displayOriginalText(originalText);
             }
         }
     }

     /**
      * Validates command-line arguments provided to the program.
      * Checks number of arguments, base format, input format, and cipher validity.
      * If invalid, displays usage rules and exits the program.
      *
      * @param args Command-line arguments to validate.
      */
     private static void validateArgs(String[] args) {
         // Check for valid number of arguments (either 2 or 4)
         if (args.length != 2 && args.length != 4) {
             displayUseRules();
             System.exit(1);
         }

         // Validate the base option
         if (!InputValidator.isValidBase(args[0])) {
             displayUseRules();
             System.exit(1);
         }

         // Validate the input string (only letters, digits and spaces)
         if (!InputValidator.isValidString(args[1])) {
             displayUseRules();
             System.exit(1);
         }

         // If cipher arguments are provided, validate them
         if (args.length == 4 ) {
             if (!args[2].equals("-k") && !args[2].equals("-key")) {
                 displayUseRules();
                 System.exit(1);
             }

             try {
                 int key = Integer.parseInt(args[3]);
                 if (!InputValidator.isValidShiftKey(key)) {
                     displayUseRules();
                     System.exit(1);
                 }
             } catch (NumberFormatException e) {
                 // Handle invalid key format
                 displayUseRules();
                 System.exit(1);
             }
         }
     }

     /**
      * Displays the usage instructions for the GlobalConvertor tool.
      * Explains accepted base and cipher options, and the expected argument formats.
      */
     private static void displayUseRules() {
         System.out.println();
         System.out.println(BOLD + "===== Global Converter =====");
         System.out.println();

         System.out.println(RESET + "Global convertor is a tool used for converting text between different bases.");
         System.out.println();

         System.out.println(BOLD + RED + "USAGE" + RESET + " : java GlobalConvertor <base> <text> <cipher> <key>");
         System.out.println();

         System.out.println(RED + "<base> " + RESET + YELLOW + "OPTIONS" + RESET + " :");
         System.out.println("   " + CYAN + "-h or -hexadecimal" + RESET + " : convert to hexadecimal");
         System.out.println("   " + CYAN + "-o or -octal      " + RESET + " : convert to octal");
         System.out.println("   " + CYAN + "-d or -decimal    " + RESET + " : convert to decimal");
         System.out.println("   " + CYAN + "-b or -binary     " + RESET + " : convert to binary");
         System.out.println("   " + CYAN + "-t or -text       " + RESET + " : convert to text");
         System.out.println();

         System.out.println(YELLOW + "NOTE" + RESET + " : " + RED + "<text>" + RESET + " must contain only numbers, " +
                 "letters (upper- or lower-case ASCII letters, no accents), and spaces. It must be enclosed in double quotes.");
         System.out.println();

         System.out.println(RED + "<cipher> " + RESET + YELLOW + "OPTIONS :" + RESET);
         System.out.println("   " + PURPLE + "-k or -key        " + RESET + " : to encrypt using the Caesar cipher (optional)");
         System.out.println();

         System.out.println(YELLOW + "NOTE" + RESET + " : " + RED + "<key>" + RESET + " must be a positive integer between 1 and " +
                 "25.");
         System.out.println();
     }
}
