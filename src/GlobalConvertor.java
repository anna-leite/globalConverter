/**
 * Entry point for the Global Converter application.
 * Handles user interaction, optional Caesar cipher encryption,
 * base conversion, and optional reverse conversion.
 */
public class GlobalConvertor {

    public static void main(String[] args) {
        System.out.println("=== Global Converter ===");

        // Prompt the user for the input string
        String inputText = UserInterface.promptForValidString();

        // Prompt the user for the desired base conversion option
        String baseOption = UserInterface.promptForValidBase();

        int shiftKey = 0;

        // Ask if the user wants to apply Caesar cipher encryption
        boolean encrypt = UserInterface.promptForEncryption();
        if (encrypt) {
            shiftKey = UserInterface.promptForShiftKey();
            UserInterface.displayOriginalText(inputText);
            inputText = CaesarCipher.encrypt(inputText, shiftKey);
            UserInterface.displayEncryptionResult(inputText);
        }

        // Perform the base conversion
        String result = Controler.convertString(inputText, baseOption);

        // Display the converted result
        UserInterface.displayConversionResult(result, UserInterface.getFullBaseName(baseOption));

        // Ask the user whether to convert back
        if (UserInterface.promptForConvertBack()) {
            String originalText = Controler.convertBack(result, baseOption);

            // Decrypt the text if it was encrypted earlier
            if (encrypt) {
                originalText = CaesarCipher.decrypt(originalText, shiftKey);
                UserInterface.displayDecryptionResult(originalText);
            } else {
                UserInterface.displayOriginalText(originalText);
            }
        }
    }
}
