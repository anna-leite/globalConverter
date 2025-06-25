/**
 * Converter for the hexadecimal numeral system.
 * <p>
 * Provides methods to encode a decimal integer into a hexadecimal string
 * and decode a hexadecimal string back into a decimal integer.
 * </p>
 */
public class HexadecimalConverter extends BaseConverter{

    /**
     * Encodes a decimal integer into its hexadecimal string representation.
     * Uses uppercase letters (A–F) for digits above 9.
     *
     * @param decimal the integer value to encode
     * @return the hexadecimal string representation of the input value
     */
    @Override
    public String encode(int decimal) {
        if (decimal == 0) return "0";

        StringBuilder hex = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;

            // Convert remainder to 0–9 or A–F
            if (remainder < 10) {
                hex.insert(0, remainder);
            } else {
                hex.insert(0, (char) ('A' + remainder - 10));
            }
            decimal /= 16;
        }

        return hex.toString();
    }

    /**
     * Decodes a hexadecimal string into its decimal integer representation.
     * Accepts both uppercase and lowercase letters (A–F, a–f).
     *
     * @param hex the hexadecimal string to decode
     * @return the decoded decimal integer
     * @throws IllegalArgumentException if the input contains invalid hexadecimal characters
     */
    @Override
    public int decode(String hex) {
        int decimal = 0;

        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int digitValue;

            if (c >= '0' && c <= '9') {
                digitValue = c - '0';
            } else if (c >= 'A' && c <= 'F') {
                digitValue = 10 + c - 'A';
            } else if (c >= 'a' && c <= 'f') {
                digitValue = 10 + c - 'a';
            } else {
                throw new IllegalArgumentException("Invalid hex digit: " + c);
            }

            // Shift left by one hex digit (multiply by 16) and add current value
            decimal = decimal * 16 + digitValue;
        }

        return decimal;
    }
}
