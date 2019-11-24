import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Q4 {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        System.out.println("Enter ten words");
        Scanner keyboard = new Scanner(System.in);
        while (keyboard.hasNext())
            set.add(keyboard.nextLine());
        HashCode.hashAll(set);
    }
}
