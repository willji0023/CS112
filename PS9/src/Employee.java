import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {
    private String id, first_name, last_name, email;

    Employee(String id, String first_name, String last_name, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public static Map<String, Employee> load() {
        Map<String, Employee> data = new HashMap<>();
        try {
            Scanner inputFile = new Scanner(new File("employees.txt"));
            inputFile.nextLine();
            while (inputFile.hasNext()) {
                String[] sections = inputFile.nextLine().split("\t", 4);
                data.put(sections[0], new Employee(sections[0], sections[1], sections[2], sections[3]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public String toString() {
        return id + " -> " + first_name + " " + last_name + " " + email;
    }
}
