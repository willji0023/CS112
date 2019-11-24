import java.util.Scanner;
import java.util.TreeSet;

public class Q1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TreeSet<String> inputs = new TreeSet<>((s1, s2) -> {
            return s1.compareToIgnoreCase(s2);
        });
        while (true) {
            String i = keyboard.nextLine();
            System.out.println("Enter a line of text");
            if (i.equalsIgnoreCase("exit"))
                break;
            inputs.add(i);
        }
        inputs.forEach(current -> System.out.println(current));
    }
}
