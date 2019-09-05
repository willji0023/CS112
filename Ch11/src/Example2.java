import java.util.InputMismatchException;
import java.util.Scanner;

public class Example2 {
    public static void main(String[] args){
        System.out.println("Welcome to XYZ Bank!");
        System.out.println("We can make a new account for you!");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name");
        String name = keyboard.nextLine();
        try {
            System.out.println("Enter opening deposit");
            double opening = keyboard.nextDouble();
            BankAccount b = new BankAccount(name, opening);
            System.out.println("SUCCESS!!!!!!!!!!!!!");
        } catch (NegativeStartingBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Can't have a balance of " + e.getTheOffendingNumber());
        } catch (InputMismatchException e){
            System.out.println("You must enter a number");
        }
    }
}
