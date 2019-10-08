import java.util.Scanner;

public class Example3 {
    public static String possibleLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static void generate(int max, String result) {
        if (result.length() == max)
            System.out.println(result);
        else {
            for (int i = 0; i < possibleLetter.length(); i++){
                generate(max, result + possibleLetter.charAt(i));
            }
        }
    }

    public static void generate(int max){
        generate(max, "");
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Brute Force Password Generator");
        System.out.println("Enter a password length");
        int length = keyboard.nextInt();

        generate(length);
    }
}
