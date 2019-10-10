import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q4 {
    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void addInts(Scanner keyboard) {
        if (keyboard.hasNextLine()) {
            try {
                list.add(keyboard.nextInt());
                addInts(keyboard);
            } catch (InputMismatchException e) {}
        }
    }

    private static int greatestInt(int max, int iterator) {
        if (iterator < list.size()){
            if (max < list.get(iterator)){
                max = list.get(iterator);
            }
            iterator++;
            return greatestInt(max, iterator);
        } else
            return max;
    }

    public static int greatestInt(int min) {
        return greatestInt(min, 0);
    }

    public static void main(String[] args) {
        System.out.println("Enter several numbers. Enter a non-integer to end.");
        Scanner keyboard = new Scanner(System.in);
        addInts(keyboard);
        int minimum = 0;
        System.out.println("Greatest number in that sequence is " + greatestInt(minimum));
    }

}
