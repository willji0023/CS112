import java.util.Scanner;

public class FibDemo
{
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Which Fibonnaci number do you want?");
    int index = keyboard.nextInt();

    System.out.printf("The Fibonnaci number at %d is %,d", index, Fib.generate(index));
  }
}
