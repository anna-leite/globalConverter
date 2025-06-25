/**
 * Abstract base class for character encoding and decoding based on various numeral systems.
 * <p>
 * Subclasses must implement specific logic for encoding a decimal integer to a string
 * in a given base, and for decoding a string from that base back to a decimal integer.
 * </p>
 */
public abstract class BaseConverter {
    /**
     * Encodes a decimal integer into its string representation using a specific numeral system.
     *
     * @param decimal the integer value to encode
     * @return the encoded string representation of the input integer
     */
    protected abstract String encode(int decimal);

    /**
     * Decodes a string representation from a specific numeral system back into a decimal integer.
     *
     * @param toDecode the string value to decode
     * @return the decoded integer value
     * @throws IllegalArgumentException if the input string is invalid for the target base
     */
    protected abstract int decode(String toDecode);
}
