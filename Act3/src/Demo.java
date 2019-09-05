import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args){
        System.out.println("Enter a number and I will figure out the data type");
        Scanner keyboard = new Scanner(System.in);
        try {
            int number = keyboard.nextInt();
            System.out.println("That's an integer!");
        } catch (InputMismatchException e){
            try {
                long number = keyboard.nextLong();
                System.out.println("That's an long!");
            } catch (InputMismatchException f){
                try {
                    double number = keyboard.nextDouble();
                    System.out.println("That's a double!");
                } catch (InputMismatchException g){
                    System.out.println("I have no clue what that is");
                }
            }
        }

    }
}
