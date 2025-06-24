public class CaesarCipher {
    
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        // Normalize shift for decryption (negative shifts)
        shift = shift % 26;
        if (shift < 0) {
            shift += 26;
        }
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                // Non-alphabetic characters remain unchanged
                result.append(ch);
            }
        }
        
        return result.toString();
    }
    
    public static String decrypt(String text, int shift) {
        // Decryption is just encryption with negative shift
        return encrypt(text, -shift);
    }
}
