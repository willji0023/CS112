import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Example2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Stock sorter");
        System.out.println("How do you want to sort this database?");
        System.out.println("[1] Ticker");
        System.out.println("[2] Company Name");
        System.out.println("[3] Industry");
        int input = keyboard.nextInt();

        Set<Stock> data;
        if (input == 1) {
             data = new TreeSet<>((s1, s2) -> {
                return s1.ticker.compareTo(s2.ticker);
            });
        } else if (input == 2) {
            data = new TreeSet<>((s1, s2) -> {
                return s1.name.compareToIgnoreCase(s2.name);
            });
        } else {
            data = new TreeSet<>((s1, s2) -> {
                int result = s1.industry.compareTo(s2.industry);

                if (result == 0)
                    return s1.ticker.compareTo(s2.ticker);
                else
                    return result;
            });
        }
        Stock.load(data);
        for(Stock current : data) {
            System.out.println(current);
        }
    }
}
