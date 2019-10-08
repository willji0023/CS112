import java.util.Scanner;

public class Example2 {
    public static int fibIterative(int subscript) {
        if (subscript == 0 || subscript == 1){
            return subscript;
        } else {
            int prevNum = 1;
            int prevPrevNum = 0;
            int acc = 0;
            for (int counter = 2; counter <= subscript; counter++){
                acc += prevPrevNum + prevNum;
                prevPrevNum = prevNum;
                prevNum = acc;
            }
            return acc;
        }
    }

    public static int fib(int subscript) {
        if (subscript == 0 || subscript == 1) // base case
            return subscript;
        else
            return fib(subscript - 1) + fib(subscript - 2);
    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many Fibonacci numbers do you want?");
        int max = keyboard.nextInt();

        for (int i = 0; i < max; i++){
            int nextNumber = fib(i);
            int otherNumber = fibIterative(i);
            System.out.printf("%15d %15d\n", nextNumber, otherNumber);
        }
    }
}
