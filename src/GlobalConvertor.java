import java.util.Scanner;

public class GlobalConvertor {
    private static String inputString;

    public static void main(String[] args) {
        System.out.println("------Global Convertor------");
        System.out.println("Global convertor is a tool to convert.");
        System.out.println("Please note : entries must be only numbers, upper- or lower-case letters and spaces.");
        System.out.println("Enter 'exit' to quit the program");
        System.out.println(" ");

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter input : ");
            inputString = sc.nextLine();

            Validator validator = new Validator(inputString);

            if (validator.isExit()) {
                terminateProgram(sc);
            }

            if (validator.validate()) {
                System.out.println("Input : " + inputString);
                break;
            }

            System.out.println("Invalid input. Please try again.");
        } while (true);


    sc.close();
    System.out.println("Program ended.");
    }

    private static void terminateProgram(Scanner sc) {
        System.out.println("Good Bye, see you soon.");
        sc.close();
        System.exit(0);
    }
}