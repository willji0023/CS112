import java.util.Scanner;

public class Q3 {
    public static String reverseString(String input) {
        if (input == "" || input.length() == 1)
            return input;
        else {
            String nextLetter = input.substring(input.length()-1);
            return nextLetter += reverseString(input.substring(0, input.length() - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a String");
        Scanner keyboard = new Scanner(System.in);
        String text = keyboard.nextLine();
        if (reverseString(text.toLowerCase()).equalsIgnoreCase(text.toLowerCase()))
            System.out.println("That is a palindrome");
        else
            System.out.println("That is NOT a palindrome");
    }
}
