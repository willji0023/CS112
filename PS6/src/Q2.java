import java.util.Scanner;

public class Q2 {
    public static String reverseString(String input) {
        if (input == "" || input.length() == 1)
            return input;
        else {
            return input.substring(input.length()-1) + reverseString(input.substring(0, input.length() - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a String");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Here is that String in reverse");
        System.out.println(reverseString(keyboard.nextLine()));
    }
}
