import java.util.HashMap;
import java.util.Scanner;

public class HashCode {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter any text");
        String text = keyboard.nextLine().toLowerCase();
        HashMap<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'a')
                data.put(c, 100);
            else if (c == 'e')
                data.put(c, 200);
            else if (c == 'i')
                data.put(c, 300);
            else if (c == 'o')
                data.put(c, 400);
            else if (c == 'u')
                data.put(c, 500);
            else if (Character.isLetter(c))
                data.put(c, Character.toString(c).hashCode() - 96);
            else
                data.put(c, 0);
        }

        int hashcode = 0;
        for (int i = 1; i <= text.length(); i++) {
            if (data.get(text.charAt(i-1)) <= 26)
                hashcode += i * data.get(text.charAt(i - 1));
            else
                hashcode += data.get(text.charAt(i-1));
        }
        System.out.println("The CS112 hashcode for that string is " + hashcode);
    }
}