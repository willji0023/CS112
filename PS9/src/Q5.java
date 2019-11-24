import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Q5 {
    public static void main(String[] args) {
        Map<Integer, CustomerBalances> customers = new HashMap<>();

        System.out.println("Enter a filename");
        Scanner keyboard = new Scanner(System.in);
        try {
            Scanner inputFile = new Scanner(new File(keyboard.nextLine()));
            inputFile.nextLine();
            while (inputFile.hasNext()){
                String[] custInfo = inputFile.nextLine().split("\t", 2);
                int custID = Integer.parseInt(custInfo[0]);
                CustomerBalances foundCustomer = customers.get(custID);
                if (foundCustomer == null)
                    customers.put(custID, new CustomerBalances(custID, custInfo[1]));
                else {
                    foundCustomer.add(custInfo[1]);
                    customers.put(custID, foundCustomer);
                }
            }
            customers.forEach((x,y) -> {
                System.out.println("Customer " + x + ": Last balance: " + y.getLast() + " High balance: " + y.getHigh() + " Low balance: " + y.getLow());
            });

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
