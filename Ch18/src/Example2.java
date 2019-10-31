import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
    public static ArrayList<Pair<String, String>> loadDatabase() {
        ArrayList<Pair<String, String>> result = new ArrayList<>();
        try {
            Scanner inputFile = new Scanner(new File("user-database.txt"));
            inputFile.nextLine(); // skip over header
            while(inputFile.hasNextLine()) {
                String[] tokens = inputFile.nextLine().split("\t");
                Pair<String, String> group = new Pair<>(tokens[0], tokens[1]);
                result.add(group);
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static Pair<String, String> findPair(ArrayList<Pair<String, String>> data, String key) {
        for (Pair<String, String> current : data) {
            if (current.getKey().equals(key)) {
                return current;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("== Welcome to the website ==");
        System.out.println("You must log in to continue");
        System.out.println("Enter username");
        String username = keyboard.nextLine();

        ArrayList<Pair<String, String>> users = loadDatabase();

        Pair<String, String> theUser = findPair(users, username);
        if (theUser == null) {
            System.out.println("No user " + username + " exists");
        } else {
            System.out.println("That user has been found");
            System.out.println("Enter password");
            String password = keyboard.nextLine();
            if (!theUser.getValue().equals(password)) {
                System.out.println("Incorrect password!");
            } else {
                System.out.println("Welcome to the site!");
            }
        }
    }
}
