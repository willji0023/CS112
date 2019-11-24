import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter ticker symbol to look up");
        String ticker = keyboard.nextLine();

        Map<String, Stock> data = new HashMap<>();
        Stock.load(data);

        System.out.println(data.get(ticker.toUpperCase())); // Displays Stock value associated with that ticker key
    }
}
