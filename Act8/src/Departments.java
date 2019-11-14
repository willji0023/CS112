import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.Scanner;

public class Departments {
    public static void main(String[] args) {
        try {
            Scanner inputFile = new Scanner(new File("departments.txt"));
            inputFile.nextLine();
            TreeSet<String> departments = new TreeSet<>();
            while (inputFile.hasNext())
                departments.add(inputFile.nextLine().split("\t")[2]);

            departments.forEach(current -> { if (!current.contains(" ")) System.out.println(current); });

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}