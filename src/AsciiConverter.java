/**
 * Utility class for converting ASCII character values between decimal and other bases.
 */
public class AsciiConverter {

    /**
     * Converts a decimal integer to its representation in a given base (up to 36).
     *
     * @param decimal the decimal value to convert
     * @param base the target base (between 2 and 36)
     * @return the string representation of the value in the given base
     * @throws IllegalArgumentException if base is out of range
     */
    public static String convertToBase(int decimal, int base) {
        if (decimal == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % base;
            char digit;
            
            if (remainder < 10) {
                digit = (char) ('0' + remainder);
            } else {
                digit = (char) ('A' + remainder - 10);
            }
            
            result.insert(0, digit);
            decimal /= base;
        }
        
        return result.toString();
    }

    /**
     * Converts a number string in a given base (up to 36) back to its decimal integer value.
     *
     * @param value the string representing a number in the given base
     * @param base the base of the number (between 2 and 36)
     * @return the decimal integer equivalent of the string
     * @throws IllegalArgumentException if the input contains invalid characters
     */
    public static int convertToDecimal(String value, int base) {
        int decimal = 0;
        
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            int digitValue;
            
            if (c >= '0' && c <= '9') {
                digitValue = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                digitValue = 10 + c - 'A';
            } else if (c >= 'a' && c <= 'z') {
                digitValue = 10 + c - 'a';
            } else {
                throw new IllegalArgumentException("Invalid digit for base " + base + ": " + c);
            }
            
            if (digitValue >= base) {
                throw new IllegalArgumentException("Digit " + c + " is not valid in base " + base);
            }
            
            decimal = decimal * base + digitValue;
        }
        
        return decimal;
    }
}
