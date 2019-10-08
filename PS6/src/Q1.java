import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1 {
    public static int calcSum(int x){
        if (x > 0)
            return x + calcSum(--x);
        else
            return 0;
    }

    public static void main (String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a maximum");
        try {
            int max = keyboard.nextInt();
            int sum = calcSum(max);
            System.out.println("The sum of number from 1 to " + max + " is " + sum);
        } catch (InputMismatchException e){
            System.out.println("Not an integer");
        }
    }
}
