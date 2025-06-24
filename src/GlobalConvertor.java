public class GlobalConvertor {
    public static void main(String[] args) {
        System.out.println("=== Global Converter ===");
        
        // Get user input
        String inputText = UserInterface.promptForValidString();
        String baseOption = UserInterface.promptForValidBase();
        int shiftKey = 0;
        
        // Handle encryption if requested
        boolean encrypt = UserInterface.promptForEncryption();
        if (encrypt) {
            shiftKey = UserInterface.promptForShiftKey();
            inputText = CaesarCipher.encrypt(inputText, shiftKey);
            UserInterface.displayEncryptionResult(inputText);
        }
        
        // Convert to the requested base
        String result = BaseConverter.convertString(inputText, baseOption);
        
        UserInterface.displayOriginalText(inputText);
        UserInterface.displayConversionResult(result, BaseConverter.getFullBaseName(baseOption));
        
        // Handle conversion back if requested
        if (UserInterface.promptForConvertBack()) {
            String originalText = BaseConverter.convertBack(result, baseOption);
            
            // Decrypt if needed
            if (encrypt) {
                originalText = CaesarCipher.decrypt(originalText, shiftKey);
                UserInterface.displayDecryptionResult(originalText);
            } else {
                UserInterface.displayOriginalText(originalText);
            }
        }
    }
}
