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

            System.out.println("Writing check for $100...");
            b.writeCheck(100);
            System.out.println("Writing check for $50...");
            b.writeCheck(50);
            System.out.println("Writing check for $25...");
            b.writeCheck(25);

            System.out.println(b);
        } catch (NegativeStartingBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("Can't have a balance of " + e.getTheOffendingNumber());
        } catch (InputMismatchException e){
            System.out.println("You must enter a number");
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
    }
}
