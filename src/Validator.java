public class Validator {
    private String inputString;

    public Validator(String inputString) {
        this.inputString = inputString;
    }

    public boolean isExit() {
        return inputString.equalsIgnoreCase("exit");
    }

    public boolean isEmpty() {
        return inputString.trim().isEmpty();
    }

    public boolean validate() {
        if (this.isEmpty()) return false;

        for (char c : inputString.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
}
