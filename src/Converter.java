public class Converter {
    
    // Convert a decimal value to the target base
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
    
    // Convert from target base to decimal
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
