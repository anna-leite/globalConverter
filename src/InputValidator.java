public class InputValidator {
    
    public static boolean isValidString(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }
    
    public static boolean isValidBase(String base) {
        return base.equals("-h") || base.equals("-hexadecimal") ||
               base.equals("-o") || base.equals("-octal") ||
               base.equals("-d") || base.equals("-decimal") ||
               base.equals("-b") || base.equals("-binary") ||
               base.equals("-t") || base.equals("-text");
    }
    
    public static boolean isValidShiftKey(int key) {
        return key >= 1 && key <= 25;
    }
}
