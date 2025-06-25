/**
 * Controller class responsible for coordinating string conversion
 * between text and various numeral base representations.
 */
public class Controler {

    /**
     * Converts a plain text string into a space-separated string
     * representing each character in the specified numeral base.
     *
     * @param input      the original text string to convert
     * @param baseOption the base option (e.g. "-b", "-h", "-o", etc.)
     * @return a space-separated string of encoded characters
     */
    public static String convertString(String input, String baseOption) {
        BaseConverter converter = ConverterFactory.createConverter(baseOption);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int asciiValue = input.charAt(i);
            if (i > 0) {
                result.append(" ");
            }
            result.append(converter.encode(asciiValue));
        }
        return result.toString();
    }

    /**
     * Converts a space-separated string of base-encoded values back
     * into its original plain text form.
     *
     * @param input      the encoded string (e.g. "41 42 43")
     * @param baseOption the base option used for decoding
     * @return the decoded plain text string
     * @throws IllegalArgumentException if the input contains invalid characters
     */
    public static String convertBack(String input, String baseOption) {
        BaseConverter converter = ConverterFactory.createConverter(baseOption);
        String[] parts = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            if (part.isEmpty()) continue;
            int asciiValue = converter.decode(part);
            result.append((char) asciiValue);
        }
        return result.toString();
    }
}
