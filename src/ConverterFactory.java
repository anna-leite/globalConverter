/**
 * Factory class for creating instances of {@link BaseConverter}
 * based on the specified base option.
 * <p>
 * Supports binary, octal, decimal, hexadecimal, and text conversions.
 * </p>
 */
public class ConverterFactory {

    /**
     * Creates an appropriate {@link BaseConverter} implementation
     * based on the base option string.
     *
     * @param baseOption a string representing the desired base (e.g., "-b", "-hexadecimal")
     * @return a {@link BaseConverter} instance corresponding to the base option
     * @throws IllegalArgumentException if the base option is not recognized
     */
    public static BaseConverter createConverter(String baseOption) {
        return switch (baseOption) {
            case "-h", "-hexadecimal" -> new HexadecimalConverter();
            case "-o", "-octal" -> new OctalConverter();
            case "-d", "-decimal" -> new DecimalConverter();
            case "-b", "-binary" -> new BinaryConverter();
            case "-t", "-text" -> new TextConverter();
            default -> throw new IllegalArgumentException("Invalid base option: " + baseOption);
        };
    }
}
