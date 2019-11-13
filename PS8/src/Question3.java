import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {
    private static ArrayList<String> list = new ArrayList<>();

    public static ArrayList<String> insertionSort(ArrayList<String> data, int start, int end) {
        for (int i = 1; i < data.size(); i++) {
            String selected = data.get(i);
            int j = i;
            while (j > 0 && data.get(j - 1).compareToIgnoreCase(selected) > 0) {
                data.set(j, data.get(j - 1));
                j--;
            }
            data.set(j, selected);
        }
        ArrayList<String> sublist = new ArrayList<>();
        for (int i = start; i < end; i++) {
            sublist.add(data.get(i));
        }
        return sublist;
    }

    public static void load(Scanner input) {
        while(input.hasNextLine()) {
            String[] entries = input.nextLine().split("\\s+");
            list.add(String.format("%20s%20s", entries[1], entries[0]));
        }
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a starting point and ending point");
        try {
            Scanner inputFile = new Scanner(new File("user-database.txt"));
            inputFile.nextLine();
            load(inputFile);
            list = insertionSort(list, keyboard.nextInt(), keyboard.nextInt());
            for (String i : list)
                System.out.println(i);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
