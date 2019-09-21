import java.io.*;
import java.util.Scanner;

public class Example4 {
    public static void displayAllContacts(){
        try {
            FileInputStream istream = new FileInputStream("contacts.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(istream);
            boolean eof = false;
            while (!eof){
                try {
                    Contact current = (Contact)objectInputStream.readObject();
                    // CRASHES HERE
                    System.out.println(current);
                } catch (ClassNotFoundException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        System.out.println("Here are all the existing contacts");
        displayAllContacts();
        try {
            FileOutputStream ostream = new FileOutputStream("contacts.bin", true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ostream);

            Scanner keyboard = new Scanner(System.in);
            System.out.println("ADD NEW CONTACT");
            System.out.println("1. Enter name");
            String name = keyboard.nextLine();
            System.out.println("2. Enter phone");
            String phone = keyboard.nextLine();
            System.out.println("2. Enter email");
            String email = keyboard.nextLine();

            Contact c = new Contact(name, phone, email);
            objectOutputStream.writeObject(objectOutputStream);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
