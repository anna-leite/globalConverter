/**
 * Converter for the decimal numeral system.
 * <p>
 * This class provides a trivial implementation where encoding and decoding
 * are direct conversions between integers and their string representations in base 10.
 * </p>
 */
public class DecimalConverter extends BaseConverter{

    /**
     * Encodes a decimal integer into its decimal string representation.
     *
     * @param decimal the integer value to encode
     * @return the string representation of the input value in base 10
     */
    @Override
    public String encode(int decimal) {
        return Integer.toString(decimal);
    }

    /**
     * Decodes a decimal string into its integer value.
     *
     * @param decimal the string to decode
     * @return the parsed integer value
     * @throws NumberFormatException if the input string is not a valid decimal number
     */
    @Override
    public int decode(String decimal) {
        return Integer.parseInt(decimal);
    }
}
