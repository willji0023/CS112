import java.util.Queue;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int result = 0;
        do {
            System.out.println("Enter an expression in prefix form (operator comes first)");
            Queue<String> tokens = QueueUtils.build(keyboard.nextLine());
            result = QueueUtils.eval(tokens);
            System.out.println(result);
        } while (result != 0);
        System.out.println("Zero result found found. Exiting.");
    }
}
