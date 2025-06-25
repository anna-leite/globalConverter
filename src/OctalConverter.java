/**
 * Converter for the octal numeral system.
 * <p>
 * Provides methods to encode a decimal integer into an octal string
 * and decode an octal string back into a decimal integer.
 * </p>
 */
public class OctalConverter extends BaseConverter{

    /**
     * Encodes a decimal integer into its octal string representation.
     *
     * @param decimal the integer value to encode
     * @return the octal string representation of the input value
     */
    @Override
    public String encode(int decimal) {
        if (decimal == 0) return "0";

        StringBuilder octal = new StringBuilder();
        while (decimal > 0) {
            octal.insert(0, decimal % 8);
            decimal /= 8;
        }

        return octal.toString();
    }

    /**
     * Decodes an octal string into its decimal integer representation.
     *
     * @param octal the octal string to decode
     * @return the decoded decimal integer
     * @throws IllegalArgumentException if the input contains invalid octal digits (not 0–7)
     */
    @Override
    public int decode(String octal) {
        int decimal = 0;

        for (int i = 0; i < octal.length(); i++) {
            char c = octal.charAt(i);

            // Validate character is a valid octal digit
            if (c < '0' || c > '7') {
                throw new IllegalArgumentException("Invalid octal digit: " + c);
            }

            int digitValue = c - '0';
            decimal = decimal * 8 + digitValue;
        }

        return decimal;
    }
}
