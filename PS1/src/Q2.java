import java.util.Scanner;

public class Q2
{
    public static void printInfo(Employee e)
    {
        System.out.printf("%12s %12s %12s %12s\n", e.getName(), String.valueOf(e.getIdNumber()), e.getDepartment(), e.getPosition());
    }

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("-- Employee Entry Form --");
        System.out.println("Enter name");
        String name1 = keyboard.nextLine();
        System.out.println("Enter ID");
        int ID1 = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter department");
        String department1 = keyboard.nextLine();
        System.out.println("Enter position");
        String position1 = keyboard.nextLine();
        Employee e1 = new Employee(name1, ID1, department1, position1);

        System.out.println("-- Employee Entry Form --");
        System.out.println("Enter name");
        String name2 = keyboard.nextLine();
        System.out.println("Enter ID");
        int ID2 = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter department");
        String department2 = keyboard.nextLine();
        System.out.println("Enter position");
        String position2 = keyboard.nextLine();
        Employee e2 = new Employee(name2, ID2, department2, position2);

        System.out.println("-- Employee Entry Form --");
        System.out.println("Enter name");
        String name3 = keyboard.nextLine();
        System.out.println("Enter ID");
        int ID3 = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter department");
        String department3 = keyboard.nextLine();
        System.out.println("Enter position");
        String position3 = keyboard.nextLine();
        Employee e3 = new Employee(name3, ID3, department3, position3);

        System.out.printf("%12s %12s %12s %12s\n", "Name", "ID", "Department", "Position");
        printInfo(e1);
        printInfo(e2);
        printInfo(e3);
    }
}

