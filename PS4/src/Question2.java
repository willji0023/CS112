import java.util.InputMismatchException;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args){
        int sum = 0;
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        while (true){
            System.out.println("Enter a integer");
            try {
                sum += keyboard.nextInt();
            } catch (InputMismatchException e){
                String input = keyboard.nextLine();
                String extracted = "";
                for (int i = 0; i < input.length(); i++){
                    if (Character.isDigit(input.charAt(i))){
                        extracted += input.charAt(i);
                    }
                }
                if (extracted == ""){
                    break;
                }
                int newInt = Integer.parseInt(extracted);
                System.out.println("Well, that's not a number but here's what I extracted: " + newInt);
                sum += newInt;
            }
            System.out.println("Current sum: " + sum);
        }
        System.out.println("There were no digits in that input.");
        System.out.println("Final sum: " + sum);
    }
}
