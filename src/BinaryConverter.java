/**
 * Converter for binary numeral system.
 * <p>
 * This class provides methods to encode a decimal integer to binary string representation
 * and decode a binary string back into a decimal integer.
 * </p>
 */
public class BinaryConverter extends BaseConverter{
    /**
     * Encodes a decimal integer into its binary string representation.
     *
     * @param decimal the integer value to encode
     * @return the binary string representation of the input value
     */
    @Override
    public String encode(int decimal) {
        if (decimal == 0) return "0";

        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2); // Prepend the least significant bit
            decimal /= 2;
        }

        return binary.toString();
    }

    /**
     * Decodes a binary string into its decimal integer representation.
     *
     * @param binary the binary string to decode
     * @return the decoded decimal integer
     * @throws IllegalArgumentException if the input contains characters other than '0' or '1'
     */
    @Override
    public int decode(String binary) {
        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);

            // Ensure only valid binary characters
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + c);
            }

            // Shift left and add current bit
            decimal = decimal * 2 + (c - '0');
        }

        return decimal;
    }
}
