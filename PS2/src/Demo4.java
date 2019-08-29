import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("New number creation tool");
        System.out.println("Enter name");
        String name = keyboard.nextLine();
        System.out.println("Enter phone number");
        String number = keyboard.nextLine();
        System.out.println("Enter email");
        String email = keyboard.nextLine();

        SmartPhone smartPhone = new SmartPhone(name, number, email);
        System.out.print(smartPhone);
    }
}
