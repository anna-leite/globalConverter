public class BaseConverter {
    
    public static String convertString(String input, String baseOption) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int asciiValue = (int) c;
            
            if (i > 0) {
                result.append(" ");
            }
            
            switch (baseOption) {
                case "-h":
                case "-hexadecimal":
                    result.append(convertToHex(asciiValue));
                    break;
                case "-o":
                case "-octal":
                    result.append(convertToOctal(asciiValue));
                    break;
                case "-d":
                case "-decimal":
                    result.append(convertToDecimal(asciiValue));
                    break;
                case "-b":
                case "-binary":
                    result.append(convertToBinary(asciiValue));
                    break;
                case "-t":
                case "-text":
                    result.append(c);
                    break;
            }
        }
        
        return result.toString();
    }
    
    public static String convertBack(String input, String baseOption) {
        String[] parts = input.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String part : parts) {
            if (part.isEmpty()) continue;
            
            int asciiValue = 0;
            
            switch (baseOption) {
                case "-h":
                case "-hexadecimal":
                    asciiValue = hexToDecimal(part);
                    break;
                case "-o":
                case "-octal":
                    asciiValue = octalToDecimal(part);
                    break;
                case "-d":
                case "-decimal":
                    asciiValue = Integer.parseInt(part);
                    break;
                case "-b":
                case "-binary":
                    asciiValue = binaryToDecimal(part);
                    break;
                case "-t":
                case "-text":
                    result.append(part);
                    continue;
            }
            
            result.append((char) asciiValue);
        }
        
        return result.toString();
    }
    
    public static String getFullBaseName(String baseOption) {
        switch (baseOption) {
            case "-h":
            case "-hexadecimal":
                return "hexadecimal";
            case "-o":
            case "-octal":
                return "octal";
            case "-d":
            case "-decimal":
                return "decimal";
            case "-b":
            case "-binary":
                return "binary";
            case "-t":
            case "-text":
                return "text";
            default:
                return "unknown";
        }
    }
    
    private static String convertToHex(int value) {
        if (value == 0) return "0";
        
        StringBuilder hex = new StringBuilder();
        while (value > 0) {
            int remainder = value % 16;
            if (remainder < 10) {
                hex.insert(0, remainder);
            } else {
                hex.insert(0, (char) ('A' + remainder - 10));
            }
            value /= 16;
        }
        
        return hex.toString();
    }
    
    private static String convertToOctal(int value) {
        if (value == 0) return "0";
        
        StringBuilder octal = new StringBuilder();
        while (value > 0) {
            octal.insert(0, value % 8);
            value /= 8;
        }
        
        return octal.toString();
    }
    
    private static String convertToDecimal(int value) {
        return Integer.toString(value);
    }
    
    private static String convertToBinary(int value) {
        if (value == 0) return "0";
        
        StringBuilder binary = new StringBuilder();
        while (value > 0) {
            binary.insert(0, value % 2);
            value /= 2;
        }
        
        return binary.toString();
    }
    
    private static int hexToDecimal(String hex) {
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
            
            decimal = decimal * 16 + digitValue;
        }
        
        return decimal;
    }
    
    private static int octalToDecimal(String octal) {
        int decimal = 0;
        
        for (int i = 0; i < octal.length(); i++) {
            char c = octal.charAt(i);
            if (c < '0' || c > '7') {
                throw new IllegalArgumentException("Invalid octal digit: " + c);
            }
            
            int digitValue = c - '0';
            decimal = decimal * 8 + digitValue;
        }
        
        return decimal;
    }
    
    private static int binaryToDecimal(String binary) {
        int decimal = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);
            if (c != '0' && c != '1') {
                throw new IllegalArgumentException("Invalid binary digit: " + c);
            }
            
            decimal = decimal * 2 + (c - '0');
        }
        
        return decimal;
    }
}
