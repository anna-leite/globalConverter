/**
 * Converter for single character text representation.
 * <p>
 * Encodes a decimal integer as its corresponding ASCII character,
 * and decodes a single-character string back into its decimal ASCII value.
 * </p>
 */
public class TextConverter extends BaseConverter{

    /**
     * Encodes a decimal integer into its corresponding ASCII character.
     *
     * @param decimal the ASCII value to convert
     * @return a string containing the single character corresponding to the ASCII code
     */
    @Override
    public String encode(int decimal) {
        return Character.toString((char) decimal);
    }

    /**
     * Decodes a single-character string into its decimal ASCII value.
     *
     * @param text the string containing one character
     * @return the ASCII value of the character
     * @throws IllegalArgumentException if the input does not contain exactly one character
     */
    @Override
    public int decode(String text) {
        if (text.length() != 1) {
            throw new IllegalArgumentException("Text must be one charactère.");
        }
        return text.charAt(0);
    }
}
