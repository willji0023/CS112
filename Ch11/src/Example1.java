import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        System.out.println("STARTING MAIN");
        Scanner keyboard = new Scanner(System.in);
        int sum = 0;
        for (int counter = 1; counter <= 10; counter++) {
            System.out.println("Enter a number to add " + counter + " : ");
            String possiblyBadInput = "";
            try {
                possiblyBadInput = keyboard.nextLine();
                int input = Integer.parseInt(possiblyBadInput);
                sum += input; // won't happen if crash happened above
            } catch (NumberFormatException e) {
                System.out.println("Hey, " + possiblyBadInput + "'s not a number. Skipping.");
            }
        }
        System.out.println("Sum: " + sum);
        System.out.println("ENDING MAIN");
    }
}
